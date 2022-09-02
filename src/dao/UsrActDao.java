package dao;


import bean.Activity;
import bean.User;
import bean.UsrAct;
import util.connToDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用来进行用户与活动之间关系的判断
 * 如 是否参加了某个活动等
 * @Author Aealen
 */
public class UsrActDao {
    private Connection conn;
    public UsrActDao() {
        this.conn= connToDB.openDB();
    }

    /**
     * 判断用户是否参加了某个活动
     * @param user userBean
     * @param activity act Bean
     * @return  boolean  true 在   false  不在
     */
    public boolean UsrJoinedAct(User user, Activity activity){
        List<UsrAct> list=new ArrayList<UsrAct>();
        String sql="select * from usr_act where usr_id=? and act_id=?";

        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,user.getId());
            preparedStatement.setString(2,activity.getId());

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                list.add(new UsrAct(
                        rs.getString(1),
                        rs.getString(2)));
            }
            if (list.isEmpty()){
                return false;
            }else
                return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    /**
     * 用户退出活动
     * @param user User bean
     * @param activity Act bean
     * @return boolean true成功退出    false 未参加活动
     */
    public boolean UsrQuitAct(User user,Activity activity){
        if (UsrJoinedAct(user,activity)){
            //参加活动才能退出
            String sql="delete from usr_act where usr_id =? and act_id=?";
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1,user.getId());
                preparedStatement.setString(2,activity.getId());

                int x=preparedStatement.executeUpdate();

                if (x>0) return true;
                else  return false;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else {
            return false;
        }
        return false;
    }


    /**
     * 用户参加活动
     * @param user    User Bean
     * @param activity  Act Bean
     * @return  boolean true成功参加  false 失败
     */
    public boolean usrJoinAct(User user,Activity activity){
        if (!UsrJoinedAct(user,activity)){
            //没参加这个活动才能参加
           String sql="insert into usr_act (usr_id,act_id)values(?,?)";
           try {
               PreparedStatement preparedStatement=conn.prepareStatement(sql);
               preparedStatement.setString(1,user.getId());
               preparedStatement.setString(2,activity.getId());

               int x=preparedStatement.executeUpdate();
               if (x>0) return true;

           } catch (SQLException throwables) {
               throwables.printStackTrace();
           }
        }
        return false;
    }

    /**
     * 参加活动 活动当前人数应当改变
     * @param user  Bean
     * @param activity Bean
     * @return  Boolean
     */
    public boolean usrJoinWithNumAdd(User user,Activity activity){
        String sql="update all_act set current_num=current_num+1 where act_id=?";

        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,activity.getId());

            int x=preparedStatement.executeUpdate();
            if (x>0) return true;
            else return false;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * 退出活动 活动当前人数应当改变
     * @param user  Bean
     * @param activity Bean
     * @return  Boolean
     */
    public boolean usrQuitWithNumMin(User user,Activity activity){
        String sql="update all_act set current_num=current_num-1 where act_id=?";
        try {
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,activity.getId());

            int x=preparedStatement.executeUpdate();
            if (x>0) return true;
            else return false;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }




}
