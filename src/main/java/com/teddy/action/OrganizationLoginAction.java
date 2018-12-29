package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.service.OrganizationService;
import com.teddy.util.jsonSpec;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

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

public class OrganizationLoginAction extends ActionSupport implements jsonSpec {
    @Autowired
    private OrganizationService organizationService;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    @Setter
    String email;

    @Setter
    String password;

    @Validations()
    @Action(value = "/organizationLogin")
    public String execute(){
        Long id = organizationService.login(email, password);
        if (id != null) {
            resultMap.put(JSON_SUCCESS, true);
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", id);
            resultMap.put(JSON_DATA, data);
        } else {
            resultMap.put(JSON_ERROR, true);
            resultMap.put(JSON_MESSAGE, "");
        }
        return SUCCESS;
    }
}
