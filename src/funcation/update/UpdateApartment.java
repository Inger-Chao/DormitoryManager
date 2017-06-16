package funcation.update;

import base.DBService;
import model.Apartment;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by lenovo on 2017/6/14.
 */
public class UpdateApartment {


    private DBService mDBMS = new DBService().getInstance();
    private Statement mStatement = null;

    public UpdateApartment(){
        try {
            mDBMS.connect();
            mStatement = mDBMS.getStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  int update(Apartment oldApartment, Apartment newApartment){
        int result_code = 0;
        try {

            String sql ="UPDATE apartmanager,apartment\n"+
                    "SET apartment.ApartNo='"+newApartment.getNo()+"',ApartName='"+newApartment.getName()+"',ApartLocation='"+
                    newApartment.getLocation()+ "',ApartFloor="+newApartment.getFloor()+",ApartMax="+newApartment.getMax()+
                    ",ApartIn="+ newApartment.getIn()+",apartmanager.AdminNo='"+newApartment.getManagerNo()+"'\n"+
                    "WHERE apartmanager.ApartNo=apartment.ApartNo\n"+
                    "AND apartment.ApartNo='" +oldApartment.getNo()+"'";

            mStatement.execute(sql);
            mDBMS.close();
        } catch (SQLException e) {
            result_code = -1;
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result_code;
    }
}
