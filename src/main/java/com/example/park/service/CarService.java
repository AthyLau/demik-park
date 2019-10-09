package com.example.park.service;

import com.example.park.mapper.CarMapper;
import com.example.park.mapper.CarPlaceMapper;
import com.example.park.mapper.ParkMapper;
import com.example.park.pojo.dto.CarDTO;
import com.example.park.pojo.dto.PageDTO;
import com.example.park.pojo.po.CarPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 4:38 PM
 * @since JDK 1.8
 */
@Service
public class CarService {
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private ParkMapper parkMapper;

    public boolean addCar(CarDTO carDTO) {
        if (carDTO.getCarType() == 0) {
            carDTO.setCarMasterId(3);
        }
        return carMapper.addCar(carDTO);
    }

    public List<CarPO> findAll() {
        return carMapper.findAll();
    }

    public boolean deleteCar(Integer carId) {
        return carMapper.deleteCar(carId);
    }

    public boolean updateCar(CarDTO carDTO) {
        return carMapper.updateCar(carDTO);
    }

    public List<CarPO> findCarByType(Integer carType) {
        return carMapper.findCarByType(carType);
    }

    public CarPO findCarByCarNumber(String carNumber) {
        return carMapper.findCarByCarNumber(carNumber);
    }

    public List<CarPO> findCarNotPark() {
        List<CarPO> polist1 = carMapper.findAll();
        List<Integer> list = parkMapper.findAllCarParking();
        Set<Integer> set = new HashSet<>(list);
        list.clear();
        list.addAll(set);
        if (polist1 == null || list == null) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < polist1.size(); j++) {
                if (polist1.get(j).getCarId() == list.get(i)) {
                    polist1.remove(j);
                }
            }
        }
        return polist1;
    }
}
