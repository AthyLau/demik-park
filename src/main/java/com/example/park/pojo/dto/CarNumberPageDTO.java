package com.example.park.pojo.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/28 2:51 PM
 * @since JDK 1.8
 */
public class CarNumberPageDTO {
    private String carNumber;
    private Integer page;

    public CarNumberPageDTO() {
    }

    public CarNumberPageDTO(String carNumber, Integer page) {
        this.carNumber = carNumber;
        this.page = page;
    }

    @Override
    public String toString() {
        return "CarNumberPageDTO{" +
                "carNumber='" + carNumber + '\'' +
                ", page=" + page +
                '}';
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
