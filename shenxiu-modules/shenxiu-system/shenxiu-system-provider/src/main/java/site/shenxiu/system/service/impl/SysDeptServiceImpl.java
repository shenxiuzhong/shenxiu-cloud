package site.shenxiu.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import site.shenxiu.system.domain.SysDept;
import site.shenxiu.system.mapper.SysDeptMapper;
import site.shenxiu.system.service.SysDeptService;

import java.util.List;

/**
* 针对表【sys_dept(部门表)】的数据库操作Service实现
* @author shenxiu
* @version 2022-11-24 14:58:02
*/
@RequiredArgsConstructor
@Service
public class SysDeptServiceImpl implements SysDeptService{
    private final SysDeptMapper baseMapper;

    @Override
    public List<SysDept> selectDeptList(SysDept dept) {
        LambdaQueryWrapper<SysDept> lqw = new LambdaQueryWrapper<>();
        lqw.eq(ObjectUtil.isNotNull(dept.getDeptId()), SysDept::getDeptId, dept.getDeptId())
                .eq(ObjectUtil.isNotNull(dept.getParentId()), SysDept::getParentId, dept.getParentId())
                .like(StringUtils.isNotBlank(dept.getDeptName()), SysDept::getDeptName, dept.getDeptName())
                .eq(StringUtils.isNotBlank(dept.getStatus()), SysDept::getStatus, dept.getStatus())
                .orderByAsc(SysDept::getParentId)
                .orderByAsc(SysDept::getOrderNum);
        return baseMapper.selectList(lqw);
    }

    @Override
    public List<Tree<Long>> selectDeptTreeList(SysDept dept) {
        List<SysDept> depts = this.selectDeptList(dept);
        if (CollUtil.isEmpty(depts)) {
            return CollUtil.newArrayList();
        }
        //List<Tree<Object>> collect = ;
//        return TreeUtil.build(depts,-1, (sysDept, tree) ->
//                tree.setId(sysDept.getDeptId())
//                        .setParentId(sysDept.getParentId())
//                        .setName(sysDept.getDeptName())
//                        .setWeight(sysDept.getOrderNum()));

        return null;
    }

    @Override
    public List<Tree<Long>> buildDeptTreeSelect(List<SysDept> depts) {
        return null;
    }

    @Override
    public List<Long> selectDeptListByRoleId(Long roleId) {
//        SysRole role = roleMapper.selectById(roleId);
//        return baseMapper.selectDeptListByRoleId(roleId, role.getDeptCheckStrictly());
        return null;
    }

    @Override
    public SysDept selectDeptById(Long deptId) {
        SysDept dept = baseMapper.selectById(deptId);
        SysDept parentDept = baseMapper.selectOne(new LambdaQueryWrapper<SysDept>()
                .select(SysDept::getDeptName).eq(SysDept::getDeptId, dept.getParentId()));
        //dept.setParentName(ObjectUtil.isNotNull(parentDept) ? parentDept.getDeptName() : null);
        return dept;
    }

    @Override
    public long selectNormalChildrenDeptById(Long deptId) {
        return 0;
    }

    @Override
    public boolean hasChildByDeptId(Long deptId) {
        return false;
    }

    @Override
    public boolean checkDeptExistUser(Long deptId) {
        return false;
    }

    @Override
    public String checkDeptNameUnique(SysDept dept) {
        return null;
    }

    @Override
    public void checkDeptDataScope(Long deptId) {

    }

    @Override
    public int insertDept(SysDept dept) {
        return 0;
    }

    @Override
    public int updateDept(SysDept dept) {
        return 0;
    }

    @Override
    public int deleteDeptById(Long deptId) {
        return 0;
    }
}




