package com.teddy.demo.action;


import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;


@Controller
@Scope("prototype")

@ParentPackage("json-default")
@Namespace(value = "/")
@Results({@Result(name = "success", type = "json", params = {"root", "resultMap"})})
@InterceptorRefs(value = {
        @InterceptorRef("defaultStack")
})
public class AddAction extends ActionSupport {
    Map<String, Object> resultMap;

    @Action("/sh")
    public String execute() {
        resultMap.put("success", false);
        return SUCCESS;
    }
}
