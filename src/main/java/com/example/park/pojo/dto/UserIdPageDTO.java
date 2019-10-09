package com.example.park.pojo.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/28 2:54 PM
 * @since JDK 1.8
 */
public class UserIdPageDTO {
    private Integer userId;
    private Integer page;

    public UserIdPageDTO() {
    }

    public UserIdPageDTO(Integer userId, Integer page) {
        this.userId = userId;
        this.page = page;
    }

    @Override
    public String toString() {
        return "UserIdPageDTO{" +
                "userId=" + userId +
                ", page=" + page +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
