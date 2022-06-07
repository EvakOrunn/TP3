/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import interfaz.Consola;
import interfaz.EntradaSalida;
import java.io.*;
import persistencia.*;

/**
 *
 * @author Alumnos
 */
public class Alumno implements Grabable {

    private int legajo; //4 bytes
    private String nombre; //2 * 50 + 2 = 122 bytes
    private int notaUno; //4 bytes
    private int notaDos; //4 bytes
    private int notaTres; //4 bytes
    private double notaFinal; //8 bytes
                              //TOTAL = 146

    private static final int TAMARCHIVO = 100; // cantidad de registros que tendra el archivo
    private static final int TAMAREG = 146; // tamaño del registro

    public Alumno() {
        this.legajo = 0;
        this.nombre = "";
        this.notaUno = 0;
        this.notaDos = 0;
        this.notaTres = 0;
        this.notaFinal = 0;
    }

    public Alumno(int legajo, String nombre, int notaUno, int notaDos, int notaTres, double notaFinal) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.notaUno = notaUno;
        this.notaDos = notaDos;
        this.notaTres = notaTres;
        this.notaFinal = notaFinal;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNotaUno() {
        return notaUno;
    }

    public void setNotaUno(int notaUno) {
        this.notaUno = notaUno;
    }

    public int getNotaDos() {
        return notaDos;
    }

    public void setNotaDos(int notaDos) {
        this.notaDos = notaDos;
    }

    public int getNotaTres() {
        return notaTres;
    }

    public void setNotaTres(int notaTres) {
        this.notaTres = notaTres;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
    
    private void cargarLegajo(){
        EntradaSalida.emitirMensaje("Legajo:");
        int legAux = EntradaSalida.leerInt();
        setLegajo(legAux);
    }
    
    private void cargarNotaUno(){
        EntradaSalida.emitirMensaje("Primera Nota:");
        int unAux = EntradaSalida.leerInt();
        setNotaUno(unAux);
    }
    
    @Override
    public int tamRegistro() {
        return TAMAREG;
    }

    @Override
    public int tamArchivo() {
        return TAMARCHIVO;
    }

    @Override
    public void grabar(RandomAccessFile a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void leer(RandomAccessFile a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cargarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
