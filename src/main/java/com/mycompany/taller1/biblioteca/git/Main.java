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
    static ArrayList<Libro> libros = new ArrayList<>();

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
        public static void listarClientes() {
        System.out.println("\n--- LISTA DE CLIENTES ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados en el sistema.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getId() + " | Nombre: " + c.getNombre() + " | Teléfono: " + c.getTelefono() + " | Email: " + c.getEmail());
        }
    }
        public static void buscarCliente() {
        System.out.println("\n--- BUSCAR CLIENTE ---");
        System.out.print("Ingrese el ID del cliente a buscar: ");
        String idBusqueda = sc.nextLine();

        for (Cliente c : clientes) {
            if (c.getId().equals(idBusqueda)) {
                System.out.println("¡Cliente Encontrado!");
                System.out.println("ID: " + c.getId());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Teléfono: " + c.getTelefono());
                System.out.println("Email: " + c.getEmail());
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }
        public static void actualizarCliente() {
        System.out.println("\n--- ACTUALIZAR CLIENTE ---");
        System.out.print("Ingrese el ID del cliente a modificar: ");
        String idBusqueda = sc.nextLine();

        for (Cliente c : clientes) {
            if (c.getId().equals(idBusqueda)) {
                System.out.print("Nuevo Nombre (actual: " + c.getNombre() + "): ");
                c.setNombre(sc.nextLine());
                System.out.print("Nuevo Teléfono (actual: " + c.getTelefono() + "): ");
                c.setTelefono(sc.nextLine());
                System.out.print("Nuevo Email (actual: " + c.getEmail() + "): ");
                c.setEmail(sc.nextLine());
                System.out.println("¡Datos actualizados correctamente!");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }
        
        public static void eliminarCliente() {
        System.out.println("\n--- ELIMINAR CLIENTE ---");
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        String idBusqueda = sc.nextLine();

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(idBusqueda)) {
                clientes.remove(i);
                System.out.println("¡Cliente eliminado de la base de datos!");
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }
        
    public static void crearLibro() {

        System.out.println("\n--- CREAR LIBRO ---");

        System.out.print("Código: ");
        String codigo = sc.nextLine();

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        System.out.print("Cantidad de páginas: ");
        int cantidadPaginas = Integer.parseInt(sc.nextLine());

        Libro libro = new Libro(codigo, titulo, autor, cantidadPaginas);

        libros.add(libro);

        System.out.println("Libro creado correctamente.");
    }
}
