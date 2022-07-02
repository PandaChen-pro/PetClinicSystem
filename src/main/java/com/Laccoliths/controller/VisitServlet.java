package com.Laccoliths.controller;

import com.Laccoliths.entity.Client;
import com.Laccoliths.entity.ClinicStaff;
import com.Laccoliths.entity.Pet;
import com.Laccoliths.entity.Visit;
import com.Laccoliths.service.impl.ClientManageServiceImpl;
import com.Laccoliths.service.impl.ClinicStaffServiceImpl;
import com.Laccoliths.service.impl.PetManageServiceImpl;
import com.Laccoliths.service.impl.VisitServiceImpl;
import com.Laccoliths.service.inter.ClientManageService;
import com.Laccoliths.service.inter.ClinicStaffService;
import com.Laccoliths.service.inter.PetManageService;
import com.Laccoliths.service.inter.VisitService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Laccoliths
 */
@WebServlet("/VisitServlet")
public class VisitServlet extends HttpServlet {
    private final VisitService visitService = new VisitServiceImpl();
    private final ClinicStaffService clinicStaffService = new ClinicStaffServiceImpl();

    private final ClientManageService clientManageService = new ClientManageServiceImpl();

    private final PetManageService petManageService = new PetManageServiceImpl();

    private String[] methods = new String[] {"init","list","search","save","update","delete"};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if(methods[0].equals(method)){
            // 初始化
            List<ClinicStaff> clinicStaffList = this.clinicStaffService.list();
            List<Client> clientList = this.clientManageService.findByStaffId(clinicStaffList.get(0).getNumber());
            List<Pet> petList = this.petManageService.findByClientId(clientList.get(0).getId());

            req.setAttribute("StaffList",clinicStaffList);
            req.setAttribute("ClientList",clientList);
            req.setAttribute("PetList",petList);
            req.getRequestDispatcher("VisitManage.jsp").forward(req,resp);

        } else if (methods[3].equals(method)){
            // 保存
            String staffNumber = req.getParameter("staffNumber");
            String clientId = req.getParameter("clientId");
            String petId = req.getParameter("petId");
            String receptionStaffNumber = req.getParameter("receptionStaffNumber");
            String visitDate = req.getParameter("date");
            System.out.println("visitDate:"+visitDate);
            this.visitService.save(new Visit(staffNumber,petId,clientId,visitDate,receptionStaffNumber));
            resp.sendRedirect("VisitServlet?method=init");
        } else if (methods[1].equals(method)){
            // 列表
            req.setAttribute("list",this.visitService.list());
            req.getRequestDispatcher("VisitInfo.jsp").forward(req,resp);
        } else if (methods[2].equals(method)) {
            // 搜索
            String key = req.getParameter("key");
            String value = req.getParameter("value");
            System.out.println("key:"+key+" value:"+value);
            req.setAttribute("list",this.visitService.search(key,value));
            req.getRequestDispatcher("VisitInfo.jsp").forward(req,resp);

        }
    }
}
