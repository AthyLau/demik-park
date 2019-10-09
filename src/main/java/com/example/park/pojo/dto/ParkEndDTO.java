package com.example.park.pojo.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/1 5:56 PM
 * @since JDK 1.8
 */
public class ParkEndDTO {
    private Integer parkId;

    public ParkEndDTO() {
    }

    public ParkEndDTO(Integer parkId) {
        this.parkId = parkId;
    }

    @Override
    public String toString() {
        return "ParkEndDTO{" +
                "parkId=" + parkId +
                '}';
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }
}
