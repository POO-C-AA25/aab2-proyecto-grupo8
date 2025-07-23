/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoSalas {

    public ArchivoSalas() {
    }

    public void leerSalas(ArrayList<ArrayList<String>> salas) {
        try (Scanner sc = new Scanner(new File("Salas.csv"))) {
            while (sc.hasNextLine()) {
                String[] partes = sc.nextLine().split(";");
                ArrayList<String> lista = new ArrayList<>();
                for (String parte : partes) {
                    lista.add(parte);
                }
                salas.add(lista);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

