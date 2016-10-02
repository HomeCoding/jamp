package com.jamp.app.service;

import java.util.List;
import com.jamp.app.domain.Speciality;

public interface SpecialityService {
	
	void create(Speciality speciality);
	
	void remove(Speciality speciality);
	
	List<Speciality> getAll();
	
	Speciality getById(Integer id);
	
}
