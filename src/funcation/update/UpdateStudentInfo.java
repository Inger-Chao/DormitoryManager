package funcation.update;

import model.user.Student;
import base.DBService;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Joki on 2017/6/11.
 */
public class UpdateStudentInfo {

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;


    public UpdateStudentInfo(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int updateByNo(String no, Student student){

        int result_code = 0;

        String sql = "update student set sno='"+student.getNo()+
                "',sname='"+ student.getName()+"',ssex='"+ student.getSex() +"',STel='"+student.getTel()
                +"',SAcademic='"+student.getAcademic()+"',SDept='"+student.getDept()
                +"',ApartNo='"+student.getApartNO()+"',DormNo='"+student.getDormNo()+"',BedNo="+student.getBedNo()+
                ",Saddress='"+student.getAddress()+"' where sno='"+no+"'";
        try {
            mStatement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            result_code = -1;
        }
        return result_code;
    }

    public int updatePassword(Student student,String newPassword){
        String sql = "update student set password='"+newPassword +"' where sno='"+student.getNo()+"'";
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
