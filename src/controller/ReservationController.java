package controller;

import conexion.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Reservation;

/**
 *
 * @author William
 */
public class ReservationController {
    MySQLConexion conexion;
    
    public ReservationController() {
        conexion = new MySQLConexion();
    }
    
    public void insert(Reservation reservation) {
        // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()) {
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String insertSQL = "INSERT INTO Reservations (Code, NumberPersons, DateEntry, DateDeparture, ReserveStatus, TotalPrice, UserId, HotelCode, NumberBends) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setInt(1, reservation.getCode());
                    pstmt.setInt(2, reservation.getNumberPersons());
                    pstmt.setString(3, reservation.getDateEntry());
                    pstmt.setString(4, reservation.getDateDeparture());
                    pstmt.setString(5, reservation.getReserveStatus());
                    pstmt.setFloat(6, reservation.getTotalPrice());
                    pstmt.setInt(7, reservation.getUser().getId());
                    pstmt.setInt(8, reservation.getHotel().getCode());
                    pstmt.setInt(9, reservation.getRoom().getNumberBends());
                    // Execute the query
                    int rowsAffected = pstmt.executeUpdate();
                    // Verify if the insertion was successful
                    if (rowsAffected > 0) {
                        System.out.println("Successful integration");
                    } else {
                        System.out.println("Data could not be inserted");
                    }
                }
            } else {
                System.out.println("Could not establish a connection to the database");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while inserting into the database");
            e.printStackTrace();
        }
    }
    
    public void select() {
        // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()) {
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String selectSQL = "SELECT * FROM Reservations";
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();
                    // Itera on the results
                    while (rs.next()) {
                        System.out.println("Code: " + rs.getInt("Code") + ", NumberPersons: " + rs.getInt("NumberPersons") + ", DateEntry: " + rs.getString("DateEntry")
                        + ", DateDeparture: " + rs.getString("DateDeparture") + ", ReserveStatus: " + rs.getString("ReserveStatus") + ", TotalPrice: " + rs.getFloat("TotalPrice")
                        + ", UserId: " + rs.getInt("UserId") + ", HotelCode: " + rs.getInt("HotelCode") + ", NumberBends" + rs.getInt("NumberBends"));
                    }
                }
            } else {
                System.out.println("Could not establish a connection to the database");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while inserting into the database");
            e.printStackTrace();
        }
    }
    
    public void delete(int code) {
        // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()){
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String deleteSQL = "DELETE FROM Reservations WHERE Code = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)){
                    pstmt.setInt(1, code);
                    // Execute the query
                    int rowsAffected = pstmt.executeUpdate();
                    // Verify if the insertion was successful
                    if (rowsAffected > 0) {
                        System.out.println("Successfully eliminated");
                    } else {
                        System.out.println("The user has not been deleted");
                    }
                }
            }else{
                System.out.println("Could not establish a connection to the database");
            }
        }catch (SQLException e) {
            System.out.println("An error occurred while making the selection in the database");
            e.printStackTrace();
        }
    }
    
    public void search (int code) {
        // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()) {
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String searchSQL = "SELECT * FROM Reservations WHERE Code = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(searchSQL)) {
                    pstmt.setInt(1, code);
                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();
                    // Itera on the results
                    if (!rs.next()){
                        System.out.println("Does not exist");
                    }else{
                        System.out.println("Code: " + rs.getInt("Code") + ", NumberPersons: " + rs.getInt("NumberPersons") + ", DateEntry: " + rs.getString("DateEntry")
                        + ", DateDeparture: " + rs.getString("DateDeparture") + ", ReserveStatus: " + rs.getString("ReserveStatus") + ", TotalPrice: " + rs.getFloat("TotalPrice")
                        + ", UserId: " + rs.getInt("UserId") + ", HotelCode: " + rs.getInt("HotelCode") + ", NumberBends" + rs.getInt("NumberBends"));
                    }
                }
            }else{
                System.out.println("Could not establish a connection to the database");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while making the selection in the database");
            e.printStackTrace();
        }
    }
    
    public void modify (Reservation reservation) {
         // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()){
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String upDateSQL = "UPDATE Reservations SET NumberPersons = ?, DateEntry = ?, DateDeparture = ?, ReserveStatus = ?, TotalPrice = ?, UserId = ?, HotelCode = ?, NumberBends = ? WHERE Code = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(upDateSQL)){                                   
                    pstmt.setInt(1, reservation.getNumberPersons());
                    pstmt.setString(2, reservation.getDateEntry());
                    pstmt.setString(3, reservation.getDateDeparture());
                    pstmt.setString(4, reservation.getReserveStatus());
                    pstmt.setFloat(5, reservation.getTotalPrice());
                    pstmt.setInt(6, reservation.getUser().getId());
                    pstmt.setInt(7, reservation.getHotel().getCode());
                    pstmt.setInt(8, reservation.getRoom().getNumberBends());
                    pstmt.setInt(9, reservation.getCode());
                    // Execute the query
                    int rowsAffected = pstmt.executeUpdate();
                    // Verify if the insertion was successful
                    if (rowsAffected > 0) {
                        System.out.println("Successful modification");
                    } else {
                        System.out.println("Data not modified");
                    }    
                }
            }else{
                System.out.println("Could not establish a connection to the database");
            }
        }catch (SQLException e) {
            System.out.println("An error occurred while making the selection in the database");
            e.printStackTrace();
        }
    }   
}
