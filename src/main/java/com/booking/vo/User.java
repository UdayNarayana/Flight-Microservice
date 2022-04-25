package com.booking.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String userType;
	private String email;
	private String password;
	private String gender;
	private int age;
	private long mobileNo;
	private String address;
}
