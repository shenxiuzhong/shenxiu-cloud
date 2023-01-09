package site.shenxiu.system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.system.domain.SysOperLog;
import site.shenxiu.system.service.SysOperLogService;

import java.util.List;

/**
* 针对表【sys_oper_log(操作日志记录)】的数据库操作Service实现
* @author shenxiu
* @version 2022-11-24 15:16:06
*/
@RequiredArgsConstructor
@Service
public class SysOperLogServiceImpl implements SysOperLogService{

    @Override
    public PageData<SysOperLog> selectPageOperLogList(SysOperLog operLog, PageQuery pageQuery) {
        return null;
    }

    @Override
    public int insertOperlog(SysOperLog operLog) {
        return 0;
    }

    @Override
    public List<SysOperLog> selectOperLogList(SysOperLog operLog) {
        return null;
    }

    @Override
    public int deleteOperLogByIds(Long[] operIds) {
        return 0;
    }

    @Override
    public SysOperLog selectOperLogById(Long operId) {
        return null;
    }

    @Override
    public void cleanOperLog() {

    }
}




