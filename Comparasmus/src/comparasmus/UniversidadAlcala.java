
package comparasmus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class UniversidadAlcala {

    private Universidades universidades;
    private Grados grados_disponibles;
    private ArrayList<String>grados = new ArrayList<>();
    private ArrayList<String>asignaturas = new ArrayList<>(Arrays.asList("(1)Programacion", "(2)Base de Datos", 
            "(3)Estrucuta de Datos"));
    private Scanner sc = new Scanner(System.in);
    private String opcion;
    
    public UniversidadAlcala(Universidades universidades, Grados grados_disponibles){
        this.universidades = universidades;
        this.grados_disponibles = grados_disponibles;
    }
    
    public String elegirGrado() throws IOException{
        //Mostramos las gradps
        System.out.println("Grados Disponibles: " );
        try{
            grados = grados_disponibles.leerGrados();
        }catch(FileNotFoundException ie){}
        System.out.print("\nElige una opcion valida: ");
        //Introducimos la opcion
        opcion = sc.nextLine();
        while((Integer.valueOf(opcion)<0)||(Integer.valueOf(opcion)>grados.size())){
            System.out.print("Elige una opcion valida: ");
            opcion = sc.nextLine();
            opcion = String.valueOf(opcion);
        }
        System.out.println("\n[+]Grado seleccionado: " + grados.get(Integer.valueOf(opcion)-1) + "\n");
        return grados.get(Integer.valueOf(opcion)-1);
    }
    
    public String elegirAsignatura(){
        //Mostramos asignaturas
        System.out.println("Asignaturas Disponibles: "+ asignaturas);
        System.out.print("Elige una opcion valida: ");
        //Introducimos la opcion
         opcion = sc.nextLine();
        while((Integer.valueOf(opcion)<0)||(Integer.valueOf(opcion)>asignaturas.size())){
            System.out.print("Elige una opcion valida: ");
            opcion = sc.nextLine();
            opcion = String.valueOf(opcion);
        }
        System.out.println("[+]Grado seleccionado: " + asignaturas.get(Integer.valueOf(opcion)-1) + "\n");
        return asignaturas.get(Integer.valueOf(opcion)-1);
    }
    
    public void UniversidadAlcala() throws IOException{
        String grado = elegirGrado();
        String asignatura = elegirAsignatura();
    }
        
    
}