/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3_sistema_gimnasio;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author ashle
 */
public class TestGUI extends JFrame {

    private Font nunitoBold;

    public TestGUI() {

        setTitle("Test GUI");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#a7c4ce"));
      // Panel para el logo (arriba)
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(Color.decode("#a7c4ce"));
        ImageIcon originalIcon = new ImageIcon("iconos/Logo.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);  // Escalamos para que no tape todo
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel labelLogo = new JLabel(scaledIcon);
        panelLogo.add(labelLogo);
        add(panelLogo, BorderLayout.NORTH);

        Font nunitoBold;
        try {
            nunitoBold = Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Nunito-Bold.ttf")).deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(nunitoBold);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            nunitoBold = new Font("SansSerif", Font.BOLD, 18); // fallback
        }

        File logoFile = new File("iconos/Logo.png");
        if (logoFile.exists()) {
            System.out.println(" Imagen encontrada correctamente");
        } else {
            System.out.println(" Imagen no encontrada. Verifica la ruta: " + logoFile.getAbsolutePath());
        }

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

        JLabel label = new JLabel("Hola Mundo", SwingConstants.CENTER);
        label.setFont(nunitoBold);
        add(label, BorderLayout.CENTER);

        JButton btn = new JButton("Click Me");
        add(btn, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TestGUI());
    }
}
