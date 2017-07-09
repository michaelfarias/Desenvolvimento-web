package br.ufc.crateus.web.application9.view.validador;

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
			
			char m = periodo.charAt(0);
			char c = periodo.charAt(1);
			char d = periodo.charAt(2);
			char u = periodo.charAt(3);
			char s = periodo.charAt(5);
			if (!(periodo.charAt(4) == '.') || m <= 48 || m > 57 || c < 48 || c > 57 || d < 48 || d > 57 || u < 48
					|| m > 57 || s < 49 || s > 50) {
				FacesMessage msg = new FacesMessage("Periodo inválido", "Formato de periodo inválido.");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}
		}

	}

}
