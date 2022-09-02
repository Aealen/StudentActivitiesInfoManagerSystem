package service;

import bean.Activity;
import dao.ActDao;

import java.util.List;

public class ActService {
    private ActDao actDao;

    public ActService() {
        actDao=new ActDao();
    }

    /**
     * 根据ID查询活动
     * @param id
     * @return list
     */
    public List<Activity> queryActById(String id){
        return actDao.queryActById(id);
    }

    /**
     * 根据Name 查询活动
     * @param name
     * @return list
     */
    public List<Activity> queryActByName(String name){
        return actDao.queryActByName(name);
    }

    /**
     * 通过Date 查询活动
     * @param Date
     * @return list
     */
    public List<Activity> queryActByDate(String Date){
        return actDao.queryActByDate(Date);
    }

    /**
     * 通过Status 状态查询活动
     * @param status 状态
     * @return list
     */
    public List<Activity> queryActByStatus(String status){
        return actDao.queryActByStatus(status);
    }

    /**
     * 查询全部活动
     * @return list
     */
    public List<Activity> queryAct(){
        return actDao.queryAct();
    }

    /**
     * 添加活动
     * @param activity
     * @return
     */
    public boolean addAct(Activity activity){
        return actDao.addAct(activity);
    }

    /**
     * 删除一个活动
     * @param activity bean
     * @return  boolean
     */
    public boolean DelAct(Activity activity){
        return actDao.DelAct(activity);
    }

    /**
     * 编辑活动
     * @param activity bean
     * @return boolean
     */
    public boolean EditAct(Activity activity){
        return actDao.EditAct(activity);
    }




}
