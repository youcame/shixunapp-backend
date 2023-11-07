package com.shixun.app.service;

import com.shixun.app.model.entity.Resource;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author HUANG
* @description 针对表【resource】的数据库操作Service
* @createDate 2023-11-07 14:39:48
*/
public interface ResourceService extends IService<Resource> {

    Boolean addResource(int id, int money, int goods);
}
