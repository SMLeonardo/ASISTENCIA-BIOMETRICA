/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFACES;

import CONTROLADOR.Conexion;
import CONTROLADOR.GestionEncabezadoTabla;
import CONTROLADOR.Render;

import java.awt.Color;
import java.awt.Dimension;

import java.awt.Toolkit;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.io.DataOutputStream;
 import java.io.File;
 import java.io.FileOutputStream;
 
 import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author ABEL
 */


public class REPORTE_ASISTENCIA extends javax.swing.JFrame {
Conexion cc = new Conexion();
    Connection cn = (Connection) cc.Conexion();
    JButton btn1 = new JButton("");
    JButton btn2 = new JButton("");
    int clic_tabla = 0;
    ///////////////////////
     private File file;
    private List<JTable> tabla;
    private List<String> nom_files;
  
    /**
     * Creates new form REPORTE_ASISTENCIA
     */
 
       public REPORTE_ASISTENCIA(File file, List<JTable> tabla, List<String> nom_files) throws Exception {
        this.file = file;
        this.tabla = tabla;
        this.nom_files = nom_files;
        if (nom_files.size()!=tabla.size()) {
            throw new Exception ("Error");
        }
    }
       
         public boolean export() {
       
        try {
            DataOutputStream out=new DataOutputStream (new FileOutputStream(file));
            WritableWorkbook w = Workbook.createWorkbook(out);
            for (int index=0; index<tabla.size(); index++){
                JTable table=tabla.get(index);
                WritableSheet s=w.createSheet(nom_files.get(index),0);
               //Para que salga el titulo de las columnas
for (int i = 0; i < table.getColumnCount(); i++) {
      for (int j = 0; j < table.getRowCount(); j++) {
            Object titulo = table.getColumnName(i);
            s.addCell(new Label(i+1, j+1, String.valueOf(titulo)));
       }
}
for (int i = 0; i < table.getColumnCount(); i++) {
      for (int j = 0; j < table.getRowCount(); j++) {
            Object object = table.getValueAt(j, i);
            s.addCell(new Label(i+1, j+2, String.valueOf(object)));
      }
    }
             /*
            *    for sin titulo de columnas:
            *
            *  for (int i=0; i<table.getColumnCount(); i++){
            *     for (int j=0; j<table.getRowCount();j++){
            *         Object object=table.getValueAt(j,i);
            *         s.addCell (new Label(i,j,String.valueOf(object)));
            *       
            *     }  
            * }
            **/

            }
            w.write();
            w.close();
            return true;
        }

        catch (IOException | WriteException e) {
            return false;
        }
    }
    public REPORTE_ASISTENCIA() {
        initComponents();
       
         Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = getSize();
        setLocation((pantalla.width - ventana.width) / 2,
                (pantalla.height - ventana.height) / 2);
        cargar("");
          cargar2("");
          cargar3("");
        jTable1.setBackground(Color.WHITE);
        jTable1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        //personaliza el encabezado
		JTableHeader jtableHeader = jTable1.getTableHeader();
	    jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
	    jTable1.setTableHeader(jtableHeader);
            ////////////////////////////////////////////////////
              jTable2.setBackground(Color.WHITE);
        jTable2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        //personaliza el encabezado
		JTableHeader jtableHeader2 = jTable2.getTableHeader();
	    jtableHeader2.setDefaultRenderer(new GestionEncabezadoTabla());
	    jTable2.setTableHeader(jtableHeader2);
            ////////////////////////////////////////////////////
            ////////////////////////////////////////////////////
              jTable3.setBackground(Color.WHITE);
        jTable3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        //personaliza el encabezado
		JTableHeader jtableHeader3 = jTable3.getTableHeader();
	    jtableHeader3.setDefaultRenderer(new GestionEncabezadoTabla());
	    jTable3.setTableHeader(jtableHeader3);
            ////////////////////////////////////////////////////
            
    }
     void cargar(String valor){
         
    DefaultTableModel model;
    
   
//    String []titulos={"Codigo","Usuario","Contraseña","Estado","Tipo Usuario","Empleado","Operaciones"};
System.out.println("hola"+dni.getText());
    Object []Registros=new Object[6];
     jTable1.setDefaultRenderer(Object.class, new Render());
         
        
        btn1.setName("m");       
        btn2.setName("e");      
    // BLOQUEA LA EDICION DE LAS FILAS DE LA TABLA
    model= new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            };
              };
