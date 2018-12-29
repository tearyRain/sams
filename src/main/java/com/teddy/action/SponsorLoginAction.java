package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.service.SponsorService;
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

public class SponsorLoginAction extends ActionSupport implements jsonSpec {
    private static final long serialVersionUID = 1L;
    @Autowired
    private SponsorService sponsorService;

    @Getter
    @Setter
    private Map<String, Object> resultMap = new HashMap<>();

    @Getter
    @Setter
    String email;

    @Getter
    @Setter
    String password;

    @Validations()
    @Action(value = "/sponsorLogin")
    public String execute(){
        Long id = sponsorService.login(email, password);
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
