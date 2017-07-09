package br.ufc.crateus.web.application11.view.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("periodoValidator")
public class PeriodoValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object object) throws ValidatorException {
		String periodo = (String) object;
		if (periodo.length() != 6) {
			FacesMessage msg = new FacesMessage("Periodo inválido", "Formato de periodo inválido.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

		else {
			System.out.println(periodo.matches("[1-2][0-9][0-9][0-9].[1-2]"));

			if (!periodo.matches("[1-2][0-9][0-9][0-9].[1-2]")) {
				FacesMessage msg = new FacesMessage("Periodo inválido", "Formato de periodo inválido.");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}
		}

	}

}
