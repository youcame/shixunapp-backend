package com.shixun.app.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName resource
 */
@TableName(value ="resource")
@Data
public class Resource implements Serializable {
    /**
     * 总物资属性
     */
    @TableId
    private Integer id;

    /**
     * 总收到的捐款
     */
    private Integer money;

    /**
     * 捐助的衣物数量
     */
    private Integer goods;

    /**
     * 捐赠年份
     */
    private Integer year;

    /**
     * 捐赠用户
     */
    private Long donateUserId;

    /**
     * 捐款的月份
     */
    private Integer month;

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