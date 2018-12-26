package com.teddy.test;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class ValidateTest extends StrutsSpringJUnit4TestCase {
    @Test
    public void testValidate() throws Exception{
        request.setContentType("application/json");
        request.setContent("{\"password\" : \"aa\", \"id\" : 123 }".getBytes());
        String res = executeAction("adminLogin.action");
        System.out.println(res);
    }
}
