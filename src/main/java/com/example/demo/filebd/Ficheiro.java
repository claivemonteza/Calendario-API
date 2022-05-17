package com.example.demo.filebd;

import static com.example.demo.constants.ApiConstants.FILE_NAME;
import static com.example.demo.constants.ApiConstants.TEMP_FILE;

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

	public static void writeTheFile(Agenda agenda) throws IOException {
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
			buffer.write(agenda.toString());
			buffer.newLine();
			buffer.close();
		}
	}

	public static List<Agenda> readTheFile() throws Exception {
		List<Agenda> agendas = new ArrayList<>();
		FileReader file = new FileReader(FILE_NAME);

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

	public static void delete(int id) throws Exception {

		Agenda agenda = readTheFile().get(id - 1);

		File oldFile = new File(FILE_NAME);
		File newFile = new File(TEMP_FILE);

		String currentLine;
		String data[];

		try {
			FileWriter fw = new FileWriter(TEMP_FILE, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			FileReader fr = new FileReader(FILE_NAME);
			BufferedReader br = new BufferedReader(fr);

			while ((currentLine = br.readLine()) != null) {
				data = currentLine.split(",");
				if (!(data[1].equalsIgnoreCase(agenda.getInformacao()))) {
					pw.println(currentLine);
				}
			}

			pw.flush();
			pw.close();
			fw.close();
			bw.close();
			fr.close();
			br.close();

			oldFile.delete();
			File dump = new File(FILE_NAME);
			newFile.renameTo(dump);

		} catch (Exception e) {
		}
	}

	public static void modifyDetails(String removeTerm, String newInfo) {
		File oldFile = new File(FILE_NAME);
		File newFile = new File(TEMP_FILE);

		String currentLine;
		String data[];

		try {
			FileWriter fw = new FileWriter(TEMP_FILE, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			FileReader fr = new FileReader(FILE_NAME);
			BufferedReader br = new BufferedReader(fr);

			while ((currentLine = br.readLine()) != null) {
				data = currentLine.split(",");
				if (data[1].equalsIgnoreCase(removeTerm)) {
					pw.println(newInfo);
				} else {
					pw.println(currentLine);
				}
			}

			pw.flush();
			pw.close();
			fw.close();
			bw.close();
			fr.close();
			br.close();

			oldFile.delete();
			File dump = new File(FILE_NAME);
			newFile.renameTo(dump);

		} catch (Exception e) {
		}
	}

}
