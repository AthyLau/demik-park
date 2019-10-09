package com.example.park.controller;

import com.example.park.commonbox.Result;
import com.example.park.commonbox.ResultCode;
import com.example.park.commonbox.ResultGenerator;
import com.example.park.pojo.dto.CarDTO;
import com.example.park.pojo.dto.CarIdDTO;
import com.example.park.pojo.dto.CarNumberDTO;
import com.example.park.pojo.dto.CarTypeDTO;
import com.example.park.pojo.po.CarPO;
import com.example.park.service.CarService;
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
@RequestMapping("/car")
@ApiModel(description = "车辆管理模块")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 添加一个车辆
     *
     * @param carDTO
     * @return
     */
    @ApiOperation(value = "添加一个车辆", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/addCar")
    public Result addCar(@RequestBody CarDTO carDTO) {
        if (carService.addCar(carDTO)) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("添加车辆失败");
    }

    /**
     * 删除一个车辆
     *
     * @param carDTO
     * @return
     */
    @ApiOperation(value = "删除一个车辆", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/deleteCar")
    public Result deleteCar(@RequestBody CarIdDTO carDTO) {
        if (carService.deleteCar(carDTO.getCarId())) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("删除一个车辆失败");
    }

    /**
     * 更新一个车辆
     *
     * @param carDTO
     * @return
     */
    @ApiOperation(value = "更新一个车辆", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/updateCar")
    public Result updateCar(@RequestBody CarDTO carDTO) {
        if (carService.updateCar(carDTO)) {
            return ResultGenerator.genSuccessResult();
        }
        return ResultGenerator.genFailResult("更新一个车辆车辆失败");
    }

    /**
     * 查询所有车辆
     *
     * @return
     */
    @ApiOperation(value = "查询所有车辆", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/findAll")
    public Result findAll() {
        List<CarPO> list = carService.findAll();
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
    @ApiOperation(value = "根据车辆类型查询车辆", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/findCarByType")
    public Result findCarByType(@RequestBody CarTypeDTO carDTO) {
        List<CarPO> list = carService.findCarByType(carDTO.getCarType());
        if (list == null || list.size() == 0) {
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 添加一个车辆
     *
     * @return
     */
    @ApiOperation(value = "查询不在停车场的车辆", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/findCarNotPark")
    public Result findCarNotPark() {
        List<CarPO> list = carService.findCarNotPark();
        if (list == null || list.size() == 0) {
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 根据车牌号查询车辆
     *
     * @param carDTO
     * @return
     */
    @ApiOperation(value = "根据车牌号查询车辆", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/findCarByCarNumber")
    public Result findCarByCarNumber(@RequestBody CarNumberDTO carDTO) {
        CarPO carPO = carService.findCarByCarNumber(carDTO.getCarNumber());
        if (carPO == null) {
            return ResultGenerator.genSuccessResult(ResultCode.NONE_DATA);
        }
        return ResultGenerator.genSuccessResult(carPO);
    }

}
