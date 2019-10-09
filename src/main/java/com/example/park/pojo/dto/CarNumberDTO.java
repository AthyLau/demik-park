package com.example.park.pojo.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 5:14 PM
 * @since JDK 1.8
 */
public class CarNumberDTO {
    private String carNumber;

    public CarNumberDTO() {
    }

    public CarNumberDTO(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "CarNumberDTO{" +
                "carNumber='" + carNumber + '\'' +
                '}';
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
