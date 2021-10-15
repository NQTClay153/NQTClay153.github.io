/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author ADMIN
 */
public class UserDBContext extends DBContext{
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        try {
            String sql = "SELECT uid\n" +
                        "      ,[displayname]\n" +
                        "      ,[gender]\n" +
                        "      ,[dob]\n" +
                        "      ,[address]\n" +
                        "      ,[isAdmin]\n" +
                        "  FROM [User]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("uid"));
                u.setDisplayName(rs.getString("displayname"));
                u.setGender(rs.getBoolean("gender"));
                u.setDob(rs.getDate("dob"));
                u.setAddress(rs.getString("address"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public void insertUser (String displayName, Boolean gender, Date dob, String address, Boolean isAdmin) {
        try {
            String sql = "INSERT INTO [User]\n" +
                    "           ([displayname]\n" +
                    "           ,[gender]\n" +
                    "           ,[dob]\n" +
                    "           ,[address]\n" +
                    "           ,[isAdmin])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, displayName);
            stm.setBoolean(2, gender);
            stm.setDate(3, dob);
            stm.setString(4, address);
            stm.setBoolean(5, isAdmin);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteUser(int id) {
        try {
            String sql = "DELETE FROM [User]\n" +
                    "      WHERE [uid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
