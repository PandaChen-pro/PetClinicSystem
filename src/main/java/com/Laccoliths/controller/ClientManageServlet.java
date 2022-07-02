package com.Laccoliths.controller;

import com.Laccoliths.dao.inter.PetManageDao;
import com.Laccoliths.entity.Client;
import com.Laccoliths.entity.Pet;
import com.Laccoliths.service.impl.ClientManageServiceImpl;
import com.Laccoliths.service.impl.ClinicStaffServiceImpl;
import com.Laccoliths.service.impl.PetManageServiceImpl;
import com.Laccoliths.service.inter.ClientManageService;
import com.Laccoliths.service.inter.ClinicStaffService;
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
@WebServlet("/ClientManage")
public class ClientManageServlet extends HttpServlet {

    private final ClientManageService clientManageService = new ClientManageServiceImpl();
    private final PetManageService petManageService = new PetManageServiceImpl();
    private final String[] methods = new String[] {"list","search","save","update","findByStaffNumber"};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        System.out.println(method);
        if (methods[0].equals(method)){
            // 列举方法
            req.setAttribute("list",this.clientManageService.list());
            req.getRequestDispatcher("/StaffClientManage.jsp").forward(req,resp);
        }else if (methods[1].equals(method)) {
            // 搜索方法
            String key = req.getParameter("key");
            String value = req.getParameter("value");
            System.out.println(key);
            System.out.println(value);
            req.setAttribute("list",this.clientManageService.search(key,value));
            req.getRequestDispatcher("/StaffClientManage.jsp").forward(req,resp);
        }else if (methods[2].equals(method)) {
            // 保存方法
            String[] params = this.getParameters(req,methods[2]);
            params[7] = "否";
            this.clientManageService.save(new Client(params[0],params[1],params[2],params[3],params[4],params[5],params[6],params[7]));
            resp.sendRedirect(req.getContextPath() + "/ClientManage?method=list");
        }else if (methods[3].equals(method)) {
            // 更新方法
            String[] params = this.getParameters(req,methods[3]);
            this.clientManageService.update(new Client(params[0],params[1],params[2],params[3],params[4],params[5],params[6],params[7]));
            resp.sendRedirect(req.getContextPath() + "/ClientManage?method=list");
        }else if (methods[4].equals(method)) {
            // 根据工号查询方法
            String staffNumber = req.getParameter("staffNumber");
            System.out.println("findByStaffNumber:"+staffNumber);
            List<Client> list = this.clientManageService.findByStaffId(staffNumber);
            List<Pet> pets = this.petManageService.findByClientId(list.get(0).getId());
            Map<String,List> map = new HashMap<>();
            map.put("clientList",list);
            map.put("petList",pets);
            JSONArray jsonArray = JSONArray.fromObject(map);
            resp.setContentType("text/json;charset=UTF-8");
            resp.getWriter().write(jsonArray.toString());
        }
    }

    protected String[] getParameters(HttpServletRequest req,String type){
        String[] params = new String[8];
        params[0] = req.getParameter("id");
        params[1] = req.getParameter("name");
        params[2] = req.getParameter("gender");
        params[3] = req.getParameter("telephone");
        params[5] = req.getParameter("varieties");
        if (methods[2].equals(type)){
            params[4] = req.getParameter("petName");
            params[6] = req.getParameter("staffName");
            params[7] = req.getParameter("isOk");
        }else {
            params[4] = req.getParameter("petname");
            params[6] = req.getParameter("staffname");
            params[7] = req.getParameter("isok");
        }

        return params;

    }
}
