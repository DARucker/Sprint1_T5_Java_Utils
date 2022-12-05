package n1_exercici1;

import java.io.File;
import java.util.Arrays;

public class App {

	File file;

	public static void main(String[] args) {
		String path = "C:\\Users\\Dario\\eclipse-workspace\\workspace 2022";
		App app = new App();
		app.listContent(path);
	}

	private void listContent(String path) {

		file = new File(path);
		System.out.println("Contenido del directorio: ");
		System.out.println(file.getAbsolutePath()  + "\r\n");
		String[] files = file.list();
		Arrays.sort(files);
		if (files == null) {
			System.out.println("directorio vacío");
		}
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);

		}
		

		
	}		
}

