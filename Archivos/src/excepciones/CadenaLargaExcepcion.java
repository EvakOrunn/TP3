package excepciones;

/**
 * La clase CadenaLargaExcepcion se encargar de mostrar un mensaje al usuario cuando le lanza la excepcion
 * en caso de que la cadena ingresada sobrepasa el limite establecido de longitud
 */
public class CadenaLargaExcepcion extends Exception{
    
    public CadenaLargaExcepcion(){
        super("La cadena supero el maximo de caracteres");
    }

    public CadenaLargaExcepcion(String message){
        super(message);
    }

}
