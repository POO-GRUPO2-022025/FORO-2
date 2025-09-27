package GestionInventario.interfaz;
//Se importan las clases que se estaran ocupando
import GestionInventario.Inventario;
import HijasClass.Desktop;
import HijasClass.Laptop;
import HijasClass.Tablet;
import PadresClass.Equipo;

import javax.swing.*;//Nos permite crear la interfaz grafica
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

public class RegistrarEquipoDialog extends JDialog {
    //Se establecen las propiedades de la clase
    private String tipoEquipo;//Nos ayuda a llevar un control del tipo de equipo que se estara trabajando
    private JPanel panelCampos;
    private JButton btnRegistrar;
    private JButton btnCancelar;
    private Map<String, JTextField> campos;//Map que va asociada a cada JTextField
    private Inventario inventario;//Se realiza la referenci a inventario, que nos permitira agregar y almacenar los datos
//Constructor
    public RegistrarEquipoDialog(JFrame parent, String tipoEquipo, Inventario inventario) {
        super(parent, "Registrar " + tipoEquipo, true);
        this.tipoEquipo = tipoEquipo; //Se estara usando para llevar el control del tipo de equipo que se esta trabajando
        this.campos = new LinkedHashMap<String, JTextField>();//Instancia un nuevo LinkHashMap
        this.inventario = inventario;//Obtiene los valores de inventario (Los datos ya almacenados)
        //Propiedades de la ventana
        setSize(500, 400);//Se establece el tamaño de la ventana
        setLocationRelativeTo(parent);//Se centra la ventana
        setLayout(new BorderLayout());//Nos ayuda a gestionar los diferente componentes dentro de un contenedor

        setup();
        crearCamposDeFormulario();
        configurarBotonesDeFormulario();
    }
    
