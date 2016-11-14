/*
 * Sarah Axtell
 * CMSC 250
 */
package cahclient;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.layout.HBox;

/**
 *
 * @author saxtell
 */
public class HandPane extends HBox{
    private ObservableList<CardPane> hand;
    private CardPane selected;


public HandPane() {
        this.setSpacing(10);
        hand = FXCollections.observableArrayList();
    }

public void addCard(String cardtext){
    CardPane card = new CardPane(cardtext,true); 
    hand.add(card);
}


public void removeCard(CardPane card){
    hand.remove(card);
    card.removeCard();
}
 public CardPane getSelected() {
        return selected;
    }
 
}


