package com.dacs.comprenacional.model;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.toList;
import static com.dacs.comprenacional.model.Role.ACCESS_API;
import static com.dacs.comprenacional.model.Role.EDIT_OWN_PROFILE;
import static com.dacs.comprenacional.model.Role.EDIT_PROFILES;
import static com.dacs.comprenacional.model.Role.VIEW_ADMIN_PAGES;
import static com.dacs.comprenacional.model.Role.VIEW_USER_PAGES;

import java.util.Arrays;
import java.util.List;

public enum Group {

	USER(VIEW_USER_PAGES, EDIT_OWN_PROFILE, ACCESS_API),

	ADMIN(VIEW_ADMIN_PAGES, EDIT_PROFILES);

	private final List<Role> roles;

	private Group(Role... roles) {
		this.roles = unmodifiableList(asList(roles));
	}

	public List<Role> getRoles() {
		return roles;
	}

	public static List<Group> getByRole(Role role) {
		return Arrays.stream(values())
		             .filter(group -> group.getRoles().contains(role))
		             .collect(toList());
	}

}