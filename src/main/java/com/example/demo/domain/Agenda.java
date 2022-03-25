package com.example.demo.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {
	
	private Date data;
	
	private String informacao;

	@Override
	public String toString() {
		return data + "," + informacao;
	}
	
	
}
