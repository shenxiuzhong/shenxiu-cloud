package site.shenxiu.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.constructor.BaseConstructor;
import site.shenxiu.common.core.domain.R;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.system.api.SysConfigApi;
import site.shenxiu.system.domain.SysConfig;
import site.shenxiu.system.service.SysConfigService;

/**
 * 参数配置 处置类
 *
 * @author ShenXiu
 * @version 2022/11/24 11:45
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/config")
public class SysConfigController extends BaseConstructor implements SysConfigApi {

    private final SysConfigService configService;

    @GetMapping("/list")
    @Override
    public R<PageData<SysConfig>> list(SysConfig config, PageQuery pageQuery) {
        PageData<SysConfig> sysConfigPageData = configService.selectPageConfigList(config, pageQuery);
        return R.success(sysConfigPageData);
    }

    @Override
    public void export(SysConfig config) {

    }

    @Override
    public R<SysConfig> get(Long configId) {
        return null;
    }

    @Override
    public R<String> getConfigKey(String configKey) {
        return null;
    }

    @Override
    public R<Void> add(SysConfig config) {
        return null;
    }

    @Override
    public R<Void> edit(SysConfig config) {
        return null;
    }

    @Override
    public R<Void> updateByKey(SysConfig config) {
        return null;
    }

    @Override
    public R<Void> remove(Long[] configIds) {
        return null;
    }

    @Override
    public R<Void> refreshCache() {
        return null;
    }
}
