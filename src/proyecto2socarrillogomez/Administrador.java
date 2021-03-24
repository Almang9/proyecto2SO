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
public class Administrador {
    Colas nivel1;
    Colas nivel2;
    Colas nivel3;
    Colas mejoras;
    int nextId;
    Interfaz interfaz;
    
    public Administrador(Interfaz interfaz) {
        this.interfaz = interfaz;
        nivel1 = new Colas();
        nivel2 = new Colas();
        nivel3 = new Colas();
        mejoras = new Colas();
        nextId = 0;
    }
    
    public SSwitch getSwitch() {
        SSwitch consola = null;
        SSwitch cambio = null;
        //Revisa la cola de mayot prioridad primero
        if (!nivel1.isEmpty()) {
            consola = nivel1.desencolar();
            consola.resetearContador();
            interfaz.setNivel1(nivel1.print());
            System.out.println(consola.id);
        }
        //Revisa la cola de nivel 2 en caso de no existir una en la cola 3
        else if(!nivel2.isEmpty()) {
            interfaz.setNivel1("Vacia...");
            consola = nivel2.desencolar();
            consola.resetearContador();
            interfaz.setNivel2(nivel2.print());
            System.out.println(consola.id);
        }
        //Revisa la cola de nivel 3 en caso de no existir ninguna en la cola 1 y 2
        else if(!nivel3.isEmpty()) {
            interfaz.setNivel1("Vacia...");
            interfaz.setNivel2("Vacia...");
            consola = nivel3.desencolar();
            consola.resetearContador();
            interfaz.setNivel3(nivel3.print());
            System.out.println(consola.id);
        }
        if(nivel3.isEmpty()){
        interfaz.setNivel3("Vacia...");
        }
        if(nivel2.isEmpty()){
            interfaz.setNivel2("Vacia...");
        }
        if(nivel1.isEmpty()){
            interfaz.setNivel1("Vacia...");            
        }
        
        //Actualiza los contadores de cada uno de los switch
        nivel1.actualizarContador();
        nivel2.actualizarContador();
        nivel3.actualizarContador();
        mejoras.actualizarContador();
        //Revisa si la primera consola en la cola 2 que haya pasado más de 15 ciclos sin agarrarse
        if (!nivel2.isEmpty()) {
            if (nivel2.getFirst().prioridad != 2) {
                cambio = nivel2.desencolar();
                nivel1.encolar(cambio);
                interfaz.setNivel2(nivel2.print());
                interfaz.setNivel1(nivel1.print());
            }
        }
       //Revisa si la primera consola en la cola 3 que haya pasado más de 15 ciclos sin agarrarse
        if (!nivel3.isEmpty()) {
            if (nivel3.getFirst().prioridad != 3) {
                cambio = nivel3.desencolar();
                nivel2.encolar(cambio);
                interfaz.setNivel2(nivel2.print());
                interfaz.setNivel3(nivel3.print());
            }
        }
        return consola;
    }

    public void encolarListos(SSwitch nodo) {
        if (nodo != null) {
            // vuelve a encolar a las colas de prioridad, un nodo
            switch(nodo.prioridad) {
                case 1:
                    nivel1.encolar(nodo);
                    interfaz.setNivel1(nivel1.print());
                    break;
                case 2:
                    nivel2.encolar(nodo);
                    interfaz.setNivel2(nivel2.print());
                    break;
                case 3:
                    nivel3.encolar(nodo);
                    interfaz.setNivel3(nivel3.print());
                    break;
            }
        }
    }
    
    public void encolarMejoras(SSwitch nodo) {
        //encola un superSwitch a la cola de mejoras
        if (nodo != null) {
            mejoras.encolar(nodo);
            interfaz.setMejoras(mejoras.print());
        }
    }
    
    public void crearConsola() {
        //Crea una nueva consola con una prioridad aleatoria
        int nivel = 1 + (int)(Math.random()*((3-1)+1)); //Genera un número entre 1 y 3
        SSwitch consola = new SSwitch(nextId, nivel);
        encolarListos(consola);
        nextId++;
    }
    public void maybeCreateConsola(){
        double prob = Math.random();
        if (prob > 0.3){
        System.out.println("Se creó una consola nueva");
        crearConsola();
        }else{
        System.out.println("No se creó nada");
        }
    }
    /*public SSwitch getSwitch(){
        SSwitch consola = null;
    // Revisando que la cola de nivel 1 tenga una consola que retirar
        if(Simulacion.nivel1.getSize() != 0){
            consola =  Simulacion.nivel1.desencolar();
            Simulacion.nivel1.desencolar();
    // Revisando que la cola de nivel 2 tenga una consola que retirar
        }else if (Simulacion.nivel2.getSize() != 0){
            consola =  Simulacion.nivel2.desencolar();
            Simulacion.nivel2.desencolar();
    // Revisando que la cola de nivel 3 tenga una consola que retirar
        }else if(Simulacion.nivel3.getSize()!= 0){
            consola =  Simulacion.nivel3.desencolar();
            Simulacion.nivel3.desencolar();
    // Revisando que la cola de mejoras tenga una consola que retirar
        }else if(Simulacion.mejoras.getSize() != 0){
            consola =  Simulacion.mejoras.desencolar();    
            Simulacion.mejoras.desencolar();
    
    }
        return consola;
    }
        
    public void actualizarColas(){
    Simulacion.nivel1.actualizarContador();
    
    }*/
}

