package com.shixun.app.model.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shixun.app.common.PageRequest;
import lombok.Data;

import java.io.Serializable;

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
     * 捐助用户的id
     */
    private Long donateUserId;

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
    
}