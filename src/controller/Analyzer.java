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
        DbBannedCards dbController = new DbBannedCards();
        //Collection<String> bannedCards = dbController.getListOfBannedCardNames() //Retorna una Collection<String>

        List listBannedCards = Arrays.asList(listCardsUser.readDecklistFile().stream().filter(p -> p.contains("Fleecemane Lion")).collect(Collectors.toList()));
        //List listBannedCards = listCardsUser.readDecklistFile().stream().filter(p -> bannedCards.contains(p)).collect(Collectors.toList());

        return listBannedCards;
    }

}
