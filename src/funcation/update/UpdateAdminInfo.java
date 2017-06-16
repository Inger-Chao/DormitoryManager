package funcation.update;

import model.user.Admin;
import base.DBService;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Joki on 2017/6/11.
 */
public class UpdateAdminInfo {

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    public UpdateAdminInfo(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int updateByNo(String no,Admin admin){
        int result_code = 0;
        String sql = "update administrator set adminNo='"+admin.getNo()
                +"',AdminName='"+admin.getName()+"',AdminSex='"+admin.getSex()
                +"',AdminAge="+admin.getAge()+",AdminTel='"+admin.getTel()+"',ApartNo='"+admin.getApartNo()
                +"'," +
                "AdminAddr='"+admin.getAddress()+"',AdminWorkYear='"+admin.getWorkAge()+"' where adminNo='"+no+"'";
        try {
            mStatement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            result_code = -1;
        }
        return result_code;
    }

    public int updatePassword(Admin admin, String newPassword){
        String sql = "update administrator set password='"+newPassword +"' where AdminNo='"+admin.getNo()+"'";
        int result_code=0;
        try {
            mStatement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
            result_code=-1;
        }
        return result_code;
    }
}
