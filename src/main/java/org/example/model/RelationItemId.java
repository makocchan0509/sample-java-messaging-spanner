package org.example.model;

import java.io.Serializable;
import java.util.UUID;

public class RelationItemId implements Serializable {
    private UUID shopId;
    private UUID itemId;

    public RelationItemId() {
    }

    public RelationItemId(UUID shopId, UUID itemId) {
        this.shopId = shopId;
        this.itemId = itemId;
    }

    public UUID getShopId() {
        return shopId;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setShopId(UUID shopId) {
        this.shopId = shopId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }
}
