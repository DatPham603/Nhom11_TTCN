package services;

import csdl.CSDL;
import dao.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

public class AccountService {

    public void createAdminAccount() {
        String sqlCheckExists = "SELECT COUNT(*) FROM Accounts WHERE Username = 'admin';";

        try (Connection connection = CSDL.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sqlCheckExists)) {

            if (resultSet.next() && resultSet.getInt(1) > 0) {
                return;
            }

            String hashPassword = BCrypt.hashpw("admin", BCrypt.gensalt(10));
            String sqlCreateAdmin = "INSERT INTO Accounts (Username, Password, FullName, Role) VALUES ('admin', ?, 'Admin', 'ADMIN');";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateAdmin)) {
                preparedStatement.setString(1, hashPassword);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            System.out.println("Error creating admin account: " + e.getMessage());
        }
    }

    public Account getAccountByUsername(String username) {

        String sqlSelectAccount = "SELECT * FROM Accounts WHERE Username = ?";
        Account account = null;
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectAccount)) {
                preparedStatement.setString(1, username);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    account = new Account();
                    account.setAccountId(resultSet.getInt("AccountId"));
                    account.setFullName(resultSet.getString("FullName"));
                    account.setUsername(resultSet.getString("Username"));
                    account.setPassword(resultSet.getString("Password"));
                    account.setRole(resultSet.getString("Role"));
                    account.setPhone(resultSet.getString("Phone"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return account;
    }

    public List<Account> getAllAccounts() {
        List<Account> accounts = new LinkedList<>();
        String sqlGetAllUsers = "SELECT AccountId, Username, FullName, Role, Phone FROM Accounts";
        try {

            try (Connection connection = CSDL.getConnection(); Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery(sqlGetAllUsers);
                while (resultSet.next()) {
                    Account account = new Account();
                    account.setAccountId(resultSet.getInt("AccountId"));
                    account.setUsername(resultSet.getString("Username"));
                    account.setFullName(resultSet.getString("FullName"));
                    account.setPhone(resultSet.getString("Phone"));
                    account.setRole(resultSet.getString("Role"));
                    accounts.add(account);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accounts;
    }

    public Account getAccountId(Integer accountId) {
        String sqlGetAccount = "SELECT AccountId, Username, FullName, Role, Phone FROM Accounts WHERE AccountId = ?";
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAccount)) {
                preparedStatement.setInt(1, accountId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    Account account = new Account();
                    account.setAccountId(resultSet.getInt("AccountId"));
                    account.setUsername(resultSet.getString("Username"));
                    account.setFullName(resultSet.getString("FullName"));
                    account.setPhone(resultSet.getString("Phone"));
                    account.setRole(resultSet.getString("Role"));
                    return account;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Account getAccountByTableId(Integer tableId) {
        String sqlGetAccount = "SELECT TOP(1) Accounts.AccountId, Accounts.Username, Accounts.FullName, Accounts.Role, Accounts.Phone "
                + "FROM Accounts "
                + "INNER JOIN Reservations ON Accounts.AccountId = Reservations.AccountId "
                + "INNER JOIN Tables ON Reservations.TableId = Tables.TableId "
                + "WHERE Tables.TableId = ?;";
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAccount)) {
                preparedStatement.setInt(1, tableId);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    Account account = new Account();
                    account.setAccountId(resultSet.getInt("AccountId"));
                    account.setUsername(resultSet.getString("Username"));
                    account.setFullName(resultSet.getString("FullName"));
                    account.setPhone(resultSet.getString("Phone"));
                    account.setRole(resultSet.getString("Role"));
                    return account;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Account> getAccountsLikeText(String textSearch) {
        List<Account> accounts = new LinkedList<>();

        String sqlGetAccountsLikeText = "SELECT AccountId, Username, FullName, Role, Phone FROM Accounts WHERE FullName LIKE ? OR Username LIKE ?";
        try {

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAccountsLikeText)) {
                preparedStatement.setString(1, "%" + textSearch + "%");
                preparedStatement.setString(2, "%" + textSearch + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Account account = new Account();
                    account.setAccountId(resultSet.getInt("AccountId"));
                    account.setUsername(resultSet.getString("Username"));
                    account.setFullName(resultSet.getString("FullName"));
                    account.setRole(resultSet.getString("Role"));
                    account.setPhone(resultSet.getString("Phone"));
                    accounts.add(account);
                }

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accounts;
    }

    public Boolean createNewAccount(Account account) {
        String sqlCreateNewUser = "INSERT INTO Accounts (Username, Password, FullName, Role, Phone) VALUES (?, ?, ?, ?, ?);";
        try {

            account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(10)));

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateNewUser)) {
                preparedStatement.setString(1, account.getUsername());
                preparedStatement.setString(2, account.getPassword());
                preparedStatement.setString(3, account.getFullName());
                preparedStatement.setString(4, account.getRole());
                preparedStatement.setString(5, account.getPhone());

                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean updateAccount(Account account) {
        int i = 0;
        String sqlUpdatePassword = "";
        if (account.getPassword() != null) {
            account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(10)));
            sqlUpdatePassword = ", Password = ?";
        }
        String sqlUpdateUser = "UPDATE Accounts SET FullName = ?, Phone = ?, Role = ?" + sqlUpdatePassword + " WHERE AccountId = ?";
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateUser)) {
                preparedStatement.setString(++i, account.getFullName());
                preparedStatement.setString(++i, account.getPhone());
                preparedStatement.setString(++i, account.getRole());

                if (account.getPassword() != null) {
                    preparedStatement.setString(++i, account.getPassword());
                }
                preparedStatement.setInt(++i, account.getAccountId());

                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean deleteAccount(Integer accountId) {
        String sqlDeleteUser = "DELETE FROM Accounts WHERE AccountId = ?";
        try {

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteUser)) {

                preparedStatement.setInt(1, accountId);

                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
