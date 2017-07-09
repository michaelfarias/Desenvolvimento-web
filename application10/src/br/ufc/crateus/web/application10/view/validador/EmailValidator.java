package br.ufc.crateus.web.application10.view.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object object) throws ValidatorException {
		String email = (String) object;

		if (!email.matches("\\w+@\\w+.\\w+.\\w+") && !email.matches("\\w+@\\w+.\\w+")) {
			FacesMessage msg = new FacesMessage("E-mail invalido.", "Formato de email inválido.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}

}
