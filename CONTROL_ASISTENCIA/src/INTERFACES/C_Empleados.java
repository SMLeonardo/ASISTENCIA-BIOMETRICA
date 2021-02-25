/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFACES;

import CONTROLADOR.Conexion;
import CONTROLADOR.GestionEncabezadoTabla;
import CONTROLADOR.Render;
import static INTERFACES.Principal.main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author LEONARDO SUYON
 */
public class C_Empleados extends javax.swing.JInternalFrame {

    Conexion cc = new Conexion();
    Connection cn = (Connection) cc.Conexion();
    JButton btn1 = new JButton("");
    JButton btn2 = new JButton("");
    int clic_tabla = 0;

    /**
     * Creates new form C_Empleado
     */
    public C_Empleados() {
        initComponents();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = getSize();
        setLocation((pantalla.width - ventana.width) / 2,
                (pantalla.height - ventana.height) / 2);
        cargar("");
        jTable1.setBackground(Color.WHITE);
        jTable1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        //personaliza el encabezado
        JTableHeader jtableHeader = jTable1.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        jTable1.setTableHeader(jtableHeader);
    }

    void cargar(String valor) {
        DefaultTableModel model;
        String mostrar = "SELECT EMPL_dni,EMPL_nombres,EMPL_apellidos,EMPL_telefono,EMPL_direccion,EMPL_ciudad FROM EMPLEADO WHERE CONCAT(EMPL_dni,EMPL_nombres,EMPL_apellidos) LIKE '%" + valor + "%'";
//    String []titulos={"Codigo","Usuario","Contraseña","Estado","Tipo Usuario","Empleado","Operaciones"};
        Object[] Registros = new Object[8];
        jTable1.setDefaultRenderer(Object.class, new Render());

        btn1.setName("m");
        btn2.setName("e");
        // BLOQUEA LA EDICION DE LAS FILAS DE LA TABLA
        model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        ;
        };
        
        model.addColumn("Dni");
        model.addColumn("Nombres");
        model.addColumn("Apellidos");
        model.addColumn("Telefono");
        model.addColumn("Direccion");
        model.addColumn("Ciudad");
        model.addColumn("Editar");
        model.addColumn("ELiminar");
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("EMPL_dni");
                Registros[1] = rs.getString("EMPL_nombres");
                Registros[2] = rs.getString("EMPL_apellidos");
                Registros[3] = rs.getString("EMPL_telefono");
                Registros[4] = rs.getString("EMPL_direccion");
                Registros[5] = rs.getString("EMPL_ciudad");
                Registros[6] = btn1;
                Registros[7] = btn2;
                model.addRow(Registros);
            }
// PASO LOS REGISTROS AL JTABEL1 
            jTable1.setModel(model);
// DIMENSIONA EL ALTO DE LAS FILAS DEL JTABLE 
            jTable1.setRowHeight(45);
// CENTRA DATOS DEL JTABLE
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
            tcr.setHorizontalAlignment(SwingConstants.CENTER);
            jTable1.getColumnModel().getColumn(0).setCellRenderer(tcr);
            jTable1.getColumnModel().getColumn(1).setCellRenderer(tcr);
            jTable1.getColumnModel().getColumn(2).setCellRenderer(tcr);
            jTable1.getColumnModel().getColumn(3).setCellRenderer(tcr);
            jTable1.getColumnModel().getColumn(4).setCellRenderer(tcr);
            jTable1.getColumnModel().getColumn(5).setCellRenderer(tcr);     
