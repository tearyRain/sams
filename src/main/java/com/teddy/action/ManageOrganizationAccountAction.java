package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.entity.Organization;
import com.teddy.service.OrganizationService;
import com.teddy.vo.OrganizationVo;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>action:</b> manageOrganizationAccount.action <br>
 * <b>function:</b> 管理员管理组织账号 <br>
 * <b>progress:</b> finish
 * <h2>call standard:</h2>
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "organizationVo" : &organizationVo
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

public class ManageOrganizationAccountAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Map<String, Object> resultMap = new HashMap<>();

    @Getter
    @Setter
    private OrganizationVo organizationVo;

    @Autowired
    private OrganizationService organizationService;

    @Validations()
    @Action(value = "/manageOrganizationAccount")
    public String execute(){
        boolean result = organizationService.updateInformation(organizationVo);
        if(result == true){
            resultMap.put("message", "success");
            resultMap.put("data", null);
        }
        else{
            resultMap.put("message", "failure");
        }
        return SUCCESS;
    }

}