package services;

import csdl.CSDL;
import dao.MenuItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class MenuItemService {

    public List<MenuItem> getAllMenuItems() {
        List<MenuItem> menuItems = new LinkedList<>();

        String sqlGetAllMenuItems = "SELECT ItemId, Name, Description, Price, Category, Available FROM MenuItems";
        try {

            try (Connection connection = CSDL.getConnection(); Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sqlGetAllMenuItems);
                while (resultSet.next()) {
                    MenuItem menuItem = new MenuItem();
                    menuItem.setItemId(resultSet.getInt("ItemId"));
                    menuItem.setName(resultSet.getString("Name"));
                    menuItem.setDescription(resultSet.getString("Description"));
                    menuItem.setPrice(resultSet.getFloat("Price"));
                    menuItem.setCategory(resultSet.getString("Category"));
                    menuItem.setAvailable(resultSet.getByte("Available"));
                    menuItems.add(menuItem);
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menuItems;
    }

    public MenuItem getMenuItemId(Integer ItemId) {
        String sqlGetMenuItem = "SELECT ItemId, Name, Description, Price, Category, Available FROM MenuItems WHERE ItemId = ?";
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGetMenuItem)) {
                preparedStatement.setInt(1, ItemId);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    MenuItem menuItem = new MenuItem();
                    menuItem.setItemId(resultSet.getInt("ItemId"));
                    menuItem.setName(resultSet.getString("Name"));
                    menuItem.setDescription(resultSet.getString("Description"));
                    menuItem.setPrice(resultSet.getFloat("Price"));
                    menuItem.setCategory(resultSet.getString("Category"));
                    menuItem.setAvailable(resultSet.getByte("Available"));
                    return menuItem;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<MenuItem> getMenuItemsLikeText(String searchText) {
        List<MenuItem> menuItems = new LinkedList<>();

        String sqlGetMenuItemsLikeText = "SELECT ItemId, Name, Description, Price, Category, Available FROM MenuItems WHERE Name LIKE ? OR Category LIKE ?";
        try {

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGetMenuItemsLikeText)) {
                preparedStatement.setString(1, "%" + searchText + "%");
                preparedStatement.setString(2, "%" + searchText + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    MenuItem menuItem = new MenuItem();
                    menuItem.setItemId(resultSet.getInt("ItemId"));
                    menuItem.setName(resultSet.getString("Name"));
                    menuItem.setDescription(resultSet.getString("Description"));
                    menuItem.setPrice(resultSet.getFloat("Price"));
                    menuItem.setCategory(resultSet.getString("Category"));
                    menuItem.setAvailable(resultSet.getByte("Available"));
                    menuItems.add(menuItem);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return menuItems;
    }

    public Boolean createMenuItem(MenuItem menuItem) {

        String sqlCreateMenuItem = "INSERT INTO MenuItems (Name, Description, Price, Category, Available) VALUES(?, ?, ?, ?, ?)";
        try {

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateMenuItem)) {
                preparedStatement.setString(1, menuItem.getName());
                preparedStatement.setString(2, menuItem.getDescription());
                preparedStatement.setFloat(3, menuItem.getPrice());
                preparedStatement.setString(4, menuItem.getCategory());
                preparedStatement.setByte(5, menuItem.getAvailable());

                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean updateMenuItem(MenuItem menuItem) {

        String sqlUpdateCourse = "UPDATE MenuItems SET Name = ?, Description = ?, Price = ?, Category = ?, Available = ? WHERE ItemId = ?";
        try {

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateCourse)) {

                preparedStatement.setString(1, menuItem.getName());
                preparedStatement.setString(2, menuItem.getDescription());
                preparedStatement.setFloat(3, menuItem.getPrice());
                preparedStatement.setString(4, menuItem.getCategory());
                preparedStatement.setByte(5, menuItem.getAvailable());
                preparedStatement.setInt(6, menuItem.getItemId());
                preparedStatement.execute();
            }
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean deleteMenuItem(Integer itemId) {
        String sqlDeleteCourse = "DELETE FROM MenuItems WHERE ItemId = ?";
        try {

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteCourse)) {

                preparedStatement.setInt(1, itemId);

                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
