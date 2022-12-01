package com.example.demo.dto;

import java.util.Date;
import java.util.List;

import com.example.demo.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class AgendaResponseDTO {

	@JsonFormat(pattern = "EEE MMM dd yyyy")
	private String data;
	private List<String> informacoes;
	
	public AgendaResponseDTO(Date date, List<String> informacoes){
		this.data = DateUtil.format(date);
		this.informacoes = informacoes;
	}
	
}
