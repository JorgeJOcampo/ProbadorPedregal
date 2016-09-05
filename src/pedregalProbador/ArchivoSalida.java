package pedregalProbador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ArchivoSalida {
/*	private File archivoSalida;
	private FileReader reader;
	private BufferedReader buffer;
*/	
	private Scanner salida;
	public ArchivoSalida(String path) throws FileNotFoundException{
		/*archivoSalida=new File(path);
		reader=new FileReader(archivoSalida);
		buffer=new BufferedReader(reader);
		*/
		salida= new Scanner(new File(path));
	}

	public String getEntra() throws IOException {
		//return buffer.readLine();
		return salida.nextLine();
	}
	public int getPosicionInicialXCasa() throws IOException{
		//return buffer.read()-1;
		return  salida.nextInt()-1;
	}
	public int getPosicionInicialYCasa() throws IOException{
		
		//return  buffer.read()-1;
		return salida.nextInt() -1;
	}

	public String obtenerOrientacion() throws IOException {
		salida.nextLine();
		return salida.nextLine();
	}
	
	
}
