package base;

import java.io.*;

public class EscribeFichero {
	FileWriter fichero = null;
	PrintWriter pw = null;
	
	public void guardar(String valor) {
		try {
			fichero = new FileWriter("C://Users//Windows left//Desktop//prueba.txt");
			pw = new PrintWriter(fichero);
			
			pw.write(valor);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}