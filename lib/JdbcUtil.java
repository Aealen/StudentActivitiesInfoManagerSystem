package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * 封装数据库连接 单例模式.
 * @author 
 **/
public class JdbcUtil {

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
            
            InputStream inStream = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("db.properties");
                  
            //InputStream inStream = new FileInputStream("db.properties");
            p.load(inStream);

            Class.forName(p.getProperty("driverClassName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JdbcUtil() {
    }

    private static Connection createConn() {
        try {
             return DriverManager.getConnection(p.getProperty("url"),
                    p.getProperty("username"), p.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "数据库连接失败，请检查配置文件db.properties！");
        }
        return null;
    }

    /**
     * 打开数据库.
     *
     * @return Connection 数据库连接对象
     */
    public static Connection openDB() {
        if (conn == null) {
            conn = createConn();
        }
        return conn;
    }

    /**
     * 关闭数据库.
     */
    public static void closeDB() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 打开JDBC事务.
     */
    public static void openShiwu() {
        if (conn != null) {
            try {
                conn.setAutoCommit(false);
            } catch (SQLException ex) {
                //Logger.getLogger(DbConn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * 关闭JDBC事务
     */
    public static void closeShiwu() {
        if (conn != null) {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * JDBC事务提交
     */
    public static void commit() {
        if (conn != null) {
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * JDBC事务回滚
     */
    public static void rollback() {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        Connection conn = JdbcUtil.openDB();
        if (conn != null) {
            System.out.println("数据库连接成功");
        }
    }
}
