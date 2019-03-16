import java.util.ArrayList;
import java.util.Scanner;
import BUI.Envio;
import FAC.*;
import ITE.RepositorioReservaciones;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Bienvenido a esta paqueteria, ingrese su rfc");
		boolean flag = true;
		String rfc = input.next();
		PaqueteriaFacade fac = new PaqueteriaFacade(rfc);
		while(flag) {
			System.out.println("Seleccione una opcion del menu\n\t1) Añadir un envio\n\t2) Ver Envios\n\t3) Ver Costo actual\n\t4) Realizar el envio");
			switch(input.nextInt()) {
				case 1: //Añadir envio
					System.out.println("A donde desea hacer el envio:\n\t1) SONORA\n\t2) YUCATAN\n\t3) PACHUCA");
					int destino = input.nextInt();
					System.out.println("Cual es la direccion de recoleccion?");
					String recoleccion = input.next();
					System.out.println("Cual es el codigo postal de la direccion de recoleccion?");
					String codigopostal = input.next();
					System.out.println("Cuantos gramos pesa su paquete?");
					double gramos = input.nextDouble();
					System.out.println("Que tipo de paquete es?\n\t)1) Documento\n\t2) Caja");
					int tipo = input.nextInt();
					System.out.println("Es un paquete fragil?\n\t1) No \n\t) 2) Si");
					boolean fragil = (input.nextInt() - 1) != 0;
					System.out.println("Se requiere firma contra entrega?\n\t1) No \n\t 2) Si");
					boolean firma = (input.nextInt() - 1) != 0;
					System.out.println("Se puede dejar en su hogar sin ser atendido?\n\t1) No \n\t 2) Si");
					boolean atendido = (input.nextInt() - 1) != 0;
					fac.añadirEnvio(destino, recoleccion, codigopostal, gramos, tipo, fragil, firma, atendido);
					break;
				case 2: //Ver envios
					System.out.println(fac.verEnvios());
					break;
				case 3: //Ver costo actual
					System.out.println("El costo hasta ahora es de: $"+fac.verCostoFinal()+" MXN");
					break;
				case 4: // Realizar el envio
					fac.realizarEnvio();
					flag = false;
					System.out.println("\nGracias por realizar sus envios en nuestra paqueteria");
					break;
				default:
					break;
			}
		}
	}
}
