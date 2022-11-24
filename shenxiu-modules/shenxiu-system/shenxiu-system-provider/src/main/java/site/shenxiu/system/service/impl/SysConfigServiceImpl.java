package site.shenxiu.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import site.shenxiu.common.core.constant.SystemConstants;
import site.shenxiu.common.core.exception.BusinessException;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.common.mybatis.pagination.PageUtils;
import site.shenxiu.system.domain.SysConfig;
import site.shenxiu.system.mapper.SysConfigMapper;
import site.shenxiu.system.service.SysConfigService;

import java.util.Arrays;
import java.util.List;

/**
 * 针对表【sys_config(参数配置表)】的数据库操作Service实现
 *
 * @author ShenXiu
 * @version 2022/11/23 16:01
 */
@RequiredArgsConstructor
@Service
public class SysConfigServiceImpl implements SysConfigService {

    private final SysConfigMapper baseMapper;

    @Override
    public PageData<SysConfig> selectPageConfigList(SysConfig config, PageQuery pageQuery) {
        LambdaQueryWrapper<SysConfig> lqw = new LambdaQueryWrapper<SysConfig>()
                .like(StringUtils.isNotBlank(config.getConfigName()), SysConfig::getConfigName, config.getConfigName())
                .eq(StringUtils.isNotBlank(config.getConfigType()), SysConfig::getConfigType, config.getConfigType())
                .like(StringUtils.isNotBlank(config.getConfigKey()), SysConfig::getConfigKey, config.getConfigKey());
        Page<SysConfig> page = baseMapper.selectPage(PageUtils.build(pageQuery), lqw);
        return PageUtils.build(page);
    }

    @Override
    public SysConfig selectConfigById(Long configId) {
        return baseMapper.selectById(configId);
    }

    @Override
    public String selectConfigByKey(String configKey) {
        SysConfig retConfig = baseMapper.selectOne(new LambdaQueryWrapper<SysConfig>()
                .eq(SysConfig::getConfigKey, configKey));
        if (ObjectUtil.isNotNull(retConfig)) {
            return retConfig.getConfigValue();
        }
        return StringUtils.EMPTY;
    }

    @Override
    public List<SysConfig> selectConfigList(SysConfig config) {
        LambdaQueryWrapper<SysConfig> lqw = new LambdaQueryWrapper<SysConfig>()
                .like(StringUtils.isNotBlank(config.getConfigName()), SysConfig::getConfigName, config.getConfigName())
                .eq(StringUtils.isNotBlank(config.getConfigType()), SysConfig::getConfigType, config.getConfigType())
                .like(StringUtils.isNotBlank(config.getConfigKey()), SysConfig::getConfigKey, config.getConfigKey());
        return baseMapper.selectList(lqw);
    }

    @Override
    public String insertConfig(SysConfig config) {
        baseMapper.insert(config);
        return null;
    }

    @Override
    public String updateConfig(SysConfig config) {
        if (config.getConfigId() != null) {
            baseMapper.updateById(config);
        } else {
            baseMapper.update(config, new LambdaQueryWrapper<SysConfig>().eq(SysConfig::getConfigKey, config.getConfigKey()));
        }
        return null;
    }

    @Override
    public void deleteConfigByIds(Long[] configIds) {
        for (Long configId : configIds) {
            SysConfig config = selectConfigById(configId);
            if (StringUtils.equals(SystemConstants.YES, config.getConfigType())) {
                throw new BusinessException(String.format("内置参数【%1$s】不能删除 ", config.getConfigKey()));
            }
        }
        baseMapper.deleteBatchIds(Arrays.asList(configIds));
    }

    @Override
    public void loadingConfigCache() {

    }

    @Override
    public void clearConfigCache() {

    }

    @Override
    public void resetConfigCache() {

    }

    @Override
    public String checkConfigKeyUnique(SysConfig config) {
        Long configId = ObjectUtil.isNull(config.getConfigId()) ? -1L : config.getConfigId();
        SysConfig info = baseMapper.selectOne(new LambdaQueryWrapper<SysConfig>().eq(SysConfig::getConfigKey, config.getConfigKey()));
        if (ObjectUtil.isNotNull(info) && info.getConfigId().longValue() != configId.longValue()) {
            return SystemConstants.NOT_UNIQUE;
        }
        return SystemConstants.UNIQUE;
    }
}




