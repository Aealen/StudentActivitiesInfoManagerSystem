package util;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class connToDB {
    //        Properties properties =new Properties();
//        properties.load(new FileInputStream("Resources\\config.properties"));
//
//        String user = properties.getProperty("CONNECTION_USERNAME");
//        String pwd = properties.getProperty("CONNECTION_PASSWORD");
//        String driver=properties.getProperty("DRIVER_CLASS");
//        String url=properties.getProperty("CONNECTION_URL");
//        Class.forName(driver);
//        Connection conn= DriverManager.getConnection(url,user,pwd);
//        System.out.println(conn);
    private static Connection conn = null;
    private static Properties p = new Properties();

    /**
     * 静态代码块：类加载时被调用.
     *
     * 读取数据库配置文件db.properties
     * 加载驱动
     */
    static {
        try {
        InputStream inStream =Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("config.properties");
            p.load(inStream);//读取配置文件

            Class.forName(p.getProperty("DRIVER_CLASS"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private connToDB(){

    }

    /**
     * 创建数据库连接
     *
     * @return null or Connection Object
     */
    private static Connection createConn(){

        try {
            return DriverManager.getConnection(
                    p.getProperty("CONNECTION_URL"),
                    p.getProperty("CONNECTION_USERNAME"),
                    p.getProperty("CONNECTION_PASSWORD"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null,"数据库连接失败，请检查配置文件 config.properties");
        }
        return null;
    }

    /**
     * 打开数据库
     *
     * @return Connection Object
     */
    public static Connection openDB(){
        if (conn==null)
            conn=createConn();
        return conn;
    }

    /**
     * 关闭数据库
     */
    public static void closeDB(){
        if (conn!=null){
            try {
                conn.close();
                conn=null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 打开JDBC事务
     */
    public static void openShiWu(){
        if (conn!=null){
            try {
                conn.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭JDBC事务
     */
    public static void closeShiWu(){
        if (conn!=null){
            try {
                conn.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * JDBC事务提交
     */
    public static void commit(){
        if (conn!=null){
            try {
                conn.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 事务回滚
     */
    public static void rollback(){
        if (conn!=null){
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }









    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Connection conn=connToDB.openDB();
        if (conn!=null)
            System.out.println("数据库连接成功！");

    }
}
