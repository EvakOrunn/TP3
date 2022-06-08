/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import interfaz.EntradaSalida;
import java.io.*;
import persistencia.*;
import excepciones.*;

/**
 *
 * @author Luis Roberto Cruz
 */
public class Alumno implements Grabable {

    private int legajo; // 4 bytes
    private String nombre; // 2 * 60 + 2 = 122 bytes
    private int notaUno; // 4 bytes
    private int notaDos; // 4 bytes
    private int notaTres; // 4 bytes
    private double notaFinal; // 8 bytes
                              // TOTAL = 146

    private static final int TAMARCHIVO = 100; // cantidad de registros que tendra el archivo
    private static final int TAMAREG = 146; // tamaño del registro

    /**
     * Constructor por defecto de la clase Alumno.
     * Inicializa los valores del legajo y las notas en -1 y el nombre en ""
     */
    public Alumno() {
        this.legajo = -1;
        this.nombre = "";
        this.notaUno = -1;
        this.notaDos = -1;
        this.notaTres = -1;
        this.notaFinal = -1;
    }

    /**
     * Constructor de la clase Alumno, en este constructor se le solicita al usuari que ingrese todos
     * los datos del Alumno por parametro de entrada.
     * 
     * @param legajo                Legajo con el que se identifica al Alumno
     * @param nombre                Nombre y Apellido del Alumno
     * @param notaUno               1ra nota del Alumno
     * @param notaDos               2da nota del Alumno
     * @param notaTres              3ra nota del Alumno
     */
    public Alumno(int legajo, String nombre, int notaUno, int notaDos, int notaTres) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.notaUno = notaUno;
        this.notaDos = notaDos;
        this.notaTres = notaTres;
    }

    /**
     * Retorna el legajo del Alumno
     * 
     * @return                      legajo del Alumno
     */
    public int getLegajo() {
        return legajo;
    }

    /**
     * Establece el legajo del Alumno teniendo en cuenta que este no puede ser un valor negativo de
     * ser asi entonces el programa lanzara una excepcion 
     * 
     * @param legajo               Legajo del Alumno
     */
    public void setLegajo(int legajo) throws NumeroNegativoExcepcion {
        if (legajo < 0) {
            throw new NumeroNegativoExcepcion();
        }
        this.legajo = legajo;
    }

    /**
     * Retorna el nombre y apellido del Alumno
     * 
     * @return nombre               nombre y apellido del Alumno
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws CadenaLargaExcepcion {
        if (nombre.length() > 60) {
            throw new CadenaLargaExcepcion();
        }
        this.nombre = nombre;
    }

    public int getNotaUno() {
        return notaUno;
    }

    public void setNotaUno(int notaUno) throws NotaInvalidaExcepcion {
        if (notaUno < 0) {
            throw new NotaInvalidaExcepcion();
        }
        this.notaUno = notaUno;
    }

    public int getNotaDos() {
        return notaDos;
    }

    public void setNotaDos(int notaDos) throws NotaInvalidaExcepcion {
        if (notaDos < 0) {
            throw new NotaInvalidaExcepcion();
        }
        this.notaDos = notaDos;
    }

    public int getNotaTres() {
        return notaTres;
    }

    public void setNotaTres(int notaTres) throws NotaInvalidaExcepcion {
        if (notaTres < 0) {
            throw new NotaInvalidaExcepcion();
        }
        this.notaTres = notaTres;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    private void cargarNotas() {

        EntradaSalida.emitirMensaje("¿Desea cargar las notas del Alumno? S/N:");
        char ax = EntradaSalida.leerChar();
        Character.toUpperCase(ax);

        if (Character.compare(ax, 'S') == 0) {
            EntradaSalida.emitirMensaje("Seleccione una nota a cargar:");
            mostrarNotasACargar();
            int notAx = EntradaSalida.leerInt();

            switch (notAx) {
                case 1:
                    cargarNotaUno();
                    break;
                case 2:
                    cargarNotaDos();
                    break;
                case 3:
                    cargarNotaTres();
                    break;
                case 4:
                    generarNotaFinal();
                    break;
                default:
                    EntradaSalida.emitirMensajeLN("Valor invalido...");
                    break;
            }
        }
    }

    private void mostrarNotasACargar() {
        System.out.println("          Notas a cargar          ");

        if (this.notaUno < 0) {
            System.out.println("| 1.Primera Nota                 |");
        }
        if (this.notaDos < 0) {
            System.out.println("| 2.Segunda Nota                 |");
        }
        if (this.notaTres < 0) {
            System.out.println("| 3.Tercera Nota                 |");
        }
        if ((this.notaUno > 0) && (this.notaDos > 0) && (this.notaTres > 0)) {
            System.out.println("| 4.Generar Nota Final           |");
        }
    }

    private void cargarLegajo() {
        while (true) {
            try {
                EntradaSalida.emitirMensaje("Legajo:");
                int legAux = EntradaSalida.leerInt();
                setLegajo(legAux);
            } catch (NumberFormatException | NumeroNegativoExcepcion e) {
                EntradaSalida.emitirMensaje("Error:" + e.getMessage());
            }
        }
    }

    private void cargarNombre() {
        while (true) {
            try {
                EntradaSalida.emitirMensaje("Apellido y Nombre:");
                String nomAux = EntradaSalida.leerString();
                setNombre(nomAux);
            } catch (CadenaLargaExcepcion e) {
                EntradaSalida.emitirMensaje("Error:" + e.getMessage());
            }
        }
    }

    private void cargarNotaUno() {
        while (true) {
            try {
                EntradaSalida.emitirMensaje("Primera Nota:");
                int unAux = EntradaSalida.leerInt();
                setNotaUno(unAux);
            } catch (NotaInvalidaExcepcion e) {
                EntradaSalida.emitirMensaje("Error:" + e.getMessage());
            }
        }
    }

    private void cargarNotaDos() {
        while (true) {
            try {
                EntradaSalida.mostrarMensaje("Segunda Nota:");
                int doAux = EntradaSalida.leerInt();
                setNotaDos(doAux);
            } catch (NotaInvalidaExcepcion e) {
                EntradaSalida.emitirMensaje("Error:" + e.getMessage());
            }
        }
    }

    private void cargarNotaTres() {
        while (true) {
            try {
                EntradaSalida.mostrarMensaje("Tercera Nota:");
                int trAux = EntradaSalida.leerInt();
                setNotaTres(trAux);
            } catch (NotaInvalidaExcepcion e) {
                EntradaSalida.emitirMensaje("Error:" + e.getMessage());
            }
        }
    }

    private void generarNotaFinal() {
        int fnNota = (this.notaUno + this.notaDos + this.notaTres) / 3;
        this.notaFinal = fnNota;
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
        try {
            a.writeInt(this.legajo);
            Register.writeString(a, this.nombre, 60);
            a.writeInt(this.notaUno);
            a.writeInt(this.notaDos);
            a.writeInt(this.notaTres);
            a.writeDouble(this.notaFinal);
        } catch (IOException e) {
            System.out.println("Error al grabar los datos:" + e.getMessage());
            System.exit(1);
        }    
    }

    @Override
    public void leer(RandomAccessFile a) {
        try {
            this.legajo = a.readInt();
            this.nombre = Register.readString(a, 60).trim();
            this.notaUno = a.readInt();
            this.notaDos = a.readInt();
            this.notaTres = a.readInt();
            this.notaFinal = a.readDouble();
        } catch (IOException e) {
            System.out.println("Error al leer los datos:" + e.getMessage());
            System.exit(1);
        }    
    }

    @Override
    public void mostrarRegistro() {
        System.out.println(toString());    
    }

    @Override
    public void cargarDatos() {
        cargarLegajo();
        cargarNombre();
        cargarNotas();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Apellido y Nombre:").append(nombre).append("\n");
        sb.append("Legajo:").append(legajo).append("\n");
        sb.append("1ra Nota:").append(notaUno).append("\n");
        sb.append("2da Nota:").append(notaDos).append("\n");
        sb.append("3ra Nota:").append(notaTres).append("\n");
        sb.append("Nota Final:").append(notaFinal).append("\n");
        return sb.toString();
    }

}
