package com.teddy.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;

import java.util.Map;

@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/templates")
@Results({@Result(name = "success", type = "redirect", location = "/templates/login.html")})
public class StudentLogoutAction extends ActionSupport {

    @Action(value = "studentLogout")
    public String execute(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.remove("studentId");
        return SUCCESS;
    }

}
