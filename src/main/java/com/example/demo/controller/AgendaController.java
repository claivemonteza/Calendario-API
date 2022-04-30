package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Agenda;
import com.example.demo.dto.AgendaDTO;
import com.example.demo.service.AgendaService;
import com.example.demo.util.DateUtil;


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
	
	@PutMapping(value="/authors/update/{id}")
	public Agenda update(@RequestBody AgendaDTO dto,@PathVariable("id") Long id) {
		return null;
	}
	
	@DeleteMapping(value="/marcacao/delete/{id}")
	public void delete(@PathVariable("id") int  id) {
		
	}
	
	@GetMapping(value="/marcacao/byDate/{date}")
	public List<Agenda> list(@PathVariable("date") String date) throws Exception{
		return agendaService.findByDate(DateUtil.formatStringToDate(date));
	}
}
