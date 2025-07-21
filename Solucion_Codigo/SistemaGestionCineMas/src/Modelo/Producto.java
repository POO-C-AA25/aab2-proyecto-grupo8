/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public abstract class Producto {
    protected double precio;
    protected int cantidad;

    public Producto(double precio, int cantidad) {
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public abstract double calcularTotal();
}
