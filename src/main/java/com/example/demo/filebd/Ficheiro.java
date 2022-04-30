package com.example.demo.filebd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.Agenda;
import com.example.demo.util.DateUtil;

public class Ficheiro {

	private static String fileName = "Agendamentos";
	private static String filePath = "Agendamentos.txt";
	
	public static void WriteOnTheFile(Agenda agenda) throws IOException {
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(fileName, true))) {
			buffer.write(agenda.toString());
			buffer.newLine();
			buffer.close();
		}
	}

	public static List<Agenda> readTheFile() throws Exception {
		List<Agenda> agendas = new ArrayList<>();
		FileReader file = new FileReader(fileName);

		try (BufferedReader reader = new BufferedReader(file)) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(",");
				Agenda agenda = new Agenda();
				agenda.setData(DateUtil.formatStringToDate(data[0]));
				agenda.setInformacao(data[1]);
				agendas.add(agenda);
			}
			reader.close();
			file.close();

		}
		return agendas;
	}

	public static void delete(String removeTerm, int positionOfTerm) {
		int position = positionOfTerm - 1;
		String tempFile = "temp.txt";
		File oldFile = new File(filePath);
		File newFile = new File(tempFile);
		
		String currentLine;
		String data[];
		
		try {
			FileWriter fw = new FileWriter(fileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			while ((currentLine = br.readLine()) != null) {
				data = currentLine.split(",");
				if(!(data[position].equalsIgnoreCase(removeTerm))) {
					pw.println(currentLine);
				}
			}
			
			pw.flush();
			pw.close();
			fr.close();
			br.close();
			bw.close();
			fw.close();
			
			oldFile.delete();
			File dump = new File(filePath);
			newFile.renameTo(dump);
					
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
