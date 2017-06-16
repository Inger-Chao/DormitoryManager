package funcation.select;

import model.Apartment;
import model.Dorm;
import base.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 通过学号查公寓号或者公寓号和宿舍号
 * Created by Joki on 2017/6/9.
 */
public class SelectLives {

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    private Apartment apartment = null;
    private Dorm dorm = null;

    /**
     * 查询学生所住楼的楼的信息
     * @param sno
     * @return
     */
    public Apartment selectApart(String sno){
        try {
            String sql = "select apartment.ApartNo,ApartName,ApartLocation,ApartFloor,ApartMax,ApartIn,AdminNO " +
                    "from apartment,apartmanager" +
                    " where apartment.ApartNo=apartmanager.ApartNo and apartment.apartNo=" +
                    "(select apartNo from live where apartment.ApartNo=live.Apartno and sno='"+sno+"')";
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
            apartment = dealApartResult(mStatement.executeQuery(sql));
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apartment;
    }

    private Apartment dealApartResult(ResultSet resultSet) {
        if (resultSet!= null){
            try {
                if (resultSet.next()){
                    apartment = new Apartment(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5),
                            resultSet.getInt(6),
                            resultSet.getString(7));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return apartment;
    }

}
