
import java.util.Scanner;
/**
 *
 * @author juan_
 */
public class Reto1Ciclo2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int tiempoViaje = 0;
       String esfera = "";
       System.out.println("ingrese una distancia");
       Scanner sc = new Scanner(System.in);
       int casaGoku = sc.nextInt();
       int proximaEsfera = distanciaALaProximaEsfera(casaGoku);
       int dViaje = duracionDelViaje(casaGoku, proximaEsfera);
       if (dViaje >= 0 && dViaje <= 20) {
           esfera = "uno";
       }
       else if (dViaje >= 21 && dViaje <= 30){
           esfera = "dos";
       }
       else if (dViaje >= 31 && dViaje <= 50){
           esfera = "tres";
       }
       else {
           esfera = "cuatro";
       }
        

       System.out.print(casaGoku +" "+ proximaEsfera +" "+ dViaje +" "+"\n"+ esfera);
    }
    
    public static int distanciaALaProximaEsfera(int distanciaCasaGoku){
        int proximaEsfera = distanciaCasaGoku * 2 + 4;
        return proximaEsfera;
    }
    public static int duracionDelViaje(int distanciaCasaGoku, int distanciaEsfera){
        int dViaje = (distanciaCasaGoku + distanciaEsfera) /5;
        return dViaje;
    }
}
