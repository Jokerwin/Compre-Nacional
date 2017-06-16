package com.dacs.comprenacional.view.validator;

import static org.omnifaces.util.Messages.createError;

import java.util.Optional;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import com.dacs.comprenacional.business.service.UserService;
import com.dacs.comprenacional.model.User;

@FacesValidator("emailVerifiedValidator")
public class EmailVerifiedValidator implements Validator {

	@Inject
	private UserService userService;

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (value == null) {
			return;
		}

		Optional<User> user = userService.getByEmail((String) value);

		if (user.isPresent() && !user.get().isEmailVerified()) {
			throw new ValidatorException(createError("emailVerifiedValidator"));
		}
	}

}