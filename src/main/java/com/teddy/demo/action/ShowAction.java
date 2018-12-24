package com.teddy.demo.action;

import com.opensymphony.xwork2.ActionSupport;
import com.teddy.demo.entity.Person;
import com.teddy.demo.service.ShowService;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * ShowAction
 */
// @Result param includeProperties, excludeProperties, root
// help file = https://blog.csdn.net/qq_36295256/article/details/76915438
// help file = https://blog.csdn.net/gxy1317/article/details/52409360
// help file = https://www.dubby.cn/detail.html?id=9070 jackson
@Controller
@Scope("prototype")

@ParentPackage("json-default")
@Namespace(value = "/")
@Results({@Result(name = "success", type = "json", params = {"root", "resultMap"})})
@InterceptorRef(value = "json")
public class ShowAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    @Getter
    private Map<String, Object> resultMap = new HashMap<>();

    @Setter
    private Person person;
    @Setter
    private Long age;

    @Autowired
    private ShowService showService;

    @Action(value = "/add")
    public String execute() {
        if (age != null) {
            person.setAge(showService.yourAge());
        }
        resultMap.put("person", person);
        age += 1;
        resultMap.put("status", true);
        resultMap.put("age", age);
        return SUCCESS;
    }
}