package site.shenxiu.system.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import site.shenxiu.common.core.domain.R;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.system.domain.SysDictType;

import java.util.List;

/**
 * 数据字典类型 API定义
 *
 * @author ShenXiu
 * @version 2022/11/30 15:50
 * @definition 数据字典类型api定义
 */
public interface SysDictTypeApi {
    /**
     * 查询字典类型列表
     *
     * @param dictType  数据字典类型
     * @param pageQuery 分页查询对象
     * @return 分页数据
     */
    @GetMapping("/getPage")
    R<PageData<SysDictType>> getPage(SysDictType dictType, PageQuery pageQuery);

    /**
     * 导出字典类型列表
     *
     * @param dictType 数据字典类型
     */
    @PostMapping("/export")
    void export(SysDictType dictType);

    /**
     * 查询字典类型详细
     *
     * @param dictId 字典ID
     * @return 数据字典类型
     */
    @GetMapping(value = "/{dictId}")
    R<SysDictType> getInfo(@PathVariable Long dictId);

    /**
     * 新增字典类型
     *
     * @param dict 数据字典类型
     * @return 响应对象
     */
    @PostMapping(value = "/add")
    R<Void> add(@Validated @RequestBody SysDictType dict);

    /**
     * 修改字典类型
     *
     * @param dict 数据字典类型
     * @return 响应对象
     */
    @PostMapping(value = "/edit")
    R<Void> edit(@Validated @RequestBody SysDictType dict);

    /**
     * 删除字典类型
     *
     * @param dictIds 字典ID串
     * @return 响应对象
     */
    @PostMapping("/remove")
    R<Void> remove(@RequestBody Long[] dictIds);

    /**
     * 刷新字典缓存
     *
     * @return 响应对象
     */
    @PostMapping("/refreshCache")
    R<Void> refreshCache();

    /**
     * 获取字典选择框列表
     *
     * @return 列表
     */
    @GetMapping("/optionselect")
    R<List<SysDictType>> optionselect();
}
