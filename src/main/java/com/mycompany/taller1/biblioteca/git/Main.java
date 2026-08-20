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
    static ArrayList<Prestamo> prestamos = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {
int opcionPrincipal = 0;

        do {
            System.out.println("\n==========================================");
            System.out.println("     SISTEMA DE GESTIÓN DE BIBLIOTECA     ");
            System.out.println("==========================================");
            System.out.println("1. Gestión de Clientes");
            System.out.println("2. Gestión de Libros");
            System.out.println("3. Gestión de Préstamos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcionPrincipal = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcionPrincipal = -1;
            }

            switch (opcionPrincipal) {
                case 1:
                    menuClientes();
                    break;
                case 2:
                    menuLibros();
                    break;
                case 3:
                    menuPrestamos();
                    break;
                case 4:
                    System.out.println("\n¡Gracias por usar el sistema de biblioteca!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcionPrincipal != 4);
    }

    // --- SUBMENÚS DE NAVEGACIÓN ---

    private static void menuClientes() {
        int opcion = 0;
        do {
            System.out.println("\n--- SUBMENÚ: GESTIÓN DE CLIENTES ---");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Buscar Cliente");
            System.out.println("4. Actualizar Cliente");
            System.out.println("5. Eliminar Cliente");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1: crearCliente(); break;
                case 2: listarClientes(); break;
                case 3: buscarCliente(); break;
                case 4: actualizarCliente(); break;
                case 5: eliminarCliente(); break;
                case 6: System.out.println("Volviendo al menú principal..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private static void menuLibros() {
        int opcion = 0;
        do {
            System.out.println("\n--- SUBMENÚ: GESTIÓN DE LIBROS ---");
            System.out.println("1. Crear Libro");
            System.out.println("2. Listar Libros");
            System.out.println("3. Buscar Libro");
            System.out.println("4. Actualizar Libro");
            System.out.println("5. Eliminar Libro");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1: crearLibro(); break;
                case 2: listarLibros(); break;
                case 3: 
                    System.out.print("Ingrese el código a buscar: ");
                    String cod = sc.nextLine();
                    Libro l = buscarLibro(cod);
                    System.out.println(l != null ? l : "Libro no encontrado.");
                    break;
                case 4: actualizarLibro(); break;
                case 5: eliminarLibro(); break;
                case 6: System.out.println("Volviendo al menú principal..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
    }

    private static void menuPrestamos() {
        int opcion = 0;
        do {
            System.out.println("\n--- SUBMENÚ: GESTIÓN DE PRÉSTAMOS ---");
            System.out.println("1. Registrar Préstamo");
            System.out.println("2. Registrar Devolución");
            System.out.println("3. Listar Préstamos Activos");
            System.out.println("4. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1: crearPrestamo(); break;
                case 2: devolucion(); break;
                case 3: listarPrestamos(); break;
                case 4: System.out.println("Volviendo al menú principal..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
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

    public static void listarLibros() {

        System.out.println("\n--- LISTA DE LIBROS ---");

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public static Libro buscarLibro(String codigo) {

        for (Libro libro : libros) {

            if (libro.getCodigo().equalsIgnoreCase(codigo)) {
                return libro;
            }
        }

        return null;
    }

    public static void actualizarLibro() {

        System.out.println("\n--- ACTUALIZAR LIBRO ---");

        System.out.print("Ingrese el código del libro: ");
        String codigo = sc.nextLine();

        Libro libro = buscarLibro(codigo);

        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        System.out.print("Nuevo título: ");
        String titulo = sc.nextLine();

        System.out.print("Nuevo autor: ");
        String autor = sc.nextLine();

        System.out.print("Nueva cantidad de páginas: ");
        int cantidadPaginas = Integer.parseInt(sc.nextLine());

        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setCantidadPaginas(cantidadPaginas);

        System.out.println("Libro actualizado correctamente.");
    }

    public static void eliminarLibro() {

        System.out.println("\n--- ELIMINAR LIBRO ---");

        System.out.print("Ingrese el código del libro: ");
        String codigo = sc.nextLine();

        Libro libro = buscarLibro(codigo);

        if (libro == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        libros.remove(libro);

        System.out.println("Libro eliminado correctamente.");
    }

    public static void crearPrestamo() {

        System.out.println("\n--- REGISTRAR PRÉSTAMO ---");

        System.out.print("Ingrese el ID del cliente: ");
        String idCliente = sc.nextLine();

        Cliente clienteEncontrado = null;

        for (Cliente cliente : clientes) {
            if (cliente.getId().equalsIgnoreCase(idCliente)) {
                clienteEncontrado = cliente;
                break;
            }
        }

        if (clienteEncontrado == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese el código del libro: ");
        String codigoLibro = sc.nextLine();

        Libro libroEncontrado = buscarLibro(codigoLibro);

        if (libroEncontrado == null) {
            System.out.println("Libro no encontrado.");
            return;
        }

        Prestamo prestamo = new Prestamo(clienteEncontrado, libroEncontrado);

        prestamos.add(prestamo);

        System.out.println("Préstamo registrado correctamente.");
    }

    public static void devolucion() {

        System.out.println("\n--- DEVOLUCIÓN DE LIBRO ---");

        System.out.print("Ingrese el código del libro: ");
        String codigoLibro = sc.nextLine();

        for (Prestamo prestamo : prestamos) {

            if (prestamo.getLibro().getCodigo().equalsIgnoreCase(codigoLibro)
                    && prestamo.isActivo()) {

                prestamo.setActivo(false);

                System.out.println("Libro devuelto correctamente.");
                return;
            }
        }

        System.out.println("No se encontró un préstamo activo para ese libro.");
    }

    public static void listarPrestamos() {

        System.out.println("\n--- PRÉSTAMOS ACTIVOS ---");

        boolean hayPrestamosActivos = false;

        for (Prestamo prestamo : prestamos) {

            if (prestamo.isActivo()) {
                System.out.println(prestamo);
                hayPrestamosActivos = true;
            }
        }

        if (!hayPrestamosActivos) {
            System.out.println("No hay préstamos activos.");
        }
    }

}
