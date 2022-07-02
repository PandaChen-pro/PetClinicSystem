package com.Laccoliths.controller;

import com.Laccoliths.entity.Pet;
import com.Laccoliths.service.impl.PetManageServiceImpl;
import com.Laccoliths.service.inter.PetManageService;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Laccoliths
 */
@WebServlet("/PetManage")
public class PetManageServlet extends HttpServlet {
    private PetManageService petManageService = new PetManageServiceImpl();
    private String[] methods = new String[] {"list","search","save","update","findByClientId","findByPetId"};


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if(methods[0].equals(method)){
            // 列举方法
            req.setAttribute("list",this.petManageService.list());
            req.getRequestDispatcher("/StaffPetManage.jsp").forward(req,resp);
        }else if (methods[1].equals(method)) {
            // 查询方法
            String key = req.getParameter("key");
            String value = req.getParameter("value");
            System.out.println(key);
            System.out.println(value);
            req.setAttribute("list",this.petManageService.search(key,value));
            req.getRequestDispatcher("/StaffPetManage.jsp").forward(req,resp);
        }else if (methods[2].equals(method)) {
            // 新增方法
            String[] parameters = this.getParameters(req,methods[2]);
            this.petManageService.save(new Pet(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4],parameters[5],parameters[6],parameters[7],parameters[8]));
            resp.sendRedirect(req.getContextPath() + "/PetManage?method=list");
        }else if (methods[3].equals(method)) {
            // 更新方法
            String[] parameters = this.getParameters(req,methods[3]);
            this.petManageService.update(new Pet(parameters[0],parameters[1],parameters[2],parameters[3],parameters[4],parameters[5],parameters[6],parameters[7],parameters[8]));
            resp.sendRedirect(req.getContextPath() + "/PetManage?method=list");
        }else if (methods[4].equals(method)) {
            // 通过客户id查询方法
            String clientId = req.getParameter("clientId");
            List<Pet> list = this.petManageService.findByClientId(clientId);
            Map<String,List> map = new HashMap<>();
            map.put("petList",list);
            JSONArray jsonArray = JSONArray.fromObject(map);
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(jsonArray.toString());
        }else if (methods[5].equals(method)) {
            // 通过宠物Id查询方法
            String petId = req.getParameter("petId");
            String petVariety = this.petManageService.findByPetId(petId);
            Map<String,String> map = new HashMap<>();
            map.put("petVariety",petVariety);
            JSONArray jsonArray = JSONArray.fromObject(map);
            resp.setContentType("text/json;charset=utf-8");
            resp.getWriter().write(jsonArray.toString());
        }
    }
    protected String[] getParameters(HttpServletRequest req,String type){
        String[] params = new String[9];
        params[0] = req.getParameter("id");
        System.out.println("params[0]："+params[0]);
        params[1] = req.getParameter("name");
        params[2] = req.getParameter("gender");
        params[3] = req.getParameter("age");
        params[4] = req.getParameter("varieties");
        params[5] = req.getParameter("symptom");
        if (methods[2].equals(type)){
            params[6] = req.getParameter("isCure");
            params[7] = req.getParameter("clientName");
            params[8] = req.getParameter("doctorName");
        }else {
            params[6] = req.getParameter("iscure");
            params[7] = req.getParameter("clientname");
            params[8] = req.getParameter("doctorname");
        }

        return params;

    }
}
