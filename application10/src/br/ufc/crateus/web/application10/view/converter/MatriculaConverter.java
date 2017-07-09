package br.ufc.crateus.web.application10.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufc.crateus.web.application10.model.Matricula;
import br.ufc.crateus.web.application10.repository.MatriculaRepository;

@FacesConverter("matriculaConverter")
public class MatriculaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		System.out.println(value);
		return MatriculaRepository.getById(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		Matricula matricula = (Matricula) obj;

		System.out.println(matricula);
		return String.valueOf(matricula.getId());
	}

}
