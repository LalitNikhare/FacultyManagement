package com.cg.fmanage.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fmanage.beans.Faculty;
import com.cg.fmanage.beans.FacultyPOJO;
import com.cg.fmanage.repo.FacultyRepo;

@Service(value = "facultyservice")
public class FacultyMgrImpl implements FacultyMgr {
	@Autowired
	private FacultyRepo facultyRepo;

	private Faculty facultyBean;

	private FacultyPOJO facultyPOJO;

	@Override
	public Faculty addFaculty(FacultyPOJO faculty) {
		facultyBean = convertToBean(faculty);
		return facultyRepo.save(facultyBean);

	}

	@Override
	public FacultyPOJO getFaculty(int id) {
//		return facultyRepo.getFacultyByID(id);
		facultyBean = facultyRepo.getFacultyByID(id);
		facultyPOJO = convertToPOJO(facultyBean);
		return facultyPOJO;

	}

	@Override
	public void deleteFaculty(int id) {
		facultyRepo.deleteFacultyById(id);
	}

	@Override
	public void updateFaculty(FacultyPOJO faculty) {
		facultyBean = convertToBean(faculty);
		facultyRepo.updateFacultyById(facultyBean.getFacultyName(), facultyBean.getFacultyId());
	}

	@Override
	public List<FacultyPOJO> getAllfaculty() {
		List<Faculty> facultyList = facultyRepo.getAllFaculty();
		List<FacultyPOJO> facultyPOJOLIst = new ArrayList<FacultyPOJO>();
		for (Faculty faculty : facultyList) {
			facultyPOJO = convertToPOJO(faculty);
			facultyPOJOLIst.add(facultyPOJO);
		}
		return facultyPOJOLIst;

	}

	public boolean checkFaculty(int facultyId) {
		if (facultyRepo.existsById(facultyId))
			return true;
		else
			return false;
	}

	public Faculty convertToBean(FacultyPOJO oldFaculty) {
		Faculty newFaculty = new Faculty();
		BeanUtils.copyProperties(oldFaculty, newFaculty);
		return newFaculty;
	}

	public FacultyPOJO convertToPOJO(Faculty oldFaculty) {
		FacultyPOJO newFaculty = new FacultyPOJO();
		BeanUtils.copyProperties(oldFaculty, newFaculty);
		return newFaculty;
	}

}
