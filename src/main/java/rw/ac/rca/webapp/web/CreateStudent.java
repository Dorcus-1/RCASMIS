package rw.ac.rca.webapp.web;

import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.AddressDAO;
import rw.ac.rca.webapp.dao.impl.AddressDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();
    private AddressDAO addressDAO= AddressDAOImpl.getInstance();

    public CreateStudent() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");
        System.out.println("The user in session is: " + user);

        if (pageRedirect != null) {
            System.out.println("The print statement is and the only is: " + pageRedirect);
            if (pageRedirect.equals("createstudent")) {
                List<Address>  addressList = addressDAO.getAllAddresses();
                request.setAttribute("address",addressList);
                request.getRequestDispatcher("WEB-INF/createStudent.jsp").forward(request, response);
            } else {
                request.setAttribute("error ", "No user found");
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error ", "No user found");
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");

        if (pageRedirect != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (pageRedirect.equals("createstudent")) {
                boolean isRepeating = Integer.parseInt(request.getParameter("repeating")) == 1 ? true : false;
                boolean isPartTime = Integer.parseInt(request.getParameter("ptime")) == 1 ? true : false;
                boolean isInternational = Integer.parseInt(request.getParameter("international")) == 1 ? true : false;
//                int addressId = Integer.parseInt(request.getParameter(""));
//                Address address = addressDAO.getAddressById(addressId);

                Student student = new Student();
                student.setFirstName(request.getParameter("fname"));
                student.setLastName(request.getParameter("lname"));
                student.setPhoneNumber(request.getParameter("number"));
                student.setPartTime(isPartTime);
                student.setRepeating(isRepeating);
                student.setInternational(isInternational);
                try {
                    student.setDateOfBirth(simpleDateFormat.parse(request.getParameter("dob")));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
////                student.setAddress(address);
//                try {
//                    simpleDateFormat.parse(request.getParameter("student"));
//                } catch (ParseException e) {
//                    throw new RuntimeException(e);
//                }

                try {
                    // Fetch the address from the database

                    // Save the student
                    studentDAO.saveStudent(student);

                    request.setAttribute("success", "Successfully created the student");
                    request.getRequestDispatcher("WEB-INF/createStudent.jsp").forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("error", "Failed to create the student");
                    request.getRequestDispatcher("WEB-INF/createStudent.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }

}