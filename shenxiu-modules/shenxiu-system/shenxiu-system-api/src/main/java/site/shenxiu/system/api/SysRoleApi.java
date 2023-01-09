package site.shenxiu.system.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import site.shenxiu.common.core.domain.ResEntity;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.system.domain.SysRole;
import site.shenxiu.system.domain.SysUser;
import site.shenxiu.system.domain.SysUserRole;

import java.util.List;
import java.util.Map;

/**
 * 角色Api 定义
 *
 * @author shenxiu
 * @version 2022/12/5 16:11
 * @definition 角色Api 定义
 */
public interface SysRoleApi {

    /**
     * 查询角色信息列表
     *
     * @param role      角色
     * @param pageQuery 分页查询对象
     * @return 分页列表
     */
//    @SaCheckPermission("system:role:list")
    @GetMapping("/list")
    ResEntity<PageData<SysRole>> list(SysRole role, PageQuery pageQuery);

    /**
     * 导出角色信息列表
     *
     * @param role 角色
     * @return 响应数据
     */
//    @Log(title = "角色管理", businessType = BusinessType.EXPORT)
//    @SaCheckPermission("system:role:export")
    @PostMapping("/export")
    ResEntity<Void> export(SysRole role);

    /**
     * 根据角色编号获取详细信息
     *
     * @param roleId 角色ID
     * @return 角色信息
     */
//    @SaCheckPermission("system:role:query")
    @GetMapping(value = "/{roleId}")
    ResEntity<SysRole> getInfo(@PathVariable Long roleId);

    /**
     * 新增角色
     *
     * @param role 角色
     * @return 响应对象
     */
//    @SaCheckPermission("system:role:add")
//    @Log(title = "角色管理", businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    ResEntity<Void> add(@Validated @RequestBody SysRole role);

    /**
     * 修改保存角色
     *
     * @param role 角色
     * @return 响应对象
     */
//    @SaCheckPermission("system:role:edit")
//    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/edit")
    ResEntity<Void> edit(@Validated @RequestBody SysRole role);

    /**
     * 修改保存数据权限
     *
     * @param role 角色
     * @return 响应对象
     */
//    @SaCheckPermission("system:role:edit")
//    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
    @PostMapping("/dataScope")
    ResEntity<Void> dataScope(@RequestBody SysRole role);

    /**
     * 状态修改
     *
     * @param role 角色
     * @return 响应对象
     */
//    @SaCheckPermission("system:role:edit")
//    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    ResEntity<Void> changeStatus(@RequestBody SysRole role);

    /**
     * 删除角色
     *
     * @param roleIds 角色ID串
     * @return 响应对象
     */
//    @SaCheckPermission("system:role:remove")
//    @Log(title = "角色管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove/{roleIds}")
    ResEntity<Void> remove(@RequestBody Long[] roleIds);

    /**
     * 获取角色选择框列表
     *
     * @return 角色列表
     */
//    @SaCheckPermission("system:role:query")
    @GetMapping("/optionselect")
    ResEntity<List<SysRole>> optionselect();

    /**
     * 查询已分配用户角色列表
     *
     * @param user      用户
     * @param pageQuery 分页查询
     * @return 分页数据
     */
//    @SaCheckPermission("system:role:list")
    @GetMapping("/authUser/allocatedList")
    ResEntity<PageData<SysUser>> allocatedList(SysUser user, PageQuery pageQuery);

    /**
     * 查询未分配用户角色列表
     *
     * @param user      用户
     * @param pageQuery 分页查询
     * @return 分页数据
     */
//    @SaCheckPermission("system:role:list")
    @GetMapping("/authUser/unallocatedList")
    ResEntity<PageData<SysUser>> unallocatedList(SysUser user, PageQuery pageQuery);

    /**
     * 取消授权用户
     *
     * @param userRole 用户角色
     * @return 响应对象
     */
//    @SaCheckPermission("system:role:edit")
//    @Log(title = "角色管理", businessType = BusinessType.GRANT)
    @PostMapping("/authUser/cancel")
    ResEntity<Void> cancelAuthUser(@RequestBody SysUserRole userRole);

    /**
     * 批量取消授权用户
     *
     * @param roleId  角色ID
     * @param userIds 用户ID串
     * @return 响应对象
     */
//    @SaCheckPermission("system:role:edit")
//    @Log(title = "角色管理", businessType = BusinessType.GRANT)
    @PostMapping("/authUser/cancelAll")
    ResEntity<Void> cancelAuthUserAll(Long roleId, Long[] userIds);

    /**
     * 批量选择用户授权
     *
     * @param roleId  角色ID
     * @param userIds 用户ID串
     * @return 响应对象
     */
//    @SaCheckPermission("system:role:edit")
//    @Log(title = "角色管理", businessType = BusinessType.GRANT)
    @PostMapping("/authUser/selectAll")
    ResEntity<Void> selectAuthUserAll(Long roleId, Long[] userIds);

    /**
     * 获取对应角色部门树列表
     *
     * @param roleId 角色ID
     * @return 响应对象
     */
//    @SaCheckPermission("system:role:query")
    @GetMapping(value = "/deptTree/{roleId}")
    ResEntity<Map<String, Object>> deptTree(@PathVariable("roleId") Long roleId);
}
