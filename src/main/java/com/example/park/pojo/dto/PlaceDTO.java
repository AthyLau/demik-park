package com.example.park.pojo.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 6:26 PM
 * @since JDK 1.8
 */
public class PlaceDTO {
    /**
     * 车位id
     */
    private Integer carPlaceId;
    /**
     * 车位名字
     */
    private String carPlaceName;
    /**
     * 车位地址
     */
    private String carPlaceAddr;
    /**
     *     车位类型
     */
    private String carPlaceType;

    public PlaceDTO() {

    }

    public PlaceDTO(Integer carPlaceId, String carPlaceName, String carPlaceAddr, String carPlaceType) {
        this.carPlaceId = carPlaceId;
        this.carPlaceName = carPlaceName;
        this.carPlaceAddr = carPlaceAddr;
        this.carPlaceType = carPlaceType;
    }

    @Override
    public String toString() {
        return "PlaceDTO{" +
                "carPlaceId=" + carPlaceId +
                ", carPlaceName='" + carPlaceName + '\'' +
                ", carPlaceAddr='" + carPlaceAddr + '\'' +
                ", carPlaceType='" + carPlaceType + '\'' +
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

    public void setCarPlaceType(String carPlaceType) {
        this.carPlaceType = carPlaceType;
    }
}
