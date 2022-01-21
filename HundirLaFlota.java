import java.util.Scanner;

public class HundirLaFlota {
	//Declaración de variables tipo final
	public static final char AGUA='A', AGUA_NO_TOCADO='.',TOCADO='X';
	public static final int TAMANIO=10;
	public static Scanner dato= new Scanner(System.in);
	
	public static void main(String[] args) {
		//Declaración de variables locales al main()
		int puntosJugador, puntosOrdenador;
		puntosJugador=puntosOrdenador=24;
		boolean juegoTerminado=false, tiroCorrecto=false;
		
		//Declaración de arrays
		char [][] mapaUsuario = new char[TAMANIO][TAMANIO];
		char [][] mapaOrdenador = new char[TAMANIO][TAMANIO];
		char [][] mapaOrdenadorParaUsuario = new char[TAMANIO][TAMANIO];
		int [] disparo = new int[2];
		
		//Inicializar mapas y registrar barcos
		inicializacionMapa(mapaUsuario);
		inicializacionMapa(mapaOrdenador);
		inicializacionMapa(mapaOrdenadorParaUsuario);
				
		registrarBarcos(mapaUsuario);
		registrarBarcos(mapaOrdenador);
		
		imprimirMapa("MAPA USUARIO",mapaUsuario);
		imprimirMapa("MAPA ORDENADOR",mapaOrdenador);
		imprimirMapa("MAPA ORDENADOR PARA USUARIO",mapaOrdenadorParaUsuario);
		
		while(!juegoTerminado) {
			//Dispara usuario
			if(puntosJugador!=0) { 
				//Dispara Ordenador
			}
		}		
	}
	
	public static void inicializacionMapa(char [][] m) {
		for (int f = 0; f < m.length; f++) {
			for (int c = 0; c < m[f].length; c++) {
				m[f][c]	= AGUA_NO_TOCADO;		
			}
		}		
	}
	
	public static void imprimirMapa(String titulo,char [][] m) {
		//char[] letrasCabecera = {'A','B','C',    }
		//Crear vector con las letras de las cabeceras de filas
		char[] letrasCabecera = new char[TAMANIO];
		for (int i = 0; i < TAMANIO; i++) {
			letrasCabecera[i]=(char)('A'+ i);			
		}
		
		//Visualizar el Array
		//Imprimir la 1ª linea de cabecera
		System.out.print("\n"+titulo+"\n    ");
		for (int i = 0; i <TAMANIO; i++) {
			System.out.printf("[%1d] ",i);			
		}
		
		
				
		//Imprimir contenido del array
		for (int i = 0; i <m.length; i++) {
			System.out.printf("\n[%s] ",letrasCabecera[i]);	
			for (int j = 0; j <m[i].length; j++) {
				System.out.printf(" %S  ",m[i][j]);				
			}			
		}		
	}
	
	public static void registrarBarcos(char [][] m) {
		//Declaración de vectores locales al método
		int[] barcos = {5,5,3,3,3,1,1,1,1,1};
		char[] direccion = {'V','H'};
		boolean colocado;
		int fila,columna,dir;
		
		for (int tamanioBarco : barcos) {
			colocado=false;
			while(!colocado) {
				//Generar coordenadas y dirección aleatoriamente
				fila=(int)(Math.random()*TAMANIO);
				columna=(int)(Math.random()*TAMANIO);
				dir=(int)(Math.random()*2);
				
				//Comprobar si el barco cabe a partir de esas coordenadas
				if((direccion[dir]=='V' && (fila+tamanioBarco)<TAMANIO) || (direccion[dir]=='H' && (columna+tamanioBarco)<TAMANIO)) {
					//Comprobar si el barco no choca con otro ya colocado
					boolean vacio=true;
					if (direccion[dir]=='V') {
						int f=0;
						while (f<tamanioBarco && vacio) {
							if(m[fila+f][columna]!=AGUA_NO_TOCADO) vacio=false;								
							else f++;							
						}						
					} else {
						int c=0;
						while (c<tamanioBarco && vacio) {
							if(m[fila][columna+c]!=AGUA_NO_TOCADO) vacio=false;								
							else c++;							
						}					
					}
					if(vacio) {
						//Colocar el barco en estas coordenadas
						for (int i = 0; i < tamanioBarco; i++) {
							if (direccion[dir]=='V') m[fila+i][columna]=Integer.toString(tamanioBarco).charAt(0);	
							else  m[fila][columna+i]=Integer.toString(tamanioBarco).charAt(0);
						}
						colocado=true;						
					}				
				}			
			}
		}
	}
}
