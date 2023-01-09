package site.shenxiu.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import site.shenxiu.system.domain.SysMenu;

import java.util.List;

/**
* 针对表【sys_menu(菜单权限表)】的数据库操作Mapper
* @author shenxiu
* @version 2022-11-24 15:15:56
*/
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据角色ID查询菜单列表
     * @param roleId 角色ID
     * @return 菜单列表
     */
    List<SysMenu> selectMenuListByRoleId(Long roleId);

    /**
     * 根据角色ID查询权限
     *
     * @param roleId 角色ID
     * @return 权限列表
     */
    //public List<String> selectMenuPermsByRoleId(Long roleId);

}




