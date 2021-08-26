package com.mygate.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor {

	private String name;
	private String adharNumber;
	private String vehicleNumber;
	private String details;
}
