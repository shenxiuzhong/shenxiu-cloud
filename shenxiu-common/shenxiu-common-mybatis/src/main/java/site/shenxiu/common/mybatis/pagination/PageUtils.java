package site.shenxiu.common.mybatis.pagination;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.lang3.StringUtils;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.common.core.utils.SqlUtils;

/**
 * mybatis-plus 分页工具类
 *
 * @author shenxiu
 * @version 2022/11/23 16:57
 */
public class PageUtils {

    /**
     * 当前记录起始索引 默认值
     */
    public static final int DEFAULT_PAGE_NUM = 1;

    /**
     * 每页显示记录数 默认值 默认查全部
     */
    public static final int DEFAULT_PAGE_SIZE = Integer.MAX_VALUE;

    /**
     * 构建分页数据对象
     * @param page 分页Page对象
     * @param <T> 泛型
     * @return 分页数据对象
     */
    public static <T> PageData<T> build(IPage<T> page) {
        return new PageData<>(page.getRecords(), page.getTotal());
    }

    /**
     * 构建分页模型 mybatis-plus
     * @param pageQuery 分页查询对象
     * @param <T> 泛型
     * @return 分页模型
     */
    public static <T> Page<T> build(PageQuery pageQuery) {
        Integer pageNum = ObjectUtil.defaultIfNull(pageQuery.getPageNum(), DEFAULT_PAGE_NUM);
        Integer pageSize = ObjectUtil.defaultIfNull(pageQuery.getPageSize(), DEFAULT_PAGE_SIZE);
        if (pageNum <= 0) {
            pageNum = DEFAULT_PAGE_NUM;
        }
        Page<T> page = new Page<>(pageNum, pageSize);
        OrderItem orderItem = buildOrderItem(pageQuery);
        if (ObjectUtil.isNotNull(orderItem)) {
            page.addOrder(orderItem);
        }
        return page;
    }

    /**
     * 构建排序元素对象
     * @param pageQuery 分页查询
     * @return 排序元素
     */
    private static OrderItem buildOrderItem(PageQuery pageQuery) {
        // 兼容前端排序类型
        if ("ascending".equals(pageQuery.getIsAsc())) {
            pageQuery.setIsAsc("asc");
        } else if ("descending".equals(pageQuery.getIsAsc())) {
            pageQuery.setIsAsc("desc");
        }
        if (StringUtils.isNotBlank(pageQuery.getOrderByColumn())) {
            String orderBy = SqlUtils.escapeOrderBySql(pageQuery.getOrderByColumn());
            orderBy = StrUtil.toUnderlineCase(orderBy);
            if ("asc".equals(pageQuery.getIsAsc())) {
                return OrderItem.asc(orderBy);
            } else if ("desc".equals(pageQuery.getIsAsc())) {
                return OrderItem.desc(orderBy);
            }
        }
        return null;
    }
}
