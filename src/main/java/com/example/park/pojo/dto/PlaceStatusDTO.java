package com.example.park.pojo.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 5:29 PM
 * @since JDK 1.8
 */
public class PlaceStatusDTO {
    private Integer placeStatus;

    public PlaceStatusDTO() {
    }

    public PlaceStatusDTO(Integer placeStatus) {
        this.placeStatus = placeStatus;
    }

    @Override
    public String toString() {
        return "PlaceStatusDTO{" +
                "placeStatus=" + placeStatus +
                '}';
    }

    public Integer getPlaceStatus() {
        return placeStatus;
    }

    public void setPlaceStatus(Integer placeStatus) {
        this.placeStatus = placeStatus;
    }
}
