package funcation.delete;

import base.DBService;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Joki on 2017/6/11.
 */
public class DeleteDorm {
    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;


    public DeleteDorm(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int delete(String apartNo,String dormNo){
        int result_code = 0;
        String sql = "delete from dorm where apartNo='"+ apartNo+"' and DormNo='"+dormNo+"'";
        try {
            mStatement.execute(sql);
            mDBMS.close();
        } catch (SQLException e) {
            e.printStackTrace();
            result_code=-1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result_code;
    }

}
