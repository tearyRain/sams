package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.teddy.service.StudentService;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;


/**
 * <b>action:</b> studentLogin.action <br>
 * <b>function:</b> 学生登录 <br>
 * <b>progress:</b> finish
 * <h2> call standard: </h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "studentId" : _studentId,
 *     "password" :_password
 * }
 * </pre>
 * <h3>success call</h3>
 * <pre>
 * {
 *     "message" : "success",
 *     "data" : {
 *         "id" : _id
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
public class StudentLoginAction extends ActionSupport {

    @Autowired
    private StudentService studentService;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    private Map<String, Object> data = new HashMap<>();

    @Setter
    Long studentId;

    @Setter
    String password;

    @Action(value = "/studentLogin")
    public String execute(){
        boolean checkResult = studentService.checkPassword(studentId, password);
        if (checkResult) {
            resultMap.put("message", "success");
            data.put("id", studentId);
            resultMap.put("data", data);
        } else {
            resultMap.put("message", "failure");
        }
        return SUCCESS;
    }
}
