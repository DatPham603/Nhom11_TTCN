package services;

import csdl.CSDL;
import dao.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class TableService {

    public List<Table> getAllTables() {
        List<Table> tables = new LinkedList<>();

        String sqlGetAlltables = "SELECT TableId, Number, Status, Seats FROM Tables";
        try {
            try (Connection connection = CSDL.getConnection(); Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sqlGetAlltables);
                while (resultSet.next()) {
                    Table table = new Table();
                    table.setTableId(resultSet.getInt("TableId"));
                    table.setNumber(resultSet.getInt("Number"));
                    table.setStatus(resultSet.getString("Status"));
                    table.setSeats(resultSet.getInt("Seats"));
                    tables.add(table);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tables;
    }

    public Table getTableId(Integer tableId) {
        String sqlGetTable = "SELECT TableId, Number, Status, Seats FROM Tables WHERE TableId = ?";
        Table table = null;
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGetTable)) {
                preparedStatement.setInt(1, tableId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {  // Kiểm tra xem có kết quả nào hay không
                    table = new Table();
                    table.setTableId(resultSet.getInt("TableId"));
                    table.setNumber(resultSet.getInt("Number"));
                    table.setStatus(resultSet.getString("Status"));
                    table.setSeats(resultSet.getInt("Seats"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return table;
    }

    public List<Table> getTableLikeText(String textSearch) {
        List<Table> tables = new LinkedList<>();

        String sqlGetSemestersLikeText = "SELECT TableId, Number, Status, Seats FROM Tables WHERE Status LIKE ?";
        try {

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGetSemestersLikeText)) {
                preparedStatement.setString(1, "%" + textSearch + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Table table = new Table();
                    table.setTableId(resultSet.getInt("TableId"));
                    table.setNumber(resultSet.getInt("Number"));
                    table.setStatus(resultSet.getString("Status"));
                    table.setSeats(resultSet.getInt("Seats"));
                    tables.add(table);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return tables;
    }

    public Boolean createNewTable(Table table) {

        String sqlCreateTable = "INSERT INTO Tables (Number, Status, Seats) VALUES(?, ?, ?)";
        try {

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateTable)) {
                preparedStatement.setInt(1, table.getNumber());
                preparedStatement.setString(2, table.getStatus());
                preparedStatement.setInt(3, table.getSeats());

                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean updateTable(Table table) {
        String sqlUpdateTable = "UPDATE Tables SET Number = ?, Status = ?, Seats = ? WHERE TableId = ?";
        try {

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateTable)) {

                preparedStatement.setInt(1, table.getNumber());
                preparedStatement.setString(2, table.getStatus());
                preparedStatement.setInt(3, table.getSeats());
                preparedStatement.setInt(4, table.getTableId());

                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean deleteTable(Integer tableId) {
        String sqlDeleteTable = "DELETE FROM Tables WHERE TableId = ?";
        try {

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteTable)) {

                preparedStatement.setInt(1, tableId);
                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
