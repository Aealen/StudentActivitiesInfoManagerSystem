package service;

import bean.User;
import dao.UserDao;

/**
 * 封装用户管理业务逻辑.
 *
 * @author
 */
public class UserService {

    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    /**
     * 根据用户编号查询用户信息.
     *
     * @param id 用户编号
     * @return User
     */
    public User queryUserById(String id) {
        return userDao.queryUserById(id);
    }

    /**
     * 添加一个用户.
     *
     * @param user 用户信息
     * @return boolean true 成功 false 失败
     */
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    /**
     * 修改登陆用户密码.
     *
     * @param user 用户信息 用户编号必须，其他字段为修改后的值
     * @return boolean true 成功 false 失败
     */
    public boolean modUserPassword(User user) {
        User userNew = userDao.queryUserById(user.getId());
        if(userNew == null)
            return false;
        userNew.setPassword(user.getPassword());
        return userDao.modUser(userNew);
    }

    /**
     * 删除指定用户.
     *
     * @param user 用户信息 用户编号必须
     * @return boolean true 成功 false 失败
     */
    public boolean delUser(User user) {
        return userDao.delUser(user);
    }

    /**
     * 重置指定用户的密码.
     *
     * @param user 用户信息 用户编号必须
     * @return boolean true 成功 false 失败
     */
    public boolean resetUserPass(User user) {
        User userNew = userDao.queryUserById(user.getId());
        if(userNew == null)
            return false;
        userNew.setPassword("888888");
        return userDao.modUser(userNew);
    }

    /**
     * 退出系统.
     */
    public void exitSys() {
        System.exit(0);
    }
}
