package com.teddy.test;

import com.opensymphony.xwork2.ActionProxy;
import com.teddy.action.AdminLoginAction;
import com.teddy.action.StudentLoginAction;
import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class AdminLoginActionTest extends StrutsSpringJUnit4TestCase {
    @Test
    public void test() throws Exception{
        request.setContent("{\"admin\" : \"admin\"}".getBytes());
        request.setContentType("application/json");
        ActionProxy actionProxy = getActionProxy("adminLogin.action");
        assertNotNull(actionProxy);
        AdminLoginAction action = (AdminLoginAction) actionProxy.getAction();
        assertNotNull(action);
        actionProxy.execute();
        System.out.println(response.getContentAsString());
    }
}
