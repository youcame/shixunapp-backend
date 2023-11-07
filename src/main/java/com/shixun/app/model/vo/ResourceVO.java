package com.shixun.app.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @TableName resource
 */
@TableName(value ="resource")
@Data
public class ResourceVO implements Serializable {

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
     * 捐款的月份
     */
    private Integer month;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}