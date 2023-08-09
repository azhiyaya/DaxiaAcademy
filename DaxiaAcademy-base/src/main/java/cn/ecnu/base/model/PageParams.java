package cn.ecnu.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <p>@author zachary</p>
 * <p>@version 1.0</p>
 * <p>@description 分页查询分页参数</p>
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageParams {

    /**
     * 当前所在页码 默认当前在第一页
     */
    private Long pageNo = 1L;

    /**
     * 每页显示的记录数 默认20条数据
     */
    private Long pageSize = 20L;
}
