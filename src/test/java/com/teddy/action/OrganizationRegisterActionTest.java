package com.teddy.action;

import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class OrganizationRegisterActionTest extends StrutsSpringJUnit4TestCase {

    @Test
    public void test() throws Exception {
//        OrganizationVo organizationVo = new OrganizationVo();
//        organizationVo.setDescription("desc");
//        organizationVo.setEmail("zhaojin@g.com");
//        organizationVo.setName("jin");
//        Map<String, Object> map = new HashMap<>();
//        map.put("organization", organizationVo);
//        map.put("password", "pwd");
//        String json = JSON.toJSONString(map);
        request.setContent("{\"organization\":{\"name\":\"asd\",\"email\":\"11@qq.com\",\"description\":\"121212\",\"contact\":{\"gender\":\"FEMALE\",\"name\":\"13214\",\"phone\":\"124214\"}}}".getBytes());
        request.setContentType("application/json");
        ActionProxy actionProxy = getActionProxy("organizationRegister.action");
        assertNotNull(actionProxy);
        actionProxy.execute();
        System.out.println(response.getContentAsString());
    }
}
