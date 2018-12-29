package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.service.OrganizationService;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>action:</b> organizationLogin.action <br>
 * <b>function:</b> 组织登录 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "email" : _email,
 *     "password" : _password
 * }
 * </pre>
 * <h3>success call</h3>
 * <pre>
 * {
 *     "message" : "success",
 *     "data" : {
 *         "id" : _id
 *     }
 * }
 * </pre>
 * <h3>failure call</h3>
 * <pre>
 * {
 *      "message" : _errorMsg,
 * }
 * </pre>
 */

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

public class OrganizationLoginAction extends ActionSupport {
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
            resultMap.put("message", "success");
            HashMap<String, Object> data = new HashMap<>();
            data.put("id", id);
            resultMap.put("data", data);
        } else {
            resultMap.put("message", "");
            resultMap.put("data", null);
        }
        return SUCCESS;
    }
}
