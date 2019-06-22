/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.traccar.database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 * Create logs in database for errors associated with unique identifier
*/
public class LogReportQueries {
    public static DataSource dataSource;
    
    /**
     * Create logs of error in database
     * @param Identifier Each device has a specific identifier
     * @param Log_type Type for  Log creation
     * @param Log_message Message with respect to log type 
     * @return Integer Non zero if successfully added
    */
    public static int createLog(String uniqueid,String log_type,String log_message)throws SQLException{
            Connection con=dataSource.getConnection();
            String query1="select userid from tc_user_device where deviceid in (select id from tc_devices where uniqueid=?)";
            PreparedStatement preparedStatement=con.prepareStatement(query1);
            preparedStatement.setString(1, uniqueid);
            ResultSet rs=preparedStatement.executeQuery();
            int userid=0;
        if(rs.next()){
            userid=rs.getInt(1);
         }
            String query2="insert into logreport(log_type,log_message,userid) values(?,?,?)";
            preparedStatement=con.prepareStatement(query2);
            preparedStatement.setString(1, log_type);
            preparedStatement.setString(2, log_message);
            preparedStatement.setInt(3, userid);
            int i=0;
            i=preparedStatement.executeUpdate();
            con.close();
        if(i>0){
            return i;
        }else{
            return 0;
        }
    }
}
