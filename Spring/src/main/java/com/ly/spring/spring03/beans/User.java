package com.ly.spring.spring03.beans;

/*
* @Component：基本注解，标识一个受Spring管理的组件
* @Repository：标识持久层组件
* @Service：标识服务层（业务层）组件
* @Controller：标识控制层（表现层）组件
*/

import org.springframework.stereotype.Component;

@Component
public class User {

	private Integer id;
	private String username;
	private String password;
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}

}
