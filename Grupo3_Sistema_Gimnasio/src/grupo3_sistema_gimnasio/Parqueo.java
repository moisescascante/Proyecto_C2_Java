/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3_sistema_gimnasio;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ashle
 */
public class Parqueo {

    /// DECLARAMOS LAS TRES MATRICES
    /// DE LOS NIVELES DEL PARQUEO Y SON CHAR YA QUE ES UNA SOLA LETRA
    private char[][] nivelG1;
    private char[][] nivelG2;
    private char[][] nivelG3;

    /// para asignar ID del socio en el campo 
    private int[][] idsG1;
    private int[][] idsG2;
    private int[][] idsG3;

    ///SETTER AND GETTER
    public char[][] getNivelG1() {
        return nivelG1;
    }

    public void setNivelG1(char[][] nivelG1) {
        this.nivelG1 = nivelG1;
    }

    public char[][] getNivelG2() {
        return nivelG2;
    }

    public void setNivelG2(char[][] nivelG2) {
        this.nivelG2 = nivelG2;
    }

    public char[][] getNivelG3() {
        return nivelG3;
    }

    public void setNivelG3(char[][] nivelG3) {
        this.nivelG3 = nivelG3;
    }

    public int[][] getIdsG1() {
        return idsG1;
    }

    public void setIdsG1(int[][] idsG1) {
        this.idsG1 = idsG1;
    }

    public int[][] getIdsG2() {
        return idsG2;
    }

    public void setIdsG2(int[][] idsG2) {
        this.idsG2 = idsG2;
    }

    public int[][] getIdsG3() {
        return idsG3;
    }

    public void setIdsG3(int[][] idsG3) {
        this.idsG3 = idsG3;
    }

    ///INICIALIZAMOS LAS MATRICES PUBLIC
    public Parqueo() {
        nivelG1 = new char[4][5];
        nivelG2 = new char[5][5];
        nivelG3 = new char[6][5];

        idsG1 = new int[4][5];
        idsG2 = new int[5][5];
        idsG3 = new int[6][5];
    }

    public void inicializarNiveles() {
        inicializarNivelCondicion(nivelG1, idsG1, "G1"); //llamamos al inicializador de condicion
        inicializarNivelCondicion(nivelG2, idsG2, "G2");
        inicializarNivelCondicion(nivelG3, idsG3, "G3");
        mostrarNivel(nivelG1, "G1");
        mostrarNivel(nivelG2, "G2");
        mostrarNivel(nivelG3, "G3");
    }

    // LLENAMOS LAS MATRICES DE LIBRE
    private void inicializarNivelCondicion(char[][] nivel, int[][] ids, String tipo) {
        for (int i = 0; i < nivel.length; i++) {
            for (int j = 0; j < nivel[0].length; j++) {
                nivel[i][j] = 'L';
                ids[i][j] = 0;
            }
        }

        // CONFIGURACION MANUAL DE DISCAPACITADOS Y ENTRENADOR SENIOR 
        if (tipo.equals("G1")) {
            nivel[0][0] = 'E';
            nivel[3][0] = 'D';
            nivel[3][1] = 'D';
            nivel[3][2] = 'D';
        } else if (tipo.equals("G2")) {
            nivel[0][0] = 'E';
            nivel[4][0] = 'D';
            nivel[4][1] = 'D';
            nivel[4][2] = 'D';
        } else if (tipo.equals("G3")) {
            nivel[0][0] = 'E';
            nivel[5][0] = 'D';
            nivel[5][1] = 'D';
            nivel[5][2] = 'D';
        }
    }

    public void mostrarNivel(char[][] nivel, String nombreNivel) {
        StringBuilder resultado = new StringBuilder(); // impresion mas compacta
        resultado.append("nivel ").append(nombreNivel).append("\n"); // inyectar los datos al nivel correspondiente

        for (int i = 0; i < nivel[0].length; i++) {
            resultado.append((i + 1)).append(" ");
        }
        resultado.append("\n");

        char fila = 'A';
        for (int i = 0; i < nivel.length; i++) {
            resultado.append(fila).append(" ");
            for (int j = 0; j < nivel[0].length; j++) {
                resultado.append("|").append(nivel[i][j]);
            }
            resultado.append("|\n");
            fila++;
        }

        JOptionPane.showMessageDialog(null, resultado.toString());

    }

    public boolean asignarEspacio(char[][] nivel, int[][] ids, int idSocio) {
        String filaInput = JOptionPane.showInputDialog("Digite la letra de la fila que desea parquear A - B - C - D");
        String columnaInput = JOptionPane.showInputDialog("Digite el numero de la columna 1 - 2 - 3 ....");

        int fila = filaInput.toUpperCase().charAt(0) - 'A'; // Ponemos uppercase en caso de que entre lower y asiganmos al char la letra dada colocamos el espacio
        int columna = Integer.parseInt(columnaInput) - 1;

        if (fila >= 0 && fila < nivel.length && columna >= 0 && columna < nivel[0].length) { // que no entre vacio
            char espacio = nivel[fila][columna];

            if (espacio == 'L') { // si esta libre
                nivel[fila][columna] = 'O'; //  sale como ocupado
                ids[fila][columna] = idSocio; // sacomos id de clase socio
                JOptionPane.showInternalMessageDialog(null, "Se Asigno el parqueo correctamente");
                mostrarNivel(nivel, columnaInput);
                return true;
            } else if (espacio == 'D') {
                JOptionPane.showInternalMessageDialog(null, "Espacio de discapacitados");
            } else if (espacio == 'E') {
                JOptionPane.showInternalMessageDialog(null, "Espacio de Entrenador Senior");
            } else {
                JOptionPane.showInternalMessageDialog(null, "Espacio fuera de rango");
            }
        }
        return false;
    }

    public String getEstadoNivel(char[][] nivel) {
        int total = 0;
        int ocupados = 0;

        for (int i = 0; i < nivel.length; i++) {
            for (int j = 0; j < nivel[i].length; j++) {
                total++;
                if (nivel[i][j] != '0') {
                    ocupados++;
                }
            }
        }

        return ocupados + " espacios ocupados de " + total;
    }
}


