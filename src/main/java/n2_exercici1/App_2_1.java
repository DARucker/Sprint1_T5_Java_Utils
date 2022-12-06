package n2_exercici1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class App_2_1 {

	private File file;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static List<String> datosArchivo = new ArrayList<>();
    static Properties properties= new Properties();
	
	public static void main(String[] args) {

	    try {
	        properties.load(new FileInputStream(new File("C:\\Users\\Dario\\eclipse-workspace\\workspace 2022\\Sprint1_Tasca5_Java_Utils\\src\\main\\java\\n2_exercici1\\configuration.properties")));
	        
	        System.out.println(properties.get("path"));
	        System.out.println(properties.get("file"));
	        
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
		String path = (String) properties.get("path");		
		App_2_1 app = new App_2_1();
		app.listContent(path);
		app.guardarArchivo(datosArchivo);
	}

	private void listContent(String path) {
		file = new File(path);
		File[] files = file.listFiles();
		Arrays.sort(files);
		if (files == null) {
			System.out.println("directorio vacío");
		}
		for (int i = 0; i < files.length; i++) {

			if (!files[i].getName().startsWith(".")) {
				if (!files[i].isDirectory()) {
					datosArchivo.add(
							"  F: "+ files[i].getAbsolutePath() + "(Created: " + sdf.format(files[i].lastModified()) + ")");
				}
				if (files[i].isDirectory()) {
					path = files[i].getPath();

					datosArchivo.add("D: " + files[i].getAbsolutePath() + "(Created: " + sdf.format(files[i].lastModified()) + ")");
					listContent(path);
				}
			}
		}

	}

	public void guardarArchivo(List<String> datosArchivo) {
 
		String ruta = (String) properties.get("pathfile");
		String archivo = (String) properties.get("file");		

		File f = new File(ruta + archivo);
		try {
			FileWriter fileWriter = new FileWriter(f);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (String s : datosArchivo) {
				bufferedWriter.write(s + "\n");
			}
			bufferedWriter.close();
			System.out.println("Archivo guardado.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
