package com.example.demo.dto;

import java.util.Date;

import com.example.demo.domain.Agenda;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AgendaResponseDTO {

	@JsonFormat(pattern = "M/d/YYYY")
	private Date data;
	private String informacao;
	private int day;
	
	public AgendaResponseDTO(Agenda agenda){
		this.data = agenda.getData();
		this.informacao = agenda.getInformacao();
		this.day = agenda.getData().getDate();
	}
}
