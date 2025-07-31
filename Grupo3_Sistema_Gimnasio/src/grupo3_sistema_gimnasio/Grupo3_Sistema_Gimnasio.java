/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grupo3_sistema_gimnasio;

import java.io.File;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author ashle
 */
public class Grupo3_Sistema_Gimnasio {

    /**
     * @param args the command line arguments
     */
    /// CREAMOS CLASE PREDETERMINADAS Y LA NUEVA CLASE
        
    private static Actividad nuevaActividad;
    private static Actividad Yoga = new Actividad("Yoga", LocalTime.of(6, 0), 6, 0);
    private static Actividad Crossfit = new Actividad("Crossfit", LocalTime.of(7, 0), 7, 0);
    private static Actividad Zumba = new Actividad("Zumba", LocalTime.of(8, 0), 8, 0);
    private static Actividad Pilates = new Actividad("Pilates", LocalTime.of(17, 0), 13, 0);
    private static Actividad funcionales = new Actividad("funcionales", LocalTime.of(18, 0), 7, 0);
    private static Actividad Boxeo = new Actividad("Boxeo", LocalTime.of(19, 0), 11, 0);
    private static Socio socio1 = new Socio("Juan", 1252, true);
    private static Socio socio3 = new Socio("Matias", 3828, false);

    // INICILIZAMOS TODOS LOS OBJETOS
    public static Socio getSocio3() {
        return socio3;
    }

    public static void setSocio3(Socio socio3) {
        Grupo3_Sistema_Gimnasio.socio3 = socio3;
    }

    public static Socio getSocio1() {
        return socio1;
    }

    public static void setSocio1(Socio socio1) {
        Grupo3_Sistema_Gimnasio.socio1 = socio1;
    }

    public static Actividad getNuevaActividad() {

        return nuevaActividad;
    }

    public static void setNuevaActividad(Actividad nuevaActividad) {
        Grupo3_Sistema_Gimnasio.nuevaActividad = nuevaActividad;
    }

    public static Actividad getYoga() {
        return Yoga;
    }

    public static void setYoga(Actividad Yoga) {
        Grupo3_Sistema_Gimnasio.Yoga = Yoga;
    }

    public static Actividad getCrossfit() {
        return Crossfit;
    }

    public static void setCrossfit(Actividad Crossfit) {
        Grupo3_Sistema_Gimnasio.Crossfit = Crossfit;
    }

    public static Actividad getZumba() {
        return Zumba;
    }

    public static void setZumba(Actividad Zumba) {
        Grupo3_Sistema_Gimnasio.Zumba = Zumba;
    }

    public static Actividad getPilates() {
        return Pilates;
    }

    public static void setPilates(Actividad Pilates) {
        Grupo3_Sistema_Gimnasio.Pilates = Pilates;
    }

    public static Actividad getFuncionales() {
        return funcionales;
    }

    public static void setFuncionales(Actividad funcionales) {
        Grupo3_Sistema_Gimnasio.funcionales = funcionales;
    }

    public static Actividad getBoxeo() {
        return Boxeo;
    }

    public static void setBoxeo(Actividad Boxeo) {
        Grupo3_Sistema_Gimnasio.Boxeo = Boxeo;
    }

