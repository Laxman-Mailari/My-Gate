package com.mygate.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Guard {
	@Id
	private String guardId;
	private Person guard;
	private Address address;
	private Long contactNumber;
	private String mailId;
	private String password;
}
