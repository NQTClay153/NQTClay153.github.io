/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class AccountDBContext extends DBContext{
    public Account getAccount(String username, String password)
    {
        try {
            String sql = "SELECT [username]\n" +
                    "      ,[password]\n" +
                    "  FROM [Account]\n" +
                    "  WHERE [username] = ? AND [password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                Account account = new Account();
                account.setUsername(username);
                account.setPassword(password);
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    public ArrayList<Account> getAccounts()
//    {
//        ArrayList<Account> accounts = new ArrayList<>();
//        try {
//            String sql = "SELECT [username]\n" +
//                    "      ,[password]\n" +
//                    "  FROM [Account]\n";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            ResultSet rs = stm.executeQuery();
//            while(rs.next())
//            {
//                Account account = new Account();
//                account.setUsername(rs.getString("username"));
//                account.setPassword(rs.getString("password"));
//                accounts.add(account);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return accounts;
//    }
    
    public Account checkAccountExist(String acc) {
        try {
            String sql = "SELECT [username]\n" +
                    "      ,[password]\n" +
                    "  FROM [Account]\n" +
                    "  where username like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, acc);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insertAccount (String username, String password) {
        try {
            String sql = "INSERT INTO [dbo].[Account]\n" +
                    "           ([username]\n" +
                    "           ,[password])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
