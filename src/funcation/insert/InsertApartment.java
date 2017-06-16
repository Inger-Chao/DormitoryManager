package funcation.insert;

import model.Apartment;
import base.DBService;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Joki on 2017/6/10.
 */
public class InsertApartment {
    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    public InsertApartment(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //插入公寓信息。apartment有一个插入触发器，会自动向apartmanager表插入一个新的元组。当负责人不为空时，更新apartmanager表
    public int insert(Apartment apartment){
        int result_code = 0;
        String sql1 = "insert into apartment value('" +apartment.getNo()+ "','" +
                apartment.getName() + "','" +
                apartment.getLocation() + "'," + apartment.getFloor() + "," + apartment.getMax()
                + "," + apartment.getIn() + ");";

        try {
            mStatement.execute(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
            result_code = -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!apartment.getManagerNo().isEmpty()){
            String sql2 = "update apartmanager set AdminNo='" + apartment.getManagerNo()
                    + "' where ApartNo='" + apartment.getNo() + "'";
            try {
                mStatement.execute(sql2);
            } catch (SQLException e) {
                e.printStackTrace();
                result_code = -1;
            }
        }

        try {
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result_code;
    }
}
