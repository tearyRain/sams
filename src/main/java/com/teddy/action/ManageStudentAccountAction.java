package com.teddy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.entity.Gender;
import com.teddy.entity.Student;
import com.teddy.service.StudentService;
import com.teddy.vo.StudentVo;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/templates")
@Results({@Result(name = "success", type = "redirectAction", params = {"actionName", "studentInfo"}),
        @Result(name = "input", type = "redirectAction", params = {"actionName", "studentInfo"})})

public class ManageStudentAccountAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Setter @Getter
    private String phone;

    @Autowired
    private StudentService studentService;

    @Validations()
    @Action(value = "manageStudentAccount")
    public String execute(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        Long id = (Long)session.get("studentId");
        if (id != null && studentService.updatePhone(id, phone)) {
            return SUCCESS;
        }
        return INPUT;
    }

}


