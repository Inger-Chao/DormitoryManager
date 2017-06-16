package funcation.insert;

import model.user.Admin;
import base.DBService;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Joki on 2017/6/10.
 */
public class InsertAdmin {

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    public InsertAdmin(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(Admin admin){
        int result_code = 0;
        String sql = "insert into administrator(AdminNo,AdminName,AdminTel,ApartNo) " +
                "values('" + admin.getNo() +"','"
                + admin.getName() + "','" + admin.getTel() +
                "','"+admin.getApartNo()+"')";
        try {
            mStatement.execute(sql);
            mDBMS.close();
        } catch (SQLException e) {
            e.printStackTrace();
            result_code = -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result_code;
    }
}
