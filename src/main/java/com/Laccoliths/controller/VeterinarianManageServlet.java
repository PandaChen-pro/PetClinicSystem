package com.Laccoliths.controller;

import com.Laccoliths.entity.ClinicStaff;
import com.Laccoliths.entity.Veterinarian;
import com.Laccoliths.service.impl.VeterinarianServiceImpl;
import com.Laccoliths.service.inter.VeterinarianService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Laccoliths
 */
@WebServlet("/VeterinarianManage")
public class VeterinarianManageServlet extends HttpServlet {
    private VeterinarianService veterinarianService = new VeterinarianServiceImpl();
    private String[] methods = new String[] {"list","search","save","update","delete","staffList"};

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
            req.setAttribute("list",this.veterinarianService.list());
            req.getRequestDispatcher("/VeterinarianManage.jsp").forward(req,resp);
        }else if (methods[1].equals(method)) {
            // 查询方法
            String key = req.getParameter("key");
            String value = req.getParameter("value");
            System.out.println(key);
            System.out.println(value);
            req.setAttribute("list",this.veterinarianService.search(key,value));
            req.getRequestDispatcher("/VeterinarianManage.jsp").forward(req,resp);
        }else if (methods[2].equals(method)) {
            // 新增方法
            String[] parameters = this.getParameters(req,resp);
            this.veterinarianService.save(new Veterinarian(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4]));
            resp.sendRedirect(req.getContextPath() + "/VeterinarianManage?method=list");
        }else if (methods[3].equals(method)) {
            //更新方法
            String[] parameters = this.getParameters(req,resp);
            System.out.println(parameters[0] + "");
            this.veterinarianService.update(new Veterinarian(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4]));
            resp.sendRedirect(req.getContextPath() + "/VeterinarianManage?method=list");
        }else if (methods[4].equals(method)) {
            System.out.println("兽医delete操作");
            System.out.println(req.getParameter("worknumber"));
            this.veterinarianService.delete(req.getParameter("worknumber"));
            resp.sendRedirect(req.getContextPath() + "/VeterinarianManage?method=list");
        }else if (methods[5].equals(method)) {
            // 列举方法
            req.setAttribute("list",this.veterinarianService.list());
            req.getRequestDispatcher("/StaffVeterinarianManage.jsp").forward(req,resp);
        }


    }
    protected String[] getParameters(HttpServletRequest req,HttpServletResponse resp){
        String[] params = new String[5];
        params[0] = req.getParameter("worknumber");
        params[1] = req.getParameter("name");
        params[2] = req.getParameter("gender");
        params[3] = req.getParameter("telephone");
        params[4] = req.getParameter("speciality");
        return params;

    }
}
