package com.example.park.pojo.vo;


/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 5:42 PM
 * @since JDK 1.8
 */
public class ParkVO {
    /**
     * 停车记录的id
     */
    private Integer parkId;
    /**
     * 停车费用
     */
    private Double parkFee;
    /**
     * 一小时代金券的数量
     */
    private Integer carAwardNumber;
    /**
     * 停车总时间
     */
    private Integer carTime;
    /**
     * 代金券累加时间
     */
    private Integer carAwardTime;

    public ParkVO() {
    }

    public ParkVO(Integer parkId, Double parkFee, Integer carAwardNumber, Integer carTime, Integer carAwardTime) {
        this.parkId = parkId;
        this.parkFee = parkFee;
        this.carAwardNumber = carAwardNumber;
        this.carTime = carTime;
        this.carAwardTime = carAwardTime;
    }

    @Override
    public String toString() {
        return "ParkVO{" +
                "parkId=" + parkId +
                ", parkFee=" + parkFee +
                ", carAwardNumber=" + carAwardNumber +
                ", carTime=" + carTime +
                ", carAwardTime=" + carAwardTime +
                '}';
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Double getParkFee() {
        return parkFee;
    }

    public void setParkFee(Double parkFee) {
        this.parkFee = parkFee;
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
