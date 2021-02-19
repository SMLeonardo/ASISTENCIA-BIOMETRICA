/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLADOR;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class Render extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
//        if(value instanceof JButton){
//            JButton btn1 = (JButton)value;
//            if(isSelected){
//                btn1.setForeground(Color.white);
//                btn1.setBackground(new java.awt.Color(255,153,0));
//                
//            }else{
//                btn1.setForeground(Color.white);
//                btn1.setBackground(new java.awt.Color(255,153,0));
//            }
//            return btn1;
//        }
     
          
                    if(value instanceof JButton){
            JButton btn1 = (JButton)value; 
                       if (btn1.getName().equals("m")) {
                           if(isSelected){
//                btn1.setForeground(Color.white);
                btn1.setBackground(new java.awt.Color(255,255,255));
                btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/edit.png")));     
                btn1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
            }else{
//                btn1.setForeground(Color.white);
               btn1.setBackground(new java.awt.Color(255,255,255));
            btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/edit.png")));
            btn1.setBorder(null);
                           }
            return btn1; 
                        }else if (btn1.getName().equals("e")) {
                             if(isSelected){
                btn1.setBackground(new java.awt.Color(255,255,255));
                btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/delete.png")));     
                btn1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                
            }else{
                btn1.setBackground(new java.awt.Color(255,255,255));
                btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/delete.png")));     
                btn1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
            }
            return btn1; 
                        }
            
        }
//                this.setBackground(Color.GREEN);
//                this.setForeground(Color.black);
            
        
        if(value instanceof JCheckBox){
            JCheckBox ch = (JCheckBox)value;
            return ch;
        }
        
        return super.getTableCellRendererComponent(table, value, isSelected, 
                hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
//    return this;
    }

    
}

