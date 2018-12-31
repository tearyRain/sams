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
 * <b>action:</b> activitySelectSponsor.action <br>
 * <b>function:</b> 活动选择赞助商 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "activityId" : _activityId
 *     "sponsorId" : _sponsorId
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
 *      "message" : _errorMsg,
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

public class ActivitySelectSponsor extends ActionSupport {
    @Autowired
    private ActivityService activityService;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    @Setter
    private Long activityId;

    @Setter
    private Long sponsorId;

    @Validations()
    @Action(value = "/activitySelectSponsor")
    public String execute() {
        boolean ret = activityService.selectSponsor(activityId, sponsorId);
        if (ret) {
            resultMap.put("data", null);
            resultMap.put("message", "success");
        } else {
            resultMap.put("message", "failure");
        }
        return SUCCESS;
    }
}
