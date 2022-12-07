package n3_exercici1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReaderAndWriter {

	StringBuilder sb;
	private String path = "src\\main\\java\\n3_exercici1\\";
	private String line;
	private String fileRead;
	
	public String readFile(String fileToRead) {
    	try {
    		sb = new StringBuilder();
    		FileReader fileReader = new FileReader(path + fileToRead);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				if (!line.isEmpty()) {
					fileRead = sb.append(line).toString();
				}
			}
    	} catch (Exception e) {
			e.printStackTrace();
		}
		return fileRead;    	
    }
	
	public void saveFile(String encriptedText, String nombreArchivo) {
		 
		File file = new File(path + nombreArchivo);
		try {
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(encriptedText);
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
