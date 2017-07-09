package br.ufc.crateus.web.application9.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufc.crateus.web.application9.model.Disciplina;
import br.ufc.crateus.web.application9.repository.DisciplinaRepository;

@FacesConverter("disciplinaConverter")
public class DisciplinaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		// TODO Auto-generated method stub
		return DisciplinaRepository.getById(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		// TODO Auto-generated method stub
		
		Disciplina disciplina = (Disciplina) obj;
		return String.valueOf(disciplina.getId());
	}

}
