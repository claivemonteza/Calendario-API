package com.example.demo.dto;

import com.example.demo.domain.Agenda;
import com.example.demo.util.DateUtil;

import lombok.Data;

@Data
public class AgendaResponseDTO {

	
	private String data;
	private String informacao;
	private int day;
	
	@SuppressWarnings("deprecation")
	public AgendaResponseDTO(Agenda agenda){
		this.data = DateUtil.format(agenda.getData());
		this.informacao = agenda.getInformacao();
		this.day = agenda.getData().getDate();
	}
}
