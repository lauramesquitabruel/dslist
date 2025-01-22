package com.bruel.dslist.dto;

import com.bruel.dslist.entities.Game;
import jakarta.persistence.Column;

public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDesc;

    public GameMinDTO(){

    }

    public GameMinDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDesc = entity.getShortDesc();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDesc() {
        return shortDesc;
    }
}
