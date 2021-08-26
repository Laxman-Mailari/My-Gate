package com.mygate.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	private String location;
	private String city;
	private String state;
	private String country;
	private Long pincode;
}
