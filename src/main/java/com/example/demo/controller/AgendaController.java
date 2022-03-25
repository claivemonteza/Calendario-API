package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Agenda;
import com.example.demo.dto.AgendaDTO;
import com.example.demo.service.AgendaService;


@RestController
@RequestMapping(value="api/v1")
public class AgendaController {

	@Autowired
	AgendaService agendaService;
	
	@GetMapping(value="/marcacao")
	public List<Agenda> list() throws Exception {
		return agendaService.list();
	}
	
	@PostMapping(value="/marcacao/save")
	public void save(@RequestBody AgendaDTO dto) throws Exception {
		agendaService.save(dto.toEntity());
	}
}
