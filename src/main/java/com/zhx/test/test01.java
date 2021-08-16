package com.zhx.test;

import com.zhx.bean.Employee;
import com.zhx.service.EmployeeService;
import com.zhx.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @version 1.0
 * @Author 郑煌兴
 * @注释
 */
public class test01 {
    @Test
    public void test1(){
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("SpringApplication.xml");
        EmployeeService employeeServiceImpl = classPathXmlApplicationContext.getBean("employeeServiceImpl", EmployeeService.class);
        List<Employee> empList = employeeServiceImpl.getEmpList();
        System.out.println(empList.size());
    }
}
