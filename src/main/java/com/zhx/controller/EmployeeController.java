package com.zhx.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhx.bean.Employee;
import com.zhx.bean.Msg;
import com.zhx.service.EmployeeService;
import com.zhx.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import java.util.List;

/**
 * @version 1.0
 * @Author 郑煌兴
 * @注释
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/list")
    public String getEmps() {
        System.out.println("访问该方法");
        return "list";
    }

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping("/emps/{pn}")
    @ResponseBody
    public Msg getEmpsWithJson(@PathVariable("pn") Integer pn) {
        // 这不是一个分页查询
        // 引入PageHelper分页插件
        System.out.println(pn);
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Employee> emps = employeeService.getEmpList();
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(emps, 5);
        return Msg.success().add("pageInfo", page);
//        return page;
    }

    @RequestMapping("/test/{id}")
    @ResponseBody
    String test(@PathVariable("id")String id) {
        return id;
    }

    /**
     * 查询员工数据（分页查询）
     *
     * @return
     */
//     @RequestMapping("/emps/{pn}")
    public String getEmps(@PathVariable("pn") Integer pn,
                          Model model) {
        System.out.println("分页查询" + pn);
        // 这不是一个分页查询；
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 5);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<Employee> emps = employeeService.getEmpList();
        System.out.println(emps.size() + "--------------------");
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(emps, 5);
        model.addAttribute("pageInfo", page);
        return "list";
    }

}
