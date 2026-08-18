/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.taller1.biblioteca.git;

/**
 *
 * @author PC
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Cliente> clientes = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Aquí irá el menú (Fase 8)
        
    }
    
    public static void crearCliente() {
        System.out.println("\n--- CREAR CLIENTE ---");
        System.out.print("Ingrese ID: ");
        String id = sc.nextLine();
        System.out.print("Ingrese Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Ingrese Email: ");
        String email = sc.nextLine();

        Cliente nuevoCliente = new Cliente(id, nombre, telefono, email);
        clientes.add(nuevoCliente);
        System.out.println("¡Cliente registrado con éxito!");
    }
}
