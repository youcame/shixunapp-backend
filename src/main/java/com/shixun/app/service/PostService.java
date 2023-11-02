package com.shixun.app.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shixun.app.model.dto.post.PostQueryRequest;
import com.shixun.app.model.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shixun.app.model.vo.PostVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author HUANG
* @description 针对表【post(新闻)】的数据库操作Service
* @createDate 2023-11-02 10:19:56
*/
public interface PostService extends IService<Post> {
    /**
     * 校验
     *
     * @param post
     * @param add
     */
    void validPost(Post post, boolean add);

    /**
     * 获取查询条件
     *
     * @param postQueryRequest
     * @return
     */
    QueryWrapper<Post> getQueryWrapper(PostQueryRequest postQueryRequest);

    /**
     * 获取帖子封装
     *
     * @param post
     * @param request
     * @return
     */
    PostVO getPostVO(Post post, HttpServletRequest request);

    /**
     * 分页获取帖子封装
     *
     * @param postPage
     * @param request
     * @return
     */
    Page<PostVO> getPostVOPage(Page<Post> postPage, HttpServletRequest request);

}
