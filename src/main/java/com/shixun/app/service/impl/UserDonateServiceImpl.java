package com.shixun.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shixun.app.model.entity.User;
import com.shixun.app.model.entity.UserDonate;
import com.shixun.app.model.vo.StatisticVO;
import com.shixun.app.model.vo.UserDonateVO;
import com.shixun.app.model.vo.UserVO;
import com.shixun.app.service.UserDonateService;
import com.shixun.app.mapper.UserDonateMapper;
import com.shixun.app.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static com.shixun.app.constant.UserConstant.*;

/**
* @author HUANG
* @description 针对表【user_donate】的数据库操作Service实现
* @createDate 2023-10-31 15:02:22
*/
@Service
public class UserDonateServiceImpl extends ServiceImpl<UserDonateMapper, UserDonate>
    implements UserDonateService{

    @Resource
    UserService userService;

    @Override
    public List<UserDonateVO> getUserReceiveById(Long childrenId) {
        QueryWrapper<UserDonate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("receiveUserId",childrenId);
        List<UserDonate> userDonateList = this.list(queryWrapper);
        List<UserDonateVO> list = new ArrayList<>();
        for(UserDonate userDonate : userDonateList){
            UserDonateVO userDonateVO = new UserDonateVO();
            QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("id",userDonate.getDonateUserId());
            User user = userService.getOne(queryWrapper1);
            UserVO userVo = new UserVO();
            BeanUtils.copyProperties(userDonate,userDonateVO);
            BeanUtils.copyProperties(user,userVo);
            userDonateVO.setDonateUserVO(userVo);
            list.add(userDonateVO);
        }
        return list;
    }

    @Override
    public List<UserDonateVO> getUserDonateById(Long donatorId) {
        QueryWrapper<UserDonate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("donateUserId",donatorId);
        List<UserDonate> userDonateList = this.list(queryWrapper);
        List<UserDonateVO> list = new ArrayList<>();
        for(UserDonate userDonate : userDonateList){
            UserDonateVO userDonateVO = new UserDonateVO();
            QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("id",userDonate.getReceiveUserId());
            User user = userService.getOne(queryWrapper1);
            UserVO userVo = new UserVO();
            BeanUtils.copyProperties(userDonate,userDonateVO);
            BeanUtils.copyProperties(user,userVo);
            userDonateVO.setReceiveUserVO(userVo);
            list.add(userDonateVO);
        }
        return list;
    }

    @Override
    public StatisticVO getStatistic() {
        StatisticVO statisticVO = new StatisticVO();
        QueryWrapper<User> queryWrapper1 = new QueryWrapper<>();
        List<User> list1 = userService.list(queryWrapper1);
        int chiNum=0;
        int volNum=0;
        int donNum=0;
        for (User user : list1) {
            if(CHILDREN_ROLE.equals(user.getUserRole()))chiNum++;
            else if(VOLUNTEER_ROLE.equals(user.getUserRole()))volNum++;
            else if (DONATOR_ROLE.equals(user.getUserRole())) {
                donNum++;
            }
        }
        int total = 0;
        HashSet<Long> donatorHs = new HashSet<>();
        HashSet<Long> childrenHs = new HashSet<>();
        QueryWrapper<UserDonate> queryWrapper = new QueryWrapper<>();
        List<UserDonate> list = this.list(queryWrapper);
        for (UserDonate userDonate : list) {
            if(!donatorHs.contains(userDonate.getDonateUserId())){
                donatorHs.add(userDonate.getDonateUserId());
            }
            if(!childrenHs.contains(userDonate.getReceiveUserId())){
                childrenHs.add(userDonate.getReceiveUserId());
            }
            if(userDonate.getDonateMoney()!=0){
                total+=userDonate.getDonateMoney();
            }
        }
        statisticVO.setChildrenNum(chiNum);
        statisticVO.setVolunteerNum(volNum);
        statisticVO.setDonatorNum(donNum);
        statisticVO.setAlreadyDonateNum(donatorHs.size());
        statisticVO.setTotalMoney(total);
        statisticVO.setAlreadyReceiveNum(childrenHs.size());
        return statisticVO;
    }
}




