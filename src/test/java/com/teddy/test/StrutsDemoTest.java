package com.teddy.test;

import com.teddy.demo.service.ShowService;
import org.apache.struts2.StrutsSpringTestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// https://struts.apache.org/plugins/junit/
// https://blog.csdn.net/TestingGDR/article/details/83755597
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:context.xml")
public class StrutsDemoTest extends StrutsSpringTestCase {

    @Autowired
    private ShowService showService;

    @Override
    protected String[] getContextLocations() {
        return new String[]{"classpath:context.xml"};
    }

    @Test
    void test() throws Exception {
        assertNotNull(showService);
        request.setContentType("application/json");
        request.setContent("\"age\" : 12, \"person\":\"{ \"age\" : 78, \"name\" : \"yao\"}".getBytes());
        String res = executeAction("add.action");
        String responseContent = response.getContentAsString();
        System.out.println(res);
    }

    @BeforeEach
    protected void setUp() throws Exception {
        super.setUp();
    }

    @AfterEach
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
