package InicioSesion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Escribir {

    public static void escribir(String nombre, String contrasenna) {
        FileWriter fich = null;
        PrintWriter pw = null;
        try {
            fich = new FileWriter("users.txt", true);
            pw = new PrintWriter(fich);
            pw.println("Nombre:"+nombre+"\t"+"Contraseña:"+contrasenna);
            fich.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static boolean validar(String nombre, String contrasenna) {
        boolean ok = false;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("users.txt");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            String[] lineaSplit;
            while (linea != null && !ok) {
                lineaSplit = linea.split("\t");
                if (lineaSplit[0].equalsIgnoreCase("Nombre:"+nombre) && lineaSplit[1].equalsIgnoreCase("Contraseña:"+contrasenna)) {
                    ok = true;
                }
                linea = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ok;
    }
}
