package com.shixun.app.service;
import java.util.Date;
import java.util.Random;

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

    Random random = new Random();
    String[] avatarUrls = {
            "https://hzh-1318734603.cos.ap-shanghai.myqcloud.com/news1.png",
            "https://hzh-1318734603.cos.ap-shanghai.myqcloud.com/news2.png",
            "https://hzh-1318734603.cos.ap-shanghai.myqcloud.com/news3.png",
            "https://hzh-1318734603.cos.ap-shanghai.myqcloud.com/news4.png"
    };

    @Test
    void insert() {
        for(int i=1;i<=103;i++) {
            Post post = postService.getById(i);
            post.setThumbNum((int) (Math.random() * 5000) + 1);
            post.setFavourNum((int) (Math.random() * 5000) + 1);
            postService.updateById(post);
        }
    }

    @Test
    void update() {
        for(int i=1;i<=103;i++) {
            Post post = postService.getById(i);
            int index = random.nextInt(avatarUrls.length);
            post.setAvatar(avatarUrls[index]);
            postService.updateById(post);
        }
    }


}