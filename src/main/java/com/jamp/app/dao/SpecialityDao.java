package com.jamp.app.dao;

import java.util.List;
import com.jamp.app.domain.Speciality;

public interface SpecialityDao extends BaseCrudDao<Speciality> {
	List<Speciality> getByName(String name);

	List<Speciality>  getAllWithPrograms();
}
