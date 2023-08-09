package cn.ecnu.content;

import cn.ecnu.base.model.PageParams;
import cn.ecnu.base.model.PageResult;
import cn.ecnu.content.mapper.CourseBaseMapper;
import cn.ecnu.content.model.dto.QueryCourseParamsDto;
import cn.ecnu.content.model.po.CourseBase;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;


/**
 * <p>@author zachary</p>
 * <p>@version 1.0</p>
 * <p>@description 课程信息接口测试</p>
 */

@SpringBootTest
public class CourseBaseMapperTest {

    @Resource
    CourseBaseMapper courseBaseMapper;

    @Test
    public void testCourseBaseMapper(){
        //查询条件
        QueryCourseParamsDto queryCourseParamsDto = new QueryCourseParamsDto();
        queryCourseParamsDto.setCourseName("java");

        //queryCourseParamsDto.setAuditStatus("202004");

        //queryCourseParamsDto.setPublishStatus("203001");

        //根据查询条件查询数据信息
        LambdaQueryWrapper<CourseBase> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .like(StringUtils.isNotEmpty(queryCourseParamsDto.getCourseName()),CourseBase::getName, queryCourseParamsDto.getCourseName())
                .eq(StringUtils.isNotEmpty(queryCourseParamsDto.getAuditStatus()),CourseBase::getAuditStatus,queryCourseParamsDto.getAuditStatus())
                .eq(StringUtils.isNotEmpty(queryCourseParamsDto.getPublishStatus()),CourseBase::getStatus,queryCourseParamsDto.getPublishStatus());

        //创建分页参数对象
        PageParams pageParams = new PageParams(1L,30L);
        Page<CourseBase> courseBasePage = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());

        Page<CourseBase> selectedPage = courseBaseMapper.selectPage(courseBasePage, queryWrapper);

        PageResult<CourseBase> courseBasePageResult = new PageResult<CourseBase>(selectedPage.getRecords(),selectedPage.getTotal(),selectedPage.getCurrent(),selectedPage.getSize());

        courseBasePageResult.getData().stream().forEach(courseBase -> System.out.println(courseBase.getName()));

        System.out.println("总记录数 ："+courseBasePageResult.getCount());
        System.out.println("当前页码 ："+courseBasePageResult.getPage());
        System.out.println("每页记录数 ："+courseBasePageResult.getPageSize());

    }
}
