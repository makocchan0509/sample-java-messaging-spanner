package org.example.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.util.UUID;

@Entity
@Table(name="items")
@IdClass(RelationItemId.class)
public class Items {

    @Id
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    @Column(name = "shopId")
    private UUID shopId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(java.sql.Types.VARCHAR)
    @Column(name = "itemId")
    private UUID itemId;

    @Column(name = "itemName")
    private String itemName;

    public UUID getShopId() {
        return shopId;
    }

    public void setShopId(UUID shopId) {
        this.shopId = shopId;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
