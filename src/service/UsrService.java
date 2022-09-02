package service;


import bean.User;
import dao.UsrDao;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 封装用户业务
 * 用户管理
 * 登录 注册  改密
 */
public class UsrService {
    private UsrDao usrDao;

    public UsrService() {
        usrDao=new UsrDao();
    }

    /**
     * 用户登录
     *
     * @param name 用户名
     * @param pwd 用户密码
     * @return boolean true 用户名和密码正确    false  1.未注册查无此人 2.密码错误
     */
    public boolean UsrLogin(String name,String pwd){
        List<User> LogUsr=usrDao.queryUsrByName(name);
        if (LogUsr.isEmpty())
            return false;  //查无此人 请检查用户名和密码是否正确!
        else {
            //说明有这个人,接下来进行密码比对
            if (pwd.equals(LogUsr.get(0).getPwd()))
                return true;//密码正确  登录成功
            else
                return false;//密码错误 请检查用户名和密码是否正确!
        }
    }

    /**
     * 注册
     * 添加一个用户
     * @param /user 用户信息
     * @return boolean true 成功 false 失败
     */
    public boolean addUsr(String name,String pwd) {
        User user=new User();
        user.setName(name);
        user.setPwd(pwd);
        user.setIsAdmin("0");
        return usrDao.addUsr(user);
    }

    public boolean UsrAuthorFileWrite(String username){
        String UsrAuthFilePath="E:\\MyDesktop\\Fighting\\JAVA\\FinaProject\\Resources\\UsrAuthoLog.txt";
        File file=new File(UsrAuthFilePath);
        FileOutputStream fos=null;
        if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fos=new FileOutputStream(UsrAuthFilePath,false);
            byte[] data=username.getBytes(StandardCharsets.UTF_8);
            fos.write(data);
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * 获取当前用户NAme
     * @return dates    用户名
     */
    public String getCurrentUsrName(){
        String UsrAuthFilePath="E:\\MyDesktop\\Fighting\\JAVA\\FinaProject\\Resources\\UsrAuthoLog.txt";
        BufferedReader bfr=null;
        String datas=new String();
        try {

            bfr=new BufferedReader(new FileReader(UsrAuthFilePath));
            datas=bfr.readLine();
            //System.out.println(datas);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return datas;

    }



    /**
     * 用户是否已经存在
     *
     * @param name
     * @return boolean true 存在 false 不存在
     */
    public boolean UsrIsExist(String name){
        List<User> usr=usrDao.queryUsrByName(name);
        if (usr.isEmpty()) return false;
        else  return true;
    }


    /**
     * 用户是否是管理员
     * @param /user 用户信息
     * @return boolean true 是管理员 false 是普通用户
     */
    public boolean UsrIsAdmin(String name){
        List<User> user=usrDao.queryUsrByName(name);
        if (user.get(0).getIsAdmin().equals("1"))
            return true;
        return false;
    }


    /**
     * 根据用户编号查询用户信息
     * @param id
     * @return User
     */
    public List<User> queryUserById(String id){
        return usrDao.queryUsrById(id);
    }

    /**
     * 根据用户姓名查询
     * @param name
     * @return
     */
    public List<User> queryUserByName(String name){
        return usrDao.queryUsrByName(name);
    }

    /**
     * 根据用户类型查询
     * @param isAdmin
     * @return  0普通 1管理
     */
    public List<User> queryUserByType(String isAdmin){
        return usrDao.queryUsrByType(isAdmin);
    }

    /**
     * 查询全部用户信息
     * @return
     */
    public List<User> queryUser(){
        return usrDao.queryUsr();
    }

    /**
     * 修改用户信息 包括权限控制
     * 用一个新的临时 User   userNew 修改后替换源数据
     *
     * @param user
     * @return boolean true成功 false查无此人
     */
    public boolean modUsrInfo(User user){
        List<User> userNew=usrDao.queryUsrById(user.getId());
        if (userNew.isEmpty())//  查无此人
            return false;
        userNew.get(0).setPwd(user.getPwd());
        userNew.get(0).setName(user.getName());
        userNew.get(0).setIsAdmin(user.getIsAdmin());
        return usrDao.modUsr(userNew.get(0));
    }

    /**
     * 删除指定用户    ById
     * @param user
     * @return
     */
    public boolean delUsr(User user){
        return usrDao.delUsr(user);
    }

    public boolean UpdateLogInTime(User user){
        return usrDao.UpdateLogInTime(user);
    }


    public Boolean addUsr(User user,int flag) {
        if (flag==0) {
            if (UsrIsExist(user.getName()))
                return false;
            return usrDao.addUsr(user);
        }
        else if (flag==1){
            //有ID
            if (UsrIsExist(user.getName()))
                return false;
            return usrDao.addUsrHandly(user);
        }

        return false;
    }
}
