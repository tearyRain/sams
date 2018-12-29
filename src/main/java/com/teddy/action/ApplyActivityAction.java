package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>action:</b> applyActivity.action <br>
 * <b>function:</b> 学生申请参与活动（不作为志愿者） <br>
 * <b>progress:</b> todo
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

@ParentPackage("json-default")
@Namespace(value = "/")
@Results({@Result(name = "success", type = "chain", params = {"root", "resultMap"}),
        @Result(name = "input", type = "chain", params = {"actionName", "validateError"})})
@InterceptorRefs(value = {
        @InterceptorRef("json"),
        @InterceptorRef("defaultStack")
})

public class ApplyActivityAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    @Setter
    Long activityId;

    @Setter
    Long organizationId;

    @Validations()
    @Action(value = "/applyActivity")
    public String execute(){

        return SUCCESS;
    }
}
