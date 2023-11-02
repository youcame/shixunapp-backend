package com.shixun.app.mapper;

import com.shixun.app.model.entity.Post;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Date;
import java.util.List;

/**
* @author HUANG
* @description 针对表【post(新闻)】的数据库操作Mapper
* @createDate 2023-11-02 10:19:56
* @Entity com.shixun.app.model.entity.Post
*/
public interface PostMapper extends BaseMapper<Post> {
    /**
     * 查询帖子列表（包括已被删除的数据）
     */
    List<Post> listPostWithDelete(Date minUpdateTime);
}




