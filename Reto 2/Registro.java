

import java.util.Scanner;

public class Registro {
    public static Scanner sc = new Scanner(System.in);
    public static String estudiantes = "***Listado de estudiantes***";
    public static void main(String args[]){
        int option;
        do{
            option = procesarComandos();
        }while(option != 3);        
    }
    public static int procesarComandos(){
        
        String command[] = sc.nextLine().split("&");
        switch(command[0]){
            case "1":
                agregarEstudiante(command);
                return 1;
            case "2":
                listarEstudiantes();
                return 2;            
            case "3":
                return 3;
        }
        return 0;
    }
    public static void agregarEstudiante(String[] infoEstudiantes){

        if(infoEstudiantes[1].equalsIgnoreCase("Posgrado")){
            Posgrado p1 = new Posgrado(
                    infoEstudiantes[2], 
                    Integer.parseInt(infoEstudiantes[3]), 
                    infoEstudiantes[4], 
                    infoEstudiantes[5], 
                    infoEstudiantes[6]
            );
            estudiantes += "\n\tEstudiante Posgrado";
            estudiantes += "\n\tNombre: " + p1.nombre;
            estudiantes += "\n\tEdad: " + p1.edad + " anios";
            estudiantes += "\n\tPrograma: " + p1.programa;
            estudiantes += "\n\tEtnia: " + p1.tipo_etnia;
            estudiantes += "\n\tModalidad: " + p1.modalidad;          
        } else {
            Pregrado pr1 = new Pregrado(
                    infoEstudiantes[2], 
                    Integer.parseInt(infoEstudiantes[3]), 
                    infoEstudiantes[4], 
                    infoEstudiantes[5], 
                    infoEstudiantes[6]
            );            
            estudiantes += "\n\tEstudiante Pregrado";
            estudiantes += "\n\tNombre: " + pr1.nombre;
            estudiantes += "\n\tEdad: " + pr1.edad + " anios";
            estudiantes += "\n\tPrograma: " + pr1.programa;
            estudiantes += "\n\tEtnia: " + pr1.tipo_etnia;
            estudiantes += "\n\tCreditos aprobados: " + pr1.cantidad_creditos;          
        }
    }
    public static void listarEstudiantes(){
        System.out.print(estudiantes);
    }
}
