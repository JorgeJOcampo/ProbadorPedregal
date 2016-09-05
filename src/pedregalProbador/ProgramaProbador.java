package pedregalProbador;

public class ProgramaProbador {
	

	public static void main(String[] args){
		try {
			System.out.println(probador());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public static boolean probador() throws Exception{
		
		String path="D:/11.Casa horizontal que entra vertical.out";
		ArchivoSalida archivoSalida= new ArchivoSalida(path);
		path="D:/11.Casa horizontal que entra vertical.in";
		ArchivoEntrada archivoEntrada= new ArchivoEntrada(path);
		String entra=archivoSalida.getEntra();
		
		int largoTerreno=archivoEntrada.getLargoTerreno();
		int anchoTerreno=archivoEntrada.getAnchoTerreno();

		int largoCasa=archivoEntrada.getLargoCasa();
		int anchoCasa=archivoEntrada.getAnchoCasa();
		
		boolean[][] terreno =archivoEntrada.crearTerrenoConPe�ascos(largoTerreno,anchoTerreno);
	
		
		/*for(int i=0;i<terreno.length;i++){
			for(int j=0;j<terreno[i].length;j++){
				System.out.print(terreno[i][j] + " ");
			}
			System.out.println("");
		}*/
	/*	System.out.println(entra);
		System.out.println("largo terreno: "+ largoTerreno);
		System.out.println("ancho terreno: "+ anchoTerreno);
		System.out.println("largo casa: "+ largoCasa);
		System.out.println("ancho casa: "+ anchoCasa);
		Pruebas feas parte I*/
		
		

		if(entra.toUpperCase().equals("SI")){
		 //si entra se crea;
			int posicionInicialXCasa=archivoSalida.getPosicionInicialXCasa();
			int posicionInicialYCasa=archivoSalida.getPosicionInicialYCasa();
			String orientacionDeLaPuerta=archivoSalida.obtenerOrientacion();
			
			/*System.out.println("posicion inicial x de la casa " + posicionInicialXCasa);
			System.out.println("posicion inicial y de la casa " + posicionInicialYCasa);
			System.out.println(orientacionDeLaPuerta);
			Pruebas feas parte II */
			 if(largoCasa<anchoCasa && (orientacionDeLaPuerta.equals("S")||orientacionDeLaPuerta.equals("N"))){ //la casa no se roto
				 return !hayPe�asco(posicionInicialXCasa,posicionInicialYCasa,largoCasa,anchoCasa,terreno);
			 }
			 if(largoCasa<anchoCasa &&(orientacionDeLaPuerta.equals("E")||orientacionDeLaPuerta.equals("O"))){//la casa se roto
				 return !hayPe�asco(posicionInicialXCasa,posicionInicialYCasa,anchoCasa,largoCasa,terreno);
			 }
			 
			 if(largoCasa>anchoCasa &&(orientacionDeLaPuerta.equals("E")||orientacionDeLaPuerta.equals("O"))){//la casa no se roto
				 return !hayPe�asco(posicionInicialXCasa,posicionInicialYCasa,largoCasa,anchoCasa,terreno);
			 }
			 
			 if(largoCasa>anchoCasa &&(orientacionDeLaPuerta.equals("S")||orientacionDeLaPuerta.equals("N"))){//la casa se roto
				 return !hayPe�asco(posicionInicialXCasa,posicionInicialYCasa,anchoCasa,largoCasa,terreno);
			 }
			 if(largoCasa==anchoCasa)
				 return !hayPe�asco(posicionInicialXCasa,posicionInicialYCasa,largoCasa,anchoCasa,terreno);
		}
		else {
			if((largoCasa>=largoTerreno && anchoCasa>=anchoTerreno)||(largoCasa>=anchoTerreno && anchoCasa>=largoTerreno)){
				return true;
			}
			//falta verificar si el largoCasa es mas largo que el anchoterreno y largoterreno y lo mismo con el anchocasa
			
			boolean entro=verificarSiCasaEntra(largoTerreno, anchoTerreno, largoCasa, anchoCasa, terreno);
			if(!entro){
				entro=verificarSiCasaEntra(largoTerreno, anchoTerreno, anchoCasa, largoCasa, terreno);
			}
			return !entro;
		}
		return false;
		
		
		
	}

	private static boolean verificarSiCasaEntra(int largoTerreno, int anchoTerreno, int largoCasa, int anchoCasa, boolean[][] terreno) {
        boolean hayPe�asco = true;
        for(int i=0;i<largoTerreno;i++){
 			for(int j=0;j<anchoTerreno;j++){
				if(i + largoCasa < terreno.length && j + anchoCasa < terreno[i].length){
//					while(!(terreno[deltaX][deltaY]) && (deltaX < i+anchoCasa)){
//						deltaY=j;
//						while(!(terreno[deltaX][deltaY]) && (deltaY < j+largoCasa-1)){
//							deltaY++;
//						}
//						deltaX++;
//					}
                    hayPe�asco = false;
                    for(int deltaX=i ; deltaX < largoCasa + i ; deltaX++){
                        for(int deltaY=j ; deltaY < anchoCasa + j ; deltaY++){
                            if(terreno[deltaX][deltaY]){
                                hayPe�asco = true;
                            }
                            if(hayPe�asco){
                                break;
                            }
                        }
                        if(hayPe�asco){
                            break;
                        }
                    }
                    if(!hayPe�asco){
                        return true;
                    }
				}
			}
		}
		return !hayPe�asco;
	}
	
	public static boolean hayPe�asco(int posicionInicialXCasa,int posicionInicialYCasa,int largoCasa,int anchoCasa,boolean[][] terreno) throws Exception{
		if(posicionInicialXCasa+largoCasa>terreno.length||posicionInicialYCasa+anchoCasa>terreno[0].length) {
			throw new Exception("Segmentation fault");
		}
		
		for(int i=posicionInicialXCasa;i<posicionInicialXCasa+largoCasa;i++){
			 for(int j=posicionInicialYCasa;j<posicionInicialYCasa+anchoCasa;j++){
				 if(terreno[i][j]){
					 return true;
				 }
			 }
		 }
		 return false;
	}
	
}

