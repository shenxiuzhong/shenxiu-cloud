package site.shenxiu.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.shenxiu.common.core.domain.ResEntity;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.common.web.controller.BaseController;
import site.shenxiu.system.api.SysRoleApi;
import site.shenxiu.system.domain.SysRole;
import site.shenxiu.system.domain.SysUser;
import site.shenxiu.system.domain.SysUserRole;
import site.shenxiu.system.service.SysRoleService;

import java.util.List;
import java.util.Map;

/**
 * 角色处置类
 *
 * @author ShenXiu
 * @version 2022/12/5 17:02
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/role")
public class SysRoleController extends BaseController implements SysRoleApi {

    private final SysRoleService sysRoleService;

    @Override
    public ResEntity<PageData<SysRole>> list(SysRole role, PageQuery pageQuery) {
        PageData<SysRole> sysRolePageData = sysRoleService.selectPageRoleList(role, pageQuery);
        return ResEntity.success(sysRolePageData);
    }

    @Override
    public ResEntity<Void> export(SysRole role) {
        return null;
    }

    @Override
    public ResEntity<SysRole> getInfo(Long roleId) {
        return ResEntity.success(sysRoleService.selectRoleById(roleId));
    }

    @Override
    public ResEntity<Void> add(SysRole role) {
        sysRoleService.insertRole(role);
        return ResEntity.success();
    }

    @Override
    public ResEntity<Void> edit(SysRole role) {
        sysRoleService.updateRole(role);
        return ResEntity.success();
    }

    @Override
    public ResEntity<Void> dataScope(SysRole role) {
        return null;
    }

    @Override
    public ResEntity<Void> changeStatus(SysRole role) {
        return null;
    }

    @Override
    public ResEntity<Void> remove(Long[] roleIds) {
        return null;
    }

    @Override
    public ResEntity<List<SysRole>> optionselect() {
        return null;
    }

    @Override
    public ResEntity<PageData<SysUser>> allocatedList(SysUser user, PageQuery pageQuery) {
        return null;
    }

    @Override
    public ResEntity<PageData<SysUser>> unallocatedList(SysUser user, PageQuery pageQuery) {
        return null;
    }

    @Override
    public ResEntity<Void> cancelAuthUser(SysUserRole userRole) {
        return null;
    }

    @Override
    public ResEntity<Void> cancelAuthUserAll(Long roleId, Long[] userIds) {
        return null;
    }

    @Override
    public ResEntity<Void> selectAuthUserAll(Long roleId, Long[] userIds) {
        return null;
    }

    @Override
    public ResEntity<Map<String, Object>> deptTree(Long roleId) {
        return null;
    }
}
