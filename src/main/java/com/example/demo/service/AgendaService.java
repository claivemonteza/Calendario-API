package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Agenda;
import com.example.demo.filebd.File;

@Service
public class AgendaService {

	public void save(Agenda agenda) throws Exception {
		File.WriteOnTheFile(agenda);
	}

	public List<Agenda> list() throws Exception{
		return File.readTheFile();
	}
}
