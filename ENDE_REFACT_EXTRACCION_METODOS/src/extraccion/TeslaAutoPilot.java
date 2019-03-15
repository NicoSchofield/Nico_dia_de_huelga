package extraccion;
import java.io.IOException;

/**
 * Nuestra empresa ha sido elegida para pasar el código del gran Nicola Tesla (que de lo viejo que es programa en linea de comandos)
 * a el nuevo coche Tesla Roadster v360, toda una máquina que da toda suerte de respuestas por interfaz gráfico.
 * Evidentemente nuestra clase quee estaba pensada para usar y abusar de println debe pasar a un interfaz gráfico, pero queremos
 * conservar su funcionalidad.
 * Su misión, si la acepta, es extrar todos los métodos relevantes para que el diseñador de interfaz pueda mostrar los diferentes gráficos
 * Si encuentras alguna constante para extraer, hazlo.
 * Adicionalmeente se pide usar javaDoc para comentar los nuevos procedimientos y realizar al menos dos pruebas JUnit
 * @author idela
 *
 */

/**
 * 
 * @version v1 2019
 * @author Nico Schofield
 * */
public class TeslaAutoPilot {
	private static int numeroDePasajeros = 4; //cantidad de pasajeros que son admisibles
	
	/**Valida la opcion de menu str
	 * @param str
	 * @author Nico Schofield
	 * @since 2018
	 * @return devuelve un int opcionDelMenu
	 * */
	public static int validarOpcion(StringBuffer str) {
		String opcionDelMenuLeida = str.toString();
	    opcionDelMenuLeida= opcionDelMenuLeida.substring(0,1);
	    
	    int opcionDelMenu=0000;
		try {
			opcionDelMenu = Integer.valueOf(opcionDelMenuLeida);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Nada puedo hacer si no metes un número");
		}
		return opcionDelMenu;
	}

	/**Lee la opcion de menu introducida por el usuario
	 * @param nada
	 * @author Nico Schofield
	 * @since 2018
	 * @return devulve un StringBuffer con la opcion leida
	 * */
	public static StringBuffer leerOpcion() {
		//Creo un menu cutre para pedirle al usuario una opcion
		System.out.println("Elige un número entre el 1 y el 6 y pulsa ENTER");
		
		//leo la opcion por linea de comando
		StringBuffer str = new StringBuffer();
	    char c;
	    try{
	        while ((c=(char)System.in.read())!='\n'){
	            str.append(c);
	        }
	    }catch(IOException ex){}
	    //saco lo leido
		System.out.print("Lo leido es ");
	    System.out.println(str);
		return str;
	}

	/**En base a la opcion de menu validada ejecuta un metodo u otro
	 * @param opcionDelMenu un numerico del 1 al 6
	 * @author Nico Schofield
	 * @since 2018
	 * @return void
	 * */
	public static void menuSwitch(int opcionDelMenu) {
		switch(opcionDelMenu) {

	    case 1:
	    {
	    	System.out.print("Zona 1 Cálculo del ángulo de giro = ");
		    double resultadoDelGiro = giroResultante();
		    System.out.println(resultadoDelGiro);
		    
	    }
	    break;
	    case 2:
	    {
	    	System.out.print("Zona 2 Cálculo del area que de aparcamiento = ");
		    int areaAOcupar = areaOcuparResultante();
		    System.out.println(areaAOcupar);
	    }
	    break;
	    case 3:
	    {
	    	System.out.print("Zona 3 Volumen de las ruedas = ");
	    	double volumenDeRueda = volumenRuedaResultante();
		    System.out.println(volumenDeRueda);
	    }
	    break;
	    case 4:
	    {
	    	System.out.print("Zona 4 Cáculo de energía potencial = ");
	    	double potencial = potencialResultado();
	    	System.out.println(potencial);
	    }
	    break;
	    case 5:
	    {
	    	System.out.print("Zona 5 Cálculo de energía de impacto Airbag Cortina =  ");
	    	double impacto = impactoResultado();
	    	System.out.println(impacto);
	    }
	    break;
	    case 6:
	    {
	    	System.out.print("Zona 6 Cantidad de pasajeros =  ");
		    System.out.println(numeroDePasajeros);
	    }	   
	    break;
	    
	    default:
	    	System.out.println("Eso no es una opcion valida, me voy!!!");
	    
	    }// fin de switch
	}
	/**
	 * @since 2018
	 * @return void
	 * @author Nico Schofield
	 */
	public static double impactoResultado() {
		double pesoAirbag = 200;
		double distanciaDeLaCabeza = 12;
		double impacto = pesoAirbag * distanciaDeLaCabeza * 9.8; // Energia potencial total al caer de un bordillo
		return impacto;
	}
	/**Devuelve un double resultado de multiplicar masaVehiculo*alturaBordillo*9.8
	 * @since 2018
	 * @return double
	 * @author Nico Schofield
	 */
	public static double potencialResultado() {
		double masa = 2000;
		double alturaDelBordillo = 12;
		double potencial = masa * alturaDelBordillo * 9.8; // Energia potencial total al caer de un bordillo
		return potencial;
	}
	/**Devuelve un double resultado de multiplicar PI *radioRueda^2*anchoDeRueda
	 * @since 2018
	 * @return double
	 * @author Nico Schofield
	 */
	public static double volumenRuedaResultante() {
		double radioRueda = 42.3;  // cm  de radio
		double anchoDeRueda = 3.4; // varia según el modelo
		double volumenDeRueda;
		volumenDeRueda = 3.14 * radioRueda * radioRueda * anchoDeRueda;
		return volumenDeRueda;
	}
	/**Devuelve un int areaAOcupar resultado de 
	 * multiplicar la longitud del vehiculo por 
	 * la profundidad del vehiculo (el area a ocupar) 
	 * @since 2018
	 * @return double
	 * @author Nico Schofield
	 */
	public static int areaOcuparResultante() {
		int longitud = 4; //es el valor de el sensor de aparcamiento, otras veces vale otro número
		int profundidad = 4;
		int areaAOcupar = longitud * profundidad;
		return areaAOcupar;
	}
	/**Devuelve un double resultado de multiplicar PI por el radio del giro
	 * @since 2018
	 * @return int
	 * @author Nico Schofield
	 */
	public static double giroResultante() {

		double radioDeGiro = 4.3;  // metros a girar
		double resultadoDelGiro = 0; //inicialización
		resultadoDelGiro = 3.14 * radioDeGiro;
		return resultadoDelGiro;
	}

	/**Metodo main que lee la opcion que desea el usuario 
	 * y llama al metodo menu switch para que ejecute la accion
	 * @see leerOpcion validarOpcion menuSwitch
	 * @param no utiliza parametros de entrada
	 * */
	
	public static void main(String[] args) {
		
		
		StringBuffer str = leerOpcion();
	    
	    int opcionDelMenu = validarOpcion(str);
	    
	    menuSwitch(opcionDelMenu);

	}
}