    private void setup() {
        //Se crean los diferentes componentes que lleva el cuadro de registro de equipo
        JLabel lblTitulo = new JLabel("Registrar " + tipoEquipo, SwingConstants.CENTER); //Se escribe Registrar + el tipo de equipo que se esta usando, y centrado
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));//Se definen las propiedades de la fuente que se utilizara para la label
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(lblTitulo, BorderLayout.NORTH);//nos ayuda a posicionar la label

        panelCampos = new JPanel(); // Se crea un elemento Jpanel
        panelCampos.setBorder(BorderFactory.createTitledBorder("Informacion del " + tipoEquipo));//Se agrega un titulo
        
        JScrollPane scrollPane = new JScrollPane(panelCampos);//Se crea un scroll
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);//Solo lo mostrara cuando sea necesario
        add(scrollPane, BorderLayout.CENTER);

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout());//Agrega un nuevo pane que se utilizara para los botones
        btnRegistrar = new JButton("Registrar");//JButton es el componente de Swing que crea un boton
        btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnRegistrar);//Se agregan los botones
        panelBotones.add(btnCancelar);
        add(panelBotones, BorderLayout.SOUTH);//Ubicacion de los botones
    }
    //Se crea el metodo para los campos en en los que se introduciran los datos
    private void crearCamposDeFormulario() {
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));//Se crea un margen
        
        switch (tipoEquipo) {//Mediante switch y utilizando tipoEquipo se condicionan los campos que se crearan
            case "Desktop"://Cuando es Desktop
                panelCampos.setLayout(new GridLayout(7, 2, 5, 5));//Nos ayuda a gestionar los elmentos dentro de una cuadricula
                //Se empiezan a crear los diferentes campos para Desktop
                // Fabricante
                JLabel lblFabricante = new JLabel("Fabricante:");//Etiqueta
                JTextField txtFabricante = new JTextField(20);//Campo de texto
                panelCampos.add(lblFabricante);//Se Agregan dentro de la cuadricula
                panelCampos.add(txtFabricante);
                campos.put("Fabricante", txtFabricante);//Dentro del LinkHashmap, se crea con una clave, y se almacena el dato que se ingresara en el campo de texto
                
                // Modelo
                JLabel lblModelo = new JLabel("Modelo:");
                JTextField txtModelo = new JTextField(20);
                panelCampos.add(lblModelo);
                panelCampos.add(txtModelo);
                campos.put("Modelo", txtModelo);
                
                // Microprocesador
                JLabel lblMicroprocesador = new JLabel("Microprocesador:");
                JTextField txtMicroprocesador = new JTextField(20);
                panelCampos.add(lblMicroprocesador);
                panelCampos.add(txtMicroprocesador);
                campos.put("Microprocesador", txtMicroprocesador);
                
                // Memoria
                JLabel lblMemoria = new JLabel("Memoria:");
                JTextField txtMemoria = new JTextField(20);
                panelCampos.add(lblMemoria);
                panelCampos.add(txtMemoria);
                campos.put("Memoria", txtMemoria);
                
                // Tarjeta grafica
                JLabel lblTarjetaGrafica = new JLabel("Tarjeta grafica:");
                JTextField txtTarjetaGrafica = new JTextField(20);
                panelCampos.add(lblTarjetaGrafica);
                panelCampos.add(txtTarjetaGrafica);
                campos.put("Tarjeta grafica", txtTarjetaGrafica);
                
                // Tamaño de torre
                JLabel lblTamanoTorre = new JLabel("Tamaño de torre:");
                JTextField txtTamanoTorre = new JTextField(20);
                panelCampos.add(lblTamanoTorre);
                panelCampos.add(txtTamanoTorre);
                campos.put("Tamaño de torre", txtTamanoTorre);
                
                // Capacidad de disco duro
                JLabel lblCapacidadDisco = new JLabel("Capacidad de disco duro:");
                JTextField txtCapacidadDisco = new JTextField(20);
                panelCampos.add(lblCapacidadDisco);
                panelCampos.add(txtCapacidadDisco);
                campos.put("Capacidad de disco duro", txtCapacidadDisco);
                break;
                
            case "Laptop":
                panelCampos.setLayout(new GridLayout(6, 2, 5, 5));
                
                // Fabricante
                JLabel lblFabricanteLaptop = new JLabel("Fabricante:");
                JTextField txtFabricanteLaptop = new JTextField(20);
                panelCampos.add(lblFabricanteLaptop);
                panelCampos.add(txtFabricanteLaptop);
                campos.put("Fabricante", txtFabricanteLaptop);
                
                // Modelo
                JLabel lblModeloLaptop = new JLabel("Modelo:");
                JTextField txtModeloLaptop = new JTextField(20);
                panelCampos.add(lblModeloLaptop);
                panelCampos.add(txtModeloLaptop);
                campos.put("Modelo", txtModeloLaptop);
                
                // Microprocesador
                JLabel lblMicroprocesadorLaptop = new JLabel("Microprocesador:");
                JTextField txtMicroprocesadorLaptop = new JTextField(20);
                panelCampos.add(lblMicroprocesadorLaptop);
                panelCampos.add(txtMicroprocesadorLaptop);
                campos.put("Microprocesador", txtMicroprocesadorLaptop);
                
                // Memoria
                JLabel lblMemoriaLaptop = new JLabel("Memoria:");
                JTextField txtMemoriaLaptop = new JTextField(20);
                panelCampos.add(lblMemoriaLaptop);
                panelCampos.add(txtMemoriaLaptop);
                campos.put("Memoria", txtMemoriaLaptop);
                
                // Tamaño pantalla
                JLabel lblTamanoPantalla = new JLabel("Tamaño pantalla:");
                JTextField txtTamanoPantalla = new JTextField(20);
                panelCampos.add(lblTamanoPantalla);
                panelCampos.add(txtTamanoPantalla);
                campos.put("Tamaño pantalla", txtTamanoPantalla);
                
                // Capacidad de disco duro
                JLabel lblCapacidadDiscoLaptop = new JLabel("Capacidad de disco duro:");
                JTextField txtCapacidadDiscoLaptop = new JTextField(20);
                panelCampos.add(lblCapacidadDiscoLaptop);
                panelCampos.add(txtCapacidadDiscoLaptop);
                campos.put("Capacidad de disco duro", txtCapacidadDiscoLaptop);
                break;
                
            case "Tablet":
                panelCampos.setLayout(new GridLayout(7, 2, 5, 5));
                
                // Fabricante
                JLabel lblFabricanteTablet = new JLabel("Fabricante:");
                JTextField txtFabricanteTablet = new JTextField(20);
                panelCampos.add(lblFabricanteTablet);
                panelCampos.add(txtFabricanteTablet);
                campos.put("Fabricante", txtFabricanteTablet);
                
                // Modelo
                JLabel lblModeloTablet = new JLabel("Modelo:");
                JTextField txtModeloTablet = new JTextField(20);
                panelCampos.add(lblModeloTablet);
                panelCampos.add(txtModeloTablet);
                campos.put("Modelo", txtModeloTablet);
                
                // Microprocesador
                JLabel lblMicroprocesadorTablet = new JLabel("Microprocesador:");
                JTextField txtMicroprocesadorTablet = new JTextField(20);
                panelCampos.add(lblMicroprocesadorTablet);
                panelCampos.add(txtMicroprocesadorTablet);
                campos.put("Microprocesador", txtMicroprocesadorTablet);
                
                // Tamano diagonal de pantalla
                JLabel lblTamanoDiagonal = new JLabel("Tamano diagonal de pantalla:");
                JTextField txtTamanoDiagonal = new JTextField(20);
                panelCampos.add(lblTamanoDiagonal);
                panelCampos.add(txtTamanoDiagonal);
                campos.put("Tamano diagonal de pantalla", txtTamanoDiagonal);
                
                // Capacitiva/Resistiva
                JLabel lblCapacitiva = new JLabel("Capacitiva/Resistiva:");
                JTextField txtCapacitiva = new JTextField(20);
                panelCampos.add(lblCapacitiva);
                panelCampos.add(txtCapacitiva);
                campos.put("Capacitiva/Resistiva", txtCapacitiva);
                
                // Tamaño memoria NAND
                JLabel lblMemoriaNAND = new JLabel("Tamaño memoria NAND:");
                JTextField txtMemoriaNAND = new JTextField(20);
                panelCampos.add(lblMemoriaNAND);
                panelCampos.add(txtMemoriaNAND);
                campos.put("Tamaño memoria NAND", txtMemoriaNAND);
                
                // Sistema Operativo
                JLabel lblSistemaOperativo = new JLabel("Sistema Operativo:");
                JTextField txtSistemaOperativo = new JTextField(20);
                panelCampos.add(lblSistemaOperativo);
                panelCampos.add(txtSistemaOperativo);
                campos.put("Sistema Operativo", txtSistemaOperativo);
                break;
                
            default:
                // No hacer nada si el tipo no es reconocido
                break;
        }
    }
    //Logica para los botones
    private void configurarBotonesDeFormulario() {
        btnCancelar.addActionListener(new ActionListener() {//Al darle clic
            public void actionPerformed(ActionEvent e) {
                dispose();//Cierra la ventana
            }
        });
        
        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrarEquipo();//Ejecuta el metodo para registrar el equipo
            }
        });
    }
    //Metodo para registrar el equipo
    private void registrarEquipo() {
        // Validar que todos los campos esten llenos
        StringBuilder errorValidacion = new StringBuilder("Por favor complete los campos faltantes:\n\n");
        boolean existeError = false;// Llevara un control si se encuentra un error
        //Se inicia la validacion de todos los campos que se almacenaron en el LinkHashMap campos
        for (Map.Entry<String, JTextField> entry : campos.entrySet()) {
            if (entry.getValue().getText().trim().isEmpty()) {
                errorValidacion.append("- ").append(entry.getKey().replaceFirst(":", "")).append("\n");//Ira almacenando cada campo vacio utilizando la clave del LinkHashMap
                existeError = true;//Verdadero cuando se ecuentra con algun campo vacio
            }
        }

        if (existeError) {//Si se encontraron campos vacios mostrara un mensaje con el error
            JOptionPane.showMessageDialog(this,
                    errorValidacion.toString(),
                    "Campo(s) requerido",
                    JOptionPane.WARNING_MESSAGE);
            return;//Devuelve el control a la ventana para realizar las correcciones de los campos vacios
        }
        //Si no existen errores muestra un mensaje que se registro el equipo y un detalle de campo con sus datos registrados
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Equipo registrado exitosamente:\n\n");
        mensaje.append("Tipo: ").append(tipoEquipo).append("\n");

        for (Map.Entry<String, JTextField> entry : campos.entrySet()) {
            mensaje.append(entry.getKey()).append(": ").append(entry.getValue().getText()).append("\n");
        }

        JOptionPane.showMessageDialog(this, mensaje.toString(), "Equipo Registrado", JOptionPane.INFORMATION_MESSAGE);//Muestra el mensaje con los datos almacenados en mensaje
        //Inicia el proceso de almacenado
        Equipo equipo=null;//Se crea un objeto de tipo equipo vacio
        switch (tipoEquipo) {//Dependiento del tipo de equipo que se esta trabajando
            case "Desktop":
                equipo = new Desktop(//Al objeto equipo que se creo vacio, se instancia con la Clase Desktop
                        //y se van llenando sus propiedades con llamando los datos de LinkHashMap campos, utilizando su respectiva clave
                        campos.get("Fabricante").getText(),
                        campos.get("Modelo").getText(),
                        campos.get("Microprocesador").getText(),
                        campos.get("Memoria").getText(),
                        campos.get("Tarjeta grafica").getText(),
                        campos.get("Tamaño de torre").getText(),
                        campos.get("Capacidad de disco duro").getText());

                break;

            case "Laptop"://Mismo proceso cuando es una laptop
                equipo = new Laptop(
                        campos.get("Fabricante").getText(),
                        campos.get("Modelo").getText(),
                        campos.get("Microprocesador").getText(),
                        campos.get("Memoria").getText(),
                        campos.get("Tamaño pantalla").getText(),
                        campos.get("Capacidad de disco duro").getText());

                break;

            case "Tablet"://mismo proceso cuando es una tablet
                equipo = new Tablet(
                        campos.get("Fabricante").getText(),
                        campos.get("Modelo").getText(),
                        campos.get("Microprocesador").getText(),
                        campos.get("Tamano diagonal de pantalla").getText(),
                        campos.get("Capacitiva/Resistiva").getText(),
                        campos.get("Tamaño memoria NAND").getText(),
                        campos.get("Sistema Operativo").getText());

                break;
        }
        inventario.agregarEquipo(equipo);//Una ves que se tenemos el objeto con la respectiva clase que se utilizo, se llama al metodo para almacenar la clase en inventario
        dispose();//cierra la ventana
    }
}
