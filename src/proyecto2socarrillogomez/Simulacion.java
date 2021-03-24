/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2socarrillogomez;
import java.lang.Math;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alman
 */
public class Simulacion {
    // Colas con distintos niveles de prioridad 1 tiene la mayor prioridad, 3 tiene la menor       
    Robot robot;
    Administrador admin;
    SSwitch consola;
    Interfaz interfaz;
    boolean simulacion = true;
    public Simulacion(Interfaz interfaz){
        // Inicialización de las colas y el robot        
        this.interfaz = interfaz;
        robot = new Robot(this.interfaz);
        admin = new Administrador(this.interfaz);        
    }
    
    public void IniciarSim(){
        admin.crearConsola();        
        while(simulacion){
            try {                
                consola = admin.getSwitch();
                robot.revisar(consola, admin);
                
                consola = null;
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulacion.class.getName()).log(Level.SEVERE, null, ex);
            }                       
        if(admin.nextId == 2147483647){
        simulacion = false;
        System.out.println("SIMULACION FINALIZADA");
        break;
        }
        }
    }
    
    
    public static void main(String[] args) {
        Interfaz f = new Interfaz();
        f.setResizable(false);
        f.setLocationRelativeTo(null);       
        f.setVisible(true);
        f.s.IniciarSim();
    }
}
