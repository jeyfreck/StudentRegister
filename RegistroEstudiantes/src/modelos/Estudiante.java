/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author pc
 */
public class Estudiante {
    private int id;
    private String nombre;
    private String condicion;
    private int[] notas;

    public Estudiante() {
    }

    public Estudiante(int id, String nombre, String condicion, int[] notas) {
        this.id = id;
        this.nombre = nombre;
        this.condicion = condicion;
        this.notas = notas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }

    public int getNotaAt(int index) {
        if (index >= 0 && index < notas.length) {
            return notas[index];
        }
        return 0;  
    }
}
