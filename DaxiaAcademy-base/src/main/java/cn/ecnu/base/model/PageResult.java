package cn.ecnu.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>@author zachary</p>
 * <p>@version 1.0</p>
 * <p>@description 通用分页查询结果</p>
 */

@Data
@AllArgsConstructor
public class PageResult<T> implements Serializable {

    /**
     * 查询结果数据列表
     */
    private List<T> data;

    /**
     * 总记录数
     */
    private Long count;

    /**
     * 当前页码
     */
    private Long page;

    /**
     * 每页记录数
     */
    private Long pageSize;

}