model.addColumn("HORA INGRESO");
model.addColumn("HORA SALIDA");
model.addColumn("DIA SEMANA");
model.addColumn("FECHA");
model.addColumn("EDITAR");
model.addColumn("ELIMINAR");
        try {
            ///////////////////////////////////
         String SQL="SELECT * FROM empleado WHERE EMPL_dni='"+dni.getText()+"'";   
            String nom="";
            String ape="";
            String car="";
            int id=0;
         Statement st2 = cn.createStatement();
            ResultSet rs2=st2.executeQuery(SQL);
             System.out.println("nom: "+dni.getText());
            while(rs2.next())
            {              
                id=rs2.getInt(1);
                 nombre1.setText(rs2.getString(3)); 
                 apellido1.setText(rs2.getString(4));
                 SQL="SELECT * FROM cargo WHERE CARGO_id='"+rs2.getString(12)+"'"; 
                 Statement st3 = cn.createStatement();
            ResultSet rs3=st3.executeQuery(SQL);
             while(rs3.next())
            {   
                cargo1.setText(rs3.getString(2));
            }
               st3.close();
               rs3.close();
                 
            }
            st2.close();
            rs2.close();


         ///////////////////////////////////
             String mostrar="SELECT * FROM detalle_horario WHERE EMPLEADOS_EMPL_dni='"+id+"'";
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                 
                  Registros[0]= rs.getString(2);
                  Registros[1]= rs.getString(3);
                  //////////////////////////////////
                  String[] dias={"Lunes","Martes", "Miércoles","Jueves","Viernes","Sábado","Domingo"};
                  Registros[2]= dias[Integer.parseInt(rs.getString(6))-1];
                  //////////////////////////////////
                  Registros[3]= rs.getString(4); 
                  Registros[4]=btn1;
                  Registros[5]=btn2;
                  model.addRow(Registros);
              }
// PASO LOS REGISTROS AL JTABEL1 
              jTable1.setModel(model);
// DIMENSIONA EL ANHO DE LAS FILAS DEL JTABLE 
              jTable1.setRowHeight(45);
// CENTRA DATOS DEL JTABLE
DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
tcr.setHorizontalAlignment(SwingConstants.CENTER);
jTable1.getColumnModel().getColumn(0).setCellRenderer(tcr);
jTable1.getColumnModel().getColumn(1).setCellRenderer(tcr);
jTable1.getColumnModel().getColumn(2).setCellRenderer(tcr);
jTable1.getColumnModel().getColumn(3).setCellRenderer(tcr);
//jTable1.getColumnModel().getColumn(4).setCellRenderer(tcr);
//jTable1.getColumnModel().getColumn(5).setCellRenderer(tcr);
// OTRA FORMA DE CENTRAR DATOS EN JTABLE
// final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellHeaderRenderer();
//    defaultTableCellRenderer.setHorizontalTextPosition(defaultTableCellRenderer.CENTER);
//    jTable1.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(6).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(7).setCellRenderer(defaultTableCellRenderer);
// DIMENSIONA TAMAÑO DE LAS FILAS   
//    jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
//    jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
//    jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
//    jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
//    jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
//    jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
//    jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
//    jTable1.getColumnModel().getColumn(7).setPreferredWidth(70); 

 
        } catch (SQLException ex) {
            Logger.getLogger(R_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  }
    
     void cargar2(String valor){
         
    DefaultTableModel model;
    
   
//    String []titulos={"Codigo","Usuario","Contraseña","Estado","Tipo Usuario","Empleado","Operaciones"};
System.out.println("hola"+dni.getText());
    Object []Registros=new Object[8];
     jTable2.setDefaultRenderer(Object.class, new Render());
         
        
        btn1.setName("m");       
        btn2.setName("e");      
    // BLOQUEA LA EDICION DE LAS FILAS DE LA TABLA
    model= new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            };
              };
    model.addColumn("NOMBRE APELLIDO");
    model.addColumn("CARGO");
