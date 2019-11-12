
package comparasmus;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JTextArea;


public class UniversidadAlcala {

    private Grados grados_disponibles;
    private Asignaturas asignaturas_disponibles;
    private ArrayList<String>grados = new ArrayList<>();
    private ArrayList<String>asignaturas = new ArrayList<>();
    private ArrayList<String>competencias = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private String opcion;
    private String grado_elegido;
    private String asignatura_elegida, competencia_elegida;
    private JComboBox jComboBox1, jComboBox2;
    private JTextArea jTextArea;
    
    public UniversidadAlcala(Grados grados_disponibles, Asignaturas asignaturas_disponibles,
    JComboBox jComboBox1, JComboBox jComboBox2){
        this.grados_disponibles = grados_disponibles;
        this.asignaturas_disponibles = asignaturas_disponibles;
        this.jComboBox1 = jComboBox1;
        this.jComboBox2 = jComboBox2;
    }
    
    public String elegirGrado() throws IOException{
        //Mostramos las gradps
        System.out.println("¿Quieres incluir un nuevo grado?");
        String grado = sc.nextLine();
        while(!grado.toUpperCase().contains("N")&&(!grado.toUpperCase().contains("S"))){
            System.out.println("¿Quieres incluir un nuevo grado?");
            grado = sc.nextLine();
        }
        if(grado.toUpperCase().contains("S")){
            grado_elegido = grados_disponibles.incluirGrado();
        }else{
            System.out.println("Grados Disponibles: " );
        try{
            grados = grados_disponibles.leerGrados();
            for(int i = 0; i<grados.size(); i++){
                jComboBox1.addItem(grados.get(i));
            }
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
            grado_elegido = grados.get(Integer.valueOf(opcion)-1);
        }
        return grado_elegido;
    }
    
    public String elegirAsignatura(String grado_seleccionado) throws IOException{
        //Mostramos asignaturas
        System.out.println("¿Quieres incluir una nueva asignatura?"+"("+grado_seleccionado+"): ");
        String asignatura = sc.nextLine();
        while(!asignatura.toUpperCase().contains("N")&&(!asignatura.toUpperCase().contains("S"))){
            System.out.println("¿Quieres incluir un nuevo grado?");
            asignatura = sc.nextLine();
        }
        if(asignatura.toUpperCase().contains("S")){
            asignaturas_disponibles.incluirAsignatura(grado_seleccionado);
        }else{
                try{
                    asignaturas = asignaturas_disponibles.leerAsignaturasGrado(grado_seleccionado);
                    for(int i = 0; i<asignaturas.size(); i++){
                        jComboBox2.addItem(asignaturas.get(i));
                    }
                }catch(FileNotFoundException ie){}
            System.out.print("\nElige una opcion valida: ");
            //Introducimos la opcion
            try{
             opcion = sc.nextLine();
            }catch(ArrayIndexOutOfBoundsException ie){System.out.println("Error.");}
            while((Integer.valueOf(opcion)<0)||(Integer.valueOf(opcion)>asignaturas.size())){
                System.out.print("\nElige una opcion valida: ");
                opcion = sc.nextLine();
                opcion = String.valueOf(opcion);
            }
            System.out.println("[+]Asignatura seleccionada: " + asignaturas.get(Integer.valueOf(opcion)-1) + "\n");
                asignatura_elegida = asignaturas.get(Integer.valueOf(opcion)-1);

            System.out.println("Competencias de (" + (asignatura_elegida)+"): ");
            try{
                competencias = asignaturas_disponibles.leerCompetenciasAsignatura(asignatura_elegida, jTextArea);
            }catch(FileNotFoundException ie){}
        }
        return asignatura_elegida;
    }
    
    public void UniversidadAlcala() throws IOException{
        elegirGrado();
        String asignatura = elegirAsignatura(grado_elegido);
    }
        

    
}