package dao;

import bean.Activity;
import util.connToDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 活动Dao 相关
 * @Author Aealen
 */
public class ActDao {
    private Connection conn;
    public ActDao() {
        this.conn= connToDB.openDB();
    }


    /**
     * 通过ID查询活动
     * 从表all_act中 按 act_id  查询活动
     * 并将查询结果存到 List中
     * @param id 查询活动ID
     * @return Activity 对象
     */
    public List<Activity> queryActById(String id){
        List<Activity> list=new ArrayList<Activity>();
        Activity activity=new Activity();
        String sql="select * from all_act where act_id=?";

        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,id);
            ResultSet rs= preparedStatement.executeQuery();
            while (rs.next()){
                list.add(new Activity(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    /**
     * 根据Name查询活动
     * 从表all_act中 按 name  查询活动
     * 并将查询结果存到 List中
     * @param name
     * @return
     */
    public List<Activity> queryActByName(String name){
        List<Activity> list=new ArrayList<Activity>();
        String sql="select * from all_act where name = ?";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                list.add(new Activity(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }


    /**
     * 通过活动时间查询活动
     * 从表 all_act 按 活动时间 time 查询
     * @param Date  活动时间
     * @return
     */
    public List<Activity> queryActByDate(String Date){
        List<Activity> list=new ArrayList<Activity>();
        String sql="select * from all_act where time=?";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,Date);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                list.add(new Activity(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    /**
     * 通过 活动状态查询
     * @param status 活动状态
     * @return list
     */
    public List<Activity> queryActByStatus(String status){
        List<Activity> list=new ArrayList<Activity>();
        String sql="select * from all_act where status=?";

        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,status);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                list.add(new Activity(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return list;
    }

    /**
     * 查询全部活动
     * @return list
     */
    public List<Activity> queryAct(){
        List<Activity> list =new ArrayList<Activity>();
        String sql="select * from all_act";

        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            ResultSet rs =preparedStatement.executeQuery();
            while (rs.next()){
                list.add(new Activity(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    /**
     * 添加新活动
     * @param activity Bean
     * @return Boolean
     */
    public boolean addAct(Activity activity){
        String sql="insert into all_act (name,act_desc,time)values(?,?,?)";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,activity.getName());
            preparedStatement.setString(2,activity.getDesc());
            preparedStatement.setString(3,activity.getTime());
            int x=preparedStatement.executeUpdate();
            if (x>0){
                return true;
            }else return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    /**
     * 删除一个活动  通过ID
     * @param activity bean
     * @return  boolean
     */
    public boolean DelAct(Activity activity){
        String sql="delete from all_act where act_id=?";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,activity.getId());

            int x=preparedStatement.executeUpdate();
            if (x>0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    /**
     * 编辑活动
     * @param activity Bean
     * @return Boolean
     */
    public boolean EditAct(Activity activity){
        String sql="update all_act set name=?,act_desc=?,status=?,time=? where act_id =?";

        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,activity.getName());
            preparedStatement.setString(2,activity.getDesc());
            preparedStatement.setString(3,activity.getStatus());
            preparedStatement.setString(4,activity.getTime());
            preparedStatement.setString(5,activity.getId());

            int x=preparedStatement.executeUpdate();
            if (x>0) return  true;
            else return false;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }






}
