package site.shenxiu.system.controller;

import cn.hutool.core.lang.tree.Tree;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.shenxiu.common.core.constant.SystemConstants;
import site.shenxiu.common.core.domain.R;
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
 * @author ShenXiu
 * @version 2022/12/5 9:37
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/menu")
public class SysMenuController extends BaseController implements SysMenuApi {

    private final SysMenuService sysMenuService;

    @Override
    public R<List<SysMenu>> list(SysMenu menu) {
        Long userId = null;//LoginHelper.getUserId();
        List<SysMenu> menus = sysMenuService.selectMenuList(menu, userId);
        return R.success(menus);
    }

    @Override
    public R<List<SysMenu>> dirMenuList(SysMenu menu) {
        menu.setMenuType(SystemConstants.TYPE_DIR);
        return null;
    }

    @Override
    public R<SysMenu> getInfo(Long menuId) {
        return R.success(sysMenuService.selectMenuById(menuId));
    }

    @Override
    public R<List<Tree<Long>>> treeselect(SysMenu menu) {
        return null;
    }

    @Override
    public R<Map<String, Object>> roleMenuTreeselect(Long roleId) {
        return null;
    }

    @Override
    public R<Void> add(SysMenu menu) {
        sysMenuService.insertMenu(menu);
        return R.success();
    }

    @Override
    public R<Void> edit(SysMenu menu) {
        sysMenuService.updateMenu(menu);
        return R.success();
    }

    @Override
    public R<Void> remove(Long menuId) {
        return null;
    }

    @Override
    public R<List<RouterVo>> getRouters() {
        //Long userId = LoginHelper.getUserId();
        List<SysMenu> menus = sysMenuService.selectMenuTreeByUserId(null);
        return R.success(sysMenuService.buildMenus(menus));
    }
}
