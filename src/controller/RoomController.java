package controller;

import conexion.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import models.Room;

/**
 *
 * @author William
 */
public class RoomController {
    MySQLConexion conexion;
    
    public RoomController() {
        conexion = new MySQLConexion();
    }
    
    public void insert(Room room) {
        // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()) {
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String insertSQL = "INSERT INTO Rooms (HotelCode, HotelName, NumberRoom, NumberBends) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setInt(1, room.getHotelCode());
                    pstmt.setString(2, room.getHotelName());
                    pstmt.setInt(3, room.getNumberRoom());
                    pstmt.setInt(4, room.getNumberBends());
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
                String selectSQL = "SELECT * FROM Rooms";
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();
                    // Itera on the results
                    while (rs.next()) {
                        System.out.println("HotelCode: " + rs.getString("HotelCode") + ", HotelName: " + rs.getString("HotelName") + ", NumberRoom: " + rs.getString("NumberRoom")
                        + ", NumberBends: " + rs.getString("NumberBends"));
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
                String deleteSQL = "DELETE FROM Rooms WHERE HotelCode = ?";
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
                String searchSQL = "SELECT * FROM Rooms WHERE HotelCode = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(searchSQL)) {
                    pstmt.setInt(1, code);
                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();
                    // Itera on the results
                    if (!rs.next()){
                        System.out.println("Does not exist");
                    }else{
                        System.out.println("HotelCode: " + rs.getString("HotelCode") + ", HotelName: " + rs.getString("HotelName") + ", NumberRoom: " + rs.getString("NumberRoom")
                        + ", NumberBends: " + rs.getString("NumberBends"));
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
    
    public void modify (Room room) {
         // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()){
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String upDateSQL = "UPDATE Rooms SET HotelName = ?, NumberRoom = ?, NumberBends = ? WHERE HotelCode = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(upDateSQL)){                                 
                    pstmt.setString(1, room.getHotelName());
                    pstmt.setInt(2, room.getNumberRoom());
                    pstmt.setInt(3, room.getNumberBends());
                    pstmt.setInt(4, room.getHotelCode());
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
    
    public void hotelList (JComboBox hotel) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
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
                        modelo.addElement(rs.getString("Name"));
                    }
                }
            } else {
                System.out.println("Could not establish a connection to the database");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while inserting into the database");
            e.printStackTrace();
        }
       hotel.setModel(modelo);
    }  
}
