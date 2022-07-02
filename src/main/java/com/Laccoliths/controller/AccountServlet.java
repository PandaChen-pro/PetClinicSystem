package com.Laccoliths.controller;

import com.Laccoliths.dto.SystemAdminDto;
import com.Laccoliths.dto.ClinicStaffDto;
import com.Laccoliths.service.impl.ClinicStaffServiceImpl;
import com.Laccoliths.service.inter.SystemAdminService;
import com.Laccoliths.service.impl.SystemAdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author MSI
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {
    SystemAdminService systemAdminService = new SystemAdminServiceImpl();
    ClinicStaffServiceImpl clinicStaffService = new ClinicStaffServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        final String[] identifier = new String[] {"systemAdmin", "clinicStaff"};
        final String[] methods = new String[] {"login", "logout"};

        System.out.println(method);


        if (methods[0].equals(method)) {
            // 登录功能
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String type = req.getParameter("type");
            if (identifier[0].equals(type)) {
                // 系统管理员登录
                SystemAdminDto systemAdminDto = this.systemAdminService.login(username, password);
                int code = systemAdminDto.getCode();
                if (code == -1) {
                    // 用户名不存在
                    req.setAttribute("usernameError", "用户名不存在");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                } else if (code == -2) {
                    // 密码错误
                    req.setAttribute("passwordError", "密码错误");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                } else if (code == 0) {
                    //跳转到登录成功界面
                    HttpSession session = req.getSession();
                    session.setAttribute("systemAdmin", systemAdminDto.getSystemAdmin());
                    session.setAttribute("userName",systemAdminDto.getSystemAdmin().getUsername());
                    resp.sendRedirect(req.getContextPath()+"/SystemAdminstrator.jsp");
                }
            }else if (identifier[1].equals(type)){
                // 诊所职工登录
                ClinicStaffDto clinicStaffDto = this.clinicStaffService.login(username, password);
                int code = clinicStaffDto.getCode();
                if (code == -1) {
                    // 用户名不存在
                    req.setAttribute("usernameError", "用户名不存在");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                } else if (code == -2) {
                    // 密码错误
                    req.setAttribute("passwordError", "密码错误");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                } else if (code == 0) {
                    //跳转到登录成功界面
                    HttpSession session = req.getSession();
                    session.setAttribute("clinicStaff", clinicStaffDto.getClinicStaff());
                    session.setAttribute("userName",clinicStaffDto.getClinicStaff().getUsername());
                    resp.sendRedirect(req.getContextPath()+"/ClinicStaff.jsp");
                }
            }
        }else if (methods[1].equals(method)) {
            // 销毁session，回到登录页面
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
