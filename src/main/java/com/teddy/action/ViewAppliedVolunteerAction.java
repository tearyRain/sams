package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.entity.Activity;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>action:</b> viewAppliedVolunteer.action <br>
 * <b>function:</b> 查看学生已参加的所有志愿者活动，分页查询 <br>
 * <b>progress:</b> todo
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
    @Getter
    @Setter
    private Map<String, Object> resultMap = new HashMap<>();

    @Validations()
    @Action(value = "/viewAppliedVolunteer")
    public String execute() {
        return SUCCESS;
    }

}
