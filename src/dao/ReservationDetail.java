/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.Date;

/**
 *
 * @author caosy
 */
public class ReservationDetail {

    private Integer reservationId;
    private Integer accountId;
    private Integer tableId;
    private String status;
    private Date reservationTime;
    private String fullName;
    private String phone;
    private Integer number;
    private Integer seats;
    private Integer Flag;

    public ReservationDetail() {
    }

    public ReservationDetail(Integer reservationId, Integer accountId, Integer tableId, String status, Date reservationTime, String fullName, String phone, Integer number, Integer seats, Integer Flag) {
        this.reservationId = reservationId;
        this.accountId = accountId;
        this.tableId = tableId;
        this.status = status;
        this.reservationTime = reservationTime;
        this.fullName = fullName;
        this.phone = phone;
        this.number = number;
        this.seats = seats;
        this.Flag = Flag;
    }

    public Integer getFlag() {
        return Flag;
    }

    public void setFlag(Integer Flag) {
        this.Flag = Flag;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "ID: " + reservationId
                + "\nTrạng thái: " + status
                + "\nThời gian: " + reservationTime
                + "\nHọ tên: " + fullName
                + "\nSố điện thoại: " + phone
                + "\nBàn số: " + number
                + "\nSố ghế: " + seats;
    }

}
