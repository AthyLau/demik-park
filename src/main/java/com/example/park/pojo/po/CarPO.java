package com.example.park.pojo.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 4:56 PM
 * @since JDK 1.8
 */
public class CarPO {

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
     * 车主名字
     */
    private String carMasterName;
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

    public CarPO() {
    }

    public CarPO(Integer carId, String carNumber, Integer carMasterId, String carMasterName, Integer carType, Integer carAwardNumber, Integer carTime, Integer carAwardTime) {
        this.carId = carId;
        this.carNumber = carNumber;
        this.carMasterId = carMasterId;
        this.carMasterName = carMasterName;
        this.carType = carType;
        this.carAwardNumber = carAwardNumber;
        this.carTime = carTime;
        this.carAwardTime = carAwardTime;
    }

    @Override
    public String toString() {
        return "CarPO{" +
                "carId=" + carId +
                ", carNumber='" + carNumber + '\'' +
                ", carMasterId=" + carMasterId +
                ", carMasterName='" + carMasterName + '\'' +
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

    public String getCarMasterName() {
        return carMasterName;
    }

    public void setCarMasterName(String carMasterName) {
        this.carMasterName = carMasterName;
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
