package com.example.park.mapper;

import com.example.park.pojo.dto.CarDTO;
import com.example.park.pojo.po.CarPO;
import com.example.park.pojo.vo.ParkVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 4:38 PM
 * @since JDK 1.8
 */
@Mapper
@Repository
public interface CarMapper {

    /**
     * 添加车辆
     *
     * @param carDTO
     * @return
     */
    @Insert("INSERT into cars(car_number,car_master_id,car_type,car_award_number,car_time,car_award_time) " +
            "values(#{carNumber},#{carMasterId},#{carType},#{carAwardNumber},#{carTime},#{carAwardTime})")
    boolean addCar(CarDTO carDTO);

    /**
     * 查询所有的长期车车辆信息
     *
     * @return
     */
    @Select("select c.car_id,c.car_number,c.car_master_id,c.car_type,c.car_award_number,c.car_time,c.car_award_time,u.user_name as car_master_name from cars as c,users as u where u.user_id = c.car_master_id")
    List<CarPO> findAll();

    /**
     * 删除
     *
     * @param carId
     * @return
     */
    @Delete("delete from cars where car_id = #{carId}")
    boolean deleteCar(Integer carId);

    /**
     * @param carDTO
     * @return
     */
    @Update("update cars set car_number = #{carNumber},car_master_id = #{carMasterId},car_type = #{carType},car_award_number = #{carAwardNumber}, " +
            "car_time = #{carTime},car_award_time = #{carAwardTime} where car_id = #{carId}")
    boolean updateCar(CarDTO carDTO);

    /**
     * @param carType
     * @return
     */
    @Select("select c.car_id,c.car_number,c.car_master_id,c.car_type,c.car_award_number,c.car_time,c.car_award_time,u.user_name as car_master_name from cars as c,users as u where u.user_id = c.car_master_id and c.car_type = #{carType}")
    List<CarPO> findCarByType(Integer carType);

    /**
     * @param carNumber
     * @return
     */
    @Select("select c.car_id,c.car_number,c.car_master_id,c.car_type,c.car_award_number,c.car_time,c.car_award_time,u.user_name as car_master_name from cars as c,users as u where u.user_id = c.car_master_id and c.car_number = #{carNumber}")
    CarPO findCarByCarNumber(String carNumber);

    @Select("select c.car_id,c.car_number,c.car_master_id,c.car_type,c.car_award_number,c.car_time,c.car_award_time,u.user_name as car_master_name from cars as c,users as u where u.user_id = c.car_master_id and c.car_id = #{id}")
    CarPO findCarById(Integer id);

    @Update("update cars set car_award_number = #{carAwardNumber},car_time = #{carTime},car_award_time = #{carAwardTime} where car_id = #{id}")
    Boolean updateTimeAndAward(@Param("carAwardNumber") Integer carAwardNumber, @Param("carTime") Integer carTime, @Param("carAwardTime") Integer carAwardTime, @Param("id") Integer id);
}
