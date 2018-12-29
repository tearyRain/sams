package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.service.StudentService;
import com.teddy.util.jsonSpec;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;


/**
 * success output
 * {
 * success: true,
 * data:{
 * activities: [  #activityVo* ]
 * }
 * }
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

public class ViewParticipatedActivityAction extends ActionSupport implements jsonSpec {

    @Setter
    Long studentId;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();
    @Autowired
    private StudentService studentService;

    @Validations()
    @Action(value = "/viewParticipatedActivity")
    public String execute(){
        resultMap.put(JSON_SUCCESS, "true");
        resultMap.put(JSON_DATA, studentService.findParticipatedActivity(studentId));
        return SUCCESS;
    }

}
