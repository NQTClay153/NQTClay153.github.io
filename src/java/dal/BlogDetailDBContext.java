/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Blog;
import model.BlogDetail;
import model.User;

/**
 *
 * @author ADMIN
 */
public class BlogDetailDBContext extends DBContext{
    public BlogDetail getBlogDetail(int id) {
        try {
            String sql = "SELECT b.bid, b.blogTitle, b.[from]\n" +
                        "      ,u.uid, u.displayname, u.gender, u.dob, u.[address], u.isAdmin\n" +
                        "      ,[description]\n" +
                        "FROM [Blog Detail] bd INNER JOIN Blog b ON bd.blogid = b.bid\n" +
                        "			INNER JOIN [User] u ON bd.userid = u.uid\n" +
                        "WHERE b.bid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            BlogDetail bd = new BlogDetail();
            if (rs.next()) {
                Blog b = new Blog();
                b.setTitle(rs.getString("blogTitle"));
                b.setFrom(rs.getDate("from"));
                b.setId(rs.getInt("bid"));
                bd.setBlog(b);
                User u = new User();
                u.setId(rs.getInt("uid"));
                u.setDisplayName(rs.getString("displayname"));
                u.setGender(rs.getBoolean("gender"));
                u.setDob(rs.getDate("dob"));
                u.setAddress(rs.getString("address"));
                u.setIsAdmin(rs.getBoolean("isAdmin"));
                bd.setUser(u);
                bd.setDescription(rs.getString("description"));
            }
//            int bid = rs.getInt("bid");
//            if (bid != 0) {
//                Comment c = new Comment();
//                c.setBlogDetail(bd);
//                User u = new User();
//                u.setId(rs.getInt("uid"));
//                u.setDisplayName(rs.getString("displayname"));
//                u.setGender(rs.getBoolean("gender"));
//                u.setDob(rs.getDate("dob"));
//                u.setAddress(rs.getString("address"));
//                u.setIsAdmin(rs.getBoolean("isAdmin"));
//                c.setUser(u);
//            }
            return bd;
        } catch (SQLException ex) {
            Logger.getLogger(BlogDetailDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void deleteBDetail(int id) {
        try {
            String sql = "DELETE FROM [Blog Detail]\n" +
                    "      WHERE [blogid] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BlogDetailDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
