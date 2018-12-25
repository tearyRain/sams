package com.teddy.action;

import com.teddy.entity.Student;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import static com.opensymphony.xwork2.Action.SUCCESS;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value = "/")
@Results({
        @Result(name = "success", location = "/welcome.jsp")
})

public class ManagerStudentAccountAction {
    @Getter
    @Setter
    Student student;

    @Action(value = "managerStudentAccount")

    public String execute(){
        return SUCCESS;
    }

}


