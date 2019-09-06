package com.foo.myFinalApp;

import java.io.Serializable;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.util.Clients;

import com.foo.myFinalApp.entity.User;
import com.foo.myFinalApp.impl.AuthenticationServiceImpl;
import com.foo.myFinalApp.impl.UserInfoServiceImpl;
import com.foo.myFinalApp.utils.AuthenticationService;
import com.foo.myFinalApp.utils.CommonInfoService;
import com.foo.myFinalApp.utils.UserCredential;
import com.foo.myFinalApp.utils.UserInfoService;

public class ProfileViewModel implements Serializable {
	private static final long serialVersionUID = 1L;

	// services
	private AuthenticationService authService = new AuthenticationServiceImpl();
	private UserInfoService userInfoService = new UserInfoServiceImpl();

	// data for the view
	private User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}

	/**
	 * Retrieve all known country names.
	 * 
	 * @return a list of country name
	 */
	public List<String> getCountryList() {
		return CommonInfoService.getCountryList();
	}

	public ProfileViewModel() {
		UserCredential userCredential = authService.getUserCredential();
		currentUser = userInfoService.findUser(userCredential.getAccount());
		if (currentUser == null) {
			// TODO handle un-authenticated access
			return;
		}
	}

	@Command // @Command annotates a command method
	@NotifyChange("currentUser") // @NotifyChange annotates data changed notification after calling this method
	public void save() {
		currentUser = userInfoService.updateUser(currentUser);
		Clients.showNotification("Your profile is updated");
	}

	@Command
	@NotifyChange("currentUser")
	public void reload() {
		UserCredential cre = authService.getUserCredential();
		currentUser = userInfoService.findUser(cre.getAccount());
	}
}