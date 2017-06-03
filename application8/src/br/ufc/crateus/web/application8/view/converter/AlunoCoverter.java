package br.ufc.crateus.web.application8.view.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.ufc.crateus.web.application8.model.Aluno;
import br.ufc.crateus.web.application8.repository.AlunoRepository;

@FacesConverter("alunoConverter")
public class AlunoCoverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		return AlunoRepository.getById(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		// TODO Auto-generated method stub

		Aluno aluno = (Aluno) obj;
		return String.valueOf(aluno.getId());
	}

}
