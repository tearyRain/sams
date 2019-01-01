package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.service.SponsorService;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>action:</b> sponsorLogin.action <br>
 * <b>function:</b> 赞助商登录 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "email" : _email,
 *     "password": _password
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

public class SponsorLoginAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    @Autowired
    private SponsorService sponsorService;

    @Getter
    @Setter
    private Map<String, Object> resultMap = new HashMap<>();

    private Map<String, Object> data = new HashMap<>();

    @Getter
    @Setter
    String email;

    @Getter
    @Setter
    String password;

    @Validations()
    @Action(value = "/sponsorLogin")
    public String execute(){
        Long sponsorId = sponsorService.login(email, password);
        if(sponsorId == null)
            resultMap.put("message", "failure");
        else{
            resultMap.put("message", "success");
            data.put("id", sponsorId);
            resultMap.put("data", data);
        }
        return SUCCESS;
    }

}
