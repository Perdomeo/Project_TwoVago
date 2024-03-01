package controller;

import conexion.MySQLConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import models.User;

/**
 *
 * @author William
 */
public class UserController {
    MySQLConexion conexion;

    public UserController() {
        conexion = new MySQLConexion();
    }
    
    public void insert(User user) {
        // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()) {
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String insertSQL = "INSERT INTO User (Id, UserName, Email, Password, Age, Address, Phone, Role ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                    pstmt.setInt(1, user.getId());
                    pstmt.setString(2, user.getUserName());
                    pstmt.setString(3, user.getEmail());
                    pstmt.setString(4, user.getPassword());
                    pstmt.setInt(5, user.getAge());
                    pstmt.setString(6, user.getAddress());
                    pstmt.setString(7, user.getPhone());
                    pstmt.setString(8, user.getRole().getRole());
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
                String selectSQL = "SELECT * FROM User";
                try (PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();
                    // Itera on the results
                    while (rs.next()) {
                        System.out.println("Id: " + rs.getInt("Id") + ", UserName: " + rs.getString("UserName") + ", Email: " + rs.getString("Email")
                        + ", Password: " + rs.getString("Password" ) + ", Age: " + rs.getString("Age" ) +", Address: " + rs.getString("Address" ) 
                        + ", Phone: " + rs.getString("Phone" ) + ", Role: " + rs.getString("Role" ));
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
    
    public void delete(int id) {
        // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()){
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String deleteSQL = "DELETE FROM User WHERE Id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)){
                    pstmt.setInt(1, id);
                    // Execute the query
                    int rowsAffected = pstmt.executeUpdate();
                    // Verify if the insertion was successful
                    if (rowsAffected > 0) {
                        System.out.println("Successfully eliminated");
                    } else {
                        System.out.println("The user has not been deleted");
                    }
                }
            }else {
                System.out.println("Could not establish a connection to the database");
            }
        }catch (SQLException e) {
            System.out.println("An error occurred while inserting into the database");
            e.printStackTrace();
        }
    }
    
    public void search (int id) {
        // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()) {
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String searchSQL = "SELECT * FROM User WHERE Id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(searchSQL)) {
                    pstmt.setInt(1, id);
                    // Execute the query
                    ResultSet rs = pstmt.executeQuery();
                    // Itera on the results
                    if (!rs.next()){
                        System.err.println("does not exist");
                    }else{
                        System.out.println("Id: " + rs.getInt("Id") + ", UserName: " + rs.getString("UserName") + ", Email: " + rs.getString("Email")
                        + ", Password: " + rs.getString("Password" ) + ", Age: " + rs.getString("Age" ) +", Address: " + rs.getString("Address" ) 
                        + ", Phone: " + rs.getString("Phone" ) + ", Role: " + rs.getString("Role" ));
                    }
                }
            } else {
                System.out.println("Could not establish a connection to the database");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while making the selection in the database");
            e.printStackTrace();
        }
    }
    
    public void modify (User user) {
         // Establishes the connection to the database
        try (Connection conn = conexion.mySQLConexion()){
            // Verify if the connection was successful
            if (conn != null) {
                // Prepares the SQL query to insert data
                String upDateSQL = "UPDATE User SET UserName = ?, Email =  ?, Password = ?, Age =  ?, Address = ?, Phone = ?, Role = ? WHERE Id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(upDateSQL)){                   
                    pstmt.setString(1, user.getUserName());
                    pstmt.setString(2, user.getEmail());
                    pstmt.setString(3, user.getPassword());
                    pstmt.setInt(4, user.getAge());
                    pstmt.setString(5, user.getAddress());
                    pstmt.setString(6, user.getPhone());
                    pstmt.setString(7, user.getRole().getRole());
                    pstmt.setInt(8, user.getId());
                    // Execute the query
                    int rowsAffected = pstmt.executeUpdate();
                    // Verify if the insertion was successful
                    if (rowsAffected > 0) {
                        System.out.println("successful modification");
                    } else {
                        System.out.println("data not modified");
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
    
    public void roleList (JComboBox rol){
        DefaultComboBoxModel model= new DefaultComboBoxModel();
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
                        model.addElement(rs.getString("Role"));
                    }
                }
            } else {
                System.out.println("Could not establish a connection to the database");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while inserting into the database");
            e.printStackTrace();
        }
        rol.setModel(model);
    }
}
