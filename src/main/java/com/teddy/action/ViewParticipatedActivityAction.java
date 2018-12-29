package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
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
 * <b>action:</b> viewParticipatedActivity.action <br>
 * <b>function:</b> 查询学生所参与的所有活动 <br>
 * <b>progress:</b> finish
 * call standard:
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "studentId" : _studentId
 * }
 * </pre>
 * <h3>success call</h3>
 * <pre>
 * {
 *     "message" : "success",
 *     "data" : [ ... &activityVo ]
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

public class ViewParticipatedActivityAction extends ActionSupport {

    @Autowired
    private StudentService studentService;

    @Setter
    Long studentId;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    @Validations()
    @Action(value = "/viewParticipatedActivity")
    public String execute(){
        resultMap.put("message", "success");
        resultMap.put("data", studentService.findParticipatedActivity(studentId));
        return SUCCESS;
    }
}
