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

import java.util.HashMap;
import java.util.Map;

/**
 * <b>action:</b> sponsorChangePassword.action <br>
 * <b>function:</b> 赞助商修改密码 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "sponsorId" : _sponsorId,
 *     "password": _password
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

public class SponsorChangePasswordAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    @Getter
    @Setter
    Long sponsorId;

    @Getter
    @Setter
    String password;

    @Autowired
    SponsorService sponsorService;

    @Validations()
    @Action(value = "/sponsorChangePassword")
    public String execute(){
        boolean result = sponsorService.changePassword(sponsorId, password);
        if(result){
            resultMap.put("message", "success");
            resultMap.put("data", null);
        }
        else
            resultMap.put("message", "failure");
        return SUCCESS;
    }

}