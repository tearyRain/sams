package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")

@ParentPackage("json-default")
@Namespace(value = "/")
@Results({@Result(name = "success", type = "json", params = {"root", "resultMap"})})
public class ValidateErrorAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Map<String, Object> resultMap = new HashMap<>();

    @Action(value = "/validateError")
    public String execute(){
        resultMap.put("success", false);
        resultMap.put("errorMsg", getFieldErrors());
        return SUCCESS;
    }
}
