package com.example.OrderService.domain;

public class InventoryMerchant {
    Inventory inventory;
    MerchantStore merchantStore;

    public InventoryMerchant(Inventory inventory, MerchantStore merchantStore) {
        this.inventory = inventory;
        this.merchantStore = merchantStore;
    }

    public InventoryMerchant() {
    }

    public Inventory getInventory() {


        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public MerchantStore getMerchantStore() {
        return merchantStore;
    }

    public void setMerchantStore(MerchantStore merchantStore) {
        this.merchantStore = merchantStore;
    }
}
