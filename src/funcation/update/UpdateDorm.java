package funcation.update;

import base.DBService;
import model.Dorm;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by lenovo on 2017/6/14.
 */
public class UpdateDorm {

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    public UpdateDorm(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  int update(Dorm dorm1){
        int result_code = 0;
        try {
            String sql ="UPDATE dorm,dormmanager,live\n"+
                    "SET dorm.DormBed='"+dorm1.getBedNum()+"',dorm.DormIn='"+dorm1.getBedIn()+
                    "',dormmanager.BedNo=(SELECT live.bedNo FROM live WHERE live.SNo='"+dorm1.getManagerNo()+"')\n"+
                    "WHERE dormmanager.BedNo=live.bedNo\n " +
                    "and dorm.ApartNo=dormmanager.ApartNo\n" +
                    "and dorm.dormNo=dormmanager.DormNo\n" +
                    "and dormmanager.ApartNo=live.Apartno\n" +
                    "and dormmanager.DormNo=live.DormNo\n" +
                    "and live.ApartNo='"+ dorm1.getApartNo()+"'\n" +
                    "and live.dormNo='"+dorm1.getDormNo()+"'\n";

            mStatement.execute(sql);
            mDBMS.close();
        } catch (SQLException e) {
            result_code = -1;
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result_code;
    }
}
