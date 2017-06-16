package funcation.select;

import model.user.Admin;
import base.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * Created by Joki on 2017/6/8.
 */
public class SelectAdminInfo {

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    private Vector<Admin> admins = new Vector<>();

    private Admin admin = null;

    public SelectAdminInfo(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vector<Admin> selectAll(){
        try {
            String sql = "select * from administrator";
            admins = dealAllResult(mStatement.executeQuery(sql));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admins;
    }

    private Vector<Admin> dealAllResult(ResultSet resultSet) {
        if (resultSet != null){
            try {
                while (resultSet.next()){
                    admins.add(new Admin(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getInt(8)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return admins;
    }

    public Admin select(String no){
        try {
            String sql = "select * from administrator where adminNo LIKE'"+ no +"%'";
            ResultSet resultSet = mStatement.executeQuery(sql);
            admin = dealResult(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;
    }

    private Admin dealResult(ResultSet resultSet) throws SQLException{
        if (resultSet.next()){
             admin = new Admin(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getInt(8));
        }
        return admin;
    }

    public String selectPassword(Admin admin){

        String password="";

        try {
            String sql = "select password from administrator where adminNo='" + admin.getNo() +"'";
            ResultSet resultSet = mStatement.executeQuery(sql);
            if (resultSet.next()){
                password = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }

}
