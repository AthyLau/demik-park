package com.example.park.pojo.dto;

/**
 * Function:
 *
 * @author liubing
 * Date: 2019/5/28 2:32 PM
 * @since JDK 1.8
 */
public class PageDTO {
    private Integer page;

    public PageDTO() {
    }

    public PageDTO(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "page=" + page +
                '}';
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
