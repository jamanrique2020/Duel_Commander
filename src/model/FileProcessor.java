package model;

import controller.Analyzer;
import database.DbBannedCards;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileProcessor {



    public Collection<String> readDecklistFile() throws IOException{
        Class clazz = FileProcessor.class;
        InputStream inputStream = clazz.getResourceAsStream("../resources/Ejemplo de Baraja.cod");
        Collection data = readFromInputStream(inputStream);

        return data;
    }
    public Collection readFromInputStream(InputStream is) throws IOException {
        List <String> resultList = new ArrayList();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultList.add(line);

            }

        }
        return resultList;
    }

    public void  writeOutputAnalysis() throws IOException {

        Analyzer dataWrite = new Analyzer();

            Path p1 = Paths.get("src" ,  "resources", "Resultado análisis.txt");
            OutputStream output = new FileOutputStream(String.valueOf(p1));

            try (OutputStreamWriter writeAnalysis = new OutputStreamWriter(output)){
                writeAnalysis.write(String.valueOf(dataWrite));
            }
            catch (FileNotFoundException f) {
            System.out.println("File not found: " + f);
            }
            catch (IOException e) {
                System.out.println("IO Exception: " + e);
            }
    }

}
