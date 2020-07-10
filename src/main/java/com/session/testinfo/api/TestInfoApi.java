package com.session.testinfo.api;


import com.session.testinfo.model.Request;
import com.session.testinfo.model.SessionInfo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ApiOperation(value = "TestInfo Details of Students ", tags = "TestInfo Controller")
@SwaggerDefinition(
        consumes = {"application/json"},
        produces = {"application/json"}
)
@RequestMapping(value = "/session")
public interface TestInfoApi {

    @PostMapping(value = "/getSessionInfo")
    @ApiOperation(value = "Gets All test Sessions by start time ", notes = "Based on Given Date and start Time it returns" +
            " all the TestSessions of that particular date")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "not found!!!")})
    public List<SessionInfo> getSessionInfoByDateAndTime(@RequestBody Request request);

    @GetMapping(value = "/getAllSessionsInfo")
    @ApiOperation(value = "Gets All sessionsInfo ", notes = "Returns All  sessionInfo the DB")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "not found!!!")})
    public List<SessionInfo> getAllSessionInfo();

    @PostMapping(value = "/create")
    @ApiOperation(value = "create SessionInfo ",
            notes = " Create TestInformation for Each ClassRoom based on session")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "not found!!!")})
    public SessionInfo createSession(@RequestBody SessionInfo sessionInfo);

}
