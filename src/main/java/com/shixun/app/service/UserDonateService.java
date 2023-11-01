package com.shixun.app.service;

import com.shixun.app.model.entity.UserDonate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shixun.app.model.vo.StatisticVO;
import com.shixun.app.model.vo.UserDonateVO;

import java.util.List;

/**
* @author HUANG
* @description 针对表【user_donate】的数据库操作Service
* @createDate 2023-10-31 15:02:22
*/
public interface UserDonateService extends IService<UserDonate> {
    /**
     * 通过被捐赠者获取信息
     * @param childrenId
     */
    public List<UserDonateVO> getUserReceiveById(Long childrenId);

    /**
     * 通过捐赠者获取信息
     * @param donatorId
     */
    public List<UserDonateVO> getUserDonateById(Long donatorId);

    public StatisticVO getStatistic();
}
