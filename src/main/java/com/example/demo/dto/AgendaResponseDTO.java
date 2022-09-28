package com.example.demo.dto;

import com.example.demo.domain.Agenda;
import com.example.demo.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AgendaResponseDTO {

	@JsonFormat(pattern = "EEE MMM dd yyyy")
	private String data;
	private String informacao;
	
	public AgendaResponseDTO(Agenda agenda){
		this.data = DateUtil.format(agenda.getData());
		this.informacao = agenda.getInformacao();
	}
}
