package pedregalProbador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ArchivoSalida {
	private Scanner salida;
	public ArchivoSalida(String path) throws FileNotFoundException{
		salida= new Scanner(new File(path));
	}

	public String getEntra() throws IOException {
		return salida.nextLine();
	}
	public int getPosicionInicialXCasa() throws IOException{
		return  salida.nextInt()-1;
	}
	public int getPosicionInicialYCasa() throws IOException{
		
		return salida.nextInt() -1;
	}

	public String obtenerOrientacion() throws IOException {
		salida.nextLine();
		return salida.nextLine();
	}
	
	
}
