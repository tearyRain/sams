package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.entity.Activity;
import com.teddy.entity.CheckStatus;
import com.teddy.entity.Support;
import com.teddy.service.ActivityService;
import com.teddy.vo.SponsorVo;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <b>action:</b> viewActivitySponsor.action <br>
 * <b>function:</b> 查看活动的所有赞助商 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "activityId" : _activityId
 * }
 * </pre>
 * <h3>success call</h3>
 * <pre>
 * {
 *     "message" : "success",
 *     "data" : [ ... &SponsorVo ]
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

public class ViewActivitySponsorAction extends ActionSupport {
    @Getter
    @Setter
    Activity activity;

    @Setter
    Long activityId;
    @Getter
    @Setter
    CheckStatus checkStatus;
    @Autowired
    private ActivityService activityService;
    @Getter
    @Setter
    private Map<String, Object> resultMap = new HashMap<>();
    private Map<String, Object> data = new HashMap<>();
    @Getter
    @Setter
    Support support;

    @Validations()
    @Action(value = "/viewActivitySponsor")
    public String execute() {
        List<SponsorVo> list = activityService.findActivitySponsor(activityId);
        if (list.size() != 0) {
            resultMap.put("message", "success");
            data.put("SponsorVo", list);
            resultMap.put("data", data);
        } else {
            resultMap.put("message", "null");
        }
        return SUCCESS;
    }

}