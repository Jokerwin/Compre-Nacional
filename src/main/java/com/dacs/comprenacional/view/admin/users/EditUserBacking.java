package com.dacs.comprenacional.view.admin.users;

import static org.omnifaces.util.Faces.redirect;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.dacs.comprenacional.business.service.UserService;
import com.dacs.comprenacional.model.User;
import org.omnifaces.cdi.Param;

@Named
@RequestScoped
public class EditUserBacking {

	@Inject @Param(name="id")
	private User user;

	@Inject
	private UserService userService;

	public void save() throws IOException {
		userService.update(user);
		redirect("admin/users");
	}

	public User getUser() {
		return user;
	}

}