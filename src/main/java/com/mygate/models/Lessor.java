package com.mygate.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Lessor {
	@Id
	private String homeNumber;
	private Person lessor;
	private Address address;
	private Long contactNumber;
	private String mailId;
	private List<Person> familyMembers;
	private String password;
}
