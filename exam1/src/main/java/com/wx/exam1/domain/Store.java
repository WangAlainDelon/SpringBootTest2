package com.wx.exam1.domain;


import java.util.Date;

public class Store   {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.store_id
     *
     * @mbggenerated
     */
    private Byte storeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.manager_staff_id
     *
     * @mbggenerated
     */
    private Byte managerStaffId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.address_id
     *
     * @mbggenerated
     */
    private Short addressId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.last_update
     *
     * @mbggenerated
     */
    private Date lastUpdate;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store
     *
     * @mbggenerated
     */
    public Store(Byte storeId, Byte managerStaffId, Short addressId, Date lastUpdate) {
        this.storeId = storeId;
        this.managerStaffId = managerStaffId;
        this.addressId = addressId;
        this.lastUpdate = lastUpdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table store
     *
     * @mbggenerated
     */
    public Store() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.store_id
     *
     * @return the value of store.store_id
     *
     * @mbggenerated
     */
    public Byte getStoreId() {
        return storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.store_id
     *
     * @param storeId the value for store.store_id
     *
     * @mbggenerated
     */
    public void setStoreId(Byte storeId) {
        this.storeId = storeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.manager_staff_id
     *
     * @return the value of store.manager_staff_id
     *
     * @mbggenerated
     */
    public Byte getManagerStaffId() {
        return managerStaffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.manager_staff_id
     *
     * @param managerStaffId the value for store.manager_staff_id
     *
     * @mbggenerated
     */
    public void setManagerStaffId(Byte managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.address_id
     *
     * @return the value of store.address_id
     *
     * @mbggenerated
     */
    public Short getAddressId() {
        return addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.address_id
     *
     * @param addressId the value for store.address_id
     *
     * @mbggenerated
     */
    public void setAddressId(Short addressId) {
        this.addressId = addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.last_update
     *
     * @return the value of store.last_update
     *
     * @mbggenerated
     */
    public Date getLastUpdate() {
        return lastUpdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.last_update
     *
     * @param lastUpdate the value for store.last_update
     *
     * @mbggenerated
     */
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}