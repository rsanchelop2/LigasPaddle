package edu.masanz.da.lp;

import java.util.Scanner;

/**
 * Clase principal para ejecutar la aplicación de gestión de ligas de paddle.
 * Utiliza la clase GestorLigas para gestionar las ligas y la clase Gui para la interacción con el usuario.
 */
public class App {

    private GestorLigas gestorLigas;

    /**
     * Constructor de la clase App.
     */
    public App() {
        // TODO 11: instancia el GestorLigas e inicializa las ligas utilizando la clase Init
        gestorLigas = new GestorLigas();
        Init.crearLigas(gestorLigas);
    }

    /**
     * Método principal para ejecutar la aplicación.
     */
    public void run() {
        // TODO 12: en un bucle muestra el menú, lee la opción y ejecuta la opción hasta que se elija salir.
        while (true){
            Gui.mostrarMenu();
            String s = "";
            System.out.printf("Introduce una opcion: ");
            int n = Gui.leerNumero(s);
            ejecutarOpcion(n);
        }
    }

    /**
     * Ejecuta la opción seleccionada del menú.
     * @param numOpc Número de opción seleccionada.
     */
    private void ejecutarOpcion(int numOpc) {
        // TODO 13: implementa la ejecución de las opciones del menú utilizando un switch.
        // Llama a los métodos correspondientes para cada opción.

        switch (numOpc){
            case 1:
                listarEquiposLigas();
                break;
            case 2:
                mostrarTablaResultadosLiga();
                break;
            case 3:
                listarCampeonesLigas();
                break;
            case 4:
                anotarMarcadoresLiga();
                break;
            case 0:
                salir();
                System.exit(0);
        }
    }

    /**
     * Lista los equipos de las ligas disponibles.
     */
    private void listarEquiposLigas() {
        // TODO 14: muestra la lista de ligas, lee el número de liga y muestra la lista de equipos de la liga seleccionada.

        int numeroLiga = Gui.leerNumero(gestorLigas.getListaLigas());

        for (int i = 0; i < numeroLiga; i++) {
            System.out.println(gestorLigas.getLiga(numeroLiga));
            for (int j = 0; j < 4; j++) {
                System.out.println(gestorLigas.getEquipo(numeroLiga, j));
            }
        }
    }

    /**
     * Lista los campeones de las ligas.
     */
    private void listarCampeonesLigas() {
        // TODO 15: muestra el listado de campeones de todas las ligas.
        System.out.println(gestorLigas.getListadoCampeonesLigas());
    }

    /**
     * Muestra la tabla de resultados de una liga seleccionada.
     */
    private void mostrarTablaResultadosLiga() {
        // TODO 16: muestra la lista de ligas, lee el número de liga y muestra la tabla de resultados de la liga seleccionada.
        //int n = gestorLigas.getLiga();
        // preguntar como y a que liga mostrar la tabla

    }

    /**
     * Muestra la tabla de resultados de una liga específica.
     * @param numLiga Número de la liga.
     */
    private void mostrarTablaResultadosLiga(int numLiga) {
        // TODO 17: muestra la tabla de resultados de la liga indicada.
        //int n = gestorLigas.getLiga(numLiga);
        int x = 1;

    }

    /**
     * Anota los marcadores de los partidos de una liga seleccionada.
     */
    private void anotarMarcadoresLiga() {
        // TODO 18: Para anotar los marcadores de los partidos de una liga seleccionada,
        // muestra la lista de ligas, lee el número de liga, muestra la lista de equipos,
        // permite al usuario seleccionar dos equipos y anotar los marcadores de sus partidos.
        // Muestra la tabla de resultados antes y después de anotar los marcadores.
        // Permite repetir el proceso hasta que el usuario decida salir.

        String s = "";
        System.out.println(gestorLigas.getListaEquipos(Gui.leerNumero(gestorLigas.getListaLigas())));

        System.out.printf("Introduce el numero del primer equipo: ");
        int n1 = Gui.leerNumero(s);
        System.out.printf("Introduce el numero del segundo equipo: ");
        int n2 = Gui.leerNumero(s);
        int n = Gui.leerNumero(gestorLigas.getListaLigas());
        System.out.printf("Introduce numero de marcador: ");
        int n3 = Gui.leerNumero(s);
        System.out.printf("Introduce puntos equipo 1: ");
        int n4 = Gui.leerNumero(s);
        System.out.printf("Introduce puntos equipo 2: ");
        int n5 = Gui.leerNumero(s);
        gestorLigas.setMarcadorPartido(n,n1,n2,n3,n4,n5);

        System.out.println(gestorLigas.getTablaResultadosLiga(Gui.leerNumero(gestorLigas.getListaLigas())));

        System.out.printf("Desea repetir el proceso? 1 = si, 2 = no: ");
        int a = Gui.leerNumero(s);
        if (a == 1){
            anotarMarcadoresLiga();
        } else if (a == 2) {
            run();
        } else {
            System.out.println("Numero no valido, volviendo al menu...");
        }
    }

    /**
     * Muestra un mensaje de salida: "Saliendo...".
     */
    private void salir() {
        Gui.mostrarTexto("Saliendo...");
    }

    /**
     * Muestra un mensaje de opción no válida: "Opción no válida".
     */
    private void opcionNoValida() {
        Gui.mostrarTexto("Opción no válida");
    }


}
