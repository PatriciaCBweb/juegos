package juegos;

import java.util.Scanner;

public class Menu {
	//Definición variables
	private String titulo;
	private String [] opciones;
	private int eleccion=0;
	
	//Constructor vacío
	Menu(){	
	}
	
	//Constructor al que se le pasan las opciones
	Menu(String [] opc){
		int tam = opc.length;
		this.opciones = new String[tam]; //definimos 
		            //el tamaño del array para poder continuar
		for(int j=0;j<tam;j++) {
			this.opciones[j]=opc[j];
		}
	}

	//getters y setters
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String[] getOpciones() {
		return opciones;
	}

	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}

	public int getEleccion() {
		return eleccion;
	}

	public void setEleccion(int eleccion) {
		this.eleccion = eleccion;
	}
	
	//Mostra opciones
	public void mostrarMenu() {
		System.out.println(this.titulo); //titulo del menu
		System.out.println("-".repeat(this.titulo.length()+1)); //linea separación
		for(int j=0;j<this.opciones.length;j++) { //menu
			System.out.println((j+1)+".- "+this.opciones[j]);
		}//for
		System.out.println("0.- Salir\n");
	}
	
	//Elegir opción
	public int eligeOpcion() { //Aquí dentro filtros mejor
		int opc=0;
		boolean valido = false;
		Scanner sc = new Scanner (System.in);
		
		while(!valido) {
			System.out.print("Elige una opción: ");
			opc=sc.nextInt();
			//numeros = numero opciones
			if(opc>=0 && opc<=opciones.length) {
				valido = true;
				System.out.println();
			}else {
				System.out.println();
				System.out.println("Opción no válida");
				System.out.println();
			}
		}//while

		return opc;
	}
	
	public String MuestraLiteral(int opc) {
		if(opc==0) {
			return "Salir";
		}else {
			return this.opciones[opc-1];
		}
	}

}
