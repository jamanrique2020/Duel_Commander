import controller.Analyzer;
import database.DbBannedCards;
import model.FileProcessor;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        DbBannedCards db = new DbBannedCards();
        Analyzer comparator = new Analyzer();
        try {
            fileProcessor.readDecklistFile();
            db.bannedCardsDB();
            comparator.compareCards();
            fileProcessor.writeOutputAnalysis();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
