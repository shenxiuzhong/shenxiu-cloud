package site.shenxiu.system.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import site.shenxiu.common.core.domain.R;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.system.domain.SysConfig;

/**
 * 系统参数配置API定义
 *
 * @author ShenXiu
 * @version 2022/11/23 14:13
 * @definition 参数配置api定义
 */
public interface SysConfigApi {
    /**
     * 获取参数配置列表
     * @param config 参数配置
     * @param pageQuery 分页查询
     * @return 分页数据对象
     */
    @GetMapping("/getPage")
    R<PageData<SysConfig>> getPage(SysConfig config, PageQuery pageQuery);

    /**
     * 导出参数配置
     * @param config 参数配置
     */
    @PostMapping("/export")
    void export(SysConfig config);

    /**
     * 根据参数编号获取详细信息
     * @param configId 配置ID
     * @return 参数配置对象
     */
    @GetMapping(value = "/{configId}")
    R<SysConfig> getInfo(@PathVariable Long configId);

    /**
     * 根据参数键名查询参数值
     *
     * @param configKey 配置key
     * @return 参数值
     */
    @GetMapping(value = "/getConfigKey/{configKey}")
    R<String> getConfigKey(@PathVariable String configKey);

    /**
     * 新增参数配置
     * @param config 参数配置
     * @return 响应对象
     */
    @PostMapping(value = "/add")
    R<Void> add(@Validated @RequestBody SysConfig config);

    /**
     * 修改参数配置
     * @param config 参数配置
     * @return 响应对象
     */
    @PostMapping(value = "/edit")
    R<Void> edit(@Validated @RequestBody SysConfig config);

    /**
     * 根据参数键名修改参数配置
     * @param config 参数配置
     * @return 响应对象
     */
    @PostMapping(value = "/updateByKey")
    R<Void> updateByKey(@RequestBody SysConfig config);

    /**
     * 删除参数配置
     *
     * @param configIds 配置ID串
     * @return 响应对象
     */
    @PostMapping("/remove")
    R<Void> remove(@RequestBody Long[] configIds);

    /**
     * 刷新参数缓存
     * @return 响应对象
     */
    @GetMapping("/refreshCache")
    R<Void> refreshCache();
}
