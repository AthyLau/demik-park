package com.example.park.controller;

import com.example.park.commonbox.Result;
import com.example.park.commonbox.ResultCode;
import com.example.park.commonbox.ResultGenerator;
import com.example.park.pojo.dto.*;
import com.example.park.service.ParkService;
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
 * Date: 2019/5/1 4:38 PM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/park")
@ApiModel(description = "停车管理模块")
public class ParkController {
    @Autowired
    private ParkService parkService;


    @ApiOperation(value = "某车进入停车场", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/start")
    public Result start(@RequestBody ParkStartDTO parkStartDTO) {
        if (parkService.start(parkStartDTO)) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("生成停车记录失败");
    }


    @ApiOperation(value = "某车离开停车场", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/end")
    public Result end(@RequestBody ParkEndDTO parkEndDTO) {
        if (parkService.end(parkEndDTO.getParkId())) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("更新停车记录失败");
    }

    @ApiOperation(value = "查询所有的停车记录", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/findAll")
    public Result findAll(@RequestBody PageDTO pageDTO) {
        List<ParkPO> list = parkService.findAll(pageDTO.getPage());
        if (list == null || list.size() == 0) {
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        return ResultGenerator.genSuccessResult(list);
    }

    @ApiOperation(value = "查询某车的所有的停车记录", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/findByCarNumber")
    public Result findByCarNumber(@RequestBody CarNumberPageDTO carNumberPageDTO) {
        List<ParkPO> list = parkService.findByCarNumber(carNumberPageDTO.getCarNumber(), carNumberPageDTO.getPage());
        if (list == null || list.size() == 0) {
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        return ResultGenerator.genSuccessResult(list);
    }

    @ApiOperation(value = "查询某人的所有的停车记录", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/findByMasterId")
    public Result findByMasterId(@RequestBody UserIdPageDTO userIdDTO) {
        List<ParkPO> list = parkService.findByMasterId(userIdDTO.getUserId(), userIdDTO.getPage());
        if (list == null || list.size() == 0) {
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        return ResultGenerator.genSuccessResult(list);
    }
}
