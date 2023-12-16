package sit.int202.classicmodelfri.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelfri.CheckParam;
import sit.int202.classicmodelfri.entities.Office;
import sit.int202.classicmodelfri.repositories.OfficeRepository;


import java.io.IOException;

@WebServlet(name = "AddOfficeServlet", value = "/adding-office")
public class AddOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add_office.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] params = { //require value
                request.getParameter("newOfficeCode"),
                request.getParameter("newOfficeCity"),
                request.getParameter("newOfficePhone"),
                request.getParameter("newOfficeAddress1"),
                request.getParameter("newOfficeState"),
                request.getParameter("newOfficeCountry"),
                request.getParameter("newOfficePostalCode"),
                request.getParameter("newOfficeTerritory")
        };
        if (CheckParam.isValidString(params)) {
            System.out.println("Valid");
            OfficeRepository officeRepository = new OfficeRepository();
            Office newOffice = new Office();
            //additional null value
            String address2 = request.getParameter("newOfficeAddress2").isEmpty()
                    || request.getParameter("newOfficeAddress2") == null ?
                    null : request.getParameter("newOfficeAddress2");

            newOffice.setOfficeCode(request.getParameter("newOfficeCode"));
            newOffice.setCity(request.getParameter("newOfficeCity"));
            newOffice.setPhone( request.getParameter("newOfficePhone"));
            newOffice.setAddressLine1(request.getParameter("newOfficeAddress1"));
            newOffice.setAddressLine2(address2);
            newOffice.setState(request.getParameter("newOfficeState"));
            newOffice.setCountry(request.getParameter("newOfficeCountry"));
            newOffice.setPostalCode(request.getParameter("newOfficePostalCode"));
            newOffice.setTerritory(request.getParameter("newOfficeTerritory"));


            if (officeRepository.insert(newOffice)) {
                System.out.println("success");
                officeRepository.close();
            } else {
                System.out.println("error officeCode");
                request.setAttribute("errorAddingOffice", "Office code already exists.");
                request.getRequestDispatcher("/add_office.jsp").forward(request, response);
            }
        } else {
            System.out.println("error adding. It has null value");
            request.setAttribute("errorAddingOffice", "error adding. It has null value");
            request.getRequestDispatcher("/add_office.jsp").forward(request, response);
        }
        response.sendRedirect(request.getContextPath() + "/office-list");
    }

}
