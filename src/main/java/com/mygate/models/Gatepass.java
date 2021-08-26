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
public class Gatepass {

	@Id
	private String gatepassId;
	private String homeNumber;
	private List<Person> visitor;
	private String comment;
	private String date;
}
