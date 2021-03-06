package com.xiaobaidu.mall.entity;

import java.util.Date;

public class OrderCentre {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_centre.id
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_centre.address_id
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    private String addressId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_centre.user_id
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    private String userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_centre.user_nick_name
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    private String userNickName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_centre.order_time
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    private Date orderTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_centre.status
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_centre.remark
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_centre.creator
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    private String creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_centre.create_time
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_centre.update_time
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_centre.id
     *
     * @return the value of order_centre.id
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_centre.id
     *
     * @param id the value for order_centre.id
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_centre.address_id
     *
     * @return the value of order_centre.address_id
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public String getAddressId() {
        return addressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_centre.address_id
     *
     * @param addressId the value for order_centre.address_id
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public void setAddressId(String addressId) {
        this.addressId = addressId == null ? null : addressId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_centre.user_id
     *
     * @return the value of order_centre.user_id
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_centre.user_id
     *
     * @param userId the value for order_centre.user_id
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_centre.user_nick_name
     *
     * @return the value of order_centre.user_nick_name
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public String getUserNickName() {
        return userNickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_centre.user_nick_name
     *
     * @param userNickName the value for order_centre.user_nick_name
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName == null ? null : userNickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_centre.order_time
     *
     * @return the value of order_centre.order_time
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_centre.order_time
     *
     * @param orderTime the value for order_centre.order_time
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_centre.status
     *
     * @return the value of order_centre.status
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_centre.status
     *
     * @param status the value for order_centre.status
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_centre.remark
     *
     * @return the value of order_centre.remark
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_centre.remark
     *
     * @param remark the value for order_centre.remark
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_centre.creator
     *
     * @return the value of order_centre.creator
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public String getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_centre.creator
     *
     * @param creator the value for order_centre.creator
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_centre.create_time
     *
     * @return the value of order_centre.create_time
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_centre.create_time
     *
     * @param createTime the value for order_centre.create_time
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_centre.update_time
     *
     * @return the value of order_centre.update_time
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_centre.update_time
     *
     * @param updateTime the value for order_centre.update_time
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_centre
     *
     * @mbg.generated Thu Sep 14 11:30:14 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", addressId=").append(addressId);
        sb.append(", userId=").append(userId);
        sb.append(", userNickName=").append(userNickName);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}