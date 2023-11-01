package com.shixun.app.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user_donate
 */
@TableName(value ="user_donate")
@Data
public class UserDonate implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}