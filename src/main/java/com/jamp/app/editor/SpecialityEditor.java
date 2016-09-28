package com.jamp.app.editor;

import java.beans.PropertyEditorSupport;

import com.jamp.app.domain.Speciality;

public class SpecialityEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String id) {
		Speciality speciality = new Speciality();
		speciality.setId(Integer.parseInt(id));
		this.setValue(speciality);
	}
}
