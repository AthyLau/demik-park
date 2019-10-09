package com.example.park.pojo.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 4:44 PM
 * @since JDK 1.8
 */
public class CarDTO {
    /**
     * 车辆的id
     */
    private Integer carId;
    /**
     * 车辆的车牌号
     */
    private String carNumber;
    /**
     * 车主id（车主其实就是用户）临时车不需要用户注册，而且不会累计时间也没有代金券
     */
    private Integer carMasterId;
    /**
     * 车辆的类型（0：临时车  1：长期车）
     */
    private Integer carType;
    /**
     * 车辆代金券数量
     */
    private Integer carAwardNumber;
    /**
     * 停车总时间
     */
    private Integer carTime;
    /**
     * 代金券累积时间，过300清0。
     */
    private Integer carAwardTime;

    public CarDTO() {
    }

    public CarDTO(Integer carId, String carNumber, Integer carMasterId, Integer carType, Integer carAwardNumber, Integer carTime, Integer carAwardTime) {
        this.carId = carId;
        this.carNumber = carNumber;
        this.carMasterId = carMasterId;
        this.carType = carType;
        this.carAwardNumber = carAwardNumber;
        this.carTime = carTime;
        this.carAwardTime = carAwardTime;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "carId=" + carId +
                ", carNumber='" + carNumber + '\'' +
                ", carMasterId=" + carMasterId +
                ", carType=" + carType +
                ", carAwardNumber=" + carAwardNumber +
                ", carTime=" + carTime +
                ", carAwardTime=" + carAwardTime +
                '}';
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Integer getCarMasterId() {
        return carMasterId;
    }

    public void setCarMasterId(Integer carMasterId) {
        this.carMasterId = carMasterId;
    }

    public Integer getCarType() {
        return carType;
    }

    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    public Integer getCarAwardNumber() {
        return carAwardNumber;
    }

    public void setCarAwardNumber(Integer carAwardNumber) {
        this.carAwardNumber = carAwardNumber;
    }

    public Integer getCarTime() {
        return carTime;
    }

    public void setCarTime(Integer carTime) {
        this.carTime = carTime;
    }

    public Integer getCarAwardTime() {
        return carAwardTime;
    }

    public void setCarAwardTime(Integer carAwardTime) {
        this.carAwardTime = carAwardTime;
    }
}
