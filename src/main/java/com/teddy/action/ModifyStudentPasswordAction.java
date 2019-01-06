package com.teddy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.entity.Student;
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
 * <b>action:</b> modifyStudentPassword.action <br>
 * <b>function:</b> 学生修改密码 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "studentId" : _studentId
 *     "password" : _password
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

@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/templates")
@Results({@Result(name = "success", type = "dispatcher", location = "/templates/studentAccount.jsp"),
        @Result(name = "input", type = "dispatcher", location = "/templates/studentAccount.jsp")})
public class ModifyStudentPasswordAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String originPassword;

    @Getter
    @Setter
    private String newPassword;

    @Getter
    @Setter
    private String repeatedNewPassword;

    @Autowired
    StudentService studentService;

    @Getter
    @Setter
    Boolean notFirst = true;

    @Getter
    @Setter
    Boolean oldWrong;

    @Getter
    @Setter
    Boolean notSame;

    @Getter
    @Setter
    Boolean modifySuccess;

    @Validations()
    @Action(value = "/modifyStudentPassword")
    public String execute(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        Long studentId = (Long)session.get("studentId");
        if(studentService.checkPassword(studentId, originPassword)){
            oldWrong = false;
        }
        else{
            oldWrong = true;
        }

        if(newPassword.equals(repeatedNewPassword)){
            notSame = false;
        }
        else{
            notSame = true;
        }

        if(oldWrong == false && notSame == false){
            boolean result = studentService.modifyPassword(studentId, newPassword);
            if (result){
                modifySuccess = true;
            } else{
                modifySuccess = false;
            }
        }
        else
            modifySuccess = false;

        return SUCCESS;
    }
}
