package site.shenxiu.common.core.page;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页查询实体类
 * @author ShenXiu 
 * @version 2022/11/6 20:39
 */
@Data
public class PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分页大小
     */
    private Integer pageSize;

    /**
     * 当前页数
     */
    private Integer pageNum;

    /**
     * 排序列
     */
    private String orderByColumn;

    /**
     * 排序的方向desc或者asc
     */
    private String isAsc;
}
