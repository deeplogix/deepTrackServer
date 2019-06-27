/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.traccar.database;

import org.traccar.model.LogReport;

/**
 *
 * @author Deeplogix
 */
public class LogReportManager extends SimpleObjectManager{
    
    public LogReportManager(DataManager dataManager) {
        super(dataManager, LogReport.class);
    }
}
