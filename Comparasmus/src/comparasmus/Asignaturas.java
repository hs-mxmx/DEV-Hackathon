/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparasmus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author Daniel
 */
public class Asignaturas {
    private ArrayList<String>grados = new ArrayList<>();
    private ArrayList<String>competencias = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private String asignatura;
    private JTextArea jTextArea;
    private ArrayList<String> EstructuraDatos = new ArrayList<>(Arrays.asList("Competencia1", "Competencia2", "Competencia 3", "Competencia 6"));
    private ArrayList<String> Programacion = new ArrayList<>(Arrays.asList("Competencia10", "Competencia2", "Competencia 3", "Competencia 6"));
  
    public Asignaturas(JTextArea jTextArea){
        this.jTextArea = jTextArea;
    }
    
    public void incluirAsignatura(String grado_seleccionado)throws IOException{
        try{
            System.out.println("[+]Asignaturas Disponibles: ");
            leerAsignaturasGrado(grado_seleccionado);
        }catch(FileNotFoundException ie){}
        System.out.println("\nIntroduce una nueva asignaturas: ");
        String asignatura = sc.nextLine();
        grados.add(asignatura);
        System.out.println("Asignatura añadido con éxito. " + "\nGrados asignaturas: " + grados);
        guardarAsignaturas(grado_seleccionado, asignatura);
    }
    

    
    public void guardarAsignaturas(String grado_seleccionado,String asignaturas){
        FileWriter historial_asignaturas = null;
        PrintWriter hist_w = null;
        try{
            historial_asignaturas = new FileWriter("Historiales/asignaturas.txt", true);
            hist_w = new PrintWriter(historial_asignaturas);
            hist_w.println(asignaturas);
            asignatura = asignaturas;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null != historial_asignaturas)
                    historial_asignaturas.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        } 
        guardarAsignaturaSeparada(asignaturas);
        System.out.println("Grado a guardar: " + grado_seleccionado);
        guardarGradoAsignatura(grado_seleccionado);
    }
    
    
    public void guardarAsignaturaSeparada(String asignaturas){
        FileWriter historial_asignaturas = null;
        PrintWriter hist_w = null;
        try{
            historial_asignaturas = new FileWriter("Historiales/grados/asignaturas/"+asignaturas+ ".txt", true);
            hist_w = new PrintWriter(historial_asignaturas);
            hist_w.println(asignatura);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null != historial_asignaturas)
                    historial_asignaturas.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public void guardarGradoAsignatura(String grado_seleccionado){
        FileWriter historial_asignaturas = null;
        PrintWriter hist_w = null;
        System.out.println("Guardando en el grado: " + grado_seleccionado);
        try{
            historial_asignaturas = new FileWriter("Historiales/grados/"+grado_seleccionado+ ".txt", true);
            hist_w = new PrintWriter(historial_asignaturas);
            hist_w.println(asignatura);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null != historial_asignaturas)
                    historial_asignaturas.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
    

    public ArrayList<String> leerAsignaturas() throws FileNotFoundException, IOException{
        int contador = 1;
        File file = new File("C:\\Users\\Daniel\\Documents\\NetBeansProjects\\Lab_Sesion_01\\Comparasmus\\Historiales\\asignaturas.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String gs;
        while((gs = br.readLine()) != null){
            System.out.println("["+contador+"]" + gs);
            contador += 1;
            grados.add(gs);
        }
        return grados;
    }


    public ArrayList<String> leerAsignaturasCompetencias(String asignatura_seleccionada) throws FileNotFoundException, IOException{
        int contador = 1;
        File file = new File("C:\\Users\\Daniel\\Documents\\NetBeansProjects\\Lab_Sesion_01\\Comparasmus\\Historiales\\asignaturas\\"+asignatura_seleccionada+".txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String gs;
        while((gs = br.readLine()) != null){
            System.out.println("["+contador+"]" + gs);
            contador += 1;
            grados.add(gs);
        }
        return grados;
    }

    
    public ArrayList<String> leerAsignaturasGrado(String grado_seleccionado) throws FileNotFoundException, IOException{
        int contador = 1;
        File file = new File("C:\\Users\\Daniel\\Documents\\NetBeansProjects\\Lab_Sesion_01\\Comparasmus\\Historiales\\grados\\"+grado_seleccionado+".txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String gs;
        System.out.println("\nAsignaturas disponibles: ");
        while((gs = br.readLine()) != null){
            System.out.println("["+contador+"]" + gs);
            contador += 1;
            grados.add(gs);
        }
        return grados;
    }
    
    public ArrayList<String> leerCompetenciasAsignatura(String asignatura, JTextArea jTextArea) throws FileNotFoundException, IOException{
        int contador = 1;
        int iguales = 0;
        System.out.println("Asignatura: " + asignatura);
        File file = new File("C:\\Users\\Daniel\\Documents\\NetBeansProjects\\Lab_Sesion_01\\Comparasmus\\Historiales\\grados\\asignaturas\\"+asignatura+".txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String gs;
        
        while((gs = br.readLine()) != null){
            contador += 1;
            competencias.add(gs);
        }
        //EstructuraDatos
        //Programacion
        for(int i = 0; i<competencias.size(); i++){
            if(EstructuraDatos.contains(competencias.get(i))){
                System.out.println("  [+] " + competencias.get(i));
                iguales += 1;
                //jTextArea.setText(jTextArea.getText() + "  [+] " + competencias.get(i) + "\n");
            }
        }
        System.out.println("Competencias en comun con Estructura Datos: " + iguales +"/"+competencias.size());
        iguales = 0;
        
        for(int i = 0; i<competencias.size(); i++){
            if(Programacion.contains(competencias.get(i))){
                System.out.println("  [+] " + competencias.get(i));
                iguales += 1;
                //jTextArea.setText(jTextArea.getText() + "  [+] " + competencias.get(i) + "\n");
            }
        }
        
        System.out.println("Competencias en comun con Programacion: " + iguales +"/"+competencias.size());
        iguales = 0;
        
        return competencias;
    }
    
}
