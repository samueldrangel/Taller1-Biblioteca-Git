/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.taller1.biblioteca.git;

/**
 *
 * @author PC
 */
public class Libro extends Material {

    private int cantidadPaginas;

    public Libro(String codigo, String titulo, String autor, int cantidadPaginas) {
        super(codigo, titulo, autor);
        this.cantidadPaginas = cantidadPaginas;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Cantidad de páginas: " + cantidadPaginas;
    }
}
