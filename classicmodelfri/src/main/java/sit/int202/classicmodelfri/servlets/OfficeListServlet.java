package sit.int202.classicmodelfri.servlets;


import jakarta.servlet.HttpConstraintElement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classicmodelfri.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeListServlet", value = "/office-list")
public class OfficeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        OfficeRepository repository = new OfficeRepository();
//        request.setAttribute("offices", repository.findAll());
//        String officeCode = request.getParameter("officeCode");
//        if(officeCode != null) {
//            request.setAttribute("selectedOffice", repository.find(officeCode));
//        }
//        getServletContext().getRequestDispatcher("/office_list.jsp").forward(request,response);
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        request.setAttribute("allCountry", officeRepository.getAllCountry());
        request.setAttribute("allCity", officeRepository.getAllCity());
        doFilter(request, response, officeRepository);
        this.getServletContext().getRequestDispatcher("/office_list.jsp").include(request, response);
    }

    protected void doFilter(HttpServletRequest request, HttpServletResponse response, OfficeRepository officeRepository){
        String filterValue = request.getParameter("filterValue") == null ? "all" : request.getParameter("filterValue");
        if(filterValue.equalsIgnoreCase("all")){
            request.setAttribute("offices", officeRepository.findAll());
        } else {
            request.setAttribute("offices", officeRepository.findByCityOrCountry(filterValue));
        }
        request.setAttribute("selectedFilterValue", filterValue);
    }
}


