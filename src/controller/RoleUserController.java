package controller;

import conexion.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.Role;

/**
 *
 * @author William
 */
public class RoleUserController {
    MySQLConexion conexion;

    public RoleUserController() {
        conexion = new MySQLConexion();
    }

    public void insert(Role role) {
        // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()) {
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String insertSQL = "INSERT INTO Roles (Role, Code) VALUES (?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setString(1, role.getRole());
                    pstmt.setInt(2, role.getCode());
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
                String selectSQL = "SELECT * FROM Roles";
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();
                    // Itera on the results
                    while (rs.next()) {
                        System.out.println("Role: " + rs.getString("Role") + ", Code: " + rs.getString("Code"));
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
                String deleteSQL = "DELETE FROM Roles WHERE Code = ?";
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
                String searchSQL = "SELECT * FROM Roles WHERE Code = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(searchSQL)) {
                    pstmt.setInt(1, code);
                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();
                    // Itera on the results
                    if (!rs.next()){
                        System.out.println("Does not exist");
                    }else{
                        System.out.println("Role: " + rs.getString("Role") + ", Code: " + rs.getString("Code"));
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
    
    public void modify (Role role) {
         // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()){
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String upDateSQL = "UPDATE Roles SET Role = ? WHERE Code = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(upDateSQL)){
                    pstmt.setString(1, role.getRole());
                    pstmt.setInt(2, role.getCode());
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
