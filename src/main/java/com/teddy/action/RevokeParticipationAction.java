package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.service.StudentService;
import lombok.Getter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>action:</b> revokeParticipation.action <br>
 * <b>function:</b> 学生退出活动参加（不包括志愿者活动） <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "sponsor" : &sponsorVo,
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

public class RevokeParticipationAction extends ActionSupport {
    @Autowired
    private StudentService studentService;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    @Getter
    private Long studentId;

    @Getter
    private Long activityId;

    @Validations()
    @Action(value = "/revokeVolunteer")
    public String execute(){
        boolean ret = studentService.revokeParticipation(studentId, activityId);
        if (ret) {
            resultMap.put("message", "success");
            resultMap.put("data", null);
        } else
            resultMap.put("message", "failure");
        return SUCCESS;
    }
}
