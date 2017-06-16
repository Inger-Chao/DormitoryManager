package funcation.selectview;

import model.Live;
import model.user.Admin;
import base.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * Created by Joki on 2017/6/12.
 */
public class SelectCurrentAdminView {

    private DBService mDBMS = new DBService().getInstance();

    private Statement mStatement = null;

    private Vector<Live> lives = new Vector<>();
    private Live live = null;


    public SelectCurrentAdminView(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 查询此宿管管理公寓的住宿情况
     * @param admin
     * @return
     */
    public Vector<Live> selectAllLiveByApartNo(Admin admin){
        String sql = "select * from " + admin.getApartNo();
        try {
            ResultSet resultSet = mStatement.executeQuery(sql);
            while (resultSet.next()){
                lives.add(new Live(admin.getApartNo(),resultSet.getString(1),
                        resultSet.getInt(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lives;
    }

    public Vector<Live> selectAllLiveByDormNo(Admin admin , String dormNo){
        String sql = "SELECT * FROM apartments."+admin.getApartNo()+" where dormNo='"+dormNo+"';";
        try {
            ResultSet resultSet = mStatement.executeQuery(sql);
            while (resultSet.next()){
                lives.add(new Live(admin.getApartNo(),resultSet.getString(1),
                        resultSet.getInt(2),resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lives;
    }

    public Live selectBySno(Admin admin,String sno){
        String sql = "SELECT * FROM apartments."+admin.getApartNo()+" where sno='"+sno+"'";
        try {
            ResultSet resultSet = mStatement.executeQuery(sql);
            if (resultSet.next()){
                live = new Live(admin.getApartNo(),resultSet.getString(1),
                        resultSet.getInt(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return live;
    }

    public Live selectConcreteLive(Admin admin,String dormNo,int bedNo){
        String sql = "SELECT * FROM apartments."+admin.getApartNo()+" where dormNo='"+dormNo+"' and bedNo=" + bedNo;
        try {
            ResultSet resultSet = mStatement.executeQuery(sql);
            if (resultSet.next()){
                live = new Live(admin.getApartNo(),resultSet.getString(1),
                        resultSet.getInt(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return live;
    }

}
