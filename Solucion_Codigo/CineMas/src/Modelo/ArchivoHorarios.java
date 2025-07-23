/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoHorarios {

    public ArchivoHorarios() {
    }

    public void leerHorarios(ArrayList<ArrayList<String>> horarios) {
        try (Scanner sc = new Scanner(new File("Horarios.csv"))) {
            while (sc.hasNextLine()) {
                String[] partes = sc.nextLine().split(";");
                ArrayList<String> lista = new ArrayList<>();
                for (String parte : partes) {
                    lista.add(parte);
                }
                horarios.add(lista);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

