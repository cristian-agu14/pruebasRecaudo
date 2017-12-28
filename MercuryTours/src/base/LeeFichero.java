package base;

import java.io.*;

public class LeeFichero {
	private File archivo = null;
	FileReader fr = null;
	BufferedReader br = null;

	private String numeroCaja = "";

	@SuppressWarnings("finally")
	public String leer() {
		String linea = "";

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("C://Users//Windows left//Desktop//prueba.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			// while ((linea = br.readLine()) != null)
			// //numeroCaja = linea;
			// System.out.println("------------------>" + linea + "<---------------------");
			// //return linea;

			linea = br.readLine();
			System.out.println("------------------>" + linea + "<---------------------");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			return linea;
		}

	}

	public String getNumeroCaja() {
		return numeroCaja;
	}

	public void setNumeroCaja(String numeroCaja) {
		this.numeroCaja = numeroCaja;
	}

}