package com.cg.fmanage.manager;

import java.util.List;
import com.cg.fmanage.beans.Faculty;
import com.cg.fmanage.beans.FacultyPOJO;

public interface FacultyMgr {
	public Faculty addFaculty(FacultyPOJO faculty);

	public FacultyPOJO getFaculty(int id);

	public void deleteFaculty(int id);

	public void updateFaculty(FacultyPOJO faculty);

	public List<FacultyPOJO> getAllfaculty();

	public boolean checkFaculty(int facultyId);
}
