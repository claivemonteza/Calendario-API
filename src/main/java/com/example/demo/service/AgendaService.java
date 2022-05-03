package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Agenda;
import com.example.demo.filebd.Ficheiro;

@Service
public class AgendaService {

	public void save(Agenda agenda) throws Exception {
		Ficheiro.writeTheFile(agenda);
	}
	
	public Agenda update(int id, String info) throws Exception {
		Agenda agenda = list().get(id - 1);
		Ficheiro.modifyDetails(agenda.getInformacao(), info);
		return list().get(id - 1);
	}

	public List<Agenda> list() throws Exception{
		return Ficheiro.readTheFile();
	}
	
	public List<Agenda> findByDate(Date date) throws Exception{
		return Ficheiro.readTheFile().stream().filter(a->a.getData().equals(date)).collect(Collectors.toList());
	}
	
	public void delete(int id) throws Exception {
		Agenda a = list().get(id - 1);
		Ficheiro.delete(a.getInformacao());
	}
}
