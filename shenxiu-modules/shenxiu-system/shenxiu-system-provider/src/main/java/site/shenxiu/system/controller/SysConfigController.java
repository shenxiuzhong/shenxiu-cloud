package site.shenxiu.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.shenxiu.common.core.domain.R;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.common.web.controller.BaseController;
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
public class SysConfigController extends BaseController implements SysConfigApi {

    private final SysConfigService configService;

    @Override
    public R<PageData<SysConfig>> getPage(SysConfig config, PageQuery pageQuery) {
        PageData<SysConfig> sysConfigPageData = configService.selectPageConfigList(config, pageQuery);
        return R.success(sysConfigPageData);
    }

    @Override
    public void export(SysConfig config) {

    }

    @Override
    public R<SysConfig> getInfo(Long configId) {
        return R.success(configService.selectConfigById(configId));
    }

    @Override
    public R<String> getConfigKey(String configKey) {
        return null;
    }

    @Override
    public R<Void> add(SysConfig config) {
        configService.insertConfig(config);
        return R.success();
    }

    @Override
    public R<Void> edit(SysConfig config) {
        configService.updateConfig(config);
        return R.success();
    }

    @Override
    public R<Void> updateByKey(SysConfig config) {
        return null;
    }

    @Override
    public R<Void> remove(Long[] configIds) {
        configService.deleteConfigByIds(configIds);
        return R.success();
    }

    @Override
    public R<Void> refreshCache() {
        return null;
    }
}
