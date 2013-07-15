/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Automata;
/**
 *
 * @author Hola
 */
import java.util.ArrayList;
import modelo.excepciones.MachineException;

public class AutomataFinito extends Maquina {
        
    /*
     * Constuctor por defecto
     */
    public AutomataFinito(){
        estados = new ArrayList<Integer>();
        estadosFinales = new ArrayList<Integer>();
        transiciones = new ArrayList<Transicion>();
    }
    
    /*
     * Implementación de métodos abstractos de la SuperClase
     */
    @Override
    public String simular(String palabra) throws MachineException{        
        int pos = 0;
        configuracion = new Configuracion(getAlfabeto());
        configuracion.ingresarPalabra(palabra);
        configuracion.setPosicionCabezal(0);
        String resultado = "Cadena = " + configuracion.getPalabra();
        for(int i = 0; i < configuracion.getPalabra().length(); i++){
            resultado = resultado.concat("\n\nLetra leída = " + configuracion.getPalabra().charAt(i));
            for(int j = 0; j < alfabeto.getSimbolos().size(); j++){
                if(configuracion.getPalabra().charAt(i) == alfabeto.getSimbolos().get(j).charAt(0)){
                    pos=j;
                    break;                
                }
            }
            resultado = resultado.concat("\nEstado Actual = q"+configuracion.getPosicionCabezal());
            configuracion.setPosicionCabezal(proximoEstado(configuracion.getPosicionCabezal(),pos));
            resultado = resultado.concat("\nSe transiciona al estado q"+configuracion.getPosicionCabezal());
        }
        
        resultado = resultado.concat("\n\nFin del análisis de la palabra...\nSe terminó en el estado q" + configuracion.getPosicionCabezal());
        if(aceptarPalabra(configuracion.getPosicionCabezal())) {            
            resultado = resultado.concat("\nPalabra Aceptada\n\n");
        }
        else {
            resultado = resultado.concat("\nPalabra no reconocida\n\n");
        }                     
        return resultado;
    }
}
