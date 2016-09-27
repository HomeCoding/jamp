package com.jamp.app.editor;

import java.beans.PropertyEditorSupport;
import com.jamp.app.domain.Speciality;

public class SpecialityEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String id) {
		Speciality speciality;
		switch (Integer.parseInt(id)) {
		case 1:
			speciality = new Speciality(1, "Java");
			break;
		case 2:
			speciality = new Speciality(2, "JS");
			break;
		case 3:
			speciality = new Speciality(3, ".Net");
			break;
		default:
			speciality = null;
		}
		this.setValue(speciality);
	}
}
