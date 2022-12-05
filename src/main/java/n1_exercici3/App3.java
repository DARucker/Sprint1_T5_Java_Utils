package n1_exercici3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App3 {

	private File file;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static List<String> datosArchivo = new ArrayList<>();

	public static void main(String[] args) {
		String path = "C:\\Users\\Dario\\eclipse-workspace\\workspace 2022\\Katas";
		String slash = "\\";
		App3 app3 = new App3();
		app3.listContent(path, slash);
		app3.guardarArchivo(datosArchivo);
	}

	private void listContent(String path, String slash) {
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
							"  F: " + files[i].getName() + "  //  Created: " + sdf.format(files[i].lastModified()));
				}
				if (files[i].isDirectory()) {
					path = files[i].getPath();

					datosArchivo.add("D: " + path + "  //  Created: " + sdf.format(files[i].lastModified()));
					listContent(path, slash);
				}
			}
		}

	}

	public void guardarArchivo(List<String> datosArchivo) {
		String ruta = "C:\\Users\\Dario\\eclipse-workspace\\workspace 2022\\Sprint1_Tasca5_Java_Utils\\src\\main\\java\\n1_exercici3\\";
		File file = new File(ruta + "exercici3.txt");
		try {
			FileWriter fileWriter = new FileWriter(file);
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
