package rw.ac.rca.webapp.dao;


import rw.ac.rca.webapp.orm.Marks;

import java.util.List;

public interface MarksDAO {
    public Marks saveMarks(Marks marks);
    public Marks updateMarks(Marks marks);
    public Marks saveOrUpdateMarks(Marks marks);
    public boolean deleteMarks(Marks marks);
    public Marks getMarksById(int marksId);
    public List<Marks> getAllMarks();
}
