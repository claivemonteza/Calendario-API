package com.example.demo.dto;

import java.util.Date;

import com.example.demo.domain.Agenda;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AgendaResponseDTO {

	@JsonFormat(pattern = "EEE MMM dd YYYY")
	private Date data;
	private String informacao;
	
	public AgendaResponseDTO(Agenda agenda){
		this.data = agenda.getData();
		this.informacao = agenda.getInformacao();
	}
}
