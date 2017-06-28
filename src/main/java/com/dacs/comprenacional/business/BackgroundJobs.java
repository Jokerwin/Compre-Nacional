package com.dacs.comprenacional.business;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dacs.comprenacional.business.service.LoginTokenService;

@Singleton
public class BackgroundJobs {

	@PersistenceContext
	private EntityManager Manager;

	@Inject
	private LoginTokenService loginTokenService;

	@Schedule(dayOfWeek = "*", hour = "*", minute = "0", second = "0", persistent = false)
	public void hourly() {
		loginTokenService.removeExpired();
	}

}