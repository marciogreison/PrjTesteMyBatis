package com.estudos.java.marcioazevedo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
	private Integer id;
	private String name;
	private String city;
	private String email;
	private String phone;
}
