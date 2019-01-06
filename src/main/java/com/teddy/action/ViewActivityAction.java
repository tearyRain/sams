package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.entity.Organization;
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
 * <b>action:</b> viewActivity.action <br>
 * <b>function:</b> 查看所有活动，分页查询 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "pageNo" : _pageNo,
 *     "pageSize" : _pageSize
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

@ParentPackage("struts-default")
@Namespace(value = "/templates")
@Results({@Result(name = "success", type = "dispatcher", location = "/templates/showAllActivity.jsp"),
        @Result(name = "input", type = "dispatcher", location = "/templates/    showAllActivity.jsp")})

public class ViewActivityAction extends ActionSupport {

    @Getter
    @Setter
    Organization organization;
    @Autowired
    private ActivityService activityService;
    @Getter
    private Map<String, Object> resultMap = new HashMap<>();
    private Map<String, Object> data = new HashMap<>();
    @Getter
    @Setter
    List<ActivityVo> list;

    @Validations()
    @Action(value = "viewActivity")
    public String execute() {
        list = activityService.viewActivity(1, 50000);
        resultMap.put("message", "success");
        data.put("activity", list);
        resultMap.put("data", data);
        return SUCCESS;
    }
}
