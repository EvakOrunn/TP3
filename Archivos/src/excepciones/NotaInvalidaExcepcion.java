package excepciones;

public class NotaInvalidaExcepcion extends Exception{
    
    public NotaInvalidaExcepcion(){
        super("La nota ingresada es Invalida");
    }

    public NotaInvalidaExcepcion(String message){
        super(message);
    }

}
