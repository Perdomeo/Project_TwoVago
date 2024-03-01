package controller;

import conexion.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Hotel;

/**
 *
 * @author William
 */
public class HotelController {
    MySQLConexion conexion;
    
    public HotelController() {
        conexion = new MySQLConexion();
    }
    
    public void insert(Hotel hotel) {
        // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()) {
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String insertSQL = "INSERT INTO Hotels (Code, Name, City, RoomQuantity, Address, Rating, PriceNight, Amenities) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setInt(1, hotel.getCode());
                    pstmt.setString(2, hotel.getName());
                    pstmt.setString(3, hotel.getCity());
                    pstmt.setInt(4, hotel.getRoomQuantity());
                    pstmt.setString(5, hotel.getAddress());
                    pstmt.setInt(6, hotel.getRating());
                    pstmt.setFloat(7, hotel.getPriceNight());
                    pstmt.setString(8, hotel.getAmenities());
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
                String selectSQL = "SELECT * FROM Hotels";
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();
                    // Itera on the results
                    while (rs.next()) {
                        System.out.println("Code: " + rs.getString("Code") + ", Name: " + rs.getString("Name") + ", City: " + rs.getString("City")
                        + ", RoomQuantity: " + rs.getString("RoomQuantity") + ", Address: " + rs.getString("Address") + ", Rating: " + rs.getString("Rating")
                        + ", PriceNight: " + rs.getString("PriceNight") + ", Amenities: " + rs.getString("Amenities"));
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
                String deleteSQL = "DELETE FROM Hotels WHERE Code = ?";
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
                String searchSQL = "SELECT * FROM Hotels WHERE Code = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(searchSQL)) {
                    pstmt.setInt(1, code);
                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();
                    // Itera on the results
                    if (!rs.next()){
                        System.out.println("Does not exist");
                    }else{
                        System.out.println("Code: " + rs.getString("Code") + ", Name: " + rs.getString("Name") + ", City: " + rs.getString("City")
                        + ", RoomQuantity: " + rs.getString("RoomQuantity") + ", Address: " + rs.getString("Address") + ", Rating: " + rs.getString("Rating")
                        + ", PriceNight: " + rs.getString("PriceNight") + ", Amenities: " + rs.getString("Amenities"));
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
    
    public void modify (Hotel hotel) {
         // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()){
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String upDateSQL = "UPDATE Hotels SET Name = ?, City = ?, RoomQuantity = ?, Address = ?, Rating = ?, PriceNight = ?, Amenities = ? WHERE Code = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(upDateSQL)){               
                    pstmt.setString(1, hotel.getName());
                    pstmt.setString(2, hotel.getCity());
                    pstmt.setInt(3, hotel.getRoomQuantity());
                    pstmt.setString(4, hotel.getAddress());
                    pstmt.setInt(5, hotel.getRating());
                    pstmt.setFloat(6, hotel.getPriceNight());
                    pstmt.setString(7, hotel.getAmenities());
                    pstmt.setInt(8, hotel.getCode());
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
