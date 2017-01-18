package com.gmail.yoshzawa.h28jk3aopenidtest.ofy;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

public class UserAccount {
	@Id
	private Long id;
	private String email;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public UserAccount(String email){
		setEmail(email);
	}
	
	public void ofyInit(){
		ObjectifyService.register(UserAccount.class);
	}
	
	

}
