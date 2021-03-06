package com.dacs.comprenacional.view.auth;

import static javax.security.authentication.mechanism.http.AuthenticationParameters.withParams;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.identitystore.credential.UsernamePasswordCredential;

import org.omnifaces.cdi.Param;

@Named
@RequestScoped
public class LoginBacking extends AuthBacking {

	@Inject @Param(name = "continue") // Defined in @LoginToContinue of KickoffFormAuthenticationMechanism.
	private boolean loginToContinue;

	public void login() throws IOException {
		authenticate(withParams()
			.credential(new UsernamePasswordCredential(user.getEmail(), password))
			.newAuthentication(!loginToContinue)
			.rememberMe(rememberMe));
	}

}