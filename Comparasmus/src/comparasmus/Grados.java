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
import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Grados {
    private ArrayList<String>grados = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private String gradoz;
        
    public String incluirGrado() throws IOException{
        try{
            System.out.println("[+]Grados Disponibles: ");
            leerGrados();
        }catch(FileNotFoundException ie){}
        System.out.println("\nIntroduce el nuevo grado: ");
        String grado = sc.nextLine();
        grados.add(grado);
        System.out.println("Grado añadido con éxito. " + "\nGrados disponibles: " + grados);
        guardarGrados(grado);
        gradoz = grado;
        return gradoz;
    }
    
    public void guardarGrados(String grado){
        FileWriter historial_grados = null;
        PrintWriter hist_w = null;
        try{
            historial_grados = new FileWriter("Historiales/grados.txt", true);
            hist_w = new PrintWriter(historial_grados);
            hist_w.println(grado);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null != historial_grados)
                    historial_grados.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        guardarGradosSeparados(grado);
    }
    
    public void guardarGradosSeparados(String grado){
        FileWriter historial_grados = null;
        PrintWriter hist_w = null;
        try{
            historial_grados = new FileWriter("Historiales/grados/"+grado+".txt", true);
            hist_w = new PrintWriter(historial_grados);
            //hist_w.println(asignatura_seleccionada);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null != historial_grados)
                    historial_grados.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }
   
    public void guardarAsignaturaGrado(String grado,String asignatura){
        FileWriter historial_grados = null;
        PrintWriter hist_w = null;
        try{
            historial_grados = new FileWriter("Historiales/grados/"+grado+".txt", true);
            hist_w = new PrintWriter(historial_grados);
            hist_w.println(asignatura);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (null != historial_grados)
                    historial_grados.close();
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
    }

    public ArrayList<String> leerGrados() throws FileNotFoundException, IOException{
        int contador = 1;
        File file = new File("C:\\Users\\Daniel\\Documents\\NetBeansProjects\\Lab_Sesion_01\\Comparasmus\\Historiales\\grados.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String gs;
        while((gs = br.readLine()) != null){
            System.out.println("["+contador+"]" + gs);
            contador +=1 ;
            grados.add(gs);
        }
        return grados;
    }
}
