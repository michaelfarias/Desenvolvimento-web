package br.ufc.crateus.web.application8.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufc.crateus.web.application8.model.Professor;
import br.ufc.crateus.web.application8.repository.ProfessorRepository;

@FacesConverter("professorConverter")
public class ProfessorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {

		return ProfessorRepository.getById(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		Professor professor = (Professor) obj;
		return String.valueOf(professor.getId());
	}

}
