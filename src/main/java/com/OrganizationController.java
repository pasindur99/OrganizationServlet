package com;

import com.entities.Organization;
import com.services.OrganizationService;
import com.util.ServletUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/organizations")
public class OrganizationController extends HttpServlet{
    private static final OrganizationService organizationService = new OrganizationService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Organization organization = ServletUtil.expect( Organization.class, request);
        ServletUtil.respond(organizationService.saveOrganization(organization), response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        String id = request.getParameter("id");
        if (id == null){
            ServletUtil.respond(organizationService.getAll(), response);
        }else{
            Organization organization = organizationService.getOne(Integer.parseInt(request.getParameter("id")));

            if(organization != null){
                ServletUtil.respond(organizationService.getOne(Integer.parseInt(request.getParameter("id"))), response);
            }else{
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        organizationService.deleteOrg(id);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        Organization organization = ServletUtil.expect(Organization.class, request);
        ServletUtil.respond(organizationService.updateOrg(organization), response);
    }
}

