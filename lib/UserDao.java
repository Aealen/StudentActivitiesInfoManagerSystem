package dao;

import bean.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import util.JdbcUtil;

/**
 * 封装用户信息的增删改查.
 *
 * @author
 */
public class UserDao {

    private Connection conn;

    public UserDao() {
        this.conn = JdbcUtil.openDB();
    }

    /**
     * 通过用户编号id查找用户.
     * <p>从表tb_user按用户编号id查找记录<br>
     * 把记录封装成User对象并返回
     *
     * @param id 用户编号
     * @return User 用户bean
     */
    public User queryUserById(String id) {
        String sql = "select * from tb_user where id = ? ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String strId = rs.getString(1);
                if (strId.equals(id)) {
                    return new User(strId, rs.getString(2), rs.getString(3), rs.getString(4));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * 通过用户姓名name查找用户.
     * <p>从表tb_user按用户姓名name查找记录<br>
     * 把记录封装成User对象并添加到List对象，最后返回该list对象
     *
     * @param name 用户姓名
     * @return List<User> 用户bean的list对象，空表示没有找到
     */
    public List<User> queryUsersByName(String name) {

        List<User> list = new ArrayList<User>();

        String sql = "select * from tb_user  where name = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    /**
     * 查找所有用户.
     *
     * @param 无
     * @return List<User> 用户bean的list对象，空表示没有找到
     */
    public List<User> queryUsers() {
        List<User> list = new ArrayList<User>();

        String sql = "select * from tb_user  ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    /**
     * 添加一条用户资料.
     *
     * @param user
     * @return boolean true成功 false失败
     */
    public boolean addUser(User user) {

        String sql = "insert into tb_user(id, name, type) values(?,?,?) ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getType());
            int x = pstmt.executeUpdate();
            if (x > 0) {
                return true;
            }

        } catch (SQLException ex) {
            //主键冲突？
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * 修改一条用户资料.
     *
     * @param user
     * @return boolean true成功 false失败
     */
    public boolean modUser(User user) {

        String sql = "update tb_user set name=?,password=?,type=? where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getType());
            pstmt.setString(4, user.getId());
            int x = pstmt.executeUpdate();
            if (x > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * 删除一条用户资料.
     *
     * @param user
     * @return boolean true成功 false失败
     */
    public boolean delUser(User user) {

        String sql = "delete from tb_user where id = ? ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getId());
            int x = pstmt.executeUpdate();
            if (x > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String args[]) {
        UserDao dao = new UserDao();
        dao.queryUsers();
    }
}
