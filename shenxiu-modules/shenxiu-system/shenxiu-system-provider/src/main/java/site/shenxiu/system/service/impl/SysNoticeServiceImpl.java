package site.shenxiu.system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.system.domain.SysNotice;
import site.shenxiu.system.service.SysNoticeService;

import java.util.List;

/**
* 针对表【sys_notice(通知公告表)】的数据库操作Service实现
* @author ShenXiu
* @version 2022-11-24 15:16:02
*/
@RequiredArgsConstructor
@Service
public class SysNoticeServiceImpl implements SysNoticeService{

    @Override
    public PageData<SysNotice> selectPageNoticeList(SysNotice notice, PageQuery pageQuery) {
        return null;
    }

    @Override
    public SysNotice selectNoticeById(Long noticeId) {
        return null;
    }

    @Override
    public List<SysNotice> selectNoticeList(SysNotice notice) {
        return null;
    }

    @Override
    public int insertNotice(SysNotice notice) {
        return 0;
    }

    @Override
    public int updateNotice(SysNotice notice) {
        return 0;
    }

    @Override
    public int deleteNoticeById(Long noticeId) {
        return 0;
    }

    @Override
    public int deleteNoticeByIds(Long[] noticeIds) {
        return 0;
    }
}




