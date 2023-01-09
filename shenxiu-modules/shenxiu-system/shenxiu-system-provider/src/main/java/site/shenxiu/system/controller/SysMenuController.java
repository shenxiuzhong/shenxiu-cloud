package site.shenxiu.system.controller;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.shenxiu.common.core.constant.SystemConstants;
import site.shenxiu.common.core.domain.ResEntity;
import site.shenxiu.common.web.controller.BaseController;
import site.shenxiu.system.api.SysMenuApi;
import site.shenxiu.system.domain.SysMenu;
import site.shenxiu.system.domain.vo.RouterVo;
import site.shenxiu.system.service.SysMenuService;

import java.util.List;
import java.util.Map;

/**
 * 菜单按钮 处置类
 *
 * @author shenxiu
 * @version 2022/12/5 9:37
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class SysMenuController extends BaseController implements SysMenuApi {

    private final SysMenuService sysMenuService;

    @Override
    public ResEntity<List<SysMenu>> list(SysMenu menu) {
        Long userId = null;//LoginHelper.getUserId();
        List<SysMenu> menus = sysMenuService.selectMenuList(menu, userId);
        return ResEntity.success(menus);
    }

    @Override
    public ResEntity<List<SysMenu>> dirMenuList(SysMenu menu) {
        menu.setMenuType(SystemConstants.TYPE_DIR);
        return null;
    }

    @Override
    public ResEntity<SysMenu> getInfo(Long menuId) {
        return ResEntity.success(sysMenuService.selectMenuById(menuId));
    }

    @Override
    public ResEntity<List<Tree<Long>>> treeselect(SysMenu sysMenu) {
        //Long userId = LoginHelper.getUserId();
        List<SysMenu> menus = sysMenuService.selectMenuList(sysMenu, null);
        List<Tree<Long>> treeList = TreeUtil.build(menus, 0L, TreeNodeConfig.DEFAULT_CONFIG.setNameKey("label"), (menu, tree) ->
                tree.setId(menu.getMenuId())
                        .setParentId(menu.getParentId())
                        .setName(menu.getMenuName())
                        .setWeight(menu.getOrderNum()));
        return ResEntity.success(treeList);
    }

    @Override
    public ResEntity<Map<String, Object>> roleMenuTreeselect(Long roleId) {
        return null;
    }

    @Override
    public ResEntity<Void> add(SysMenu menu) {
        sysMenuService.insertMenu(menu);
        return ResEntity.success();
    }

    @Override
    public ResEntity<Void> edit(SysMenu menu) {
        sysMenuService.updateMenu(menu);
        return ResEntity.success();
    }

    @Override
    public ResEntity<Void> remove(Long menuId) {
        return null;
    }

    @Override
    public ResEntity<List<RouterVo>> getRouters() {
        //Long userId = LoginHelper.getUserId();
        List<SysMenu> menus = sysMenuService.selectMenuTreeByUserId(null);
        return ResEntity.success(sysMenuService.buildMenus(menus));
    }
}
