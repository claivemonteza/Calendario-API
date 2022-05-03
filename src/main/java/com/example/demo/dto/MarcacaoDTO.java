package com.example.demo.dto;

import java.util.Date;

import com.example.demo.domain.Agenda;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MarcacaoDTO {
	
	private int id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date data;

	private String informacao;

	public Agenda toEntity(){
		return new Agenda(data, informacao);
	} 
	
	public String toString() {
		return data + "," + informacao;
	}
}
