package com.example.park.pojo.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 5:11 PM
 * @since JDK 1.8
 */
public class CarTypeDTO {
    private Integer carType;

    public CarTypeDTO() {
    }

    public CarTypeDTO(Integer carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "CarTypeDTO{" +
                "carType=" + carType +
                '}';
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }
}
