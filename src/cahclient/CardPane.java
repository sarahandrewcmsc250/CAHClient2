/*
 * Sarah Axtell
 * CMSC 250
 */
package cahclient;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;

/**
 *
 * @author saxtell
 */
public class CardPane extends Pane{
    public static final int CARD_HEIGHT = 150;
    public static final int CARD_WIDTH = 100;
    public static final int LEFT_MARGIN = 20;
    private Rectangle border;
    private Text text;
    
    public CardPane(String cardtext, boolean wc) {
        this.setHeight(CARD_HEIGHT);
        this.setWidth(CARD_WIDTH);
        border = new Rectangle(0,0,CARD_WIDTH,CARD_HEIGHT);
           border.setStroke(Color.BLACK);
        if (wc){
           text = new Text(10,15,cardtext);
           text.setFont(Font.font ("Helvetica", 16));
           text.setFill(Color.BLACK);
           border.setFill(Color.WHITE);
        }
        else {
           text = new Text(10,15,cardtext);
           text.setFont(Font.font ("Helvetica", 16));
           text.setFill(Color.WHITE);
           border.setFill(Color.BLACK);
           border.setStroke(Color.BLACK);
        }
           this.getChildren().addAll(border,text);
        }
    
    
    public void selectCard() { 
        border.setFill(Color.SILVER); 
    }
    
    public void removeCard(){
         this.getChildren().removeAll(border, text);
    }
    
    public void deselectCard() { 
        border.setFill(Color.WHITE); }
    
    public String getText(){
        return text.toString();
    }
    
    @Override
    public boolean isResizable() {
        return false;
    }  
}