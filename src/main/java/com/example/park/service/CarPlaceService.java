package com.example.park.service;

import com.example.park.mapper.CarPlaceMapper;
import com.example.park.pojo.dto.PlaceDTO;
import com.example.park.pojo.po.PlacePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 4:39 PM
 * @since JDK 1.8
 */
@Service
public class CarPlaceService {
    @Autowired
    private CarPlaceMapper carPlaceMapper;

    public boolean addPlace(PlaceDTO placeDTO) {
        return carPlaceMapper.addPlace(placeDTO);
    }

    public boolean deletePlace(Integer carPlaceId) {
        return carPlaceMapper.deletePlace(carPlaceId);
    }

    public boolean updatePlace(PlaceDTO placeDTO) {
        return carPlaceMapper.updatePlace(placeDTO);
    }

    public List<PlacePO> findAll() {
        return carPlaceMapper.findAll();
    }

    public List<PlacePO> findPlaceByStatus(Integer placeStatus) {
        return carPlaceMapper.findPlaceByStatus(placeStatus);
    }

    public List<PlacePO> findPlaceByPlaceName(String placeName) {
        return carPlaceMapper.findPlaceByPlaceName(placeName);
    }

    public Boolean updateStatus(Integer carPlaceId, Integer status) {
        if (status == 1) {
            return carPlaceMapper.startUpdate(carPlaceId);
        } else if (status == 0) {
            return carPlaceMapper.endUpdate(carPlaceId);
        } else {
            return false;
        }
    }
}
