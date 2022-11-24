package site.shenxiu.system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.shenxiu.system.mapper.SysDeptMapper;
import site.shenxiu.system.service.SysDeptService;

/**
* 针对表【sys_dept(部门表)】的数据库操作Service实现
* @author ShenXiu
* @version 2022-11-24 14:58:02
*/
@RequiredArgsConstructor
@Service
public class SysDeptServiceImpl implements SysDeptService{
    private final SysDeptMapper baseMapper;
}




