package site.shenxiu.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import site.shenxiu.common.core.constant.SystemConstants;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.common.mybatis.pagination.PageUtils;
import site.shenxiu.system.domain.SysRole;
import site.shenxiu.system.domain.SysUserRole;
import site.shenxiu.system.mapper.SysRoleMapper;
import site.shenxiu.system.service.SysRoleService;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * 针对表【sys_role(角色信息表)】的数据库操作Service实现
 *
 * @author shenxiu
 * @version 2022-11-24 15:16:19
 */
@RequiredArgsConstructor
@Service
public class SysRoleServiceImpl implements SysRoleService {

    private final SysRoleMapper baseMapper;


    @Override
    public PageData<SysRole> selectPageRoleList(SysRole role, PageQuery pageQuery) {
        Page<SysRole> page = baseMapper.selectPage(PageUtils.build(pageQuery), this.defaultLambdaQueryWrapper(role));
        return PageUtils.build(page);
    }

    @Override
    public List<SysRole> selectRoleList(SysRole role) {
        List<SysRole> sysRoles = baseMapper.selectList(this.defaultLambdaQueryWrapper(role));
        return sysRoles;
    }

    @Override
    public List<SysRole> selectRolesByUserId(Long userId) {
        return null;
    }

    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {
        return null;
    }

    @Override
    public List<SysRole> selectRoleAll() {
        return null;
    }

    @Override
    public List<Long> selectRoleListByUserId(Long userId) {
        return null;
    }

    @Override
    public SysRole selectRoleById(Long roleId) {
        return baseMapper.selectById(roleId);
    }

    @Override
    public String checkRoleNameUnique(SysRole role) {
        boolean exist = baseMapper.exists(new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getRoleName, role.getRoleName())
                .ne(ObjectUtil.isNotNull(role.getRoleId()), SysRole::getRoleId, role.getRoleId()));
        if (exist) {
            return SystemConstants.NOT_UNIQUE;
        }
        return SystemConstants.UNIQUE;
    }

    @Override
    public String checkRoleKeyUnique(SysRole role) {
        boolean exist = baseMapper.exists(new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getRoleKey, role.getRoleKey())
                .ne(ObjectUtil.isNotNull(role.getRoleId()), SysRole::getRoleId, role.getRoleId()));
        if (exist) {
            return SystemConstants.NOT_UNIQUE;
        }
        return SystemConstants.UNIQUE;
    }

    @Override
    public void checkRoleAllowed(SysRole role) {

    }

    @Override
    public void checkRoleDataScope(Long roleId) {

    }

    @Override
    public long countUserRoleByRoleId(Long roleId) {
        return 0;
    }

    @Override
    public int insertRole(SysRole role) {
        return baseMapper.insert(role);
    }

    @Override
    public int updateRole(SysRole role) {
        return baseMapper.updateById(role);
    }

    @Override
    public int updateRoleStatus(SysRole role) {
        return 0;
    }

    @Override
    public int authDataScope(SysRole role) {
        return 0;
    }

    @Override
    public int deleteRoleById(Long roleId) {
        return baseMapper.deleteById(roleId);
    }

    @Override
    public int deleteRoleByIds(Long[] roleIds) {
        return baseMapper.deleteBatchIds(Arrays.asList(roleIds.clone()));
    }

    @Override
    public int deleteAuthUser(SysUserRole userRole) {
        return 0;
    }

    @Override
    public int deleteAuthUsers(Long roleId, Long[] userIds) {
        return 0;
    }

    @Override
    public int insertAuthUsers(Long roleId, Long[] userIds) {
        return 0;
    }

    /**
     * 默认Wrapper
     *
     * @param role 角色
     * @return Lambda 语法使用 Wrapper
     */
    private LambdaQueryWrapper defaultLambdaQueryWrapper(SysRole role) {
        return new LambdaQueryWrapper<SysRole>()
                .like(StringUtils.isNotBlank(role.getRoleName()), SysRole::getRoleName, role.getRoleName())
                .eq(StringUtils.isNotBlank(role.getStatus()), SysRole::getStatus, role.getStatus())
                .eq(ObjectUtil.isNotNull(role.getRoleId()), SysRole::getRoleId, role.getRoleId())
                .like(StringUtils.isNotBlank(role.getRoleKey()), SysRole::getRoleKey, role.getRoleKey())
                .orderByAsc(SysRole::getRoleSort);
    }
}




