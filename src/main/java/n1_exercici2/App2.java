package n1_exercici2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class App2 {

	private File file;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		String path = args[0];
		App2 app2 = new App2();
		app2.listContent(path);
	}

	private void listContent(String path) {//, String slash) {

		file = new File(path);
		File[] files = file.listFiles();
		Arrays.sort(files);
		if (files == null) {
			System.out.println("directorio vac�o");
		}
		for (int i = 0; i < files.length; i++) {

			if (!files[i].getName().startsWith(".")) {
				if (!files[i].isDirectory()) {
					System.out.println(
							"  F: " + path + files[i].getName() + "  //  Created: " + sdf.format(files[i].lastModified()));
				}
				if (files[i].isDirectory()) {
					path = files[i].getPath();
					System.out.println("D: " + path + "  //  Created: " + sdf.format(files[i].lastModified()));
					listContent(path);
				}
			}
		}
	}
}