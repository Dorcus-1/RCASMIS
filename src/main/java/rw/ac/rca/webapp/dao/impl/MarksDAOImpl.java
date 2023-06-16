package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
import rw.ac.rca.webapp.dao.MarksDAO;
import rw.ac.rca.webapp.orm.Course;
import rw.ac.rca.webapp.orm.Marks;

import java.util.List;

public class MarksDAOImpl extends DAO implements MarksDAO {

    private static MarksDAOImpl instance;

    private MarksDAOImpl() {
    }

    public static MarksDAOImpl getInstance() {
        if (instance == null) {
            return new MarksDAOImpl();
        } else {
            return instance;
        }
    }
    @Override
    public Marks saveMarks(Marks marks) {
        try {
            begin();
            getSession().save(marks);
            commit();
            return marks;
        } catch (Exception e) {
            rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Marks updateMarks(Marks marks) {
        try {
            begin();
            getSession().update(marks);
            commit();
            return marks;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public Marks saveOrUpdateMarks(Marks marks) {

        try {
            begin();
            getSession().saveOrUpdate(marks);
            commit();
            return marks;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    @Override
    public boolean deleteMarks(Marks marks) {
        try {
            begin();
            Query query = getSession().createQuery(
                    "from marks where id= :ref");
            query.setInteger("ref", marks.getId());
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
    public Marks getMarksById(int marksId) {
        try {
            begin();
            Query query = getSession().createQuery(
                    "from Marks where id= :ref");
            query.setInteger("ref", marksId);
            Marks marks = (Marks) query.uniqueResult();
            commit();
            return marks;
        } catch (Exception e) {
            rollback();
            return null;

        }
    }

    @Override
    public List<Marks> getAllMarks() {
        try {
            begin();
            Query query = getSession().createQuery("from Marks");
            List<Marks> marks = query.list();
            commit();
            return marks;
        } catch (Exception e) {
            rollback();
            return null;
        }    }
}
