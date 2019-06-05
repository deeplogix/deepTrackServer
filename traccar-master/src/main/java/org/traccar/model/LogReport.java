/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.traccar.model;

import java.sql.Date;


public class LogReport {
    long user_id;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
    
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
    
    Date logged_date;

    public Date getLogged_date() {
        return logged_date;
    }

    public void setLogged_date(Date logged_date) {
        this.logged_date = logged_date;
    }
    
}
