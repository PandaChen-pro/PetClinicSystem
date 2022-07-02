package com.Laccoliths.controller;

import com.Laccoliths.entity.ClinicStaff;
import com.Laccoliths.service.impl.ClinicStaffServiceImpl;
import com.Laccoliths.service.inter.ClinicStaffService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Laccoliths
 */
@WebServlet("/ClinicStaff")
public class ClinicStaffServlet extends HttpServlet {

    private ClinicStaffService clinicStaffService = new ClinicStaffServiceImpl();
    private String[] methods = new String[] {"list","search","save","update","delete"};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理中文乱码???
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        System.out.println(method);
        if (methods[0].equals(method)){
            // 列举方法
            req.setAttribute("list",this.clinicStaffService.list());
            req.getRequestDispatcher("/ClinicStaffManage.jsp").forward(req,resp);
        }else if (methods[1].equals(method)) {
            // 查询方法
            String key = req.getParameter("key");
            String value = req.getParameter("value");
            System.out.println(key);

            System.out.println(value);
            req.setAttribute("list",this.clinicStaffService.search(key,value));
            req.getRequestDispatcher("/ClinicStaffManage.jsp").forward(req,resp);
        }else if (methods[2].equals(method)) {
            // 新增方法
            String[] parameters = this.getParameters(req,resp);
            this.clinicStaffService.save(new ClinicStaff(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4],parameters[5]));
            resp.sendRedirect(req.getContextPath() + "/ClinicStaff?method=list");
        }else if (methods[3].equals(method)) {
            //更新方法
            String[] parameters = this.getParameters(req,resp);
            this.clinicStaffService.update(new ClinicStaff(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4],parameters[5]));
            resp.sendRedirect(req.getContextPath() + "/ClinicStaff?method=list");
        }else if (methods[4].equals(method)) {
            System.out.println("职员delete操作");
            System.out.println(req.getParameter("staffnumber"));
            this.clinicStaffService.delete(req.getParameter("staffnumber"));
            resp.sendRedirect(req.getContextPath() + "/ClinicStaff?method=list");
        }


    }
    protected String[] getParameters(HttpServletRequest req,HttpServletResponse resp){
        String[] params = new String[6];
        params[0] = req.getParameter("staffnumber");
        params[1] = req.getParameter("name");
        params[2] = req.getParameter("gender");
        params[3] = req.getParameter("telephone");
        params[4] = req.getParameter("username");
        params[5] = req.getParameter("password");
        return params;
        
    }
}
