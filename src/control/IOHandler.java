package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import modelo.Libro;

public class IOHandler {

	public void writer(Object map, String ruta) {
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

	public Object reader(String ruta) {
		try {
			File toRead = new File(ruta);
			FileInputStream fis = new FileInputStream(toRead);
			ObjectInputStream ois = new ObjectInputStream(fis);

			Object mapInFile = ois.readObject();

			ois.close();
			fis.close();
			return mapInFile;
		} catch (Exception e) {
			System.out.println(e);
		}
		return new Object();
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
