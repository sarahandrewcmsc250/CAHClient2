/*
 * Sarah Axtell
 * CMSC 250
 */
package cahclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

public class CAHGateway implements cah.CAHConstants {

    private PrintWriter outputToServer;
    private BufferedReader inputFromServer;
    private TextArea textArea;
    private Lock lock;

    public CAHGateway() {
        lock = new ReentrantLock();
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket("localhost", 8000);

            // Create an output stream to send data to the server
            outputToServer = new PrintWriter(socket.getOutputStream());

            // Create an input stream to read data from the server
            inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException ex) {
            Platform.runLater(() -> textArea.appendText("Exception in gateway constructor: " + ex.toString() + "\n"));
        }
    }
    
    public void drawWhite() {
       lock.lock();
        outputToServer.println(DRAW_WHITE);
        outputToServer.println();
        outputToServer.flush();
         lock.unlock();
    }

    public void playWhite(String wc) {
        lock.lock();
        outputToServer.println(PLAY_WHITE);
        outputToServer.println(wc);
        outputToServer.flush();
         lock.unlock();
        
    }
    
    public void pickWhite(int wcid) {
        lock.lock();
        outputToServer.println(PICK_WHITE);
        outputToServer.println(wcid);
        outputToServer.flush();
         lock.unlock();
    }
    
      public ObservableList getHand(){
        lock.lock();
        outputToServer.println(GET_HAND);
        outputToServer.flush();
        lock.unlock();
        ObservableList list = FXCollections.observableArrayList();
        int count = 0;
        try{
            count = Integer.parseInt(inputFromServer.readLine());
            for (int i = 0; i < count; ++ i){
                list.add(inputFromServer.readLine());
            }
        }catch (IOException ex){
            Platform.runLater(() -> textArea.appendText("Error in getLobbies: " + ex.toString() + "\n"));
        }
        return list;
    }

    public ObservableList getLobbies(){
        lock.lock();
        outputToServer.println(GET_LOBBIES);
        outputToServer.flush();
        lock.unlock();
        ObservableList list = FXCollections.observableArrayList();
        int count = 0;
        try{
            count = Integer.parseInt(inputFromServer.readLine());
            for (int i = 0; i < count; ++ i){
                list.add(inputFromServer.readLine());
            }
        }catch (IOException ex){
            Platform.runLater(() -> textArea.appendText("Error in getLobbies: " + ex.toString() + "\n"));
        }
        return list;
    }
    public void sendLobby(int lobby) {
        lock.lock();
        outputToServer.println(SEND_LOBBY);
        outputToServer.println(lobby);
        outputToServer.flush();
        lock.unlock();
    }
    
public void sendHandle(String handle) {
        lock.lock();
        outputToServer.println(SEND_HANDLE);
        outputToServer.println(handle);
        outputToServer.flush();
        lock.unlock();
    }
    
public void readyUp(){
     lock.lock();
        outputToServer.println(READY_UP);
        outputToServer.flush();
        lock.unlock();
}

public void unready(){
    lock.lock();
        outputToServer.println(UNREADY);
        outputToServer.flush();
        lock.unlock();
}
public int getScore(){
    lock.lock();
        outputToServer.println(GET_SCORE);
        outputToServer.flush();
        lock.unlock();
        int score = 0;
        try {
            score = Integer.parseInt(inputFromServer.readLine());
        } catch (IOException ex) {
            Platform.runLater(() -> textArea.appendText("Error in getScore: " + ex.toString() + "\n"));
        }
        return score;
}

public void drawBlack(){
    lock.lock();
        outputToServer.println(DRAW_BLACK);
        outputToServer.println();
        outputToServer.flush();
         lock.unlock();
}

public String getBlack(){
    lock.lock();
        outputToServer.println(GET_BLACK);
        outputToServer.flush();
        lock.unlock();
        String blackCard = "";
        try {
            blackCard = inputFromServer.readLine();
        } catch (IOException ex) {
            Platform.runLater(() -> textArea.appendText("Error in getBlack: " + ex.toString() + "\n"));
        }
        return blackCard;
}

}
