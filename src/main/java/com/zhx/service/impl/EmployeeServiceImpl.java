package com.zhx.service.impl;

import com.zhx.bean.Employee;
import com.zhx.dao.EmployeeMapper;
import com.zhx.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @Author 郑煌兴
 * @注释
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<Employee> getEmpList() {
        return employeeMapper.selectByExampleWithDept(null);
    }
}
