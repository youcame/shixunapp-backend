package com.shixun.app.service;
import java.util.Date;

import com.shixun.app.model.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 帖子服务测试
 *
 * @author Huang
 * @from Huang
 */
@SpringBootTest
class PostServiceTest {

    @Resource
    private PostService postService;

    @Test
    void insert() {
        for(int i=1;i<=103;i++) {
            Post post = postService.getById(i);
            post.setThumbNum((int) (Math.random() * 5000) + 1);
            post.setFavourNum((int) (Math.random() * 5000) + 1);
            postService.updateById(post);
        }
    }

}