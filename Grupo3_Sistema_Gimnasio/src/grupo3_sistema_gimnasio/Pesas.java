/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3_sistema_gimnasio;

import javax.swing.JOptionPane;

/**
 *
 * @author ashle
 */
public class Pesas {
    
   private int capacidadMaxima = 50;
   private int capcacidadActual = 0; 
   
   // INICIALIZAMOS 

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCapcacidadActual() {
        return capcacidadActual;
    }

    public void setCapcacidadActual(int capcacidadActual) {
        this.capcacidadActual = capcacidadActual;
    }
   
    // VANMOS A HACER LOS SIGUIENTES METODOS DE REGISTRAR ENTRADA Y SALIDA VOID EN LUGAR DE VOID PARA VALIDAR DE MANERA MÁS SENSILLA
    public boolean registrarEntrada(Socio socio1) { //socio1 prueba 
        if ((!socio1.isMembresiaSocio())) { // diferente a activa
            JOptionPane.showInternalMessageDialog(null, "La membresia no esta activa no se puede registrar en la sala de pesas....");
            return false;
        }
        if (capcacidadActual >= capacidadMaxima) { // VALIDACION SI YA ESTRA LLENO 
            JOptionPane.showInternalMessageDialog(null, "La sala de pesas ya esta llena...");
            return false;
        }
        // si cumple lo requerido se registra
        capcacidadActual++;
        JOptionPane.showInternalMessageDialog(null, "SE HA REGISTRADO CON EXITO, PERSONAS EN LA SALA:  " + capcacidadActual);
        return true;
    }

    public boolean registroSalida(Socio socio1) {
        if (capcacidadActual <= 0 ) {
            JOptionPane.showInternalMessageDialog(null, "No hay personas registradas en la sala"); // para no restar 0 --
            return false;
        }
        // en caso de que cumpla la salida
        capcacidadActual--;
        JOptionPane.showInternalMessageDialog(null, "Salida Registrada con exito las personas dentro son: " + capcacidadActual);
        return true;
    }
    
    public void verCapacidadPesas () {
        JOptionPane.showInternalMessageDialog(null, "La cantidad de personas en la sala de pesas es de:  " + capcacidadActual);
    }
}
   

