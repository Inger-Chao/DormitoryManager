package funcation.select;

import model.Apartment;
import base.DBService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * Created by Joki on 2017/6/9.
 */
public class SelectApartments {

    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    private Vector<Apartment> apartments = new Vector<>();

    private Apartment apartment = null;

    public SelectApartments(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Vector<Apartment> searchAll()  {
        String sql = "select apartment.ApartNo,ApartName,ApartLocation,ApartFloor,ApartMax,ApartIn,AdminNO " +
                "from apartment,apartmanager where apartment.ApartNo=apartmanager.ApartNo";
        try {
            apartments=dealResultSet(mStatement.executeQuery(sql));
            mDBMS.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return apartments;
    }

    public Vector<Apartment> dealResultSet(ResultSet resultSet){
        if (resultSet != null){
            try {
                while (resultSet.next()){
                    apartments.add(new Apartment(resultSet.getString(1),
                                    resultSet.getString(2),
                                    resultSet.getString(3),
                                    resultSet.getInt(4),
                                    resultSet.getInt(5),
                                    resultSet.getInt(6),
                                    resultSet.getString(7))
                            );
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return apartments;
    }

    public Vector<Apartment> search(String no){
        String sql = "select apartment.ApartNo,ApartName,ApartLocation,ApartFloor,ApartMax,ApartIn,adminNO " +
                "from apartment,apartmanager where apartment.ApartNo=apartmanager.ApartNo and apartment.ApartNo LIKE'" + no + "%'";
        try {
            apartments = dealResult(mStatement.executeQuery(sql));
            mDBMS.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apartments;
    }

    private Vector<Apartment> dealResult(ResultSet resultSet)  {
        if (resultSet != null){
            try {
                while (resultSet.next()){
                    apartments.add(new Apartment(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getInt(5),
                            resultSet.getInt(6),
                            resultSet.getString(7)) );
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return apartments;
    }

}
