package com.cg.fmanage.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.fmanage.beans.FacultyPOJO;
import com.cg.fmanage.exception.FacultyNotFoundException;
import com.cg.fmanage.manager.FacultyMgr;

@RestController
public class FacultyActionController {
	@Autowired
	private FacultyMgr facultyServices;

	@RequestMapping(value = "/addFaculty", method = RequestMethod.POST)
	public ResponseEntity<Object> addFaculty(@RequestBody FacultyPOJO faculty) {
		facultyServices.addFaculty(faculty);
		return new ResponseEntity<>("Faculty Successfully added", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/removeFaculty/{facultyId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> removeFaculty(@PathVariable("facultyId") int facultyId) {
		if (!facultyServices.checkFaculty(facultyId))
			throw new FacultyNotFoundException();
		facultyServices.deleteFaculty(facultyId);
		return new ResponseEntity<>("Faculty Successfully deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/updateFaculty/{facultyId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateFaculty(@PathVariable("facultyId") int facultyId,
			@RequestBody FacultyPOJO faculty) {
		if (!facultyServices.checkFaculty(facultyId))
			throw new FacultyNotFoundException();
		faculty.setFacultyId(facultyId);
		facultyServices.updateFaculty(faculty);
		return new ResponseEntity<>("Faculty Successfully updated", HttpStatus.OK);
	}

	@RequestMapping(value = "/getFaculty/{facultyId}", method = RequestMethod.GET)
	public FacultyPOJO getFaculty(@PathVariable("facultyId") int facultyId) {
		if (!facultyServices.checkFaculty(facultyId))
			throw new FacultyNotFoundException();
		return facultyServices.getFaculty(facultyId);
	}

	@RequestMapping(value = "/getAllFaculty", method = RequestMethod.GET)
	public List<FacultyPOJO> getAllFaculty() {
		List<FacultyPOJO> facultyList = facultyServices.getAllfaculty();
		for (FacultyPOJO faculty : facultyList) {
			faculty.setClassRoom(null);
			faculty.setSubject(null);
		}
		return facultyList;
	}
}
