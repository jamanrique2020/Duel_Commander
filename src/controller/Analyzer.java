package controller;

import database.DbBannedCards;
import model.FileProcessor;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Analyzer {


    public Collection compareCards() throws IOException{

        FileProcessor listCardsUser = new FileProcessor();
        DbBannedCards nameBannedCards = new DbBannedCards();

        List listBannedCards = Arrays.asList(listCardsUser.readDecklistFile().stream().filter(p -> p.contains("Fleecemane Lion")).collect(Collectors.toList()));

        return listBannedCards;
    }

}
