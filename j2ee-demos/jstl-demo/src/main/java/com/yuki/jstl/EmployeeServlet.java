package com.yuki.jstl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "employeeServlet",urlPatterns = "/emp")
public class EmployeeServlet extends HttpServlet {

    // 重定向页面
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.getRequestDispatcher("/WEB-INF/emp/emp.jsp").forward(req,resp);
    }

    // 处理请求
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("emp post ---");
        // 1. 创建对象
        String id1 = req.getParameter("id");
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = String.valueOf(req.getParameter("name"));
        String gender = String.valueOf(req.getParameter("gender"));
        String job = String.valueOf(req.getParameter("job"));
        Double salary = Double.valueOf(req.getParameter("salary"));
        Date entryDate = null;
        try {
            entryDate = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("entryDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Employee emp = new Employee(id, name, gender, job, salary, entryDate);
        //  2. 存放数据
        ServletContext servletContext = req.getServletContext();
        if (servletContext.getAttribute("empList") == null) {
            servletContext.setAttribute("empList", new ArrayList<Employee>());
        }
        List<Employee> empList = (List<Employee>) servletContext.getAttribute("empList");
        empList.add(emp);
        // 3. 重定向页面
        doGet(req, resp);
    }
}
