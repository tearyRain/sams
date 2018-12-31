package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.entity.Activity;
import com.teddy.entity.Attendance;
import com.teddy.service.AttendanceService;
import com.teddy.vo.OrganizationVo;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>action:</b> applyVolunteer.action <br>
 * <b>function:</b> 学生申请作为志愿者参与活动 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "studentId" : _studentId,
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

@ParentPackage("json-default")
@Namespace(value = "/")
@Results({@Result(name = "success", type = "chain", params = {"root", "resultMap"}),
        @Result(name = "input", type = "chain", params = {"actionName", "validateError"})})
@InterceptorRefs(value = {
        @InterceptorRef("json"),
        @InterceptorRef("defaultStack")
})

public class ApplyVolunteerAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Map<String, Object> resultMap = new HashMap<>();

    @Getter
    @Setter
    Long studentId;

    @Getter
    @Setter
    Long activityId;

    @Autowired
    private AttendanceService attendanceService;

    @Validations()
    @Action(value = "/applyVolunteer")
    public String execute(){
        boolean result = attendanceService.applyParticipation(studentId, activityId, false);
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
