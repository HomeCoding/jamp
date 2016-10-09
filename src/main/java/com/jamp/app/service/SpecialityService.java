package com.jamp.app.service;


import java.util.List;

import com.jamp.app.domain.Speciality;

public interface SpecialityService extends BaseCrudService<Speciality> {
	List<Speciality> getByName(String name);
}
