package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.entity.Activity;
import com.teddy.entity.CheckStatus;
import com.teddy.entity.Support;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

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

public class OrganizationSeeSponsorAction extends ActionSupport {
    @Getter
    @Setter
    Activity activity;

    @Getter
    @Setter
    CheckStatus checkStatus;

    @Getter
    @Setter
    Support support;

    @Validations()
    @Action(value = "/organizationSeeSponsor")
    public String execute(){
        return SUCCESS;
    }

}