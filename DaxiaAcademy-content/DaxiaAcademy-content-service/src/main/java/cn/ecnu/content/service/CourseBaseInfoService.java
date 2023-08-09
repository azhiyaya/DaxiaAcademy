package cn.ecnu.content.service;

import cn.ecnu.base.model.PageParams;
import cn.ecnu.base.model.PageResult;
import cn.ecnu.content.model.dto.QueryCourseParamsDto;
import cn.ecnu.content.model.po.CourseBase;

/**
 * <p>@author zachary</p>
 * <p>@version 1.0</p>
 * <p>@description 课程信息管理接口</p>
 */

public interface CourseBaseInfoService {

    /**
     *
     * @param queryCourseParamsDto
     * @param pageParams
     * @return 课程分页查询信息
     */
    PageResult<CourseBase> queryCourseBaseList(QueryCourseParamsDto queryCourseParamsDto, PageParams pageParams);

}
