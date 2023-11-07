package com.shixun.app.controller;

import com.shixun.app.annotation.AuthCheck;
import com.shixun.app.common.BaseResponse;
import com.shixun.app.common.ResultUtils;
import com.shixun.app.model.dto.donate.ResourceAddRequest;
import com.shixun.app.model.vo.ResourceVO;
import com.shixun.app.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Resource
    private ResourceService resourceService;

    @AuthCheck(mustRole = "admin")
    @GetMapping("/get")
    public BaseResponse<List<ResourceVO>> getResource(HttpServletRequest request){
        List<com.shixun.app.model.entity.Resource> list = resourceService.list();
        List<ResourceVO> goalList = new ArrayList<>();
        for (com.shixun.app.model.entity.Resource resource : list) {
            ResourceVO resourceVO = new ResourceVO();
            BeanUtils.copyProperties(resource,resourceVO);
            goalList.add(resourceVO);
        }
        return ResultUtils.success(goalList);
    }


    @PostMapping("/add")
    public BaseResponse<Boolean> addResource(ResourceAddRequest resourceAddRequest,HttpServletRequest request){
        int id = resourceAddRequest.getId();
        int money = resourceAddRequest.getMoney();
        int goods = resourceAddRequest.getGoods();
        Boolean result = resourceService.addResource(id,money,goods);
        return ResultUtils.success(result);
    }
}
