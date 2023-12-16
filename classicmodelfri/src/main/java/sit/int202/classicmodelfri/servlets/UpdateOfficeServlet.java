package sit.int202.classicmodelfri.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelfri.CheckParam;
import sit.int202.classicmodelfri.entities.Office;
import sit.int202.classicmodelfri.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "UpdateOfficeServlet", value = "/update-office")
public class UpdateOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeCode = request.getParameter("editOffice");
        OfficeRepository officeRepository = new OfficeRepository();
        Office findedOffice = officeRepository.findOfficeByCode(officeCode);
        if (findedOffice == null) {
            request.setAttribute("errorUpdatingOffice", "Office does not exists.");
        } else {
            request.setAttribute("officeData", findedOffice);
        }
        request.getRequestDispatcher("update_office.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] params = { //require value
                request.getParameter("currentOfficeCode"),
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
            Office targetOffice = officeRepository.findOfficeByCode(params[0]);
            if (targetOffice == null) {
                request.setAttribute("errorUpdatingOffice", "Office does not exists.");
            } else {
                String address2 = request.getParameter("newOfficeAddress2").isEmpty()
                        || request.getParameter("newOfficeAddress2") == null ?
                        null : request.getParameter("newOfficeAddress2");
                targetOffice.setOfficeCode(params[0]);
                targetOffice.setCity(params[1]);
                targetOffice.setPhone(params[2]);
                targetOffice.setAddressLine1(params[3]);
                targetOffice.setAddressLine2(address2);
                targetOffice.setState(params[4]);
                targetOffice.setCountry(params[5]);
                targetOffice.setPostalCode(params[6]);
                targetOffice.setTerritory(params[7]);
            }

            if (officeRepository.update(targetOffice)) {
                System.out.println("success");
                officeRepository.close();
            } else {
                System.out.println("error officeCode");
                request.setAttribute("errorUpdatingOffice", "Error transaction");
                request.getRequestDispatcher("/update_office.jsp").forward(request, response);
            }
        } else {
            System.out.println("error updating. It has null value");
            request.setAttribute("errorUpdatingOffice", "error adding. It has null value");
            OfficeRepository officeRepository = new OfficeRepository();
            Office findedOffice = officeRepository.findOfficeByCode(request.getParameter("currentOfficeCode"));
            request.setAttribute("officeData", findedOffice);
            request.getRequestDispatcher("/update_office.jsp").forward(request, response);
        }
        response.sendRedirect(request.getContextPath() + "/office-list");
    }

}
