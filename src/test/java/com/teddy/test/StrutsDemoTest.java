package com.teddy.test;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// https://struts.apache.org/plugins/junit/
// https://blog.csdn.net/z69183787/article/details/38893331

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class StrutsDemoTest extends StrutsSpringJUnit4TestCase {

    @Test
    public void testDemo() throws Exception {
        request.setContentType("application/json");
        request.setContent("{ \"age\" : 12, \"person\": { \"age\" : 78, \"name\" : \"yao\"}}".getBytes());
        String res = executeAction("add.action");
        String responseContent = response.getContentAsString();
        System.out.println(res);
    }
}
