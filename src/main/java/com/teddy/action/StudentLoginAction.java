package com.teddy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.teddy.service.StudentService;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
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
 */

@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/templates")
@Results({@Result(name = "success", type = "redirectAction", params = {"actionName", "viewActivity", "namespace", "/templates"}),
        @Result(name = "input", type = "dispatcher", location = "/templates/login.html")})
public class StudentLoginAction extends ActionSupport {

    @Autowired
    private StudentService studentService;

    @Setter @Getter
    Long studentId;

    @Setter @Getter
    String password;

    @Action(value = "studentLogin")
    public String execute(){
        boolean checkResult = studentService.checkPassword(studentId, password);
        if (checkResult){
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("studentId", studentId);
           return SUCCESS;
        }
        return INPUT;
    }
}
