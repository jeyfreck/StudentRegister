/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import datos.EstudiantesDatos;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.Estudiante;

/**
 *
 * @author pc
 */
public class EstudianteControlador {

 private ArrayList<Estudiante> estudiantes;  
    private EstudiantesDatos archivo;  

    public EstudianteControlador() {
        estudiantes = new ArrayList<>();
        archivo = new EstudiantesDatos();
    }

    // Método para agregar un estudiante
    public void agregarEstudiante(int id, String nombre, int[] nota, String condicion) throws IOException {
        if (buscarEstudiantePorId(id) != null) {
            System.out.println("El estudiante con ID " + id + " ya existe.");
            return;  
        }

        Estudiante nuevo = new Estudiante();
        nuevo.setId(id);
        nuevo.setNombre(nombre);
        nuevo.setNotas(nota);
        nuevo.setCondicion(condicion);

        estudiantes.add(nuevo);  
        archivo.agregarEstudiante(nuevo);  
    }

    // Método para buscar un estudiante por su ID
    public Estudiante buscarEstudiantePorId(int id) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }
        return null;
    }

    // Método para cargar los estudiantes desde un archivo
    public void cargarArchivo() throws IOException {
        try {
            estudiantes = new ArrayList<>(archivo.leerArchivo());
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
            throw e;
        }
    }

   public void mostrarEstudiantes(DefaultTableModel modelo) {
    modelo.setRowCount(0);  // Limpiar la tabla antes de agregar nuevos datos

    for (Estudiante estudiante : estudiantes) {
        // Notas finales concatenadas en un solo string
        String notasFinales = estudiante.getNotaAt(0) + ", " +
                              estudiante.getNotaAt(1) + ", " +
                              estudiante.getNotaAt(2) + ", " +
                              estudiante.getNotaAt(3) + ", " +
                              estudiante.getNotaAt(4);

        // Asegurar que los valores están en el orden correcto
        Object[] fila = {
            estudiante.getId(),         // Columna 0 - ID
            estudiante.getNombre(),     // Columna 1 - Nombre
            notasFinales,               // Columna 2 - Notas Finales
            estudiante.getCondicion()   // Columna 3 - Condición
        };
        modelo.addRow(fila);
    }
}

    // Método para ordenar los estudiantes por nombre usando MergeSort
    public void ordenarPorNombre() {
        if (estudiantes.size() > 1) {
            estudiantes = mergeSort(estudiantes);
        }
    }

    private ArrayList<Estudiante> mergeSort(ArrayList<Estudiante> lista) {
        if (lista.size() <= 1) {
            return lista;
        }

        int medio = lista.size() / 2;
        ArrayList<Estudiante> izquierda = new ArrayList<>(lista.subList(0, medio));
        ArrayList<Estudiante> derecha = new ArrayList<>(lista.subList(medio, lista.size()));

        return merge(mergeSort(izquierda), mergeSort(derecha));
    }

    private ArrayList<Estudiante> merge(ArrayList<Estudiante> izquierda, ArrayList<Estudiante> derecha) {
        ArrayList<Estudiante> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < izquierda.size() && j < derecha.size()) {
            if (izquierda.get(i).getNombre().compareToIgnoreCase(derecha.get(j).getNombre()) <= 0) {
                resultado.add(izquierda.get(i));
                i++;
            } else {
                resultado.add(derecha.get(j));
                j++;
            }
        }

        while (i < izquierda.size()) {
            resultado.add(izquierda.get(i));
            i++;
        }

        while (j < derecha.size()) {
            resultado.add(derecha.get(j));
            j++;
        }

        return resultado;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
