package edu.eci.cvds.persistence.ExceptionReport;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReportFile {
    public static void loadReport(String error)  {
        try {
            FileWriter data = new FileWriter("Errores.txt");
            data.write(error+"\r\n");
            data.close();
        }catch (Exception e){
            System.out.println("Error interno");
        }

    }

}
