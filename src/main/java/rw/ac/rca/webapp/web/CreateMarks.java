package rw.ac.rca.webapp.web;


import rw.ac.rca.webapp.dao.CourseDAO;
import rw.ac.rca.webapp.dao.MarksDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.CourseDAOImpl;
import rw.ac.rca.webapp.dao.impl.MarksDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Course;
import rw.ac.rca.webapp.orm.Marks;
import rw.ac.rca.webapp.orm.Student;
import rw.ac.rca.webapp.orm.User;

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

/**
 * Servlet implementation class CreateCourse
 */
public class CreateMarks extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MarksDAO marksDAO = MarksDAOImpl.getInstance();
    private StudentDAO studentDAO= StudentDAOImpl.getInstance();
    private CourseDAO courseDAO= CourseDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMarks() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");
        System.out.println("The user in session is: " + user);

        if (pageRedirect != null) {
            System.out.println("The print statement is and the only is: " + pageRedirect);
            if (pageRedirect.equals("createmark")) {
                List<Student> student=studentDAO.getAllStudent();
                List<Course> courses=courseDAO.getAllCourses();
                request.setAttribute("courses",courses);
                request.setAttribute("student",student);
                request.getRequestDispatcher("WEB-INF/createMarks.jsp").forward(request, response);
            } else {

                request.setAttribute("error ", "No user found");
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("error ", "No user found");
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");

        if(pageRedirect != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if(pageRedirect.equals("createmark")){
                int studentId = Integer.parseInt(request.getParameter("student"));
              Student student = studentDAO.getStudentById(studentId);
                int courseId = Integer.parseInt(request.getParameter("course"));
                Course course = courseDAO.getCourseById(courseId);
                Marks marks = new Marks();
                marks.setStudent(student);
                marks.setCourse(course);
                marks.setGradeGotten(request.getParameter("grade"));
                marks.setMarksScored(Integer.parseInt(request.getParameter("marks")));
                marks.setTotalMarks(Integer.parseInt(request.getParameter("totmarks")));
//           try {
//
//                }  catch (ParseException e) {
//                    throw new RuntimeException(e);
//                }

                // Saving the course;
                try {
                    marksDAO.saveMarks(marks);
                    request.setAttribute("success" , "Successfully created the Marks" );
                    request.getRequestDispatcher("WEB-INF/createMarks.jsp").forward(request , response);
                }catch (Exception e){
                    request.setAttribute("error" , "Failed to create the Course" );
                    request.getRequestDispatcher("WEB-INF/createMarks.jsp").forward(request , response);
                }
            }else{
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request , response);
            }
        }else{
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request , response);
        }
    }
}
