
package Controlador;
import Modelo.*;
import java.io.ObjectInputStream;

public class SerializarFlujoSalida {
    private RegistroVenta registro;
    
    public SerializarFlujoSalida(RegistroVenta registro){
        this.registro = registro;
    }
    
    public void SerializarObjeto(){
        try{
            ObjectInputStream flujoSalida = new ObjectInputStream(new FileOutputStream("Notas.dat"));
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
            
        
    }
   
}
