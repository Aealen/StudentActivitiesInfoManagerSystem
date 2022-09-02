package service;

import bean.Activity;
import bean.User;
import dao.UsrActDao;
import dao.UsrDao;

import java.io.*;
import java.util.List;


/**
 * 用来进行用户和活动之间关系操作的服务
 */
public class UsrActService {
    private UsrActDao usrActDao;
    private UsrDao usrDao;
    private UsrService usrService;


    public UsrActService() {
        usrActDao=new UsrActDao();
        usrDao=new UsrDao();
        usrService=new UsrService();
    }

    /**
     * 用户是否加入活动
     * @param activity  活动Bean
     * @return boolean  true 在   false  不在
     */
    public boolean UsrJoinedAct(Activity activity){
        return usrActDao.UsrJoinedAct(usrDao.queryUsrByName(usrService.getCurrentUsrName()).get(0),activity);
    }

    /**
     * 用户退出活动
     * @param /user User Bean
     * @param activity Act Bean
     * @return boolean true成功退出    false 未参加活动
     */
    public boolean UsrQuitAct(Activity activity){
        return usrActDao.UsrQuitAct(usrDao.queryUsrByName(usrService.getCurrentUsrName()).get(0),activity);
    }


    /**
     * 用户参加活动
     * @param activity Act Bean
     * @return boolean true成功参加  false 失败
     */
    public boolean UsrJoinAct(Activity activity){
        return usrActDao.usrJoinAct(usrDao.queryUsrByName(usrService.getCurrentUsrName()).get(0),activity);
    }

    /**
     * 参加活动 活动当前人数应当改变
     * @param activity Bean
     * @return  Boolean
     */
    public boolean usrJoinWithNumAdd(Activity activity) {
        return usrActDao.usrJoinWithNumAdd(usrDao.queryUsrByName(usrService.getCurrentUsrName()).get(0),activity);
    }

    /**
     * 退出活动 活动当前人数应当改变
     * @param activity Bean
     * @return  Boolean
     */
    public boolean usrQuitWithNumMin(Activity activity) {
        return usrActDao.usrQuitWithNumMin(usrDao.queryUsrByName(usrService.getCurrentUsrName()).get(0),activity);
    }


}
