package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.teddy.service.StudentService;
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
public class StudentLoginAction extends ActionSupport implements jsonSpec {
    private static final long serialVersionUID = 1L;

    @Autowired
    private StudentService studentService;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    @Setter
    Long id;

    @Getter
    String password;

    @Action(value = "/studentLogin")
    public String execute(){
        boolean checkResult = studentService.checkPassword(id, password);
        if (checkResult) {
            resultMap.put(JSON_SUCCESS, true);
            resultMap.put(JSON_DATA, null);
        } else {
            resultMap.put(JSON_ERROR, true);
            resultMap.put(JSON_MESSAGE, "登录失败");
        }
        return SUCCESS;
    }
}
