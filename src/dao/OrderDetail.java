package dao;

public class OrderDetail {

    private Integer OrderDetailId;
    private Integer Quantity;
    private Integer OrderId;
    private Integer ItemId;

    public OrderDetail() {
    }

    public OrderDetail(Integer OrderDetailId, Integer Quantity, Integer OrderId, Integer ItemId) {
        this.OrderDetailId = OrderDetailId;
        this.Quantity = Quantity;
        this.OrderId = OrderId;
        this.ItemId = ItemId;
    }

    public Integer getOrderDetailId() {
        return OrderDetailId;
    }

    public void setOrderDetailId(Integer OrderDetailId) {
        this.OrderDetailId = OrderDetailId;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public Integer getOrderId() {
        return OrderId;
    }

    public void setOrderId(Integer OrderId) {
        this.OrderId = OrderId;
    }

    public Integer getItemId() {
        return ItemId;
    }

    public void setItemId(Integer ItemId) {
        this.ItemId = ItemId;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "OrderDetailId=" + OrderDetailId + ", Quantity=" + Quantity + ", OrderId=" + OrderId + ", ItemId=" + ItemId + '}';
    }
}
