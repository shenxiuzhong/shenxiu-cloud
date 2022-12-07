package site.shenxiu.system.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import site.shenxiu.common.core.domain.ResEntity;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.system.domain.SysDictData;

import java.util.List;

/**
 * 数据字典数据 API定义
 *
 * @author ShenXiu
 * @version 2022/11/30 16:04
 * @definition 数据字典数据api定义
 */
public interface SysDictDataApi {
    /**
     * 查询字典数据列表
     *
     * @param dictData  字典数据
     * @param pageQuery 分页查询对象
     * @return 分页对象
     */
    @GetMapping("/getPage")
    ResEntity<PageData<SysDictData>> getPage(SysDictData dictData, PageQuery pageQuery);

    /**
     * 导出字典数据列表
     *
     * @param dictData 字典数据
     */
    @PostMapping("/export")
    void export(SysDictData dictData);

    /**
     * 查询字典数据详细
     *
     * @param dictDataId 字典code
     * @return 字典数据
     */
    @GetMapping(value = "/{dictDataId}")
    ResEntity<SysDictData> getInfo(@PathVariable Long dictDataId);

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     * @return 字典数据列表
     */
    @GetMapping(value = "/type/{dictType}")
    ResEntity<List<SysDictData>> dictType(@PathVariable String dictType);

    /**
     * 新增字典数据
     *
     * @param dict 字典数据
     * @return 响应对象
     */
    @PostMapping(value = "/add")
    ResEntity<Void> add(@Validated @RequestBody SysDictData dict);


    /**
     * 修改保存字典类型
     *
     * @param dict 字典数据
     * @return 响应对象
     */
    @PostMapping(value = "/edit")
    ResEntity<Void> edit(@Validated @RequestBody SysDictData dict);

    /**
     * 删除字典类型
     *
     * @param dictDataIds 字典Code串
     * @return 响应对象
     */
    @PostMapping("/remove")
    ResEntity<Void> remove(@RequestBody Long[] dictDataIds);
}
