package com.example.OrderService.domain;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable

public class InventoryPK implements Serializable {

    public InventoryPK() {
    }

    @ManyToOne(fetch = FetchType.EAGER)

    @JoinColumn(name="product_id")
    private Product productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="size_id")
    private Size size;


    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Color getColorId() {
        return colorId;
    }

    public void setColorId(Color colorId) {
        this.colorId = colorId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="color_id")
    private Color colorId;

    private String merchantId;



    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public InventoryPK(Product productId, Size size, Color colorId, String merchantId) {
        this.productId = productId;
        this.size = size;
        this.colorId = colorId;
        this.merchantId = merchantId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

}
