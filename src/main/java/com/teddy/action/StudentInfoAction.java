package com.teddy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;

import com.teddy.service.StudentService;
import com.teddy.vo.StudentVo;

import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.util.Map;

@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/templates")
@Results({@Result(name = "success", type = "dispatcher", location = "/templates/studentInfo.jsp"),
        @Result(name = "input", type = "dispatcher", location = "/templates/studentInfo.jsp")})

public class StudentInfoAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Autowired
    private StudentService studentService;

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String phone;

    @Getter @Setter
    private LocalDate enrollmentDate;

    @Getter @Setter
    private LocalDate birthday;

    @Getter @Setter
    private String gender;

    @Action(value = "studentInfo")
    public String execute(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        Long id = (Long)session.get("studentId");
        if (id == null) {
            return INPUT;
        }
        StudentVo studentVo = studentService.findById(id);
        if (studentVo == null) return INPUT;
        name = studentVo.getName();
        phone = studentVo.getPhone();
        enrollmentDate = studentVo.getEnrollmentDate();
        birthday = studentVo.getBirthday();
        gender = (studentVo.getGender().isFemale() ? "女" : "男");
        return  SUCCESS;
    }
}