model.addColumn("HORA INGRESO");
model.addColumn("HORA SALIDA");
model.addColumn("DIA SEMANA");
model.addColumn("FECHA");
model.addColumn("EDITAR");
model.addColumn("ELIMINAR");
        try {
            
             String mostrar="SELECT * FROM detalle_horario WHERE DETALL_HOR_observacion>='"+fecha_inicial.getText()+"' AND DETALL_HOR_observacion<= '"+fecha_final.getText()+"'";
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                 ////////////////////////////////////////
                   String SQL="SELECT * FROM empleado WHERE EMPL_id='"+rs.getString(5)+"'";
                  String nom="";
            String ape="";
            String car="";
            
         Statement st2 = cn.createStatement();
            ResultSet rs2=st2.executeQuery(SQL);
             while(rs2.next())
            { 
            Registros[0]= rs2.getString(3)+" "+rs2.getString(4);
            SQL="SELECT * FROM cargo WHERE CARGO_id='"+rs2.getString(12)+"'";
             Statement st3 = cn.createStatement();
            ResultSet rs3=st3.executeQuery(SQL);
             while(rs3.next())
            {   
                Registros[1]= rs3.getString(2);
            }
            st3.close();
            rs3.close();
            
            
            
            }
             rs2.close();
             st2.close();
                 //////////////////////////////////////// 
                  Registros[2]= rs.getString(2);
                  Registros[3]= rs.getString(3);
                  //////////////////////////////////
                  String[] dias={"Lunes","Martes", "Miércoles","Jueves","Viernes","Sábado","Domingo"};
                  Registros[4]= dias[Integer.parseInt(rs.getString(6))-1];
                  //////////////////////////////////
                  Registros[5]= rs.getString(4); 
                  Registros[6]=btn1;
                  Registros[7]=btn2;
                  model.addRow(Registros);
              }
// PASO LOS REGISTROS AL JTABEL1 
              jTable2.setModel(model);
// DIMENSIONA EL ANHO DE LAS FILAS DEL JTABLE 
              jTable2.setRowHeight(45);
