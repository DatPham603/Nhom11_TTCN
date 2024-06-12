/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Date;


/**
 *
 * @author caosy
 */
public class Order {

    private Integer orderId;
    private Date orderTime;
    private String status;
    private Integer accountId;
    private float Price;

    public Order() {
    }

    public Order(Integer orderId, Date orderTime, String status, Integer accountId, float Price) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.status = status;
        this.accountId = accountId;
        this.Price = Price;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", orderTime=" + orderTime + ", status=" + status + ", accountId=" + accountId + ", Price=" + Price + '}';
    }
}
