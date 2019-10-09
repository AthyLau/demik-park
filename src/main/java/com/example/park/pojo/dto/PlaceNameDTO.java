package com.example.park.pojo.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 5:31 PM
 * @since JDK 1.8
 */
public class PlaceNameDTO {
    private String placeName;

    public PlaceNameDTO() {
    }

    public PlaceNameDTO(String placeName) {
        this.placeName = placeName;
    }

    @Override
    public String toString() {
        return "PlaceNameDTO{" +
                "placeName='" + placeName + '\'' +
                '}';
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
