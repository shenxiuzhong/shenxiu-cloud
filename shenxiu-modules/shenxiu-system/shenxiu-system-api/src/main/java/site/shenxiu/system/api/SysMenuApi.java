package site.shenxiu.system.api;

import cn.hutool.core.lang.tree.Tree;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import site.shenxiu.common.core.domain.ResEntity;
import site.shenxiu.system.domain.SysMenu;
import site.shenxiu.system.domain.vo.RouterVo;

import java.util.List;
import java.util.Map;

/**
 * 菜单按钮API定义
 *
 * @author ShenXiu
 * @version 2022/12/5 9:25
 * @definition 菜单按钮API定义
 */
public interface SysMenuApi {

    /**
     * 获取菜单列表
     * @param menu 菜单
     * @return 列表
     */
//    @SaCheckPermission("system:menu:list")
    @GetMapping("/list")
    ResEntity<List<SysMenu>> list(SysMenu menu);

    /**
     * 一级菜单列表
     * @param menu 菜单
     * @return 列表
     */
    @GetMapping("/dirMenuList")
    ResEntity<List<SysMenu>> dirMenuList(SysMenu menu);

    /**
     * 根据菜单编号获取详细信息
     *
     * @param menuId 菜单ID
     * @return 菜单
     */
//    @SaCheckPermission("system:menu:query")
    @GetMapping(value = "/{menuId}")
    ResEntity<SysMenu> getInfo(@PathVariable Long menuId);

    /**
     * 获取菜单下拉树列表
     * @param menu 菜单
     * @return 树数据
     */
    @GetMapping("/treeselect")
    ResEntity<List<Tree<Long>>> treeselect(SysMenu menu);

    /**
     * 加载对应角色菜单列表树
     *
     * @param roleId 角色ID
     * @return  角色菜单列表树
     */
    @GetMapping(value = "/roleMenuTreeselect/{roleId}")
    ResEntity<Map<String, Object>> roleMenuTreeselect(@PathVariable("roleId") Long roleId);

    /**
     * 新增菜单
     * @param menu 菜单
     * @return 响应对象
     */
//    @SaCheckPermission("system:menu:add")
//    @Log(title = "菜单管理", businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    ResEntity<Void> add(@Validated @RequestBody SysMenu menu);

    /**
     * 修改菜单
     * @param menu 菜单
     * @return 响应对象
     */
//    @SaCheckPermission("system:menu:edit")
//    @Log(title = "菜单管理", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/edit")
    ResEntity<Void> edit(@Validated @RequestBody SysMenu menu);

    /**
     * 删除菜单
     *
     * @param menuId 菜单ID
     * @return 响应对象
     */
//    @SaCheckPermission("system:menu:remove")
//    @Log(title = "菜单管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove/{menuId}")
    ResEntity<Void> remove(@RequestBody Long menuId);

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("/getRouters")
    ResEntity<List<RouterVo>> getRouters();
}
