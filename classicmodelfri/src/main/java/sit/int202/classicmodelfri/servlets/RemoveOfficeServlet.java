package sit.int202.classicmodelfri.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelfri.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "RemoveOfficeServlet", value = "/remove-office")
public class RemoveOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
    request.setAttribute("offices", officeRepository.findAll());
    request.getRequestDispatcher("/remove_office.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String removeParam = request.getParameter("removeId");
        OfficeRepository officeRepository = new OfficeRepository();
        request.setAttribute("offices", officeRepository.findAll());
        if (removeParam == null || removeParam.isEmpty() || removeParam.equals("0")) {
            request.setAttribute("errorRemove", "Invalid id");
            request.getRequestDispatcher("remove_office.jsp").forward(request, response);
        } else {
            doRemove(removeParam, request, response);
        }
        response.sendRedirect(request.getContextPath() + "/office-list");

    }

    private void doRemove(String removeId, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        OfficeRepository officeRepository = new OfficeRepository();
        if(officeRepository.delete(removeId)){
            System.out.println("Success");
            request.setAttribute("removeStatus", "remove success");
            officeRepository.close();
        } else {
            System.out.println("Unsuccessful");
            request.setAttribute("removeStatus", "remove unsuccessful because ID its doesn't exists.");
            request.getRequestDispatcher("remove_office.jsp").forward(request, response);
            officeRepository.close();
        }
    }
}
