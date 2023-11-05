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
public class DonateAddRequest implements Serializable {


    /**
     * 接收捐助用户id
     */
    private Long receiveUserId;

    /**
     * 接收捐助用户id
     */
    private Long donateUserId;

    /**
     * 捐助的钱财
     */
    private Integer donateMoney;

    /**
     * 捐助的物品（json表示）
     */
    private String donateThing;

}