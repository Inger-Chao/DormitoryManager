package base;

import others.Config;

import java.sql.*;

/**
 * 数据库服务
 * Created by Joki on 2017/6/6.
 */
public class DBService {

    private static final String MY_SQL_DRIVER = "com.mysql.jdbc.Driver";

    private static final String MYSQL = "mysql";
    private static final String JDBC = "jdbc";

    private Connection mConnection = null;
    private Statement mStatement = null;

    /**
     * 获得完成的数据库URL
     * @return
     */
    public String getURL() {
        return JDBC + ":" + MYSQL + "://" + Config.DBMS_IP +":" +Config.DBMS_PORT + "/" + Config.DB_NAME;
    }

    /**
     * 使用单例模式创建类的实例。使得这个类的实例仅初始化一次并且有且仅有一个
     */
    private final static class DBServiceHolder{
        private static final DBService sInstance = new DBService();
    }

    public static DBService getInstance(){
        return DBServiceHolder.sInstance;
    }

    /**
     * 连接数据库
     * @throws Exception
     */
    public void connect() throws Exception {
        try {
            Class.forName(MY_SQL_DRIVER);
            mConnection = DriverManager.getConnection(getURL(),Config.DBMS_USERNAME,Config.DBMS_PASSWORD);
            mStatement = mConnection.createStatement();
        } catch (ClassNotFoundException e) {
            throw new Exception("数据库驱动异常，可能是没有导入数据库驱动：" + e.getMessage());
        } catch (SQLException e){
            throw new Exception("数据库连接异常：" + e.getMessage());
        }
    }

    /**\
     * 关闭数据库
     * @throws Exception
     */
    public void close() throws Exception{
        try {
            if (mConnection != null){
                mConnection.close();
                mConnection = null;
            }
        } catch (SQLException e) {
            throw new Exception("关闭数据库异常" + e.getMessage());
        }
    }

    public Statement getStatement() {
        return mStatement;
    }
}