// DIMENSIONA ANCHO DE COLUMNAS
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(30);
        } catch (SQLException ex) {
            Logger.getLogger(R_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEditar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        btnEditar.setBackground(new java.awt.Color(255, 0, 102));
        btnEditar.setText("jButton1");

        jButton2.setText("jButton2");

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta Empleados");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Buscar:");

        txtbuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtbuscar.setName(""); // NOI18N
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(txtbuscar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        clic_tabla = this.jTable1.rowAtPoint(evt.getPoint());

        String codigo = jTable1.getValueAt(clic_tabla, 0).toString();
//        String nombre = ""+tabla.getValueAt(clic_tabla, 1);
//        double precio = (double)tabla.getValueAt(clic_tabla, 2);
//        String marca = ""+tabla.getValueAt(clic_tabla, 3);

//        txtCodigo.setText(String.valueOf(codigo));
//        txtNombre.setText(nombre);
//        txtPrecio.setText(String.valueOf(precio));
//        txtMarca.setText(marca);
        int column = jTable1.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / jTable1.getRowHeight();

        if (row < jTable1.getRowCount() && row >= 0 && column < jTable1.getColumnCount() && column >= 0) {
            Object value = jTable1.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equals("m")) {

                    DialogEmpleado empleado = new DialogEmpleado(null, true);
                    pasarDatos(codigo);
                    empleado.setVisible(true);

                    //EVENTOS MODIFICAR
//                    activa_boton(false,true,false);
                }
                if (boton.getName().equals("e")) {
                    JOptionPane.showConfirmDialog(this, "¿Esta seguro de realizar la accion?", "Confirmar", JOptionPane.OK_CANCEL_OPTION);

                    //EVENTOS ELIMINAR
//                    activa_boton(false,false,true);
                }
            }

        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        // TODO add your handling code here:
        cargar(txtbuscar.getText());
    }//GEN-LAST:event_txtbuscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtbuscar;
    // End of variables declaration//GEN-END:variables
 public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            System.exit(0);
        }
    }

    public void pasarDatos(String cod) {
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        String sql = "SELECT * FROM EMPLEADO WHERE EMPL_dni='" + cod + "'";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                DialogEmpleado.txtcod.setText(rs.getString("EMPL_dni"));
                DialogEmpleado.txtnom.setText(rs.getString("EMPL_nombres"));
                DialogEmpleado.txtape.setText(rs.getString("EMPL_apellidos"));
                DialogEmpleado.txttel.setText(rs.getString("EMPL_telefono"));
                DialogEmpleado.txtdir.setText(rs.getString("EMPL_direccion"));
                DialogEmpleado.txtciudad.setText(rs.getString("EMPL_ciudad"));
                DialogEmpleado.txtsalario.setText(rs.getString("EMPL_salario"));     
                DialogEmpleado.cbo_puesto.setSelectedItem(Jerarquia(rs.getString("CARGO_CARGO_id")));   
               String fcontra = rs.getString("EMPL_fecha_contrat");
                String fterm = rs.getString("EMPL_fecha_termino");
                Date fecha;
                try {
                                    if (!fcontra.equals("N.definido")) {
                                        fecha = formatofecha.parse(fcontra.toString());
                                        DialogEmpleado.fcontrato.setDate(fecha);
                                    } else {
                                        DialogEmpleado.fcontrato.setDate(null);
                                    }

                                    if (!fterm.equals("N.definido")) {
                                        Date fechat = formatofecha.parse(fterm.toString());
                                        DialogEmpleado.ftermino.setDate(fechat);
                                    } else {
                                        DialogEmpleado.ftermino.setDate(null);
                                    }
                } catch (ParseException ex) {
                                    Logger.getLogger(C_Empleados.class.getName()).log(Level.SEVERE, null, ex);
                                }                
                ImageIcon li = null;
               InputStream is = rs.getBinaryStream("EMPL_foto");
                if (is != null) {
                                    BufferedImage bi = ImageIO.read(is);
                                    li = new ImageIcon(bi.getScaledInstance(260, 316, BufferedImage.SCALE_DEFAULT));
//                      foto=getToolkit().getImage(li));
//                       foto= foto.getScaledInstance(fila, fila, Image.SCALE_DEFAULT);
                                    DialogEmpleado.Ifoto.setIcon(li);

                                } else {
                                    DialogEmpleado.Ifoto.setIcon(null);
                                    JOptionPane.showMessageDialog(this, "Este empleado no tiene foto", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(C_Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
                            ex.printStackTrace();
                        }
    }

    public String Empleados(String valor) {
        String mostrar = "SELECT EMPL_nombres,EMPL_apellidos FROM EMPLEADO WHERE EMPL_id='" + valor + "'";
        String Registros;
        String Registros1;
        String listaE = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            if (rs.next()) {
                Registros = rs.getString("EMPL_nombres");
                Registros1 = rs.getString("EMPL_apellidos");
                listaE = Registros + " " + Registros1;

            }

        } catch (SQLException ex) {
            Logger.getLogger(R_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaE;
    }

    public String Jerarquia(String valor) {
        String mostrar ="SELECT CARGO_descripcion FROM CARGO WHERE CARGO_id='" + valor + "'"; 
        String Registros = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            if (rs.next()) {
                Registros = rs.getString("CARGO_descripcion");
            }

        } catch (SQLException ex) {
            Logger.getLogger(R_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Registros;
    }
}
