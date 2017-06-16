package funcation.select;

import model.Dorm;
import base.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * Created by Joki on 2017/6/9.
 */
public class SelectDorms {

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    private Vector<Dorm> dorms = new Vector<>();

    private Dorm dorm = null;

    public SelectDorms(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查找所有宿舍的信息
     * @return
     */
    public Vector<Dorm> searchAllDorms(){
        String sql = "SELECT dorm.ApartNo,dorm.DormNo,dorm.DormBed,dorm.DormIn,dormmanager.bedNo\n" +
                "from dorm,dormmanager\n" +
                "where " +
                "dorm.ApartNo=dormmanager.ApartNo\n" +
                "and dorm.dormNo=dormmanager.DormNo" ;
        try {
            dorms = dealAllResult(mStatement.executeQuery(sql));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dorms;
    }

    private Vector<Dorm> dealAllResult(ResultSet resultSet) {
        if (resultSet != null){
            try {
                while (resultSet.next()){
                    dorms.add(new Dorm(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),resultSet.getInt(4),
                            resultSet.getString(5)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dorms;
    }

    /**
     * 通过公寓号和宿舍号查找具体的宿舍信息
     * @param apartNo
     * @param dormNo
     * @return
     */
    public Vector<Dorm> search(String apartNo,String dormNo){
        try {
        String sql ="SELECT dorm.ApartNo,dorm.DormNo,dorm.DormBed,dorm.DormIn,live.SNo\n" +
                "from dorm,dormmanager,live\n" +
                "where dormmanager.BedNo=live.bedNo \n" +
                "and dormmanager.BedNo=live.bedNo\n" +
                "AND dorm.ApartNo=dormmanager.ApartNo\n" +
                "and dorm.dormNo=dormmanager.DormNo\n" +
                "and dormmanager.ApartNo=live.Apartno\n" +
                "and dormmanager.DormNo=live.DormNo\n" +
                "and live.ApartNo='"+ apartNo+"'\n" +
                "and live.dormNo="+dormNo;
             dorms = dealAllResult(mStatement.executeQuery(sql));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dorms;
    }

}
