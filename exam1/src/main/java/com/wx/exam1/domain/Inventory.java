package com.wx.exam1.domain;

import java.util.Date;

public class Inventory  {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.inventory_id
     *
     * @mbggenerated
     */
    private Integer inventoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.film_id
     *
     * @mbggenerated
     */
    private Short filmId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.store_id
     *
     * @mbggenerated
     */
    private Byte storeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column inventory.last_update
     *
     * @mbggenerated
     */
    private Date lastUpdate;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory
     *
     * @mbggenerated
     */
    public Inventory(Integer inventoryId, Short filmId, Byte storeId, Date lastUpdate) {
        this.inventoryId = inventoryId;
        this.filmId = filmId;
        this.storeId = storeId;
        this.lastUpdate = lastUpdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table inventory
     *
     * @mbggenerated
     */
    public Inventory() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.inventory_id
     *
     * @return the value of inventory.inventory_id
     *
     * @mbggenerated
     */
    public Integer getInventoryId() {
        return inventoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.inventory_id
     *
     * @param inventoryId the value for inventory.inventory_id
     *
     * @mbggenerated
     */
    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.film_id
     *
     * @return the value of inventory.film_id
     *
     * @mbggenerated
     */
    public Short getFilmId() {
        return filmId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.film_id
     *
     * @param filmId the value for inventory.film_id
     *
     * @mbggenerated
     */
    public void setFilmId(Short filmId) {
        this.filmId = filmId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.store_id
     *
     * @return the value of inventory.store_id
     *
     * @mbggenerated
     */
    public Byte getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.store_id
     *
     * @param storeId the value for inventory.store_id
     *
     * @mbggenerated
     */
    public void setStoreId(Byte storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column inventory.last_update
     *
     * @return the value of inventory.last_update
     *
     * @mbggenerated
     */
    public Date getLastUpdate() {
        return lastUpdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column inventory.last_update
     *
     * @param lastUpdate the value for inventory.last_update
     *
     * @mbggenerated
     */
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}