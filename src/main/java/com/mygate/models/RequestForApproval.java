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
public class RequestForApproval {
	@Id
	private String requestId;
	private String guardId;
	private String homeNumber;
	private Visitor visitor;
	private String date;
	private Boolean status;
}
