package com.shixun.app.model.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shixun.app.common.PageRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName user_donate
 */
@TableName(value ="user_donate")
@Data
public class UserDonateVO extends PageRequest implements Serializable {

    /**
     *
     */
    private Integer id;

    /**
     * 接收捐助用户id
     */
    private Long receiveUserId;

    /**
     * 捐助的钱财
     */
    private Integer donateMoney;

    /**
     * 捐助的物品（json表示）
     */
    private String donateThing;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 捐赠人信息
     */
    private UserVO donateUserVO;

    /**
     * 被捐赠人信息
     */
    private UserVO receiveUserVO;
    
}