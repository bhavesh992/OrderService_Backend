package com.example.OrderService.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

public class Inventory implements Serializable {

    @EmbeddedId
    private InventoryPK inventoryPK;
    @Lob
    private  byte[] productImage;
    private String productDescription;

    private int price;
    private int quantity;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public InventoryPK getInventoryPK() {
        return inventoryPK;
    }

    public void setInventoryPK(InventoryPK inventoryPK) {
        this.inventoryPK = inventoryPK;
    }

    public byte[] getProductImage() {
        return productImage;
    }

    public void setProductImage(byte[] productImage) {
        this.productImage = productImage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
