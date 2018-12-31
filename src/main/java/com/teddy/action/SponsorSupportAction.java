package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.service.SupportService;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>action:</b> sponsorSupport.action <br>
 * <b>function:</b> 赞助商请求赞助活动 <br>
 * <b>progress:</b> finish
 * <h2> call standard: </h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "sponsorId" : _sponsorId,
 *     "activityId" : _activityId
 *     "description" : _description
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

public class SponsorSupportAction extends ActionSupport {
    @Autowired
    SupportService supportService;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    @Setter
    Long sponsorId;

    @Setter
    Long activityId;

    @Setter
    String description;


    @Validations()
    @Action(value = "/sponsorSupport")
    public String execute(){
        boolean result = supportService.applySupport(sponsorId, activityId, description);
        if(result){
            resultMap.put("message", "success");
            resultMap.put("data", null);
        } else {
            resultMap.put("message", "failure");
        }
        return SUCCESS;
    }

}