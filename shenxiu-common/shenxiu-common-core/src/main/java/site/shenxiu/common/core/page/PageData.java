package site.shenxiu.common.core.page;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据对象
 *
 * @author ShenXiu
 * @version 2022/11/6 20:27
 */
@Data
@NoArgsConstructor
public class PageData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 列表数据
     */
    private List<T> rows;

    /**
     * 分页
     *
     * @param list  列表数据
     * @param total 总记录数
     */
    public PageData(List<T> list, long total) {
        this.rows = list;
        this.total = total;
    }

}
