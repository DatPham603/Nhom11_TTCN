package services;

import csdl.CSDL;
import dao.OrderDetail;
import dao.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class OrderService {

    public List<Order> getAllOrder() {
        List<Order> orders = new LinkedList<>();

        String sqlGetAllOrder = "SELECT OrderId, OrderTime, Status, Price, AccountId FROM Orders";
        try {
            try (Connection connection = CSDL.getConnection(); Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sqlGetAllOrder);
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setOrderId(resultSet.getInt("OrderId"));
                    order.setOrderTime(resultSet.getDate("OrderTime"));
                    order.setStatus(resultSet.getString("Status"));
                    order.setAccountId(resultSet.getInt("AccountId"));
                    order.setPrice(resultSet.getFloat("Price"));
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orders;
    }

    public List<Order> getAllOrderByAccountId(Integer accountId) {
        List<Order> orders = new LinkedList<>();

        String sqlGetAllOrder = "SELECT OrderId, OrderTime, Status, Price, AccountId FROM Orders WHERE AccountId = ?";
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAllOrder)) {
                preparedStatement.setInt(1, accountId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Order order = new Order();
                    order.setOrderId(resultSet.getInt("OrderId"));
                    order.setOrderTime(resultSet.getDate("OrderTime"));
                    order.setStatus(resultSet.getString("Status"));
                    order.setPrice(resultSet.getFloat("Price"));
                    order.setAccountId(resultSet.getInt("AccountId"));
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orders;
    }

    public List<OrderDetail> getAllOrderDetailOrderId(Integer orderId) {
        List<OrderDetail> orderDetails = new LinkedList<>();

        String sqlGetAllOrderDetail = "SELECT OrderDetailId, Quantity, OrderId, ItemId FROM OrderDetails WHERE OrderId = ?";
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAllOrderDetail)) {
                preparedStatement.setInt(1, orderId);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    OrderDetail OrderDetail = new OrderDetail();
                    OrderDetail.setOrderDetailId(resultSet.getInt("OrderDetailId"));
                    OrderDetail.setQuantity(resultSet.getInt("Quantity"));
                    OrderDetail.setOrderId(resultSet.getInt("OrderId"));
                    OrderDetail.setItemId(resultSet.getInt("ItemId"));
                    orderDetails.add(OrderDetail);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orderDetails;
    }

    public List<OrderDetail> getAllOrderDetailItemId(Integer itemId) {
        List<OrderDetail> orderDetails = new LinkedList<>();

        String sqlGetAllOrderDetail = "SELECT OrderDetailId, Quantity, OrderId, ItemId FROM Orders WHERE ItemId = ?";
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAllOrderDetail)) {
                preparedStatement.setInt(1, itemId);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    OrderDetail OrderDetail = new OrderDetail();
                    OrderDetail.setOrderDetailId(resultSet.getInt("OrderDetailId"));
                    OrderDetail.setQuantity(resultSet.getInt("Quantity"));
                    OrderDetail.setOrderId(resultSet.getInt("OrderId"));
                    OrderDetail.setItemId(resultSet.getInt("ItemId"));
                    orderDetails.add(OrderDetail);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return orderDetails;
    }

    public Order getOrderId(Integer orderId) {
        String sqlGetOrderId = "SELECT OrderId, OrderTime, Status, Price, AccountId FROM Orders WHERE OrderId = ?";
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGetOrderId)) {
                preparedStatement.setInt(1, orderId);
                ResultSet resultSet = preparedStatement.executeQuery();

                Order order = new Order();
                order.setOrderId(resultSet.getInt("OrderId"));
                order.setOrderTime(resultSet.getDate("OrderTime"));
                order.setStatus(resultSet.getString("Status"));
                order.setOrderId(resultSet.getInt("AccountId"));
                order.setPrice(resultSet.getFloat("Price"));
                return order;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public OrderDetail getOrderDetailId(Integer orderDetailId) {
        String sqlGetOrderDetailId = "SELECT OrderDetailId, Quantity, OrderId, ItemId FROM OrderDetails WHERE OrderDetailId = ?";
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGetOrderDetailId)) {
                preparedStatement.setInt(1, orderDetailId);
                ResultSet resultSet = preparedStatement.executeQuery();

                OrderDetail OrderDetail = new OrderDetail();
                OrderDetail.setOrderDetailId(resultSet.getInt("OrderDetailId"));
                OrderDetail.setQuantity(resultSet.getInt("Quantity"));
                OrderDetail.setOrderId(resultSet.getInt("OrderId"));
                OrderDetail.setItemId(resultSet.getInt("ItemId"));

                return OrderDetail;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Boolean Update(Order order) {

        String sqlApprove = "UPDATE Orders SET Status = ? WHERE OrderId = ?";
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlApprove)) {
                preparedStatement.setString(1, order.getStatus());
                preparedStatement.setInt(2, order.getOrderId());

                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean Delete(Integer orderId) {
        String sqlDelete = "DELETE FROM OrderDetails WHERE OrderId = ?"
                + "DELETE FROM Orders WHERE OrderId = ?";
        try {

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {

                preparedStatement.setInt(1, orderId);
                preparedStatement.setInt(2, orderId);
                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Order createOrder(Order order) {
        String sqlCreateOrder = "INSERT INTO Orders (OrderTime, Status, Price, AccountId) VALUES(?, ?, ?, ?)";
        try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateOrder, Statement.RETURN_GENERATED_KEYS)) {

            // Thiết lập các giá trị cho câu lệnh SQL
            preparedStatement.setDate(1, order.getOrderTime());
            preparedStatement.setString(2, order.getStatus());
            preparedStatement.setFloat(3, order.getPrice());
            preparedStatement.setInt(4, order.getAccountId());

            // Thực thi câu lệnh và lấy khóa chính vừa tạo
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating order failed, no rows affected.");
            }

            // Lấy ID của bản ghi vừa được chèn vào
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int orderId = generatedKeys.getInt(1);
                    order.setOrderId(orderId);
                } else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
            }
            return order;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Boolean createOrderDetail(OrderDetail orderDetail) {

        String sqlCreateOrderDetail = "INSERT INTO OrderDetails (Quantity, OrderId, ItemId) VALUES(?, ?, ?)";
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateOrderDetail)) {
                preparedStatement.setInt(1, orderDetail.getQuantity());
                preparedStatement.setInt(2, orderDetail.getOrderId());
                preparedStatement.setFloat(3, orderDetail.getItemId());

                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
