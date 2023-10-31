package com.shixun.app.controller;

import com.shixun.app.annotation.AuthCheck;
import com.shixun.app.common.BaseResponse;
import com.shixun.app.common.DeleteRequest;
import com.shixun.app.common.ErrorCode;
import com.shixun.app.common.ResultUtils;
import com.shixun.app.constant.UserConstant;
import com.shixun.app.exception.BusinessException;
import com.shixun.app.exception.ThrowUtils;
import com.shixun.app.model.entity.UserDonate;
import com.shixun.app.model.vo.UserDonateVO;
import com.shixun.app.service.UserDonateService;
import com.shixun.app.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 捐献情况接口
 *
 * @author Huang
 * @from Huang
 */
@RestController
@RequestMapping("/userDonate")
@Slf4j
public class UserDonateController {

    @Resource
    private UserService userService;

    @Resource
    private UserDonateService userDonateService;

    // endregion

    // region 增删改查

    /**
     * 创建捐献情况
     *
     * @param userDonateVO
     * @param request
     * @return
     */
    @PostMapping("/add")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Integer> addUserDonate(@RequestBody UserDonateVO userDonateVO, HttpServletRequest request) {
        if (userDonateVO == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserDonate userDonate = new UserDonate();
        BeanUtils.copyProperties(userDonateVO, userDonate);
        boolean result = userDonateService.save(userDonate);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(userDonate.getId());
    }

    /**
     * 删除捐献情况
     *
     * @param deleteRequest
     * @param request
     * @return
     */
    @PostMapping("/delete")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> deleteUserDonate(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean b = userDonateService.removeById(deleteRequest.getId());
        return ResultUtils.success(b);
    }

    /**
     * 更新捐献情况
     *
     * @param userDonateVO
     * @param request
     * @return
     */
    @PostMapping("/update")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updateUserDonate(@RequestBody UserDonateVO userDonateVO,
                                                  HttpServletRequest request) {
        if (userDonateVO == null || userDonateVO.getId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserDonate userDonate = new UserDonate();
        BeanUtils.copyProperties(userDonateVO, userDonate);
        boolean result = userDonateService.updateById(userDonate);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return ResultUtils.success(true);
    }

    /**
     * 根据 id 获取捐献情况（仅管理员）
     *
     * @param id
     * @param request
     * @return
     */
    @GetMapping("/get")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<UserDonate> getUserDonateById(long id, HttpServletRequest request) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserDonate userDonate = userDonateService.getById(id);
        ThrowUtils.throwIf(userDonate == null, ErrorCode.NOT_FOUND_ERROR);
        return ResultUtils.success(userDonate);
    }



//    /**
//     * 根据 id 获取包装类
//     *
//     * @param id
//     * @param request
//     * @return
//     */
//    @GetMapping("/get/vo")
//    public BaseResponse<UserDonateVO> getUserDonateVOById(long id, HttpServletRequest request) {
//        BaseResponse<UserDonate> response = getUserDonateById(id, request);
//        UserDonate userDonate = response.getData();
//        return ResultUtils.success(userDonateService.getUserDonateVO(userDonate));
//    }

//    /**
//     * 分页获取捐献情况列表（仅管理员）
//     *
//     * @param userDonateVO
//     * @param request
//     * @return
//     */
//    @PostMapping("/list/page")
//    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
//    public BaseResponse<Page<UserDonate>> listUserDonateByPage(@RequestBody UserDonateVO userDonateVO,
//            HttpServletRequest request) {
//        long current = userDonateVO.getCurrent();
//        long size = userDonateVO.getPageSize();
//        Page<UserDonate> userDonatePage = userDonateService.page(new Page<>(current, size),
//                userDonateService.getQueryWrapper(userDonateVO));
//        return ResultUtils.success(userDonatePage);
//    }
//
//    /**
//     * 分页获取捐献情况封装列表
//     *
//     * @param userDonateQueryRequest
//     * @param request
//     * @return
//     */
//    @PostMapping("/list/page/vo")
//    public BaseResponse<Page<UserDonateVO>> listUserDonateVOByPage(@RequestBody UserDonateQueryRequest userDonateQueryRequest,
//            HttpServletRequest request) {
//        if (userDonateQueryRequest == null) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        long current = userDonateQueryRequest.getCurrent();
//        long size = userDonateQueryRequest.getPageSize();
//        // 限制爬虫
//        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
//        Page<UserDonate> userDonatePage = userDonateService.page(new Page<>(current, size),
//                userDonateService.getQueryWrapper(userDonateQueryRequest));
//        Page<UserDonateVO> userDonateVOPage = new Page<>(current, size, userDonatePage.getTotal());
//        List<UserDonateVO> userDonateVO = userDonateService.getUserDonateVO(userDonatePage.getRecords());
//        userDonateVOPage.setRecords(userDonateVO);
//        return ResultUtils.success(userDonateVOPage);
//    }
//
//    // endregion
//
//    /**
//     * 更新个人信息
//     *
//     * @param userDonateUpdateMyRequest
//     * @param request
//     * @return
//     */
//    @PostMapping("/update/my")
//    public BaseResponse<Boolean> updateMyUserDonate(@RequestBody UserDonateUpdateMyRequest userDonateUpdateMyRequest,
//            HttpServletRequest request) {
//        if (userDonateUpdateMyRequest == null) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        UserDonate loginUserDonate = userDonateService.getLoginUserDonate(request);
//        UserDonate userDonate = new UserDonate();
//        BeanUtils.copyProperties(userDonateUpdateMyRequest, userDonate);
//        userDonate.setId(loginUserDonate.getId());
//        boolean result = userDonateService.updateById(userDonate);
//        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
//        return ResultUtils.success(true);
//    }
}
