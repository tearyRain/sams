package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.service.SponsorService;
import com.teddy.vo.SponsorVo;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>action:</b> sponsorRegister.action <br>
 * <b>function:</b> 赞助商注册 <br>
 * <b>progress:</b> finish
 * <h2> call standard: </h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "sponsor" : &sponsorVo,
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

public class SponsorRegisterAction extends ActionSupport {

    @Autowired
    SponsorService sponsorService;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();
    @Setter
    SponsorVo sponsor;
    private Map<String, Object> data = new HashMap<>();

    @Validations()
    @Action(value = "/sponsorRegister")
    public String execute(){
        Long id = sponsorService.register(sponsor);
        if (id != null) {
            resultMap.put("message", "success");
            data.put("id", id);
            resultMap.put("data", data);
        } else {
            resultMap.put("message", "failure");
        }
        return SUCCESS;
    }

}
