package com.shixun.app.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 任务
 * @TableName task
 */
@TableName(value ="task")
@Data
public class Task implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 任务内容
     */
    private String content;

    /**
     * 任务标签列表（json 数组）
     */
    private String tags;

    /**
     * 任务难度
     */
    private Integer difficulty;

    /**
     * 任务类型：0-学习任务，1-志愿者任务
     */
    private Integer types;

    /**
     * 创建用户 id
     */
    private Long createUserId;

    /**
     * 能够完成任务的用户，0-所有人都可以完成
     */
    private Long finishUserId;

    /**
     * 是否完成 0-未完成，1-完成
     */
    private Integer isFinished;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    @TableLogic
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}