// CENTRA DATOS DEL JTABLE
DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
tcr.setHorizontalAlignment(SwingConstants.CENTER);
jTable2.getColumnModel().getColumn(0).setCellRenderer(tcr);
jTable2.getColumnModel().getColumn(1).setCellRenderer(tcr);
jTable2.getColumnModel().getColumn(2).setCellRenderer(tcr);
jTable2.getColumnModel().getColumn(3).setCellRenderer(tcr);
jTable2.getColumnModel().getColumn(4).setCellRenderer(tcr);
jTable2.getColumnModel().getColumn(5).setCellRenderer(tcr);
//jTable1.getColumnModel().getColumn(4).setCellRenderer(tcr);
//jTable1.getColumnModel().getColumn(5).setCellRenderer(tcr);
// OTRA FORMA DE CENTRAR DATOS EN JTABLE
// final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellHeaderRenderer();
//    defaultTableCellRenderer.setHorizontalTextPosition(defaultTableCellRenderer.CENTER);
//    jTable1.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(6).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(7).setCellRenderer(defaultTableCellRenderer);
// DIMENSIONA TAMAÑO DE LAS FILAS   
//    jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
//    jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
//    jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
//    jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
//    jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
//    jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
//    jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
//    jTable1.getColumnModel().getColumn(7).setPreferredWidth(70); 

 
        } catch (SQLException ex) {
            Logger.getLogger(R_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    
  }
   
      void cargar3(String valor){
         
    DefaultTableModel model;
    
   
//    String []titulos={"Codigo","Usuario","Contraseña","Estado","Tipo Usuario","Empleado","Operaciones"};
System.out.println("hola"+dni.getText());
    Object []Registros=new Object[8];
     jTable3.setDefaultRenderer(Object.class, new Render());
         
        
        btn1.setName("m");       
        btn2.setName("e");      
    // BLOQUEA LA EDICION DE LAS FILAS DE LA TABLA
    model= new DefaultTableModel(){
            public boolean isCellEditable(int row, int column){
                return false;
            };
              };
    model.addColumn("NOMBRE APELLIDO");
    model.addColumn("CARGO");
model.addColumn("HORA INGRESO");
model.addColumn("HORA SALIDA");
model.addColumn("DIA SEMANA");
model.addColumn("FECHA");
model.addColumn("EDITAR");
model.addColumn("ELIMINAR");
        try {
             String [][]id_cargo=new String[5][2];
             id_cargo[0][0]="Gerente";
             id_cargo[1][0]="Administrador";
             id_cargo[2][0]="Secretaria";
             id_cargo[3][0]="Recepcionista";
             id_cargo[4][0]="Tecnico";
             id_cargo[0][1]="1";
             id_cargo[1][1]="2";
             id_cargo[2][1]="3";
             id_cargo[3][1]="4";
             id_cargo[4][1]="5";
             String id_cargo_actual="";
             for (int i = 0; i < 5; i++) {
                if(id_cargo[i][0].equals(cargo.getItemAt(cargo.getSelectedIndex()))){
                id_cargo_actual=id_cargo[i][1];
                }
            }
             System.out.println("id_Cargo:  "+id_cargo_actual);
             
            String sql_inicial="SELECT * FROM empleado WHERE CARGO_CARGO_id='"+id_cargo_actual+"'" ;
            Statement stt = cn.createStatement();
              ResultSet rss = stt.executeQuery(sql_inicial);
              while(rss.next()){
                  
              //////////////////////////////////////////7
             String mostrar="SELECT * FROM detalle_horario WHERE EMPLEADOS_EMPL_dni='"+rss.getString(1)+"'";
              Statement st = cn.createStatement();
              ResultSet rs = st.executeQuery(mostrar);
              while(rs.next())
              {
                 ////////////////////////////////////////
                   String SQL="SELECT * FROM empleado WHERE EMPL_id='"+rs.getString(5)+"'";
                  String nom="";
            String ape="";
            String car="";
            
         Statement st2 = cn.createStatement();
            ResultSet rs2=st2.executeQuery(SQL);
             while(rs2.next())
            { 
            Registros[0]= rs2.getString(3)+" "+rs2.getString(4);
            SQL="SELECT * FROM cargo WHERE CARGO_id='"+rs2.getString(12)+"'";
             Statement st3 = cn.createStatement();
            ResultSet rs3=st3.executeQuery(SQL);
             while(rs3.next())
            {   
                Registros[1]= rs3.getString(2);
            }
            st3.close();
            rs3.close();
            
            
            
            }
             rs2.close();
             st2.close();
                 //////////////////////////////////////// 
                  Registros[2]= rs.getString(2);
                  Registros[3]= rs.getString(3);
                  //////////////////////////////////
                  String[] dias={"Lunes","Martes", "Miércoles","Jueves","Viernes","Sábado","Domingo"};
                  Registros[4]= dias[Integer.parseInt(rs.getString(6))-1];
                  //////////////////////////////////
                  Registros[5]= rs.getString(4); 
                  Registros[6]=btn1;
                  Registros[7]=btn2;
                  model.addRow(Registros);
              }
        /////////////////////
        }
              rss.close();
              stt.close();
// PASO LOS REGISTROS AL JTABEL1 
              jTable3.setModel(model);
// DIMENSIONA EL ANHO DE LAS FILAS DEL JTABLE 
              jTable3.setRowHeight(45);
// CENTRA DATOS DEL JTABLE
DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
tcr.setHorizontalAlignment(SwingConstants.CENTER);
jTable3.getColumnModel().getColumn(0).setCellRenderer(tcr);
jTable3.getColumnModel().getColumn(1).setCellRenderer(tcr);
jTable3.getColumnModel().getColumn(2).setCellRenderer(tcr);
jTable3.getColumnModel().getColumn(3).setCellRenderer(tcr);
jTable3.getColumnModel().getColumn(4).setCellRenderer(tcr);
jTable3.getColumnModel().getColumn(5).setCellRenderer(tcr);
//jTable1.getColumnModel().getColumn(4).setCellRenderer(tcr);
//jTable1.getColumnModel().getColumn(5).setCellRenderer(tcr);
// OTRA FORMA DE CENTRAR DATOS EN JTABLE
// final DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellHeaderRenderer();
//    defaultTableCellRenderer.setHorizontalTextPosition(defaultTableCellRenderer.CENTER);
//    jTable1.getColumnModel().getColumn(0).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(1).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(2).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(3).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(4).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(5).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(6).setCellRenderer(defaultTableCellRenderer);
//    jTable1.getColumnModel().getColumn(7).setCellRenderer(defaultTableCellRenderer);
// DIMENSIONA TAMAÑO DE LAS FILAS   
//    jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
//    jTable1.getColumnModel().getColumn(1).setPreferredWidth(40);
//    jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
//    jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
//    jTable1.getColumnModel().getColumn(4).setPreferredWidth(10);
//    jTable1.getColumnModel().getColumn(5).setPreferredWidth(150);
//    jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
//    jTable1.getColumnModel().getColumn(7).setPreferredWidth(70); 

 
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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dni = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombre1 = new javax.swing.JTextField();
        apellido1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cargo1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        fecha_inicial = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        fecha_final = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cargo = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CONTROL DE ASISTENCIA DEL PERSONAL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century", 1, 14))); // NOI18N

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Dni:");

        dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniActionPerformed(evt);
            }
        });

        jButton1.setText("BUSCAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "HORA INGRESO", "HORA SALIDA", "DIA SEMANA", "FECHA"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        nombre1.setEditable(false);

        apellido1.setEditable(false);

        jLabel4.setText("Cargo:");

        cargo1.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombre1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(apellido1)))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cargo1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cargo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("         DNI         ", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Fecha Inicial:");

        try {
            fecha_inicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fecha_inicial.setText("21/02/2021");

        jLabel6.setText("Fecha Final:");

        try {
            fecha_final.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fecha_final.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fecha_finalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fecha_finalKeyReleased(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fecha_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fecha_final, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fecha_inicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(fecha_final, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("         FECHA         ", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setText("Cargo:");

        cargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<SELECCIONE>", "Gerente", "Administrador", "Secretaria", "Recepcionista", "Tecnico" }));
        cargo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cargoItemStateChanged(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );

        jTabbedPane1.addTab("         CARGO         ", jPanel4);

        jButton2.setText("EXPORTAR EXCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jTabbedPane1)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(482, 482, 482)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       /* String SQL = "";

                 SQL="SELECT * FROM detalle_horario WHERE EMPLEADOS_EMPL_dni="+dni.getText();   
          String c="";
          try {
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery(SQL);
            while(rs.next())
            {              
                 c=rs.getString(2); 
            }
     if(!c.equalsIgnoreCase("")){
       
    
     
     }
             } catch (SQLException ex) {
           Logger.getLogger(Ingreso_Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */
       
       cargar("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniActionPerformed

    private void fecha_finalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fecha_finalKeyPressed
        // TODO add your handling code here:
        
        
        
        
        
    }//GEN-LAST:event_fecha_finalKeyPressed

    private void fecha_finalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fecha_finalKeyReleased
        // TODO add your handling code here:
        
        if(!fecha_final.getText().substring(6, 10).equals("    ")){
            
        if(Integer.parseInt(fecha_final.getText().substring(6, 10).replaceAll(" ", ""))>1000){
            //JOptionPane.showMessageDialog(null, "hola"+fecha_final.getText().substring(6, 10));
        cargar2("");
        }
        
        }
    }//GEN-LAST:event_fecha_finalKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        if (jTable3.getRowCount()==0) {
            JOptionPane.showMessageDialog (null, "No hay datos en la tabla para exportar.","BCO",
                JOptionPane.INFORMATION_MESSAGE);
            //this.cmbConsorcio.grabFocus();
            return;
        }
        JFileChooser chooser=new JFileChooser();
        FileNameExtensionFilter filter=new FileNameExtensionFilter("Archivos de excel","xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
            List<JTable> tb=new ArrayList<>();
            List<String>nom=new ArrayList<>();
            //DefaultTableModel m = new DefaultTableModel();
		JTable t = new JTable();
                t=jTable3;
           t.removeColumn(t.getColumnModel().getColumn(6));
           
           
            tb.add(t);
            nom.add("Detalle de Gastos");
            String file=chooser.getSelectedFile().toString().concat(".xls");
            try {
                INTERFACES.REPORTE_ASISTENCIA e=new REPORTE_ASISTENCIA(new File(file),tb, nom);
                if (e.export()) {
                    JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel.","REPORTE",
                        JOptionPane.INFORMATION_MESSAGE);

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Hubo un error"+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cargoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cargoItemStateChanged
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, "HOLA");
        
        cargar3("");
        
    }//GEN-LAST:event_cargoItemStateChanged
 /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(REPORTE_ASISTENCIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(REPORTE_ASISTENCIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(REPORTE_ASISTENCIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(REPORTE_ASISTENCIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new REPORTE_ASISTENCIA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido1;
    private javax.swing.JComboBox<String> cargo;
    private javax.swing.JTextField cargo1;
    public static javax.swing.JTextField dni;
    private javax.swing.JFormattedTextField fecha_final;
    private javax.swing.JFormattedTextField fecha_inicial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField nombre1;
    // End of variables declaration//GEN-END:variables
}
