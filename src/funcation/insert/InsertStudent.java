package funcation.insert;

import model.user.Student;
import base.DBService;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Joki on 2017/6/10.
 */
public class InsertStudent {

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    public InsertStudent(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insertStuLive(Student student){
                int result_code = 0;
                String sql = "insert into student(SNo,SName,STel,apartNo,dormNo,bedNo) values('"+student.getNo()+"','"+
                        student.getName()+"','"+student.getTel()+"','"+student.getApartNO()+"','"+student.getDormNo()+"',"
                        +student.getBedNo()+");";
                try {
                    mStatement.execute(sql);
                } catch (SQLException e) {
                    e.printStackTrace();
                    result_code = -1;
        }

        try {
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result_code;
    }

}
