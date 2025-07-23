/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArchivoSnacks {

    public ArchivoSnacks() {
    }

    public void leerSnacks(ArrayList<Snack> snacks) {
        try (Scanner sc = new Scanner(new File("Snacks.csv"))) {
            while (sc.hasNextLine()) {
                String[] partes = sc.nextLine().split(";");
                snacks.add(new Snack(partes[0], Double.parseDouble(partes[1]), 0));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

