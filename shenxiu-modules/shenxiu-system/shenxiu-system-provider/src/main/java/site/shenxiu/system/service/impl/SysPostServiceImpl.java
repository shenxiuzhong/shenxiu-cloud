package site.shenxiu.system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.shenxiu.common.core.page.PageData;
import site.shenxiu.common.core.page.PageQuery;
import site.shenxiu.system.domain.SysPost;
import site.shenxiu.system.service.SysPostService;

import java.util.List;

/**
* 针对表【sys_post(岗位信息表)】的数据库操作Service实现
* @author ShenXiu
* @version 2022-11-24 15:16:16
*/
@RequiredArgsConstructor
@Service
public class SysPostServiceImpl implements SysPostService{

    @Override
    public PageData<SysPost> selectPagePostList(SysPost post, PageQuery pageQuery) {
        return null;
    }

    @Override
    public List<SysPost> selectPostList(SysPost post) {
        return null;
    }

    @Override
    public List<SysPost> selectPostAll() {
        return null;
    }

    @Override
    public SysPost selectPostById(Long postId) {
        return null;
    }

    @Override
    public List<Long> selectPostListByUserId(Long userId) {
        return null;
    }

    @Override
    public String checkPostNameUnique(SysPost post) {
        return null;
    }

    @Override
    public String checkPostCodeUnique(SysPost post) {
        return null;
    }

    @Override
    public long countUserPostById(Long postId) {
        return 0;
    }

    @Override
    public int deletePostById(Long postId) {
        return 0;
    }

    @Override
    public int deletePostByIds(Long[] postIds) {
        return 0;
    }

    @Override
    public int insertPost(SysPost post) {
        return 0;
    }

    @Override
    public int updatePost(SysPost post) {
        return 0;
    }
}




