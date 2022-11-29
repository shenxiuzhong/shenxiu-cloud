package site.shenxiu.system.service;


import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.system.domain.SysLoginInfo;

import java.util.List;

/**
* 针对表【sys_logininfor(系统访问记录)】的数据库操作Service
* @author ShenXiu
* @version 2022-11-24 15:15:52
*/
public interface SysLoginInfoService {
    /**
     * 分页查询登录日志
     * @param loginInfo 访问日志对象
     * @param pageQuery 分页查询对象
     * @return 分页结构
     */
    PageData<SysLoginInfo> selectPageLoginInfoList(SysLoginInfo loginInfo, PageQuery pageQuery);

    /**
     * 新增系统登录日志
     *
     * @param loginInfo 访问日志对象
     * @return 结果
     */
    int insertLoginInfo(SysLoginInfo loginInfo);

    /**
     * 查询系统登录日志集合
     *
     * @param loginInfo 访问日志对象
     * @return 登录记录集合
     */
    List<SysLoginInfo> selectLoginInfoList(SysLoginInfo loginInfo);

    /**
     * 批量删除系统登录日志
     *
     * @param infoIds 需要删除的登录日志ID
     * @return 结果
     */
    int deleteLoginInfoByIds(Long[] infoIds);

    /**
     * 清空系统登录日志
     */
    void cleanLoginInfo();
}
