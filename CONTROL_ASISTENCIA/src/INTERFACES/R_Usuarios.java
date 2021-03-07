/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * R_Clientes.java
 *
 * Created on 26-abr-2019, 10:44:21
 */
package INTERFACES;

import CONTROLADOR.Conexion;
//import Controlador.GenerarCodigos;
//import Controlador.GenerarNumero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CRISTHYAN
 */
public class R_Usuarios extends javax.swing.JInternalFrame {

    Conexion cc = new Conexion();
    Connection cn = (Connection) cc.Conexion();
    DefaultTableModel model;

    public R_Usuarios() {
        initComponents();
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = getSize();
        setLocation((pantalla.width - ventana.width) / 2,
                (pantalla.height - ventana.height) / 2);

        bloquear();
        Empleados("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        cbo_jerarquia = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        cbo_estado = new javax.swing.JComboBox();
        txtcod_empl = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registro Usuarios");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ID_USUARIO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("CONTRASEÑA");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("JERARQUIA");

        txtcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodActionPerformed(evt);
            }
        });
        txtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodKeyTyped(evt);
            }
        });

        cbo_jerarquia.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbo_jerarquia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Invitado" }));
        cbo_jerarquia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_jerarquiaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("EMPLEADO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("USUARIO:");

        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        txtuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtuserKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtuserKeyTyped(evt);
            }
        });

        cbo_estado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cbo_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Seleccionar--", "Activo", "Inactivo" }));
        cbo_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_estadoActionPerformed(evt);
            }
        });

        txtcod_empl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtcod_empl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Seleccionar--" }));
        txtcod_empl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcod_emplActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("ESTADO:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbo_jerarquia, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(password)
                    .addComponent(txtuser)
                    .addComponent(txtcod)
                    .addComponent(txtcod_empl, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_jerarquia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbo_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcod, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtuser, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcod_empl, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnnuevo.setBackground(new java.awt.Color(0, 102, 255));
        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setText("Nuevo");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(51, 102, 0));
        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(153, 0, 0));
        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void bloquear() {
        txtcod.setEnabled(false);
        txtuser.setEnabled(false);
        password.setEnabled(false);
        txtcod_empl.setEnabled(false);
        cbo_jerarquia.setEnabled(false);
        cbo_estado.setEnabled(false);
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(true);
        btncancelar.setEnabled(false);
    }

    void limpiar() {
        txtcod.setText("");
        txtuser.setText("");
        password.setText("");
        txtcod_empl.setSelectedItem("--Seleccionar--");
        txtcod.setText("");
        txtcod_empl.setSelectedItem("--Seleccionar--");
        cbo_jerarquia.setSelectedItem("Administrador");
        cbo_estado.setSelectedItem("--Seleccionar--");
    }

    void desbloquear() {
        txtcod.setEnabled(true);
        txtuser.setEnabled(true);
        password.setEnabled(true);
        txtcod_empl.setEnabled(true);
        cbo_jerarquia.setEnabled(true);
        cbo_estado.setEnabled(true);
        btnguardar.setEnabled(true);
        btnnuevo.setEnabled(false);
        btncancelar.setEnabled(true);
    }

    public void CodigoUsuarios() {
        String SQL = "";
//               if (password.getText().equals(null)) {

        if (!cbo_jerarquia.getSelectedItem().toString().equals("--Seleccionar--")) {
            SQL = "SELECT MAX(USU_id) FROM usuario ";
            String c = "";
            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                while (rs.next()) {
                    c = rs.getString(1);
                }
//               System.out.println(""+c);   

                if (c == null) {
                    txtcod.setText("1");
                } else {

                    int codigo = Integer.parseInt(c);
                    codigo++;
                    txtcod.setText("" + codigo);
                    System.out.println("" + codigo);
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(R_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (password.getPassword().equals("") || txtcod_empl.getSelectedItem().toString().equals("--Seleccionar--") || cbo_estado.getSelectedItem().toString().equals("--Seleccionar--")) {
            JOptionPane.showMessageDialog(this, "LLene todos los campos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String ins = "INSERT INTO USUARIO (USU_id,USU_usuario,USU_contraseña,USU_estado,TIPO_DE_USUARIO_TIPO_USER_id,EMPLEADO_EMPL_id) VALUES(?,?,?,?,?,?)";
            String mostrar = "SELECT EMPL_id FROM EMPLEADO WHERE CONCAT(EMPL_nombres,'" + " " + "',EMPL_apellidos)='" + txtcod_empl.getSelectedItem().toString() + "'";
            try {
                PreparedStatement pst = (PreparedStatement) cn.prepareStatement(ins);
                pst.setInt(1, Integer.parseInt(txtcod.getText()));
                pst.setString(2, txtuser.getText());
                pst.setString(3, new String(password.getPassword()));
                pst.setString(4, "Activo");
                if (cbo_jerarquia.getSelectedItem().toString().equals("Administrador")) {
                    pst.setInt(5, Integer.parseInt("1"));
                } else {
                    pst.setInt(5, Integer.parseInt("2"));
                }
                //////////////////////////////////////////////////////////////////////////////////////////////               
                try {
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(mostrar);
                    if (rs.next()) {
                        pst.setInt(6, Integer.parseInt(rs.getString("EMPL_id")));

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(R_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
                }

//                pst.setString(6, txtcod_empl.getSelectedItem().toString());
///////////////////////////////////////////////////////////////////////////////////////////////                
                int n = pst.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(this, "Registro Guardado con Exito", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
                    btnguardar.setEnabled(false);
                    btnnuevo.setEnabled(true);
                    btncancelar.setEnabled(true);
                    bloquear();
                } else {
                    JOptionPane.showMessageDialog(this, "Registro Invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(R_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
//        desbloquear();

        btnnuevo.setEnabled(false);
        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        txtcod.setEnabled(false);

        txtuser.setEnabled(true);
        password.setEnabled(true);
        txtcod_empl.setEnabled(true);
        cbo_jerarquia.setEnabled(true);
        cbo_estado.setEnabled(true);
        limpiar();
        txtuser.requestFocus();
        CodigoUsuarios();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        int confirmar = JOptionPane.showConfirmDialog(this, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
        if (confirmar == 0) {
            txtcod.setText("");
            bloquear();
        }
    }//GEN-LAST:event_btncancelarActionPerformed

    private void txtcodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodKeyTyped
        // TODO add your handling code here:
        if (txtcod.getText().length() == 8) {
            evt.consume();
        }
//    JOptionPane.showMessageDialog(null,"La cantidad de caracteres no es valida"+"/ ingresar 8 carateres", "ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
        char car = evt.getKeyChar();
        if (Character.isLowerCase(car)) {
            String cad = ("" + car).toUpperCase();
            car = cad.charAt(0);
            evt.setKeyChar(car);
        }
    }//GEN-LAST:event_txtcodKeyTyped

    private void cbo_jerarquiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_jerarquiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_jerarquiaActionPerformed

    private void txtuserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtuserKeyTyped

    private void cbo_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_estadoActionPerformed

    private void txtcod_emplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcod_emplActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcod_emplActionPerformed

    private void txtcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_txtcodActionPerformed

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed

    }//GEN-LAST:event_txtuserActionPerformed

    private void txtuserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            password.requestFocus();// al presionar enter mandas el cursor al siguiente text 
        }
    }//GEN-LAST:event_txtuserKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox cbo_estado;
    private javax.swing.JComboBox cbo_jerarquia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField txtcod;
    private javax.swing.JComboBox txtcod_empl;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables

    void Empleados(String valor) {
        String mostrar = "SELECT * FROM EMPLEADO WHERE CONCAT(EMPL_nombres,EMPL_apellidos) LIKE '%" + valor + "%'";
        String Registros;
        String Registros1;
        String listaE;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros = rs.getString("EMPL_nombres");
                Registros1 = rs.getString("EMPL_apellidos");
                listaE = Registros + " " + Registros1;
                txtcod_empl.addItem(listaE);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(R_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
