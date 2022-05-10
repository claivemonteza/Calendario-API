package com.example.demo.domain;

import java.util.Date;

import com.example.demo.util.DateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {
	
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private Date data;
	
	private String informacao;

	@Override
	public String toString() {
		return DateUtil.format(data) + "," + informacao;
	}
	
	
}
