package com.example.park.controller;

import com.example.park.commonbox.Result;
import com.example.park.commonbox.ResultCode;
import com.example.park.commonbox.ResultGenerator;
import com.example.park.pojo.dto.CarPlactIdDTO;
import com.example.park.pojo.dto.PlaceDTO;
import com.example.park.pojo.dto.PlaceNameDTO;
import com.example.park.pojo.dto.PlaceStatusDTO;
import com.example.park.pojo.po.PlacePO;
import com.example.park.service.CarPlaceService;
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
 * Date: 2019/5/1 4:39 PM
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/carPlace")
@ApiModel(description = "车位管理模块")
public class CarPlaceController {
    @Autowired
    private CarPlaceService carPlaceService;

    /**
     * 添加一个车辆
     *
     * @param placeDTO
     * @return
     */
    @ApiOperation(value = "添加一个车位", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/addPlace")
    public Result addPlace(@RequestBody PlaceDTO placeDTO) {
        if (carPlaceService.addPlace(placeDTO)) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加车辆失败");
    }

    /**
     * 删除一个车辆
     *
     * @param carPlactIdDTO
     * @return
     */
    @ApiOperation(value = "删除一个车辆", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/deletePlace")
    public Result deletePlace(@RequestBody CarPlactIdDTO carPlactIdDTO) {
        if (carPlaceService.deletePlace(carPlactIdDTO.getCarPlaceId())) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除一个车辆失败");
    }

    /**
     * 更新一个车辆
     *
     * @param placeDTO
     * @return
     */
    @ApiOperation(value = "更新一个车位", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/updatePlace")
    public Result updatePlace(@RequestBody PlaceDTO placeDTO) {
        if (carPlaceService.updatePlace(placeDTO)) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("更新一个车位失败");
    }

    /**
     * 查询所有车辆
     *
     * @return
     */
    @ApiOperation(value = "查询所有车位", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/findAll")
    public Result findAll() {
        List<PlacePO> list = carPlaceService.findAll();
        if (list == null || list.size() == 0) {
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 添加一个车辆
     *
     * @param carDTO
     * @return
     */
    @ApiOperation(value = "根据车位状态查询车辆", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/findPlaceByStatus")
    public Result findPlaceByStatus(@RequestBody PlaceStatusDTO carDTO) {
        List<PlacePO> list = carPlaceService.findPlaceByStatus(carDTO.getPlaceStatus());
        if (list == null || list.size() == 0) {
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 根据车牌号查询车辆
     *
     * @param placeNameDTO
     * @return
     */
    @ApiOperation(value = "根据车位名字查询车辆", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/findPlaceByPlaceName")
    public Result findPlaceByPlaceName(@RequestBody PlaceNameDTO placeNameDTO) {
        List<PlacePO> list = carPlaceService.findPlaceByPlaceName(placeNameDTO.getPlaceName());
        if (list == null || list.size() == 0) {
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        return ResultGenerator.genSuccessResult(list);
    }

}
