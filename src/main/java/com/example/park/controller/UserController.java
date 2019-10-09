package com.example.park.controller;

import com.example.park.commonbox.Result;
import com.example.park.commonbox.ResultCode;
import com.example.park.commonbox.ResultGenerator;
import com.example.park.pojo.dto.*;
import com.example.park.pojo.po.UserPO;
import com.example.park.service.UserService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/4/15 11:34 PM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/user")
@ApiModel(description = "用户管理模块")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登陆校验
     *
     * @param loginDTO
     * @return
     */
    @ApiOperation(value = "登陆校验", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/login")
    public Result login(@RequestBody LoginDTO loginDTO) {
        UserPO userPO = userService.login(loginDTO.getUserName(), loginDTO.getPassword());
        if (userPO == null) {
            return ResultGenerator.genSuccessResult("登陆失败");
        }
        return ResultGenerator.genSuccessResult(userPO);
    }

    /**
     * 添加用户
     *
     * @param userDTO
     * @return
     */
    @ApiOperation(value = "添加用户", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/add")
    public Result addUser(@RequestBody UserDTO userDTO) {
        if (userService.addUser(userDTO)) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加用户失败");
    }

    /**
     * 删除用户
     *
     * @param userIdDTO
     * @return
     */
    @ApiOperation(value = "删除用户", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/delete")
    public Result deleteUser(@RequestBody UserIdDTO userIdDTO) {
        if (userService.deleteUser(userIdDTO.getUserId())) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除用户失败");
    }

    /**
     * 根据角色查询用户
     *
     * @param userRoleIdDTO
     * @return
     */
    @ApiOperation(value = "根据角色查询用户", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/findByRole")
    public Result findByRole(@RequestBody UserRoleIdDTO userRoleIdDTO) {
        List<UserPO> userDTOList = userService.findByRole(userRoleIdDTO.getUserRoleId());
        if (userDTOList == null || userDTOList.size() == 0) {
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        return ResultGenerator.genSuccessResult(userDTOList);

    }

    /**
     * 根据用户名字查询用户
     *
     * @param userNameDTO
     * @return
     */
    @ApiOperation(value = "根据用户名字查询用户", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/findByUserName")
    public Result findByUserName(@RequestBody UserNameDTO userNameDTO) {
        UserPO po = userService.findByUserName(userNameDTO.getUserName());
        if (po == null) {
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        return ResultGenerator.genSuccessResult(po);

    }

    /**
     * 更新用户
     *
     * @param userDTO
     * @return
     */
    @ApiOperation(value = "更新用户", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/update")
    public Result updateUser(@RequestBody UpdateUserInfoDTO userDTO) {
        if (userService.updateUser(userDTO)) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("更新用户失败");
    }

    /**
     * 查询所有的用户
     *
     * @return
     */
    @ApiOperation(value = "查询所有的用户", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/findAllUser")
    public Result findAllUser() {
        List<UserPO> userDTOList = userService.findAllUser();
        if (userDTOList == null || userDTOList.size() == 0) {
            return ResultGenerator.genFailResult("查询用户失败");
        }
        return ResultGenerator.genSuccessResult(userDTOList);

    }
}
