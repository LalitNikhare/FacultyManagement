package com.cg.fmanage.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import com.cg.fmanage.beans.Faculty;

public interface FacultyRepo extends JpaRepository<Faculty, Integer> {

	public Faculty getFacultyByID(@Param("facultyID") int facultyId);

	public List<Faculty> getAllFaculty();

	@Transactional
	@Modifying
	public void deleteFacultyById(@Param("facultyID") int facultyId);

	@Transactional
	@Modifying
	public void updateFacultyById(@Param("facultyName") String facultyName, @Param("facultyID") int facultyId);

	

}
