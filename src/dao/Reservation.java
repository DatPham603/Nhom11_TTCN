package dao;

import java.sql.Date;


public class Reservation {

    private Integer reservationId;
    private Date reservationTime;
    private String status;
    private Integer accountId;
    private Integer tableId;
    private Integer Flag;

    public Reservation() {
    }

    public Reservation(Integer reservationId, Date reservationTime, String status, Integer accountId, Integer tableId, Integer Flag) {
        this.reservationId = reservationId;
        this.reservationTime = reservationTime;
        this.status = status;
        this.accountId = accountId;
        this.tableId = tableId;
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

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
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

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    @Override
    public String toString() {
        return "Reservation{" + "reservationId=" + reservationId + ", reservationTime=" + reservationTime + ", status=" + status + ", accountId=" + accountId + ", tableId=" + tableId + '}';
    }

    
}
