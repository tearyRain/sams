package com.teddy.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.teddy.entity.Organization;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * <b>action:</b> organizationChangePassword.action <br>
 * <b>function:</b> 组织修改密码 <br>
 * <b>progress:</b> todo
 * call standard:
 * <h3>how to call</h3>
 * <pre>
 * {
 *     "studentId" : _organizationId,
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

public class OrganizationChangePasswordAction extends ActionSupport {
    @Getter
    @Setter
    Organization organization;

    @Validations()
    @Action(value = "/organizationChangePassword")
    public String execute(){
        return SUCCESS;
    }

}