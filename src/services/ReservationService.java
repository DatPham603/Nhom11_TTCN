package services;

import csdl.CSDL;
import dao.Reservation;
import dao.ReservationDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class ReservationService {

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new LinkedList<>();

        String sqlGetAllStudents = "SELECT ReservationId, ReservationTime, Status, AccountId, TableId, Flag FROM Reservations";
        try {
            try (Connection connection = CSDL.getConnection(); Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sqlGetAllStudents);
                while (resultSet.next()) {
                    Reservation reservation = new Reservation();
                    reservation.setReservationId(resultSet.getInt("ReservationId"));
                    reservation.setReservationTime(resultSet.getDate("ReservationTime"));
                    reservation.setStatus(resultSet.getString("Status"));
                    reservation.setAccountId(resultSet.getInt("AccountId"));
                    reservation.setTableId(resultSet.getInt("TableId"));
                    reservation.setFlag(resultSet.getInt("Flag"));
                    reservations.add(reservation);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reservations;
    }

    public List<Reservation> getAllReservationsByAccountId(Integer accountId) {
        List<Reservation> reservations = new LinkedList<>();

        String sqlGetAllStudents = "SELECT ReservationId, ReservationTime, Status, AccountId, TableId, Flag FROM Reservations WHERE AccountId = ?";
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlGetAllStudents)) {
                preparedStatement.setInt(1, accountId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Reservation reservation = new Reservation();
                    reservation.setReservationId(resultSet.getInt("ReservationId"));
                    reservation.setReservationTime(resultSet.getDate("ReservationTime"));
                    reservation.setStatus(resultSet.getString("Status"));
                    reservation.setAccountId(resultSet.getInt("AccountId"));
                    reservation.setTableId(resultSet.getInt("TableId"));
                    reservation.setFlag(resultSet.getInt("Flag"));
                    reservations.add(reservation);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return reservations;
    }

    public Boolean Update(ReservationDetail reservation) {

        String sqlApprove = "UPDATE Reservations SET Status = ?, Flag = ? WHERE ReservationId = ?";
        try {
            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlApprove)) {
                preparedStatement.setString(1, reservation.getStatus());
                preparedStatement.setInt(2, reservation.getFlag());
                preparedStatement.setInt(3, reservation.getReservationId());

                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean Delete(Integer reservationId) {
        String sqlDelete = "DELETE FROM Reservations WHERE ReservationId = ?";
        try {

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete)) {

                preparedStatement.setInt(1, reservationId);
                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Boolean createReservation(Reservation reservation) {
        String sqlCreateMenuItem = "INSERT INTO Reservations (ReservationTime, Status, AccountId, TableId, Flag) VALUES(?, ?, ?, ?, ?)";
        try {

            try (Connection connection = CSDL.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(sqlCreateMenuItem)) {
                preparedStatement.setDate(1, reservation.getReservationTime());
                preparedStatement.setString(2, reservation.getStatus());
                preparedStatement.setInt(3, reservation.getAccountId());
                preparedStatement.setInt(4, reservation.getTableId());
                preparedStatement.setInt(5, reservation.getFlag());

                preparedStatement.execute();
            }
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
