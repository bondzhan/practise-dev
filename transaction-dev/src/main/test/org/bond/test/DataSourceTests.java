package org.bond.test;
import javax.sql.DataSource;

import org.bond.transaction.TransactionApplication;
import org.bond.transaction.controller.UserController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = TransactionApplication.class)
@SpringBootTest(classes = TransactionApplication.class)
@WebAppConfiguration
public class DataSourceTests {

    // 获取配置的数据源
    @Autowired
    DataSource dataSource;
    
    @Autowired
    DataSourceProperties dataSourceProperties;

    @Autowired
    UserController userController;
    
    private MockMvc mvc;  

    @Before
    public void setUp() throws Exception {  
        mvc = MockMvcBuilders.standaloneSetup(userController).build();  
    }  
    
    @Test
    public void testDataSource() throws Exception {
        
        // 查看配置数据源信息
        System.out.println(dataSource);
        System.out.println(dataSource.getClass().getName());
        System.out.println(dataSourceProperties.getDriverClassName());
    }
    
    @Test  
    public void addOrder() throws Exception {  
        MvcResult result = mvc.perform(  
                MockMvcRequestBuilders.get("/user/addOrder")  
                        .accept(MediaType.APPLICATION_JSON))  
                        .andReturn();
        int statusCode = result.getResponse().getStatus();  
        Assert.assertEquals(statusCode, 200);  
        String body = result.getResponse().getContentAsString();  
        System.out.println("body:"+body);  
    }  
    
}
