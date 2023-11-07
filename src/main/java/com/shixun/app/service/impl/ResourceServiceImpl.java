package com.shixun.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shixun.app.model.entity.Resource;
import com.shixun.app.mapper.ResourceMapper;
import com.shixun.app.service.ResourceService;
import org.springframework.stereotype.Service;

/**
* @author HUANG
* @description 针对表【resource】的数据库操作Service实现
* @createDate 2023-11-07 14:39:48
*/
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource>
    implements ResourceService {

    @Override
    public Boolean addResource(int id, int money, int goods) {
        Resource resource = this.getById(id);
        resource.setMoney(resource.getMoney()+money);
        resource.setGoods(resource.getGoods()+goods);
        boolean result = this.updateById(resource);
        return result;
    }
}




