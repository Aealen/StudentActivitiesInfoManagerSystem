package dao;


import bean.User;
import util.connToDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 封装用户信息的增删查改
 * @Author Aealen
 */

public class UsrDao {
    private Connection conn;

    public UsrDao(){
        this.conn= connToDB.openDB();
    }


    /**
     * 通过ID 查询用户
     * 从表all_user 中按用户ID 查找记录
     * 把记录封装成User对象并返回
     * @param id 用户ID
     * @return User  用户Bean
     */
    public List<User> queryUsrById(String id){
        List<User> list = new ArrayList<User>();
        String sql="select * from all_user where uid= ?";
        try{
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()){
                String strId=rs.getString(1);
                if (strId.equals(id)){
                    list.add(new User(
                            strId,
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5)));
                }
            }
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            Logger.getLogger(UsrDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
        return  list;
    }

    /**
     * 通过用户名 username 查找用户
     * 从表 all_user 中按 用户名 user_name 查找记录
     * 把记录封装成User对象并添加到List 对象,最后返回该list 对象
     * @param name 用户姓名
     * @return List<User> 用户bean的list对象  空表表示没有找到
     */
    public List<User> queryUsrByName(String name){
        List<User> list = new ArrayList<User>();

        String sql = "select * from all_user where user_name =?";
        try {
            PreparedStatement pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,name);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()){
                list.add(new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            Logger.getLogger(UsrDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
        return list;
    }


    /**
     * 通过 admin 查找用户
     * 从表 all_user 中按 用户名 admin 查找记录
     * 把记录封装成User对象并添加到List 对象,最后返回该list 对象
     * @param isAdmin  用户类型 1为管理员 0为普通用户
     * @return List<User> 用户bean的list对象  空表表示没有找到
     */
    public List<User> queryUsrByType(String isAdmin){
        List<User> list =new ArrayList<User>();
        String sql="select * from all_user where admin = ?";
        try {
            PreparedStatement pstmt =conn.prepareStatement(sql);
            pstmt.setString(1,isAdmin);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()){
                list.add(new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
    /**
     * 查找所有用户
     * @return
     * @return  List<User> 用户Bean的list 对象,空表示没有找到
     */
    public List<User> queryUsr(){
        List<User> list =new ArrayList<User>();

        String sql="select * from all_user ";
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();

            while (rs.next()){
                list.add(new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException throwables) {
            //throwables.printStackTrace();
            Logger.getLogger(UsrDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
        return list;
    }
    /**
     * 添加一条用户资料  自增添加
     * @param user Bean
     * @return  boolean
     */
    public boolean addUsr(User user){

        if (true){
            String sql =" insert into all_user(user_name,user_passwd,admin) values(?,?,?)";
            try {
                PreparedStatement pstmt =conn.prepareStatement(sql);
                pstmt.setString(1,user.getName());
                pstmt.setString(2,user.getPwd());
                pstmt.setString(3,user.getIsAdmin());
                int x=pstmt.executeUpdate();
                if (x>0){
                    return true;
                }
            } catch (SQLException throwables) {
                Logger.getLogger(UsrDao.class.getName()).log(Level.SEVERE,null,throwables);
            }
        }else {
            return false;//用户已存在!!
        }
        return false;
    }


    /**
     * 添加一条用户资料  手动添加
     * @param user Bean
     * @return  boolean
     */
    public boolean addUsrHandly(User user){

        if (true){
            String sql =" insert into all_user(uid,user_name,user_passwd,admin) values(?,?,?,?)";
            try {
                PreparedStatement pstmt =conn.prepareStatement(sql);
                pstmt.setString(1,user.getId());
                pstmt.setString(2,user.getName());
                pstmt.setString(3,user.getPwd());
                pstmt.setString(4,user.getIsAdmin());
                int x=pstmt.executeUpdate();
                if (x>0){
                    return true;
                }
            } catch (SQLException throwables) {
                Logger.getLogger(UsrDao.class.getName()).log(Level.SEVERE,null,throwables);
            }
        }else {
            return false;//用户已存在!!
        }
        return false;
    }

    /**
     * 通过ID 删除一个用户记录
     * @param user
     * @return boolean true 成功 false 失败
     */
    public boolean delUsr(User user){

        String sql="delete from all_user where uid = ?";
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getId());
            int x=pstmt.executeUpdate();
            if (x>0){
                return true;
            }
        } catch (SQLException throwables) {
            Logger.getLogger(UsrDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
        return false;
    }

    /**
     * 修改一条用户资料
     * @param user
     * @return boolean true成功 false失败
     */
    public boolean modUsr(User user){
        String sql="update all_user set user_name=?,user_passwd=?,admin=? where uid=?";
        try {
            PreparedStatement preparedStatement =conn.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getPwd());
            preparedStatement.setString(3, user.getIsAdmin());
            preparedStatement.setString(4,user.getId());
            int x=preparedStatement.executeUpdate();
            if (x>0)
                return true;
        } catch (SQLException throwables) {
            Logger.getLogger(UsrDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
        return false;
    }


    /**
     * 更新用户最后登录时间
     * @param user
     * @return boolean true 成功 false 失败
     */
    public boolean UpdateLogInTime(User user){
        String sql="update all_user set last_login = default where user_name = ?";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,user.getName());

            int x=preparedStatement.executeUpdate();
            if (x>0)
                return true;
        } catch (SQLException throwables) {
            Logger.getLogger(UsrDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
        return false;
    }


    public static void main(String[] args) {
        UsrDao dao =new UsrDao();
        dao.queryUsr();
    }

}
