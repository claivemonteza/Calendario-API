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
		Ficheiro.WriteOnTheFile(agenda);
	}

	public List<Agenda> list() throws Exception{
		return Ficheiro.readTheFile();
	}
	
	public List<Agenda> findByDate(Date date) throws Exception{
		return Ficheiro.readTheFile().stream().filter(a->a.getData().equals(date)).collect(Collectors.toList());
	}
}
