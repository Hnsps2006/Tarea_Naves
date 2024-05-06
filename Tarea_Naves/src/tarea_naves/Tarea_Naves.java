/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea_naves;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author eliza
 */
public class Tarea_Naves {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<Integer, NaveEspacial> naves = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int contadorNaves = 0;
        boolean salir = false;

        while (!salir) {
            System.out.println("----------- Menú -----------");
            System.out.println("1. Crear una nueva nave espacial.");
            System.out.println("2. Mostrar todas las naves espaciales existentes.");
            System.out.println("3. Actualizar los datos de una nave espacial existente.");
            System.out.println("4. Eliminar una nave espacial.");
            System.out.println("5. Salir del programa.");
            System.out.println("-----------------------------");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                if (contadorNaves < 100) {
                    System.out.print("Ingrese el nombre de la nave espacial: ");
                    String nombre = scanner.nextLine();
                    if (existeNave(nombre, naves)) {
                        System.out.println("¡Alerta! Ya existe una nave espacial con ese nombre.");
                        System.out.print("¿Desea agregar una nave con el mismo nombre pero un tipo diferente? (s/n): ");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("s")) {
                            break;
                        }
                    }
                    System.out.print("Ingrese el tipo de la nave espacial (Caza, Carga, Explorador): ");
                    String tipoNaveInput = scanner.nextLine();
                    TipoNave tipoNave = leerTipoNave(tipoNaveInput);
                    if (tipoNave == null) {
                        System.out.println("¡Error! El tipo de nave especificado no es válido.");
                        break;
                    }
                    System.out.print("Ingrese el tipo de universo de la nave espacial (Alien, StarTreck, StarWars): ");
                    String tipoUniversoInput = scanner.nextLine();
                    TipoUniverso tipoUniverso = leerTipoUniverso(tipoUniversoInput);
                    if (tipoUniverso == null) {
                        System.out.println("¡Error! El tipo de universo especificado no es válido.");
                        break;
                    }
                    naves.put(contadorNaves, new NaveEspacial(contadorNaves, nombre, tipoNave, tipoUniverso));
                    contadorNaves++;
                    System.out.println("Nave espacial creada correctamente.");
                } else {
                    System.out.println("Error: no se pudo agregar más naves, límite alcanzado.");
                }
                break;
                case 2:
                    System.out.println("Naves espaciales creadas:");
                    for (NaveEspacial nave : naves.values()) {
                        System.out.println(nave);
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la nave espacial a actualizar: ");
                    String nombreActualizar = scanner.nextLine();
                    int indiceActualizar = encontrarIndiceNave(nombreActualizar, naves);
                    if (indiceActualizar != -1) {
                        System.out.print("Ingrese el nuevo nombre para la nave espacial: ");
                        String nuevoNombre = scanner.nextLine();
                        if (existeNave(nuevoNombre, naves)) {
                            System.out.println("¡Alerta! Ya existe una nave espacial con ese nombre.");
                            System.out.print("¿Desea cambiar el nombre de la nave? (s/n): ");
                            String respuesta = scanner.nextLine();
                            if (respuesta.equalsIgnoreCase("s")) {
                                break;
                            }
                        }
                        System.out.print("Ingrese el nuevo tipo para la nave espacial (Caza, Carga, Explorador): ");
                        TipoNave nuevoTipoNave = leerTipoNave(scanner.nextLine());
                        System.out.print("Ingrese el nuevo tipo de universo para la nave espacial (Alien, StarTreck, StarWars): ");
                        TipoUniverso nuevoTipoUniverso = leerTipoUniverso(scanner.nextLine());
                        naves.get(indiceActualizar).setNombre(nuevoNombre);
                        naves.get(indiceActualizar).setTipoNave(nuevoTipoNave);
                        naves.get(indiceActualizar).setTipoUniverso(nuevoTipoUniverso);
                        System.out.println("Nave espacial actualizada correctamente.");
                    } else {
                        System.out.println("¡Error! Nave no encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre de la nave espacial a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    int indiceEliminar = encontrarIndiceNave(nombreEliminar, naves);
                    if (indiceEliminar != -1) {
                        naves.remove(indiceEliminar);
                        contadorNaves--;
                        System.out.println("Nave espacial eliminada correctamente.");
                    } else {
                        System.out.println("¡Error! No existe una nave espacial con ese nombre.");
                    }
                    break;
                case 5:
                    salir = true;
                    System.out.println("¡Hasta luego! ¡Regresa pronto!");
                    break;
                default:
                    System.out.println("Opción ingresada es inválida");
            }
        }
    }

    public static int encontrarIndiceNave(String nombre, Map<Integer, NaveEspacial> naves) {
        for (Integer key : naves.keySet()) {
            NaveEspacial nave = naves.get(key);
            if (nave.getNombre().equals(nombre)) {
                return key;
            }
        }
        return -1;
    }

    public static boolean existeNave(String nombre, Map<Integer, NaveEspacial> naves) {
        for (NaveEspacial nave : naves.values()) {
            if (nave.getNombre().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    public static TipoNave leerTipoNave(String tipo) {
        for (TipoNave tn : TipoNave.values()) {
            if (tn.getTipo().equalsIgnoreCase(tipo)) {
                return tn;
            }
        }
        return null;
    }

    public static TipoUniverso leerTipoUniverso(String tipo) {
        TipoUniverso[] universos = TipoUniverso.values();
        for (int indice_universo = 0; indice_universo < universos.length; indice_universo++) {
            if (universos[indice_universo].getTipo().equalsIgnoreCase(tipo)) {
                return universos[indice_universo];
            }
        }
        return null;
    }

}
