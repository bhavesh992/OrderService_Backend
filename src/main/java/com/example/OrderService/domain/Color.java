package com.example.OrderService.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Color {

    @Id
    private int colorId;
    private String colorName;

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
