/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.traccar.database;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;


public class LogReportQueries {
    public static DataSource dataSource;
    public static int insert(int uniqueid)throws SQLException{
        Connection con=dataSource.getConnection();
        
        return 1;
    }
}
