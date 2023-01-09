package site.shenxiu.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.common.mybatis.pagination.PageUtils;
import site.shenxiu.system.domain.SysLoginInfo;
import site.shenxiu.system.mapper.SysLoginInfoMapper;
import site.shenxiu.system.service.SysLoginInfoService;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 针对表【sys_logininfor(系统访问记录)】的数据库操作Service实现
 *
 * @author shenxiu
 * @version 2022-11-24 15:15:52
 */
@RequiredArgsConstructor
@Service
public class SysLoginInfoServiceImpl implements SysLoginInfoService {

    private final SysLoginInfoMapper baseMapper;

    /**
     * 分页查询登录日志
     *
     * @param loginInfo 访问日志对象
     * @param pageQuery 分页查询对象
     * @return 分页结构
     */
    @Override
    public PageData<SysLoginInfo> selectPageLoginInfoList(SysLoginInfo loginInfo, PageQuery pageQuery) {
        LambdaQueryWrapper<SysLoginInfo> lqw = new LambdaQueryWrapper<SysLoginInfo>()
                .like(StringUtils.isNotBlank(loginInfo.getIpaddr()), SysLoginInfo::getIpaddr, loginInfo.getIpaddr())
                .eq(StringUtils.isNotBlank(loginInfo.getStatus()), SysLoginInfo::getStatus, loginInfo.getStatus())
                .like(StringUtils.isNotBlank(loginInfo.getUserName()), SysLoginInfo::getUserName, loginInfo.getUserName());
        if (StringUtils.isBlank(pageQuery.getOrderByColumn())) {
            pageQuery.setOrderByColumn("info_id");
            pageQuery.setIsAsc("desc");
        }
        Page<SysLoginInfo> page = baseMapper.selectPage(PageUtils.build(pageQuery), lqw);
        return PageUtils.build(page);
    }

    /**
     * 新增系统登录日志
     *
     * @param loginInfo 访问日志对象
     * @return 结果
     */
    @Override
    public int insertLoginInfo(SysLoginInfo loginInfo) {
        loginInfo.setAccessTime(new Date());
        baseMapper.insert(loginInfo);
        return 0;
    }

    /**
     * 查询系统登录日志集合
     *
     * @param loginInfo 访问日志对象
     * @return 登录记录集合
     */
    @Override
    public List<SysLoginInfo> selectLoginInfoList(SysLoginInfo loginInfo) {
        return baseMapper.selectList(new LambdaQueryWrapper<SysLoginInfo>()
                .like(StringUtils.isNotBlank(loginInfo.getIpaddr()), SysLoginInfo::getIpaddr, loginInfo.getIpaddr())
                .eq(StringUtils.isNotBlank(loginInfo.getStatus()), SysLoginInfo::getStatus, loginInfo.getStatus())
                .like(StringUtils.isNotBlank(loginInfo.getUserName()), SysLoginInfo::getUserName, loginInfo.getUserName())
                .orderByDesc(SysLoginInfo::getInfoId));
    }

    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return 结果
     */
    @Override
    public int deleteLoginInfoByIds(Long[] infoIds) {
        return baseMapper.deleteBatchIds(Arrays.asList(infoIds));
    }

    /**
     * 清空系统登录日志
     */
    @Override
    public void cleanLoginInfo() {

    }
}




