package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import modelo.Libro;

public class IOHandler implements Serializable{

	public void writer(HashMap<String, Libro> map, String ruta) {
		try {
			File toWrite = new File(ruta);
			FileOutputStream fos = new FileOutputStream(toWrite);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(map);
			oos.flush();
			oos.close();
			fos.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public HashMap<String, Libro> reader(String ruta) {
		try {
			File toRead = new File(ruta);
			FileInputStream fis = new FileInputStream(toRead);
			ObjectInputStream ois = new ObjectInputStream(fis);

			HashMap<String, Libro> mapInFile = (HashMap<String, Libro>) ois.readObject();

			ois.close();
			fis.close();
			return mapInFile;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void deleter(String ruta) {
		try {
			File toDelete = new File(ruta);
			toDelete.delete();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
