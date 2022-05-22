package com.company.services.LoggerService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;

public class LoggerService {
    FileWriter writer;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");

    public void log(String action) throws SecurityException,IOException {
        writer.append(action);
        writer.append(",");
        writer.append(formatter.format(LocalDateTime.now()));
        writer.append("\n");
        writer.flush();
    }

    public LoggerService(){
        try{
            this.writer = new FileWriter("files/log.csv");
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
