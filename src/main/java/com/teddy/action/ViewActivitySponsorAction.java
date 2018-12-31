package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
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
 *     "data" : {
 *         "sponsor" : [ ... &SponsorVo ]
 *     }
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
    @Autowired
    private ActivityService activityService;
    @Setter
    Long activityId;
    @Getter
    private Map<String, Object> resultMap = new HashMap<>();
    private Map<String, Object> data = new HashMap<>();

    @Validations()
    @Action(value = "/viewActivitySponsor")
    public String execute() {
        List<SponsorVo> list = activityService.findActivitySponsor(activityId);
        if (list.size() != 0) {
            resultMap.put("message", "success");
            data.put("sponsor", list);
            resultMap.put("data", data);
        } else {
            resultMap.put("message", "failure");
        }
        return SUCCESS;
    }

}