package io.mrth.cdi.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.Dependent;

@Dependent
public class UserAuthService {
	private static final Logger LOG = LoggerFactory.getLogger(UserAuthService.class);

	public boolean authenticate(String username, String password) {
		return username.equals("admin") && password.equals("Password1");
	}
}
