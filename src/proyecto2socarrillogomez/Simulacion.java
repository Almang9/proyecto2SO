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
public class Simulacion {
    // Colas con distintos niveles de prioridad 1 tiene la mayor prioridad, 3 tiene la menor
    public static volatile Colas nivel1;
    public static volatile Colas nivel2;
    public static volatile Colas nivel3;
    public static volatile Colas mejoras;
    public static volatile int ciclos;
    robot robot;
    administrador admin;
    superSwitch consola;
    public Simulacion(){
        // Inicialización de las colas y el robot
        nivel1 = new Colas();
        nivel2 = new Colas(); 
        nivel3 = new Colas();
        mejoras = new Colas();
        robot = new robot();
        admin = new administrador();
        consola = null;
        ciclos = 0;
        //Inicio de la simulación
        IniciarSim();
    }
    public void IniciarSim(){
        if((nivel1.getSize() + nivel2.getSize() + nivel3.getSize() + mejoras.getSize()) > 0){
            consola = admin.getSwitch();
            if(consola != null){
            robot.revisarConsola(consola);
            }
        if(ciclos == 2){
            ciclos = 0;
        admin.maybeCreateConsola();;
        }
            
        }
        
    }
    public static void main(String[] args) {
        
    }
}
