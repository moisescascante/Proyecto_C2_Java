/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3_sistema_gimnasio;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author ashle
 */
public class GUI extends JFrame {

    // COLORES DEL GUI Y BOTONES
    private Color fondo = Color.decode("#a7c4ce");
    private Color colorBoton = Color.decode("#416975");
    private Color colorLetraBoton = Color.decode("#FFFFFF");
    private Font nunitoBold;
    private JPanel panelMenuOpciones; // panel con los botones del menÃº
    private JLabel labelContenido;
    private Parqueo parqueo = new Parqueo();  // ahora es un atributo global para no se elimine los estados del parqueo 
    private JTextArea estadoParqueo;

    public GUI() {

        super("Nova Gym");
        System.out.println("Constructor GUI iniciado");

        // Try-catch para cargar la fuente Nunito-Bold
        try {
            nunitoBold = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Nunito-Bold.ttf")).deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(nunitoBold);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            nunitoBold = new Font("SansSerif", Font.BOLD, 18); // fallback
        }

        // Configuracion de ventana
        setTitle("NOVA GYM");
        setResizable(false);
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(fondo);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

           // Panel para el logo (arriba)
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(Color.decode("#a7c4ce"));
        ImageIcon originalIcon = new ImageIcon("iconos/Logo.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);  // Escalamos para que no tape todo
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel labelLogo = new JLabel(scaledIcon);
        panelLogo.add(labelLogo);
        add(panelLogo, BorderLayout.NORTH);

        // Panel central (título y otros)
        JPanel panelCentro = new JPanel();
        panelCentro.setBackground(Color.decode("#a7c4ce"));
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Sistema de Gestión del Gimnasio");
        titulo.setFont(nunitoBold);
        titulo.setForeground(Color.BLACK);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentro.add(titulo);

        add(panelCentro, BorderLayout.CENTER);

        // MAIN 
        JPanel main = new JPanel();
        JLabel label = new JLabel("BIENVENIDO AL NOVA GYM", SwingConstants.CENTER);
        titulo.setFont(nunitoBold.deriveFont(24f));
        titulo.setForeground(colorBoton);
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        main.add(titulo);

        // Mensaje dinamico
        labelContenido = new JLabel("Selecciona una opción del menú.", SwingConstants.CENTER);
        labelContenido.setFont(nunitoBold.deriveFont(20f));
        labelContenido.setForeground(colorBoton);
        labelContenido.setBorder(BorderFactory.createEmptyBorder(5, 10, 15, 10));
        labelContenido.setAlignmentX(Component.CENTER_ALIGNMENT);
        main.add(labelContenido);

        // Agregar parte superior
        add(main, BorderLayout.NORTH);

        // Panel central con boton "Menu"
        JPanel panelCentral = new JPanel();
        panelCentral.setBackground(fondo);
        panelCentral.setLayout(new GridBagLayout());

        JButton btnMenu = new JButton("Menu");
        btnMenu.setFont(nunitoBold.deriveFont(18f));
        btnMenu.setPreferredSize(new Dimension(140, 50));
        panelCentral.add(btnMenu);
        add(panelCentral, BorderLayout.CENTER);

        // Panel con botones de opciones
        panelMenuOpciones = new JPanel();
        panelMenuOpciones.setBackground(fondo);
        panelMenuOpciones.setLayout(new GridLayout(4, 2, 10, 10));
        panelMenuOpciones.setVisible(false);
        panelMenuOpciones.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        String[] textos = {
            "1. Clases Disponibles", "2. Editar Clases", "3. Crear Clase",
            "4. Registrar Socio", "5. Sala de Pesas", "6. Parqueo", "7. Salir"
        };

        for (String texto : textos) {
            JButton btn = new JButton(texto);
            btn.setFont(nunitoBold.deriveFont(18f));
            btn.setPreferredSize(new Dimension(140, 45));
            btn.addActionListener(e -> manejarOpcion(texto.charAt(0)));
            panelMenuOpciones.add(btn);
        }

        add(panelMenuOpciones, BorderLayout.SOUTH);

        btnMenu.addActionListener(e -> {
            btnMenu.setVisible(false);
            panelMenuOpciones.setVisible(true);
            revalidate();
            repaint();
        });

        setVisible(true);

        // Forzar repaint y revalidate después de mostrar
        SwingUtilities.invokeLater(() -> {
            repaint();
            revalidate();
        });
    

    }

    private void manejarOpcion(char opcion) {
        switch (opcion) {
            case '1':
                labelContenido.setText("Clases disponibles (pendiente implementación)");
                break;
            case '2':
                labelContenido.setText(" Editar clases (pendiente implementación)");
                break;
            case '3':
                labelContenido.setText("Crear clase (pendiente implementación)");
                break;
            case '4':
                labelContenido.setText("Registrar socio (pendiente implementación)");
                break;
            case '5':
                labelContenido.setText(" Sala de pesas (pendiente implementación)");
                break;
            case '6':
                labelContenido.setText("Parqueo");
                mostrarPanelParqueo();
                break;
            case '7':
                int res = JOptionPane.showConfirmDialog(this, "¿Desea salir del Menu");
                if (res == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                break;
            default:
                labelContenido.setText("️Opción no válida");
        }

    }

    

    // CREAMOS PANEL PARA MODULO DE PARQUE, SU PROPIO VOID PARA SOLO INSTANSEARLO
    private void mostrarPanelParqueo() {
        parqueo.inicializarNiveles();

        // Limpiar panel central y menú
        getContentPane().removeAll();
        repaint();
        revalidate();

        JPanel panelParqueo = new JPanel();
        panelParqueo.setLayout(new BoxLayout(panelParqueo, BoxLayout.Y_AXIS));
        panelParqueo.setBackground(fondo);
        panelParqueo.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel titulo = new JLabel("Gestión de Parqueo");
        titulo.setFont(nunitoBold.deriveFont(24f));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setForeground(colorBoton);
        panelParqueo.add(titulo);
        panelParqueo.add(Box.createVerticalStrut(20));

        // Combo niveles
        String[] niveles = {"G1", "G2", "G3"};
        JComboBox<String> comboNiveles = new JComboBox<>(niveles);
        comboNiveles.setFont(nunitoBold);
        comboNiveles.setMaximumSize(new Dimension(200, 30));
        panelParqueo.add(new JLabel("Seleccione Nivel:"));
        panelParqueo.add(comboNiveles);
        panelParqueo.add(Box.createVerticalStrut(15));

        // Combo socios
        String[] socios = {
            Grupo3_Sistema_Gimnasio.getSocio1().getNombreSocio() + " (ID: " + Grupo3_Sistema_Gimnasio.getSocio1().getIdSocio() + ")",
            Grupo3_Sistema_Gimnasio.getSocio3().getNombreSocio() + " (ID: " + Grupo3_Sistema_Gimnasio.getSocio3().getIdSocio() + ")"
        };
        JComboBox<String> comboSocios = new JComboBox<>(socios);
        comboSocios.setFont(nunitoBold);
        comboSocios.setMaximumSize(new Dimension(300, 30));
        panelParqueo.add(new JLabel("Seleccione Socio:"));
        panelParqueo.add(comboSocios);
        panelParqueo.add(Box.createVerticalStrut(15));

        // Área de estado (la hacemos global)
        estadoParqueo = new JTextArea(5, 40);
        estadoParqueo.setEditable(false);
        estadoParqueo.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(estadoParqueo);
        panelParqueo.add(scroll);
        panelParqueo.add(Box.createVerticalStrut(15));

        actualizarEstadoParqueo(); // Mostrar el estado al entrar

        // Botón Asignar
        JButton btnAsignar = new JButton("Asignar espacio");
        btnAsignar.setFont(nunitoBold.deriveFont(16f));
        btnAsignar.setBackground(colorBoton);
        btnAsignar.setForeground(colorLetraBoton);
        btnAsignar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelParqueo.add(btnAsignar);

        btnAsignar.addActionListener(e -> {
            String nivel = (String) comboNiveles.getSelectedItem();
            int idSocio = comboSocios.getSelectedIndex() == 0
                    ? Grupo3_Sistema_Gimnasio.getSocio1().getIdSocio()
                    : Grupo3_Sistema_Gimnasio.getSocio3().getIdSocio();

            switch (nivel) {
                case "G1" ->
                    parqueo.asignarEspacio(parqueo.getNivelG1(), parqueo.getIdsG1(), idSocio);
                case "G2" ->
                    parqueo.asignarEspacio(parqueo.getNivelG2(), parqueo.getIdsG2(), idSocio);
                case "G3" ->
                    parqueo.asignarEspacio(parqueo.getNivelG3(), parqueo.getIdsG3(), idSocio);
            }

            actualizarEstadoParqueo();
        });

        // Botón Volver
        JButton btnVolver = new JButton("Volver al menú");
        btnVolver.setFont(nunitoBold.deriveFont(14f));
        btnVolver.setBackground(Color.LIGHT_GRAY);
        btnVolver.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVolver.addActionListener(e -> {
            getContentPane().removeAll();
          //  mostrarMenuPrincipal(); // Aquí deberías tener tu método de menú
            revalidate();
            repaint();
        });

        panelParqueo.add(Box.createVerticalStrut(20));
        panelParqueo.add(btnVolver);

        getContentPane().add(panelParqueo, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

// Método auxiliar para actualizar el estado
    private void actualizarEstadoParqueo() {
        estadoParqueo.setText(
                "Nivel G1: " + parqueo.getEstadoNivel(parqueo.getNivelG1()) + "\n"
                + "Nivel G2: " + parqueo.getEstadoNivel(parqueo.getNivelG2()) + "\n"
                + "Nivel G3: " + parqueo.getEstadoNivel(parqueo.getNivelG3())
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }
}
