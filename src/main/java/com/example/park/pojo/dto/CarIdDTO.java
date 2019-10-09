package com.example.park.pojo.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 4:53 PM
 * @since JDK 1.8
 */
public class CarIdDTO {
    private Integer carId;

    public CarIdDTO() {
    }

    public CarIdDTO(Integer carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "CarIdDTO{" +
                "carId=" + carId +
                '}';
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
