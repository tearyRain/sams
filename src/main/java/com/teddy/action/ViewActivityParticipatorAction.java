package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.entity.Activity;
import com.teddy.entity.Attendance;
import com.teddy.entity.Student;
import com.teddy.service.ActivityService;
import com.teddy.vo.StudentVo;
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
 * <b>action:</b> viewActivityParticipator.action <br>
 * <b>function:</b> 查看活动的所有参与者 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "activityId" : _activityId,
 * }
 * </pre>
 * <h3>success call</h3>
 * <pre>
 * {
 *     "message" : "success",
 *     "data" : {
 *         "student" : [... &StudentVo]
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

public class ViewActivityParticipatorAction extends ActionSupport {
    @Getter
    @Setter
    Activity activity;

    @Setter
    Long activityId;
    @Getter
    @Setter
    Student student;
    @Autowired
    private ActivityService activityService;
    @Getter
    @Setter
    private Map<String, Object> resultMap = new HashMap<>();
    private Map<String, Object> data = new HashMap<>();
    @Getter
    @Setter
    Attendance attendance;

    @Validations()
    @Action(value = "/viewActivityParticipator")
    public String execute() {
        List<StudentVo> list = activityService.findActivityParticipator(activityId);
        if (list.size() != 0) {
            resultMap.put("message", "success");
            data.put("student", list);
            resultMap.put("data", data);
        } else {
            resultMap.put("message", "null");
        }
        return SUCCESS;
    }

}