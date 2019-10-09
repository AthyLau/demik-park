package com.example.park.pojo.po;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 5:28 PM
 * @since JDK 1.8
 */
public class PlacePO {
    /**
     * 车位id
     */
    private Integer carPlaceId;
    /**
     * 车位名字
     */
    private String  carPlaceName;
    /**
     * 车位地址
     */
    private String carPlaceAddr;
    /**
     * 车位类型
     */
    private String carPlaceType;
    /**
     * 车位状态
     */
    private Integer carPlaceStatus;

    public PlacePO() {
    }

    public PlacePO(Integer carPlaceId, String carPlaceName, String carPlaceAddr, String carPlaceType, Integer carPlaceStatus) {
        this.carPlaceId = carPlaceId;
        this.carPlaceName = carPlaceName;
        this.carPlaceAddr = carPlaceAddr;
        this.carPlaceType = carPlaceType;
        this.carPlaceStatus = carPlaceStatus;
    }

    @Override
    public String toString() {
        return "PlaceDTO{" +
                "carPlaceId=" + carPlaceId +
                ", carPlaceName='" + carPlaceName + '\'' +
                ", carPlaceAddr='" + carPlaceAddr + '\'' +
                ", carPlaceType='" + carPlaceType + '\'' +
                ", carPlaceStatus=" + carPlaceStatus +
                '}';
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

    public String getCarPlaceAddr() {
        return carPlaceAddr;
    }

    public void setCarPlaceAddr(String carPlaceAddr) {
        this.carPlaceAddr = carPlaceAddr;
    }

    public String getCarPlaceType() {
        return carPlaceType;
    }

    public void setCarPlaceType(String carPlacType) {
        this.carPlaceType = carPlacType;
    }

    public Integer getCarPlaceStatus() {
        return carPlaceStatus;
    }

    public void setCarPlaceStatus(Integer carPlaceStatus) {
        this.carPlaceStatus = carPlaceStatus;
    }
}
