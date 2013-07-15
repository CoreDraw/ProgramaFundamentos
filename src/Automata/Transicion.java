/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Automata;

/**
 *
 * @author Hola
 */
public class Transicion {
    /*
     * Atributos
     */
    private int estadoActual;
    private int proximoEstado;
    private String simbolo;
    
    /*
     * Constructores
     */
    //Constructor por defecto
    public Transicion(){}
    
    //Constructor con parámetros
    public Transicion(int estadoActual, String simbolo, int proximoEstado){
        this.estadoActual = estadoActual;
        this.simbolo = simbolo;
        this.proximoEstado = proximoEstado;
    }

    /*
     * Métodos accesores y mutadores
     */
    public int getEstadoActual() {
        return estadoActual;
    }

    public int getProximoEstado() {
        return proximoEstado;
    }

    public String getSimbolo() {
        return simbolo;
    }    
}
