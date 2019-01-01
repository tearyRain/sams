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
 * <b>action:</b> sponsorChangeInformation.action <br>
 * <b>function:</b> 赞助商修改信息 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "sponsor" : &sponsorVo
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

public class SponsorChangeInformationAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    @Getter
    @Setter
    SponsorVo sponsorVo;

    @Autowired
    SponsorService sponsorService;

    @Validations()
    @Action(value = "/sponsorChangeInformation")
    public String execute(){
        boolean result = sponsorService.changeInformation(sponsorVo);
        if(result){
            resultMap.put("message", "success");
            resultMap.put("data", null);
        }
        else
            resultMap.put("message", "failure");
        return SUCCESS;
    }

}