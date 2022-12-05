package n1_exercici4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App4 {

	private FileReader fileReader;
	private BufferedReader bufferedReader;
	private String line;
	private String file = "file.txt";
	private String path = "src\\main\\java\\n1_exercici4\\";

	public static void main(String[] args) {

		App4 app4 = new App4();
		app4.readFile();
	}

	public void readFile() {

		try {

			fileReader = new FileReader(path + file);
			bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				if (!line.isEmpty()) {
					System.out.println(line);
				}

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
