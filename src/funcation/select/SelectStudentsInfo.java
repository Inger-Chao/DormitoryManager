package funcation.select;

import model.user.Student;
import base.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * Created by Joki on 2017/6/8.
 */
public class SelectStudentsInfo {

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    private Vector<Student> students = new Vector<>();

    private Student student = null;

    public SelectStudentsInfo(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有学生信息
     * @return
     */
    public Vector<Student> selectAll(){
        try {
            String sql = "select student.SNo,student.SName,student.SSex,student.STel,student.SAcademic" +
                    ",student.SDept,live.Apartno,live.DormNo,live.bedNo,student.Saddress " +
                    "from student,live " +
                    "where student.sno=live.SNo";
            students = dealAllResult(mStatement.executeQuery(sql));
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    private Vector<Student> dealAllResult(ResultSet resultSet) {
        if (resultSet != null){
            try {
                while (resultSet.next()){
                    students.add(new Student(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getInt(9),
                            resultSet.getString(10)));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return students;
    }

    /**
     * 通过学号查询该学生的情况
     * @param no
     * @return
     */
    public Student select(String no){
        try {
            String sql ="select student.SNo,student.SName,student.SSex,student.STel,student.SAcademic," +
                    "student.SDept,student.Apartno,student.DormNo,student.bedNo,student.Saddress " +
                    "from student " +
                    "where student.sno='" + no +"'";
            ResultSet resultSet = mStatement.executeQuery(sql);
            student =  dealResult(resultSet);
            mDBMS.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return student;
    }

    public Student dealResult(ResultSet resultSet){
        try {
            if (resultSet.next()){
                student = new Student(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9),
                        resultSet.getString(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public String selectPassword(Student student){

        String password = null;

        try {
            String sql = "select password from student where sno='" + student.getNo() +"'";
            ResultSet resultSet = mStatement.executeQuery(sql);
            if (resultSet.next()){
                password = resultSet.getString(1);
                System.out.println(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }
}
