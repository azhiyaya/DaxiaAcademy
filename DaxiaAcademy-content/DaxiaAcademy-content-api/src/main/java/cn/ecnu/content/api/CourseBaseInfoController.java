package cn.ecnu.content.api;

import cn.ecnu.base.model.PageParams;
import cn.ecnu.base.model.PageResult;
import cn.ecnu.content.model.dto.QueryCourseParamsDto;
import cn.ecnu.content.model.po.CourseBase;
import cn.ecnu.content.service.CourseBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>@author zachary</p>
 * <p>@version 1.0</p>
 * <p>@description 课程基本信息API</p>
 */

@Api(value = "课程基本信息接口",tags = "课程基本信息接口")
@RestController
public class CourseBaseInfoController {

    @Resource
    private CourseBaseInfoService courseBaseInfoService;

    @ApiOperation(value = "根据查询条件分页查询课程信息")
    @PostMapping("/course/list")
    public PageResult<CourseBase> list(@RequestBody(required = false) QueryCourseParamsDto queryCourseParamsDto, PageParams pageParams){
        return courseBaseInfoService.queryCourseBaseList(queryCourseParamsDto,pageParams);
    }
}
