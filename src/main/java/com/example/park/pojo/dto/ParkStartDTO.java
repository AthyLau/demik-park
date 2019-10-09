package com.example.park.pojo.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 5:53 PM
 * @since JDK 1.8
 */
public class ParkStartDTO {
    /**
     * 车位id
     */
    private Integer carPlaceId;
    /**
     * 车辆id
     */
    private Integer carId;

    public ParkStartDTO() {
    }

    public ParkStartDTO(Integer carPlaceId, Integer carId) {
        this.carPlaceId = carPlaceId;
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "ParkDTO{" +
                "carPlaceId=" + carPlaceId +
                ", carId=" + carId +
                '}';
    }

    public Integer getCarPlaceId() {
        return carPlaceId;
    }

    public void setCarPlaceId(Integer carPlaceId) {
        this.carPlaceId = carPlaceId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
