package com.shixun.app.service;

import com.shixun.app.model.entity.Task;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shixun.app.model.vo.TaskVO;

import java.util.List;

/**
* @author HUANG
* @description 针对表【task(任务)】的数据库操作Service
* @createDate 2023-11-01 15:05:24
*/
public interface TaskService extends IService<Task> {

    List<TaskVO> getTaskById(Long id);
}
