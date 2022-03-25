package com.example.demo.filebd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Agenda;
import com.example.demo.util.DateUtil;

public class File {

	public static void WriteOnTheFile(Agenda agenda) throws IOException {
		try (BufferedWriter buffer = new  BufferedWriter(new FileWriter("Agendamentos", true))) {
			buffer.write(agenda.toString());
			buffer.newLine();
			buffer.close();
		}
	}
	
	public static List<Agenda> readTheFile() throws Exception{
		List<Agenda> agendas = new ArrayList<>();
		FileReader file = new FileReader("Agendamentos");
		try (BufferedReader reader = new BufferedReader(file)) {
			String[] data = reader.readLine().split(",");
			int i = 1;
			do {
				Agenda agenda = new Agenda();
				agenda.setData(DateUtil.parseString(data[0]));
				agenda.setInformacao(data[1]);
				agendas.add(agenda);
				reader.readLine();
				i++;
			} while (i < data.length);

			reader.close();
			file.close();

		}
		return agendas;
		
	}
}
