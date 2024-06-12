package dao;

public class Table {

    private Integer tableId;
    private Integer number;
    private String status;
    private Integer seats;

    public Table(Integer tableId, Integer number, String status, Integer seats) {
        this.tableId = tableId;
        this.number = number;
        this.status = status;
        this.seats = seats;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getTableId() {
        return tableId;
    }

    public Integer getNumber() {
        return number;
    }

    public String getStatus() {
        return status;
    }

    public Integer getSeats() {
        return seats;
    }

    public Table() {
    }

    @Override
    public String toString() {
        return "Table{" + "tableId=" + tableId + ", number=" + number + ", status=" + status + ", seats=" + seats + '}';
    }
}
