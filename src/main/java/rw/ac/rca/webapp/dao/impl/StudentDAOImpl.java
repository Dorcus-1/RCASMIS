package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
//import rw.ac.rca.webapp.dao.MarksDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.orm.Course;
import rw.ac.rca.webapp.orm.Marks;
import rw.ac.rca.webapp.orm.Student;

import java.util.List;

public class StudentDAOImpl extends DAO implements StudentDAO {

    private static StudentDAOImpl instance;

    private StudentDAOImpl() {
    }

    public static StudentDAOImpl getInstance() {
        if (instance == null) {
            return new StudentDAOImpl();
        } else {
            return instance;
        }
    }
    @Override
    public Student saveStudent(Student student) {
        try {
            begin();
            getSession().save(student);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public Student updateStudent(Student student) {
        try {
            begin();
            getSession().update(student);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public Student saveOrUpdateStudent(Student student) {

        try {
            begin();
            getSession().saveOrUpdate(student);
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public boolean deleteStudent(Student student) {
        try {
            begin();
            Query query = getSession().createQuery(
                    "from student where id= :ref");
            query.setInteger("ref", student.getId());
            Course crs = (Course) query.uniqueResult();
            getSession().delete(crs);
            commit();
            return true;

        } catch (Exception e) {
            rollback();
            return false;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Student getStudentById(int studentId) {
        try {
            begin();
            Query query = getSession().createQuery(
                    "from Marks where id= :ref");
            query.setInteger("ref", studentId);
            Student student = (Student) query.uniqueResult();
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            e.printStackTrace();
            return null;

        }
    }

//    @Override
//    public Student getstudentById(int studentId) {
//        try {
//            begin();
//            Query query = getSession().createQuery(
//                    "from Marks where id= :ref");
//            query.setInteger("ref", studentId);
//            Student student = (Student) query.uniqueResult();
//            commit();
//            return student;
//        } catch (Exception e) {
//            rollback();
//            return null;
//
//        }
//    }

    @SuppressWarnings("unchecked")
    public List<Student> getAllStudent() {
        try {
            begin();
            Query query = getSession().createQuery("from Student");
            List<Student> student = query.list();
            commit();
            return student;
        } catch (Exception e) {
            rollback();
            return null;
        }    }
}
