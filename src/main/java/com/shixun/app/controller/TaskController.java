package com.shixun.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shixun.app.annotation.AuthCheck;
import com.shixun.app.common.BaseResponse;
import com.shixun.app.common.DeleteRequest;
import com.shixun.app.common.ErrorCode;
import com.shixun.app.common.ResultUtils;
import com.shixun.app.constant.UserConstant;
import com.shixun.app.exception.BusinessException;
import com.shixun.app.exception.ThrowUtils;
import com.shixun.app.model.entity.Task;
import com.shixun.app.model.vo.TaskVO;
import com.shixun.app.service.TaskService;
import com.shixun.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 任务情况接口
 *
 * @author Huang
 * @from Huang
 */
@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {

    @Resource
    private UserService userService;

    @Resource
    private TaskService taskService;

    /**
     * 创建任务情况
     *
     * @param taskVO
     * @param request
     * @return
     */
    @PostMapping("/add")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Long> addTask(@RequestBody TaskVO taskVO, HttpServletRequest request) {
        if (taskVO == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Task task = new Task();
        BeanUtils.copyProperties(taskVO, task);
        boolean result = taskService.save(task);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(task.getId());
    }

    /**
     * 删除任务情况
     *
     * @param deleteRequest
     * @param request
     * @return
     */
    @PostMapping("/delete")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> deleteTask(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean b = taskService.removeById(deleteRequest.getId());
        return ResultUtils.success(b);
    }

    /**
     * 更新任务情况
     *
     * @param taskVO
     * @param request
     * @return
     */
    @PostMapping("/update")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updateTask(@RequestBody TaskVO taskVO,
                                                  HttpServletRequest request) {
        if (taskVO == null || taskVO.getId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Task task = new Task();
        BeanUtils.copyProperties(taskVO, task);
        boolean result = taskService.updateById(task);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(true);
    }

    /**
     * 根据 id 获取任务情况（仅管理员）
     *
     * @param id
     * @param request
     * @return
     */
    @GetMapping("/get/task")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<List<TaskVO>> getTaskById(Long id,HttpServletRequest request) {
        if (id < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        List<TaskVO> list = taskService.getTaskById(id);
        return ResultUtils.success(list);
    }

    /**
     * 完成任务
     *
     * @param id
     * @param request
     * @return
     */
    @PostMapping("/finish")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> finishTaskById(Long id,HttpServletRequest request) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Task task = taskService.getById(id);
        task.setIsFinished(1);
        boolean b = taskService.updateById(task);
        ThrowUtils.throwIf(!b, ErrorCode.OPERATION_ERROR,"任务失败");
        return ResultUtils.success(Boolean.TRUE);
    }

    /**
     * 根据 id 获取任务情况（仅管理员）
     *
     * @param request
     * @return
     */
    @GetMapping("/getAllTask")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<List<TaskVO>> getAllTasks(HttpServletRequest request) {
        QueryWrapper<Task> queryWrapper = new QueryWrapper<>();
        List<TaskVO> list = new ArrayList<>();
        for (Task task : taskService.list(queryWrapper)) {
            TaskVO taskVO = new TaskVO();
            BeanUtils.copyProperties(task,taskVO);
            list.add(taskVO);
        }
        return ResultUtils.success(list);
    }


}
