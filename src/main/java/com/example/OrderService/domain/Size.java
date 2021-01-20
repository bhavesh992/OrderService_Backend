package com.example.OrderService.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="size")
public class Size {

    @Id
    private int sizeId;
    private int sizeNumber;

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getSizeNumber() {
        return sizeNumber;
    }

    public void setSizeNumber(int sizeNumber) {
        this.sizeNumber = sizeNumber;
    }
}
