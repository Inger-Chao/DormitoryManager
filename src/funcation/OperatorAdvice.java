package funcation;

import base.DBService;
import model.Advice;
import model.user.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

/**
 * Created by Joki on 2017/6/13.
 */
public class OperatorAdvice {

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    private Vector<Advice> advices = new Vector<>();

    private Advice advice = null;

    public OperatorAdvice(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int insertAdvice(Advice advice){
        int result_code = 0;

        String sql = "insert into advice(apartNo,advice,date) values('"+advice.getApartNo()+"','"
                +advice.getText()+"','"+advice.dateToString(advice.getDate())+"')";


        try {
            System.out.println(advice.toString());
            mStatement.execute(sql);
            mDBMS.close();
        } catch (SQLException e) {
            e.printStackTrace();
            result_code = -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result_code;
    }

    public Vector<Advice> selectApartAdvice(Admin admin,String date){
        String sql = "select * from advice where apartNo='" + admin.getApartNo() + "' and date=" +date+ "";
        try {
            ResultSet resultSet = mStatement.executeQuery(sql);
            while (resultSet.next()){
                advices.add(new Advice(resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4)));
            }
            mDBMS.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return advices;
    }

    public Advice selectByClick(String text,String date){
        try {
            String sql = "select * from advice where date like'" + date +"%' and advice like '" + text +"%'";
            ResultSet resultSet = mStatement.executeQuery(sql);
            if (resultSet.next()){
                advice = new Advice(resultSet.getString(2),resultSet.getString(3),
                        resultSet.getDate(4));
            }
            mDBMS.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return advice;
    }


}
