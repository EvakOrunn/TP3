package excepciones;

public class NumeroNegativoExcepcion extends Exception{
    
    public NumeroNegativoExcepcion(){
        super("Se ingreso un numero negativo");
    }

    public NumeroNegativoExcepcion(String message){
        super(message);
    }

}
