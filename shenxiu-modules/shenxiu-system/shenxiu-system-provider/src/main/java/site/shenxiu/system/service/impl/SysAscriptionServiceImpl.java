package site.shenxiu.system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.shenxiu.system.mapper.SysAscriptionMapper;
import site.shenxiu.system.service.SysAscriptionService;

/**
* 针对表【sys_ascription(归属表，人员归属)】的数据库操作Service实现
* @author ShenXiu
* @version 2022-11-30 13:09:00
*/
@RequiredArgsConstructor
@Service
public class SysAscriptionServiceImpl implements SysAscriptionService{
    private final SysAscriptionMapper baseMapper;

}




