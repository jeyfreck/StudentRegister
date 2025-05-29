/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Estudiante;

/**
 *
 * @author pc
 */
public class EstudiantesDatos {

  public ArrayList<Estudiante> leerArchivo() throws IOException {
        ArrayList<Estudiante> estudiantesLeidos = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("estudiantes.txt"));
        String linea;
        while ((linea = reader.readLine()) != null) {
            String[] partes = linea.split(",");  // Suponiendo que los datos están separados por comas
            int id = Integer.parseInt(partes[0]);
            String nombre = partes[1];
            String condicion = partes[2];
            int[] notas = new int[5];
            for (int i = 0; i < 5; i++) {
                notas[i] = Integer.parseInt(partes[i + 3]);
            }
            Estudiante estudiante = new Estudiante(id, nombre, condicion, notas);
            estudiantesLeidos.add(estudiante);
        }
        reader.close();
        return estudiantesLeidos;
    }

    public void agregarEstudiante(Estudiante estudiante) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("estudiantes.txt", true)); // Abrir en modo de escritura "append"
        writer.write(estudiante.getId() + "," + estudiante.getNombre() + "," + estudiante.getCondicion());
        for (int nota : estudiante.getNotas()) {
            writer.write("," + nota);  // Escribir las notas separadas por coma
        }
        writer.newLine();  // Salto de línea al final de cada estudiante
        writer.close();
    }
}