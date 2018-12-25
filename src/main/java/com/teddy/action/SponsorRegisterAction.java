package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.teddy.entity.ContactInfo;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

import static com.opensymphony.xwork2.Action.SUCCESS;

@Controller
@Scope("prototype")

@ParentPackage("json-default")
@Namespace(value = "/")
@Results({@Result(name = "success", type = "json", params = {"root", "resultMap"})})
@InterceptorRef(value = "json")

public class SponsorRegisterAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Map<String, Object> resultMap = new HashMap<>();

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    String password;

    @Getter
    @Setter
    String email;

    @Getter
    @Setter
    ContactInfo contact;

    @Getter
    @Setter
    String address;

    @Getter
    @Setter
    String description;

    @Action(value = "sponsorRegister")
    public String execute(){
        return SUCCESS;
    }

}
