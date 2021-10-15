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
import model.Blog;

/**
 *
 * @author ADMIN
 */
public class BlogDBContext extends DBContext{
    public Blog getBlog(int id) {
        try {
            String sql = "SELECT [bid]\n" +
                    "      ,[blogTitle]\n" +
                    "      ,[from]\n" +
                    "  FROM [Blog]\n" +
                    "  WHERE [bid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            Blog b = new Blog();
            if (rs.next()) {
                b.setId(rs.getInt("bid"));
                b.setTitle(rs.getString("blogTitle"));
                b.setFrom(rs.getDate("from"));
            }
            return b;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Blog> getBlogs() {
        ArrayList<Blog> blogs = new ArrayList<>();
        try {
            String sql = "SELECT [bid]\n" +
                    "      ,[blogTitle]\n" +
                    "      ,[from]\n" +
                    "  FROM [Blog]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                Blog b = new Blog();
                b.setId(rs.getInt("bid"));
                b.setTitle(rs.getString("blogTitle"));
                b.setFrom(rs.getDate("from"));
                blogs.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return blogs;
    }
    
    public void deleteBlog(int id) {
        try {
            String sql = "DELETE FROM [Blog]\n" +
                    "      WHERE [bid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BlogDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
