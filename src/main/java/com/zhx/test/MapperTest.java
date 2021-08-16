package com.zhx.test;

import com.zhx.bean.Employee;
import com.zhx.dao.DepartmentMapper;
import com.zhx.dao.EmployeeMapper;
import com.zhx.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.UUID;

/**
 * 导入Spring单元测试模块
 * @version 1.0
 * @Author 郑煌兴
 * @注释
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:SpringApplication.xml"})
public class MapperTest {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    //批量的Sqlsession
    @Autowired
    SqlSession session;
    @Test
    void test2(){
        System.out.println("hot-fix 4");
        System.out.println(employeeService.getEmpList().size());
    }
    @Test
    void test() throws IOException {
        System.out.println(1);
//        Employee employee = employeeMapper.selectByPrimaryKey(6);
        Employee employee = employeeMapper.selectByPrimaryKeyWithDept(1);
        System.out.println(employee);

        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 500; i++) {
            String name = UUID.randomUUID().toString().substring(0, 5);
            mapper.insert(new Employee(null,name,"0",name+"@qq.com",2));
        }
    }
}
