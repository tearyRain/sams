package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.entity.Activity;
import com.teddy.service.ActivityService;
import com.teddy.vo.ActivityVo;
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
 * <b>action:</b> viewAppliedVolunteer.action <br>
 * <b>function:</b> 查看学生已参加的所有志愿者活动，分页查询 <br>
 * <b>progress:</b> finish
 * <h2> call standard: </h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "pageNo" : _pageNo,
 *     "pageSize" : _pageSize,
 *     "studentId" : _studentId
 * }
 * </pre>
 * <h3>success call</h3>
 * <pre>
 * {
 *     "message" : "success",
 *     "data" : {
 *         "activity" : [ ... &activityVo]
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

public class ViewAppliedVolunteerAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    Activity activity;


    @Setter
    Long studentId;

    @Getter
    @Setter
    private Map<String, Object> resultMap = new HashMap<>();
    @Setter
    Long pageSize;
    @Setter
    Long pageNo;
    @Autowired
    private ActivityService activityService;
    private Map<String, Object> data = new HashMap<>();

    @Validations()
    @Action(value = "/viewAppliedVolunteer")
    public String execute() {
        List<ActivityVo> list = activityService.findAppliedVolunteer(pageNo, pageSize, studentId);
        if (list.size() != 0) {
            resultMap.put("message", "success");
            data.put("activity", list);
            resultMap.put("data", data);
        } else {
            resultMap.put("message", "null");
        }
        return SUCCESS;
    }

}
