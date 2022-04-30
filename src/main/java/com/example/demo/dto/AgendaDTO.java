package com.example.demo.dto;

import javax.validation.constraints.NotBlank;

import com.example.demo.domain.Agenda;
import com.example.demo.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AgendaDTO {

	@NotBlank(message = "Please enter a Date (yyyy-MM-dd)")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String data;
	@NotBlank(message = "Please enter a Information")
	private String informacao;
	
	public Agenda toEntity() throws Exception {
		return new Agenda(DateUtil.formatStringToDate(data), informacao);
	}
}
