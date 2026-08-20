/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller1.biblioteca.git;

/**
 *
 * @author PC
 */
public class Prestamo {
 
    private Cliente cliente;
    private Libro libro;
    private boolean activo;
 
    public Prestamo(Cliente cliente, Libro libro) {
        this.cliente = cliente;
        this.libro = libro;
        this.activo = true;
    }
 
    public Cliente getCliente() {
        return cliente;
    }
 
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
 
    public Libro getLibro() {
        return libro;
    }
 
    public void setLibro(Libro libro) {
        this.libro = libro;
    }
 
    public boolean isActivo() {
        return activo;
    }
 
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
 
    @Override
    public String toString() {
        return "Cliente: " + cliente
                + ", Libro: " + libro
                + ", Estado: " + (activo ? "Activo" : "Devuelto");
    }
}
