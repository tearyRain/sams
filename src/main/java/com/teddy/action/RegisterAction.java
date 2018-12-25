package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace(value = "/")
@Results({
        @Result(name = "success", location = "/welcome.jsp")
})

public class RegisterAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Getter @Setter
    String username;

    @Getter @Setter
    String password;

    @Action(value = "registerMy")
    public String execute() {
        return SUCCESS;
    }

}
