/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.traccar.model;

import java.util.Date;


public class LogReport extends ExtendedModel{ 
    String log_type;

    public String getLog_type() {
        return log_type;
    }

    public void setLog_type(String log_type) {
        this.log_type = log_type;
    }
    
    String log_message;

    public String getLog_message() {
        return log_message;
    }

    public void setLog_message(String log_message) {
        this.log_message = log_message;
    }
    
    Date created_at =new Date();

    public Date getLogged_date() {
        return created_at;
    }

    public void setLogged_date(Date logged_date) {
        this.created_at = logged_date;
    }
    
}
