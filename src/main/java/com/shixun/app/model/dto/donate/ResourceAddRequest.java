package com.shixun.app.model.dto.donate;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName resource
 */
@TableName(value ="resource")
@Data
public class ResourceAddRequest implements Serializable {
    /**
     * 总物资属性
     */
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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}