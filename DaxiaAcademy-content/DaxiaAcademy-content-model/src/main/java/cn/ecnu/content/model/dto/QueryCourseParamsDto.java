package cn.ecnu.content.model.dto;

import lombok.Data;

/**
 * <p>@author zachary</p>
 * <p>@version 1.0</p>
 * <p>@description 课程查询条件DTO</p>
 */

@Data
public class QueryCourseParamsDto {

    /**
     * 课程审核状态
     */
    private String auditStatus;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程发布状态
     */
    private String publishStatus;

}
