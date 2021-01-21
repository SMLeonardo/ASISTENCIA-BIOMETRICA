package CONTROLADOR;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;

public class Conexion {

    Connection conect = null;

    public Connection Conexion() {

        try {

            //Cargamos el Driver MySQL
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/asistencia", "root", "12345678");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
        return conect;

    }
}
