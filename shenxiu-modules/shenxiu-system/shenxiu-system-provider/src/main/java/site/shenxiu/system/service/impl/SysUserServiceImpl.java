package site.shenxiu.system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.system.domain.SysUser;
import site.shenxiu.system.service.SysUserService;

import java.util.List;

/**
* 针对表【sys_user(用户信息表)】的数据库操作Service实现
* @author shenxiu
* @version 2022-11-24 15:16:28
*/
@RequiredArgsConstructor
@Service
public class SysUserServiceImpl implements SysUserService{

    @Override
    public PageData<SysUser> selectPageUserList(SysUser user, PageQuery pageQuery) {
        return null;
    }

    @Override
    public List<SysUser> selectUserList(SysUser user) {
        return null;
    }

    @Override
    public PageData<SysUser> selectAllocatedList(SysUser user, PageQuery pageQuery) {
        return null;
    }

    @Override
    public PageData<SysUser> selectUnallocatedList(SysUser user, PageQuery pageQuery) {
        return null;
    }

    @Override
    public SysUser selectUserByUserName(String userName) {
        return null;
    }

    @Override
    public SysUser selectUserByPhonenumber(String phonenumber) {
        return null;
    }

    @Override
    public SysUser selectUserById(Long userId) {
        return null;
    }

    @Override
    public String selectUserRoleGroup(String userName) {
        return null;
    }

    @Override
    public String selectUserPostGroup(String userName) {
        return null;
    }

    @Override
    public String checkUserNameUnique(String userName) {
        return null;
    }

    @Override
    public String checkPhoneUnique(SysUser user) {
        return null;
    }

    @Override
    public String checkEmailUnique(SysUser user) {
        return null;
    }

    @Override
    public void checkUserAllowed(SysUser user) {

    }

    @Override
    public void checkUserDataScope(Long userId) {

    }

    @Override
    public int insertUser(SysUser user) {
        return 0;
    }

    @Override
    public boolean registerUser(SysUser user) {
        return false;
    }

    @Override
    public int updateUser(SysUser user) {
        return 0;
    }

    @Override
    public void insertUserAuth(Long userId, Long[] roleIds) {

    }

    @Override
    public int updateUserStatus(SysUser user) {
        return 0;
    }

    @Override
    public int updateUserProfile(SysUser user) {
        return 0;
    }

    @Override
    public boolean updateUserAvatar(String userName, String avatar) {
        return false;
    }

    @Override
    public int resetPwd(SysUser user) {
        return 0;
    }

    @Override
    public int resetUserPwd(String userName, String password) {
        return 0;
    }

    @Override
    public int deleteUserById(Long userId) {
        return 0;
    }

    @Override
    public int deleteUserByIds(Long[] userIds) {
        return 0;
    }
}




