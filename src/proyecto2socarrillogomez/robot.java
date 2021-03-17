/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2socarrillogomez;
import java.lang.Math;
/**
 *
 * @author Alman
 */
public class robot {
    nodo consola;
    public void revisarConsola(nodo consolaReb){
        consola = consolaReb;
    double prob = Math.random();
    if(prob <= 0.3){
    despachar();
    }else if(0.3 < prob && prob <= 0.8){
    reencolar();
    }else{
    // prob is between 0.8 and 1.0
    reencolarmejoras();
    }
    }
    
    public void despachar(){
    Simulacion.despachados++;
    System.out.println("Consola despachada");
    }
    public void reencolar(){
        switch (consola.prioridad) {
            case 1:
                Simulacion.nivel1.encolar(consola);
                break;
            case 2:
                Simulacion.nivel2.encolar(consola);
                break;
            default:
                Simulacion.nivel3.encolar(consola);
                break;
        }
    }
    public void reencolarmejoras(){
        Simulacion.mejoras.encolar(consola);
    }
    
}
