package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Agenda;
import com.example.demo.dto.AgendaDTO;
import com.example.demo.dto.AgendaResponseDTO;
import com.example.demo.dto.MarcacaoDTO;
import com.example.demo.service.AgendaService;
import com.example.demo.util.DateUtil;

@RestController
@RequestMapping(value = "api/v1")
public class AgendaController {

	@Autowired
	AgendaService agendaService;

	@GetMapping(value = "/marcacao")
	public List<AgendaResponseDTO> list() throws Exception {
		Set<Date> datas =  agendaService.list().stream().map(a->a.getData()).collect(Collectors.toSet());
		List<AgendaResponseDTO> dtos = new ArrayList<>();
		for (Date date : datas) {
			List<String> informacoes =  agendaService.list().stream().filter(
					a-> a.getData().equals(date)
				).map(a->a.getInformacao()).collect(Collectors.toList());	
			dtos.add(new AgendaResponseDTO(date, informacoes));
		}
		return dtos;
	}

	@PostMapping(value = "/marcacao/save")
	public ResponseEntity<Agenda> save(@RequestBody AgendaDTO dto) throws Exception {
		Agenda newAgenda = agendaService.save(dto.toEntity());
		return ResponseEntity.status(HttpStatus.CREATED).body(newAgenda);
	}

	@PutMapping(value = "/marcacao/update")
	public Agenda update(@RequestBody MarcacaoDTO dto) throws Exception {
		return agendaService.update(dto.getId(), dto.toEntity().toString());
	}

	/*@GetMapping(value = "/marcacao/delete/{id}")
	public void delete(@PathVariable("id") int id) throws Exception {
		agendaService.delete(id);
	}*/
	
	@DeleteMapping(value = "/marcacao/deleteInfo/{date}")
	public void delete(@PathVariable("date") String data, @RequestParam("information") String informacao ) throws Exception {
		agendaService.delete(DateUtil.formatStringToDate(data), informacao);
	}

	@GetMapping(value = "/marcacao/byDate/{date}")
	public List<Agenda> list(@PathVariable("date") String date) throws Exception {
		return agendaService.findByDate(DateUtil.formatStringToDate(date));
	}

}
