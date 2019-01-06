package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.service.AttendanceService;
import com.teddy.service.StudentService;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>action:</b> applyActivity.action <br>
 * <b>function:</b> 学生申请参与活动（不作为志愿者） <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "studentId" : _studentId
 *     "activityId" : _activityId
 * }
 * </pre>
 * <h3>success call</h3>
 * <pre>
 * {
 *     "message" : "success",
 *     "data" : null
 * }
 * </pre>
 * <h3>failure call</h3>
 * <pre>
 * {
 *      "message" : _errorMsg
 * }
 * </pre>
 */

@Controller
@Scope("prototype")

@ParentPackage("struts-default")
@Namespace(value = "/templates")
@Results({@Result(name = "success", type = "dispatcher", location = "student/applyActivity.jsp"),
        @Result(name = "input", type = "dispatcher", location = "student/applyActivity.jsp")})

public class ApplyActivityAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    @Setter
    Long studentId;

    @Setter
    Long activityId;

    @Autowired
    private AttendanceService attendanceService;

    @Validations()
    @Action(value = "/applyActivity")
    public String execute(){
        boolean result = attendanceService.applyParticipation(studentId, activityId, true);
        if(result == true){
            resultMap.put("message", "success");
            resultMap.put("data", null);
        }
        else{
            resultMap.put("message", "failure");
        }
        return SUCCESS;
    }
}
