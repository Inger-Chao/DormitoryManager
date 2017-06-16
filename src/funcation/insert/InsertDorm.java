package funcation.insert;

import model.Dorm;
import base.DBService;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Joki on 2017/6/10.
 */
public class InsertDorm {
    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    public InsertDorm(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insertIntoDorm(Dorm dorm){
        int result_code = 0;
        try {
            String sql1 = "insert into dorm(apartNo,DormNo,DormBed,DormIn) values('"+dorm.getApartNo()+"','"+dorm.getDormNo()
                    +"',"+dorm.getBedNum()+","+dorm.getBedIn()+")";
            mStatement.execute(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
            result_code = -1;
        }

        if (!dorm.getManagerNo().isEmpty()){
            String sql2 = "update dormmanager set bedNo='" + dorm.getManagerNo()+ "' where ApartNo='"
                    + dorm.getApartNo() + "' and DormNo='" + dorm.getDormNo()+ "'";
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
        return result_code;
    }

}
