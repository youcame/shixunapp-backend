package com.shixun.app.service;
import com.shixun.app.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Random;

@SpringBootTest
class UserServiceTest {


    @Resource
    private UserService userService;

    // 随机中文昵称数组
    private String[] chineseNicknames = {
            "快乐小熊",
            "幸福阳光",
            "微笑天使",
            "美丽花朵",
            "热情火焰",
            "智慧猫咪",
            "勇敢小虎",
            "甜蜜蜜蜜蜜",
            "灵动精灵",
            "幽静夜空"
    };

    // 随机中文简介数组
    private String[] chineseDescriptions = {
            "热爱大自然，勇往直前。",
            "美食探索家，烹饪达人。",
            "科技迷与代码高手。",
            "书迷，咖啡控，热爱烹饪。",
            "音乐爱好者，吉他高手。",
            "健身狂人，健身房达人。",
            "旅行者，探索世界之美。",
            "艺术爱好者，画画狂人。",
            "电影迷，爆米花行家。",
            "游戏玩家，电子竞技高手。"
    };

    @Test
    void randomUser() {
        Random random = new Random();
        for (int i = 1; i <= 10000; i++) {
            User user = new User();
            user.setUserAccount(generateRandomChineseNickname(random));
            user.setUserPassword("12345678");
            user.setUserName(generateRandomChineseNickname(random));
            user.setUserAvatar("https://avatars.githubusercontent.com/u/103118339?v=4");
            user.setUserProfile(generateRandomChineseDescription(random));
            user.setUserRole(generateRandomUserRole(random));
            userService.save(user);
        }
    }

    @Test
    void updateUser() {
        for (int i = 1; i <= 10028; i++) {
            User user = userService.getById(i);
            if(user!=null) {
                user.setUserPassword("86bd1db79525abdd576165c1427f9bf6");
                userService.updateById(user);
            }
        }
    }

    // 生成随机中文昵称
    private String generateRandomChineseNickname(Random random) {
        int randomIndex = random.nextInt(chineseNicknames.length);
        return chineseNicknames[randomIndex];
    }

    // 生成随机中文简介
    private String generateRandomChineseDescription(Random random) {
        int randomIndex = random.nextInt(chineseDescriptions.length);
        return chineseDescriptions[randomIndex];
    }

    // 生成随机用户角色
    private String generateRandomUserRole(Random random) {
        String[] userRoles = { "children", "donator", "volunteer" };
        int randomIndex = random.nextInt(userRoles.length);
        return userRoles[randomIndex];
    }
}