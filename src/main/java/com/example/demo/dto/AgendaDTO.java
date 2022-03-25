package com.example.demo.dto;

import com.example.demo.domain.Agenda;
import com.example.demo.util.DateUtil;

import lombok.Data;

@Data
public class AgendaDTO {

	private String data;
	private String informacao;
	
	public Agenda toEntity() throws Exception {
		return new Agenda(DateUtil.parseString(data), informacao);
	}
}
