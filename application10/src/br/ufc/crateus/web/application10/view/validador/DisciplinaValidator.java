package br.ufc.crateus.web.application10.view.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.ufc.crateus.web.application10.repository.DisciplinaRepository;

@FacesValidator("disciplinaValidator")
public class DisciplinaValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object obj) throws ValidatorException {
		String nome = (String) obj;
		if (DisciplinaRepository.contains(nome)) {
			FacesMessage msg = new FacesMessage("Nome de disciplina já existe", "Nome da disciplina já existe.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}
