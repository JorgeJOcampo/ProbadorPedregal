package pedregalProbador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArchivoEntrada {
	private Scanner entrada;
	
	public ArchivoEntrada(String path) throws FileNotFoundException{
		entrada= new Scanner(new File(path));
	}

	public int getLargoTerreno() {
		return entrada.nextInt();
	}

	public int getAnchoTerreno() {
		return entrada.nextInt();
	}

	public int getAnchoCasa() {
		return entrada.nextInt();
	}

	public int getLargoCasa() {
		return entrada.nextInt();
	}

	public boolean[][] crearTerrenoConPeniascos(int largoTerreno, int anchoTerreno) {
		boolean[][] terreno= new boolean[largoTerreno][anchoTerreno];
		for(int i=0;i<largoTerreno;i++){
			for(int j=0;j<anchoTerreno;j++){
				terreno[i][j]=false;
			}
		}
		int cantidadDePeniascos=entrada.nextInt();
		for(int i=0;i<cantidadDePeniascos;i++)
		{
			terreno[entrada.nextInt()-1][entrada.nextInt()-1]=true;
		}
		return terreno;
	}
	
}
