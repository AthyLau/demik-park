package com.example.park.mapper;

import com.example.park.pojo.dto.ParkPO;
import com.example.park.pojo.dto.ParkStartDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
public interface ParkMapper {

    @Insert("insert into park_log(car_place_id,car_id) values(#{carPlaceId},#{carId})")
    boolean start(ParkStartDTO parkStartDTO);

    @Update("update park_log set park_fee = #{fee},park_end_time = #{endTime} where park_id = #{parkId}")
    boolean updateFeeAndEndTime(@Param("parkId") Integer parkId, @Param("fee") Double fee, @Param("endTime") Date endTime);

    @Select("select p.park_id,p.park_start_time,p.park_end_time,p.car_place_id,cp.car_place_name,p.car_id,c.car_number,p.park_fee from cars as c,car_place as cp,park_log as p where p.car_id = c.car_id and p.car_place_id = cp.car_place_id and p.park_id = #{id}")
    ParkPO findById(Integer id);

    @Select("select p.park_id,p.park_start_time,p.park_end_time,p.car_place_id,cp.car_place_name,p.car_id,c.car_number,p.park_fee from cars as c,car_place as cp,park_log as p where p.car_id = c.car_id and p.car_place_id = cp.car_place_id order by p.park_id limit #{start},10")
    List<ParkPO> findAll(@Param("start") Integer start);

    @Select("select p.park_id,p.park_start_time,p.park_end_time,p.car_place_id,cp.car_place_name,p.car_id,c.car_number,p.park_fee from cars as c,car_place as cp,park_log as p where p.car_id = c.car_id and p.car_place_id = cp.car_place_id and c.car_number = #{number} order by p.park_id limit #{start},10")
    List<ParkPO> findByCarNumber(@Param("number") String number, @Param("start") Integer start);

    @Select("select p.park_id,p.park_start_time,p.park_end_time,p.car_place_id,cp.car_place_name,p.car_id,c.car_number,p.park_fee from cars as c,car_place as cp,park_log as p where p.car_id = c.car_id and p.car_place_id = cp.car_place_id and c.car_master_id = #{userId} order by p.park_id limit #{start},10")
    List<ParkPO> findByMasterId(@Param("userId") Integer userId, @Param("start") Integer start);

    @Select("select car_id from park_log where park_start_time = park_end_time")
    List<Integer> findAllCarParking();
}
