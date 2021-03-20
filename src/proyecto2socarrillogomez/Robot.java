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
public class Robot {
    int terminadas;
    int ciclos;
    
    public Robot() {
        this.terminadas = 0;
        this.ciclos = 0;
    }
    
    public void revisar(SSwitch consola, Administrador admin) throws InterruptedException {
        double random = Math.random();
        SSwitch aux = null;
        
        if (consola != null) {
            Thread.sleep(7000);
            if (random < 0.3) {
                this.terminadas++;
            }
            else if (random >= 0.3 && random < 0.8) {
                admin.encolarListos(consola);
            }
            else {
                admin.encolarMejoras(consola);
            }
        }
        ciclos++;
        random = Math.random();
        if (ciclos % 2 == 0 && random < 0.7) {
            admin.crearConsola();
        }
        random = Math.random();
        if (!admin.mejoras.isEmpty() && random < 0.45 ) {
            aux = admin.mejoras.desencolar();
            admin.encolarListos(aux);
        }
    }
    
    /*public void revisarConsola(SSwitch consolaReb){
        consola = consolaReb;
        double prob = Math.random();
        if(prob <= 0.3){
            despachar();
        }else if(0.3 < prob && prob <= 0.8){
            reencolar();
        }else{
        // prob is between 0.8 and 1.0
            reencolarMejoras();
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
    public void reencolarMejoras(){
        Simulacion.mejoras.encolar(consola);
    }*/
    
}
