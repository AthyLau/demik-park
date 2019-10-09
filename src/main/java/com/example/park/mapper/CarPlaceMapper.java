package com.example.park.mapper;

import com.example.park.pojo.dto.PlaceDTO;
import com.example.park.pojo.po.PlacePO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 4:39 PM
 * @since JDK 1.8
 */
@Mapper
@Repository
public interface CarPlaceMapper {
    /**
     * 添加车位
     *
     * @param placeDTO
     * @return
     */
    @Insert("insert into car_place (car_place_name,car_place_addr,car_place_type,car_place_status) " +
            "values(#{carPlaceName},#{carPlaceAddr},#{carPlaceType},0)")
    boolean addPlace(PlaceDTO placeDTO);

    /**
     * 删除车位
     *
     * @param carPlaceId
     * @return
     */
    @Delete("delete from car_place where car_place_id = #{carPlaceId}")
    boolean deletePlace(Integer carPlaceId);

    /**
     * 更新车位
     *
     * @param placeDTO
     * @return
     */
    @Update("update car_place set car_place_name = #{carPlaceName},car_place_addr = #{carPlaceAddr},car_place_type = #{carPlaceType} where car_place_id = #{carPlaceId}")
    boolean updatePlace(PlaceDTO placeDTO);

    /**
     * 查询所有车位
     *
     * @return
     */
    @Select("select car_place_id,car_place_name,car_place_addr,car_place_type,car_place_status from car_place")
    List<PlacePO> findAll();

    /**
     * 根据状态查询车位
     *
     * @param placeStatus
     * @return
     */
    @Select("select car_place_id,car_place_name,car_place_addr,car_place_type,car_place_status from car_place where car_place_status = #{placeStatus}")
    List<PlacePO> findPlaceByStatus(Integer placeStatus);

    /**
     * 根据名字查询车位
     *
     * @param placeName
     * @return
     */
    @Select("select car_place_id,car_place_name,car_place_addr,car_place_type,car_place_status from car_place where car_place_name = #{placeName}")
    List<PlacePO> findPlaceByPlaceName(String placeName);

    /**
     * @param carPlaceId
     * @return
     */
    @Update("update car_place set car_place_status = 1 where car_place_id = #{carPlaceId}")
    Boolean startUpdate(Integer carPlaceId);

    /**
     * @param carPlaceId
     * @return
     */
    @Update("update car_place set car_place_status = 0 where car_place_id = #{carPlaceId}")
    Boolean endUpdate(Integer carPlaceId);
}
