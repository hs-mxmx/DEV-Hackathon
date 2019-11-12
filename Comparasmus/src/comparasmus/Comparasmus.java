/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparasmus;

import java.io.IOException;

/**
 *
 * @author Daniel
 */
public class Comparasmus {


    public static void main(String[] args) throws IOException {
        Universidades universidades = new Universidades();
        Grados grados = new Grados();
        UniversidadAlcala uni = new UniversidadAlcala(universidades, grados);
        //universidades.Universidades();
        uni.UniversidadAlcala();

    }
    
}
