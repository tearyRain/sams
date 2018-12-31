package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.service.OrganizationService;
import com.teddy.vo.ActivityVo;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>action:</b> organizationReleaseActivity.action <br>
 * <b>function:</b> 组织发布活动 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "organizationId" : _organizationId
 *     "Activity" : &activityVo
 * }
 * </pre>
 * <h3>success call</h3>
 * <pre>
 * {
 *     "message" : "success",
 *     "data" : {
 *         "activityId" : _activityId;
 *     }
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

public class OrganizationReleaseActivityAction extends ActionSupport {
    @Autowired
    private OrganizationService organizationService;

    private Map<String, Object> data = new HashMap<>();

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    @Setter
    private ActivityVo activity;

    @Setter
    private Long organizationId;

    @Validations()
    @Action(value = "/organizationReleaseActivity")
    public String execute(){
        Long id = organizationService.releaseActivity(activity);
        if (id != null) {
            resultMap.put("message", "success");
            data.put("activity", id);
            resultMap.put("data", data);
        } else {
            resultMap.put("message", "failure");
        }
        return SUCCESS;
    }

}