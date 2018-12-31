package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.service.ActivityService;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>action:</b> verifyActivity.action <br>
 * <b>function:</b> 管理员审核活动 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "activityId" : _activityId
 *     "pass" : _pass
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

public class VerifyActivityAction extends ActionSupport {

    @Autowired
    private ActivityService activityService;
    @Setter
    boolean pass;
    @Setter
    Long activityId;
    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    private Map<String, Object> data = new HashMap<>();
    @Validations()
    @Action(value = "/verifyActivity")
    public String execute(){
        boolean checkResult = activityService.checkActivity(activityId, pass);
        if (checkResult) {
            resultMap.put("message", "success");
            resultMap.put("data", null);
        } else {
            resultMap.put("message", "null");
        }
        return SUCCESS;
    }

}