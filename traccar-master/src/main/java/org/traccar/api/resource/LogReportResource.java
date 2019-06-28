/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.traccar.api.resource;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.traccar.api.BaseResource;
import org.traccar.database.LogReportQueries;
import org.traccar.model.LogReport;

/**
 *
 * @author Deeplogix
 */
@Path("logs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LogReportResource extends BaseResource {
    @GET
    public List<LogReport> get(@QueryParam("userId") long userId) throws SQLException {
        return LogReportQueries.getLogsByUserId((int) userId);
    }
}
