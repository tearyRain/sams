package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.service.AdminService;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * <b>action:</b> adminLogin.action <br>
 * <b>function:</b> 管理员登录 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "adminId" : _adminId,
 *     "password" : _password
 * }
 * </pre>
 * <h3>success call</h3>
 * <pre>
 * {
 *     "message" : "success",
 *     "data" : null
 * }
 * </pre>
 * <h3>failure call</h3>
 * <pre>
 * {
 *      "message" : _errorMsg
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

public class AdminLoginAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Map<String, Object> resultMap = new HashMap<>();

    @Getter
    @Setter
    Long id;

    @Getter
    @Setter
    String password;

    @Autowired
    private AdminService adminService;

    @Validations(requiredFields = {
            @RequiredFieldValidator(fieldName = "id", message = "账号必须填写！")
    }, requiredStrings = {
            @RequiredStringValidator(fieldName="password", message="密码必须填写！")
    })
    @Action(value = "/adminLogin")
    public String execute(){
        boolean checkResult = adminService.checkPassword(id, password);
        if(checkResult == true){
            resultMap.put("message", "success");
            resultMap.put("data", null);
        }
        else{
            resultMap.put("message", "failure");
        }
        return SUCCESS;
    }
}
