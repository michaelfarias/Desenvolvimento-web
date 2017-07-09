package br.ufc.crateus.web.application11.view.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.ufc.crateus.web.application11.model.Matricula;
import br.ufc.crateus.web.application11.repository.MatriculaRepository;

@FacesValidator("notaValidator")
public class NotaValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object obj) throws ValidatorException {
		Matricula matricula = (Matricula) obj;

		System.out.println(matricula);
		if (MatriculaRepository.contemNota(matricula)) {
			FacesMessage msg = new FacesMessage("O aluno já possui nota!", "");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}

}
