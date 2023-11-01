package com.shixun.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shixun.app.model.entity.Task;
import com.shixun.app.model.vo.TaskVO;
import com.shixun.app.service.TaskService;
import com.shixun.app.mapper.TaskMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author HUANG
* @description 针对表【task(任务)】的数据库操作Service实现
* @createDate 2023-11-01 15:05:24
*/
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>
    implements TaskService{

    @Override
    public List<TaskVO> getTaskById(Long id) {
        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("finishUserId", id);
        List<Task> list = this.list(queryWrapper);
        List<TaskVO> newList = new ArrayList<>();
        for (Task task : list) {
            TaskVO taskVO = new TaskVO();
            BeanUtils.copyProperties(task,taskVO);
            newList.add(taskVO);
        }
        return newList;
    }

}




