package com.example.park.pojo.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 5:25 PM
 * @since JDK 1.8
 */
public class CarPlactIdDTO {
    private Integer carPlaceId;

    public CarPlactIdDTO() {
    }

    public CarPlactIdDTO(Integer carPlaceId) {
        this.carPlaceId = carPlaceId;
    }

    @Override
    public String toString() {
        return "CarPlactIdDTO{" +
                "carPlaceId=" + carPlaceId +
                '}';
    }

    public Integer getCarPlaceId() {
        return carPlaceId;
    }

    public void setCarPlaceId(Integer carPlaceId) {
        this.carPlaceId = carPlaceId;
    }
}
