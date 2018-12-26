package com.teddy.test;

import com.opensymphony.xwork2.ActionProxy;
import com.teddy.action.StudentLoginAction;
import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class StudentLoginActionTest extends StrutsSpringJUnit4TestCase {
    @Test
    public void testLogin() throws Exception {
        request.setContent("{\"id\" : \"8989\"}".getBytes());
        request.setContentType("application/json");
        ActionProxy actionProxy = getActionProxy("studentLogin.action");
        assertNotNull(actionProxy);
        StudentLoginAction action = (StudentLoginAction) actionProxy.getAction();
        assertNotNull(action);
        actionProxy.execute();
        System.out.println(response.getContentAsString());
    }
}
