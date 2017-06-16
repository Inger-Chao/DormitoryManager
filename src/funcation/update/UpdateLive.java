package funcation.update;

import model.Live;
import base.DBService;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Joki on 2017/6/12.
 */
public class UpdateLive {

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    public UpdateLive(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int updateLive(Live live){
        int result_code = 0;
        String sql = "update live set sno='"+live.getSno()+"' where apartno='"+live.getApartNo()
                +"'and dormNo='"+live.getDormNo()+"' and bedno="+live.getBedNo()+";";
        try {
            mStatement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            result_code = -1;
        }
        return result_code;
    }

    public int clearSno(Live live){
        int result_code = 0;
        String sql="update live set sno=null where apartno='" +
                live.getApartNo()+"'and dormNo='"+live.getDormNo()+"' and bedno="+live.getBedNo();
        try {
            mStatement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            result_code = -1;
        }
        return result_code;
    }
}