    public static void main(String[] args) {
        

        // INTANCEAMOS EL GUI 
 
        int opcion1 = JOptionPane.showConfirmDialog(null, "¿Desea ingresar al menú gráfico?");

        if (opcion1 == JOptionPane.YES_OPTION) {
            SwingUtilities.invokeLater(() -> new GUI());
            
            return; //  esto evita que continúe el resto del código
        }

        
        /// EJECUTA SOLO SI LA OTRA OPCION ES FALSA MENU DE CREAR ACTIVIDAD, MOSTRAR ESTADO DE ACTIVIDADES Y EDITAR LAS ACTIVIDADES
        
        int opcion = JOptionPane.showConfirmDialog(null, "¿Desea ingresar al menu?");

        boolean estadoMenu = (opcion == JOptionPane.YES_OPTION);

        while (estadoMenu) {

            int option2 = Integer.parseInt(JOptionPane.showInputDialog("¿Que Deseas Editar?\n"  /// CREAMOS LA VARIABLE PARA EL SWITCH
                    + "1. Clases Disponibles\n"
                    + "2. Editar Clases\n"
                    + "3. Crear Clase \n"
                    + "4. Registrasr a un socio en una clase \n"
                    + "5. Sala de Pesas \n"
                    + "6. Parqueo \n"
                    + "7. Salir"));
            switch (option2) {
                case 1:
                    JOptionPane.showMessageDialog(null, "ESTA SON LA CLASES DISPONIBLES DE LA MAÑANA:  \n"
                            + Yoga.toString() + "  \n"
                            + Crossfit.toString() + "  \n"
                            + Zumba.toString() + "  \n"
                            + "ESTA SON LA CLASES DISPONIBLES DE LA NOCHE:  \n"
                            + Pilates.toString() + "  \n"
                            + funcionales.toString() + "  \n"
                            + Boxeo.toString());
                    break;
                case 2:
                    /// ESTE ES PARA EDITAR TODAS LAS ACTIVIDADES YA CREADAS 
                      ///
                    
                    boolean editarDatos = true;  // creamos este dato booleano para que se pueda volver a preguntar si desea cambiar algo + y salir del while

                    while (editarDatos) {

                        int option3 = Integer.parseInt(JOptionPane.showInputDialog("¿Que Activida desea Editar?\n"  /// CREAMOS LA VARIABLE PARA EL SWITCH 
                   + "1. Yoga \n"
                                + "2. Crossfit \n"
                                + "3. Zumba \n"
                                + "4. Pilates \n"
                                + "5. funcionales \n"
                                + "6. Boxeo \n"
                                + "7. Salir"));
                        switch (option3) {

                            case 1:
                                Grupo3_Sistema_Gimnasio.getYoga().editarCuestionario();
                                JOptionPane.showInternalMessageDialog(null, Grupo3_Sistema_Gimnasio.getYoga().toString());
                                break;
                            case 2:
                                Grupo3_Sistema_Gimnasio.getCrossfit().editarCuestionario();
                                JOptionPane.showMessageDialog(null, Grupo3_Sistema_Gimnasio.getCrossfit().toString());
                                break;
                            case 3:
                                Grupo3_Sistema_Gimnasio.getZumba().editarCuestionario();
                                JOptionPane.showInternalMessageDialog(null, Grupo3_Sistema_Gimnasio.getZumba().toString());
                                break;
                            case 4:
                                Grupo3_Sistema_Gimnasio.getPilates().editarCuestionario();
                                JOptionPane.showInternalMessageDialog(null, Grupo3_Sistema_Gimnasio.getPilates().toString());
                                break;
                            case 5:
                                Grupo3_Sistema_Gimnasio.getFuncionales().editarCuestionario();
                                JOptionPane.showInternalMessageDialog(null, Grupo3_Sistema_Gimnasio.getFuncionales().toString());
                                break;
                            case 6:
                                Grupo3_Sistema_Gimnasio.getBoxeo().editarCuestionario();
                                JOptionPane.showInternalMessageDialog(null, Grupo3_Sistema_Gimnasio.getBoxeo().toString());
                                break;
                            case 7:
                                editarDatos = false;
                                continue; //continua con el codigo  
                            default:
                                JOptionPane.showMessageDialog(null, "La opcion no es valida");
                                continue;
                        }
                        // consultamos si desea seguir editando 
                        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea cambiar otra activida?");
                        editarDatos = (respuesta == JOptionPane.YES_OPTION);
                    }
                    break;
                case 3:
                    nuevaActividad = new Actividad(" ", LocalTime.of(0, 0), 0, 0);
                    nuevaActividad.crearActividad(); // LLENAR LA INFO DE LA ACTIVIDAD
                    nuevaActividad.editarCuestionario(); // Editar actividad creada
                    JOptionPane.showInternalMessageDialog(null, nuevaActividad.toString());
                    break;
                case 4:

                    // MINI MENU PARA VALIDAR EL ID DEL SOCIO DEL LADO DE LA SECRETARIA 
                    int idSocioIngresado = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del socio que desea ingresa *PRUEBA 3828 1252*"));
                    Socio socioEncontrado = null; // vamos a usarlo al validar

                    // BUSCAMOS EL SOCIO SIN ARRAYS NO HEMOS VISTO 
                    if (idSocioIngresado == socio1.getIdSocio()) {
                        socioEncontrado = socio1;
                    } else if (idSocioIngresado == socio3.getIdSocio()) {
                        socioEncontrado = socio3;
                    } else {
                        JOptionPane.showMessageDialog(null, "Socio no encontrado");
                    }

                    if (socioEncontrado != null) {
                        int clase = Integer.parseInt(JOptionPane.showInputDialog(" A cual de las siguientes clases desea registrar al Socio \n"
                                + "1. Yoga \n"
                                + "2. Crossfit \n"
                                + "3. Zumba \n"
                                + "4. Pilates \n"
                                + "5. funcionales \n"
                                + "6. Boxeo \n"));
                        if (clase == 1) {
                            Yoga.registrarSocio(socioEncontrado);
                        } else if (clase == 2) {
                            Crossfit.registrarSocio(socioEncontrado);
                        } else if (clase == 3) {
                            Zumba.registrarSocio(socioEncontrado);
                        } else if (clase == 4) {
                            Pilates.registrarSocio(socioEncontrado);
                        } else if (clase == 5) {
                            funcionales.registrarSocio(socioEncontrado);
                        } else if (clase == 5) {
                            Boxeo.registrarSocio(socioEncontrado);
                        } else {
                            JOptionPane.showInternalMessageDialog(null, "La opcion no es valida");
                        }

                    }
                    break;
                case 5:
                    Pesas sala = new Pesas();

                    boolean seguir = true; // para poder salir del while

                    while (seguir) {

                        int option4 = Integer.parseInt(JOptionPane.showInputDialog(" BIENVENIDO A LA SALA DE PESAS \n"  /// CREAMOS LA VARIABLE PARA EL SWITCH 
                                + "1. Registrar Entrada \n"
                                + "2. Registrar Salida \n"
                                + "3. Ver Cantidad de personas dentro \n"
                                + "4. Salir"));
                        switch (option4) {

                            case 1:
                                sala.registrarEntrada(socio1);
                                /// solo socio1 para pruebas
                                 break;
                            case 2:
                                sala.registroSalida(socio1);
                                break;
                            case 3:
                                sala.verCapacidadPesas();
                                break;
                            case 4:
                                seguir = false;
                                break;
                            default:
                                JOptionPane.showInternalMessageDialog(null, "La opcion no es valida");
                        }

                    }

                    break;
                case 6:
                    Parqueo parqueo = new Parqueo();
                    
                    boolean parquear = (opcion == JOptionPane.YES_OPTION);
                    
                    while (parquear) {

                    int parqueo1;
                    
                    parqueo1 = Integer.parseInt(JOptionPane.showInputDialog("Seleccione 1. Menu de Parqueo, 2. Salir"));
                    
                        switch (parqueo1) {

                            case 1:
                                JOptionPane.showMessageDialog(null, "ESTE ES EL ESTADO ACTUAL DE LOS PARQUEOS");
                                parqueo.inicializarNiveles(); 
                                int nivel = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el nivel del parqueo: 1. G1, 2. G2, 3. G3"));

                                //MOSTRAR LOS SOCIOS QUE SE PUEDEN PARQUEAR
                                int socioSelec = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el ID del Socio \n"
                                        + "1. " + Grupo3_Sistema_Gimnasio.getSocio1().getNombreSocio() + " ID: " + Grupo3_Sistema_Gimnasio.getSocio1().getIdSocio() + " \n "
                                        + "2. " + Grupo3_Sistema_Gimnasio.getSocio3().getNombreSocio() + "ID " + Grupo3_Sistema_Gimnasio.getSocio3().getIdSocio()));

                                int idSocio;

                                if (socioSelec == 1) {
                                    idSocio = Grupo3_Sistema_Gimnasio.getSocio1().getIdSocio();
                                } else {
                                    idSocio = Grupo3_Sistema_Gimnasio.getSocio3().getIdSocio();
                                }

                                if (nivel == 1) {
                                    parqueo.asignarEspacio(parqueo.getNivelG1(), parqueo.getIdsG1(), idSocio);
                                } else if (nivel == 2) {
                                    parqueo.asignarEspacio(parqueo.getNivelG2(), parqueo.getIdsG2(), idSocio);
                                } else if (nivel == 3) {
                                    parqueo.asignarEspacio(parqueo.getNivelG3(), parqueo.getIdsG3(), idSocio);
                                }
                                
                                //JOptionPane.showInputDialog("Desea salir del parqueo");
                                
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Gracias por usar el parqueo!!");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "La opcion selecionada no es valida");
                                break;
                        }

                        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea ingresar de nuevo al parqueo?");
                        parquear = (respuesta == JOptionPane.YES_OPTION);
                    }
                    

                    break;
                case 7:
                    estadoMenu = false;
                    continue;
                default:
                    JOptionPane.showMessageDialog(null, "La opcion no es valida");
                    estadoMenu = false;
                    break;

            }
        }

        // consultamos si desea seguir editando 
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea ingresar de nuevo al MENU");
        estadoMenu = (respuesta == JOptionPane.YES_OPTION);

    }
      
}
