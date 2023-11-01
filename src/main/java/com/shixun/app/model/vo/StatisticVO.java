package com.shixun.app.model.vo;

import lombok.Data;

@Data
public class StatisticVO {


    /**
     * 学生数量
     */
    private int childrenNum;

    /**
     * 志愿者数量
     */
    private int volunteerNum;

    /**
     * 捐助者数量
     */
    private int donatorNum;

    /**
     * 参与捐赠的捐赠者数量
     */
    private int alreadyDonateNum;

    /**
     * 总捐款金额
     */
    private int totalMoney;

    /**
     * 总共被帮助人数
     */
    private int alreadyReceiveNum;
}
