package funcation.delete;

import base.DBService;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Joki on 2017/6/9.
 */
public class DeleteApartment {

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    public DeleteApartment(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //通过公寓号删除公寓信息
    public int Delete(String no){
        int resultCode = 0;
        String sql = "delete from apartment where ApartNo='" + no + "';";
        try {
            mStatement.execute(sql);
            mDBMS.close();
        } catch (SQLException e) {
            e.printStackTrace();
            resultCode = -1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultCode;
    }

}
