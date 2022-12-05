package site.shenxiu.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.shenxiu.common.core.domain.R;
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
 * @author ShenXiu
 * @version 2022/12/5 17:02
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/role")
public class SysRoleController extends BaseController implements SysRoleApi {

    private final SysRoleService sysRoleService;

    @Override
    public R<PageData<SysRole>> list(SysRole role, PageQuery pageQuery) {
        return null;
    }

    @Override
    public R<Void> export(SysRole role) {
        return null;
    }

    @Override
    public R<SysRole> getInfo(Long roleId) {
        return null;
    }

    @Override
    public R<Void> add(SysRole role) {
        return null;
    }

    @Override
    public R<Void> edit(SysRole role) {
        return null;
    }

    @Override
    public R<Void> dataScope(SysRole role) {
        return null;
    }

    @Override
    public R<Void> changeStatus(SysRole role) {
        return null;
    }

    @Override
    public R<Void> remove(Long[] roleIds) {
        return null;
    }

    @Override
    public R<List<SysRole>> optionselect() {
        return null;
    }

    @Override
    public R<PageData<SysUser>> allocatedList(SysUser user, PageQuery pageQuery) {
        return null;
    }

    @Override
    public R<PageData<SysUser>> unallocatedList(SysUser user, PageQuery pageQuery) {
        return null;
    }

    @Override
    public R<Void> cancelAuthUser(SysUserRole userRole) {
        return null;
    }

    @Override
    public R<Void> cancelAuthUserAll(Long roleId, Long[] userIds) {
        return null;
    }

    @Override
    public R<Void> selectAuthUserAll(Long roleId, Long[] userIds) {
        return null;
    }

    @Override
    public R<Map<String, Object>> deptTree(Long roleId) {
        return null;
    }
}
