package n1_exercici5;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class App5 {

	Persona p1 = new Persona("Charly", "Garcia", 1);
	Persona p2 = new Persona("Luis", "Spineta", 2);
	Persona p3 = new Persona("Lio", "Messi", 10);
	ObjectOutputStream oos;
	FileOutputStream fos;
	FileInputStream fis;
	ObjectInputStream ois;
	List<Persona> arrayPersonas = new ArrayList<>();
	private static String file;
	
	public static void main(String[] args) {
		file = args[0];
		App5 app5 = new App5();
		app5.serializeObject();
		app5.deserializeObject();
	}
	
	public void serializeObject() {
		
		try {
//			fos = new FileOutputStream("src\\main\\java\\n1_exercici5\\personas.ser");
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(p1);
			oos.writeObject(p2);
			oos.writeObject(p3);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void deserializeObject() {
		
			try {
//				fis = new FileInputStream("src\\main\\java\\n1_exercici5\\personas.ser");
				fis = new FileInputStream(file);
				ois = new ObjectInputStream(fis);

				while(ois != null) {
					
					Persona personas = (Persona) ois.readObject();
					System.out.println(personas);
					
					}
			}catch (EOFException e) { 
				System.out.println("EOF reached succefully");
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	
}
