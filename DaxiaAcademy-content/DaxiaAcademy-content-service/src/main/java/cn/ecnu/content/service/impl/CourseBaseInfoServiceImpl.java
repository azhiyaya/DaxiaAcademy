package cn.ecnu.content.service.impl;

import cn.ecnu.base.model.PageParams;
import cn.ecnu.base.model.PageResult;
import cn.ecnu.content.mapper.CourseBaseMapper;
import cn.ecnu.content.model.dto.QueryCourseParamsDto;
import cn.ecnu.content.model.po.CourseBase;
import cn.ecnu.content.service.CourseBaseInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>@author zachary</p>
 * <p>@version 1.0</p>
 * <p>@description 课程信息管理接口实现类</p>
 */

@Service
public class CourseBaseInfoServiceImpl implements CourseBaseInfoService {

    @Resource
    private CourseBaseMapper courseBaseMapper;


    @Override
    public PageResult<CourseBase> queryCourseBaseList(QueryCourseParamsDto queryCourseParamsDto, PageParams pageParams) {
        //根据查询条件查询相关信息
        LambdaQueryWrapper<CourseBase> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .like(StringUtils.isNotEmpty(queryCourseParamsDto.getCourseName()),CourseBase::getName,queryCourseParamsDto.getCourseName())
                .eq(StringUtils.isNotEmpty(queryCourseParamsDto.getAuditStatus()),CourseBase::getAuditStatus,queryCourseParamsDto.getAuditStatus())
                .eq(StringUtils.isNotEmpty(queryCourseParamsDto.getPublishStatus()),CourseBase::getStatus,queryCourseParamsDto.getPublishStatus());
        //封装分页信息
        Page<CourseBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());

        //根据分页参数以及查询条件 分页查询相关信息
        Page<CourseBase> courseBasePage = courseBaseMapper.selectPage(page, queryWrapper);

        //将相关数据解析封装为PageResult格式
        PageResult<CourseBase> result = new PageResult<>(courseBasePage.getRecords(), courseBasePage.getTotal(), courseBasePage.getCurrent(), courseBasePage.getSize());

        return result;
    }
}
