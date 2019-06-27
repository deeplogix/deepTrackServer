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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.traccar.model.LogReport;

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
    
    /**
     * Get logs present in database
     * @param UserId Unique id associated to user
     * @return List<LogReport> List of log report 
    */
    public static List<LogReport> getLogsByUserId(int userid) throws SQLException{
            List<LogReport> logReports = new ArrayList<>();
            Connection con = dataSource.getConnection();
            String getQuery = "select * from logreport where userid=?";
            PreparedStatement preparedStatement = con.prepareStatement(getQuery);
            preparedStatement.setInt(1, userid);
            ResultSet resultSet = preparedStatement.executeQuery();
             if(resultSet.next()){
                 do{
                     LogReport logReport =  new LogReport();
                     logReport.setId(resultSet.getInt(1));
                     logReport.setLog_message(resultSet.getString(2));
                     logReport.setLog_type(resultSet.getString(3));
                     logReport.setLogged_date(new Date(resultSet.getTimestamp(4).getTime()));
                     logReports.add(logReport);
                 }while(resultSet.next());
     }
     return logReports;
    }
}
