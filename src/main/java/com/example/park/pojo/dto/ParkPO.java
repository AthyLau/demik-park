package com.example.park.pojo.dto;

import java.util.Date;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 6:13 PM
 * @since JDK 1.8
 */
public class ParkPO {
    /**
     * 停车记录的id
     */
    private Integer parkId;
    /**
     * 停车开始的时间
     */
    private Date parkStartTime;
    /**
     * 停车结束的时间
     */
    private Date parkEndTime;
    /**
     * 车位id
     */
    private Integer carPlaceId;
    /**
     * 车位的名字
     */
    private String carPlaceName;
    /**
     * 汽车的id
     */
    private Integer carId;
    /**
     * 汽车车牌号
     */
    private String carNumber;

    /**
     * 停车的费用
     */
    private Double parkFee;
    public ParkPO() {
    }

    public ParkPO(Integer parkId, Date parkStartTime, Date parkEndTime, Integer carPlaceId, String carPlaceName, Integer carId, String carNumber, Double parkFee) {
        this.parkId = parkId;
        this.parkStartTime = parkStartTime;
        this.parkEndTime = parkEndTime;
        this.carPlaceId = carPlaceId;
        this.carPlaceName = carPlaceName;
        this.carId = carId;
        this.carNumber = carNumber;
        this.parkFee = parkFee;
    }

    @Override
    public String toString() {
        return "ParkPO{" +
                "parkId=" + parkId +
                ", parkStartTime=" + parkStartTime +
                ", parkEndTime=" + parkEndTime +
                ", carPlaceId=" + carPlaceId +
                ", carPlaceName='" + carPlaceName + '\'' +
                ", carId=" + carId +
                ", carNumber='" + carNumber + '\'' +
                ", parkFee=" + parkFee +
                '}';
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Date getParkStartTime() {
        return parkStartTime;
    }

    public void setParkStartTime(Date parkStartTime) {
        this.parkStartTime = parkStartTime;
    }

    public Date getParkEndTime() {
        return parkEndTime;
    }

    public void setParkEndTime(Date parkEndTime) {
        this.parkEndTime = parkEndTime;
    }

    public Integer getCarPlaceId() {
        return carPlaceId;
    }

    public void setCarPlaceId(Integer carPlaceId) {
        this.carPlaceId = carPlaceId;
    }

    public String getCarPlaceName() {
        return carPlaceName;
    }

    public void setCarPlaceName(String carPlaceName) {
        this.carPlaceName = carPlaceName;
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

    public Double getParkFee() {
        return parkFee;
    }

    public void setParkFee(Double parkFee) {
        this.parkFee = parkFee;
    }
}
