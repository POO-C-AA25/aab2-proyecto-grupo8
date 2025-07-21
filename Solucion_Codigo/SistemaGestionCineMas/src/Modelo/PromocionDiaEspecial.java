
package Modelo;

public class PromocionDiaEspecial extends Promocion{
    private int dia;

    public PromocionDiaEspecial(double precio, int dia) {
        super(precio);
        this.dia = dia;
    }
    public boolean esAplicable(int diaFuncion){
        if (this.dia == diaFuncion){
            return true;
        }else{
            return false;
        }
    }
    public double calcularPromocion(int diaFuncion){
        if (esAplicable(diaFuncion)){
            return this.precio * 0.30;
        }else{
            return this.precio;
        }
    }
}
