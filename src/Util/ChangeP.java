package Util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeP {

    public void ChangePage(String path, String tittle){
        Stage stage1= new Stage();
        Parent root= null;
        try {
            root = FXMLLoader.load(getClass().getResource(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage1.setTitle(tittle);
        stage1.setScene(new Scene(root,1205,565));
        stage1.show();
    }

    public void ChangeAddPage(String path, String tittle){
        Stage stage1= new Stage();
        Parent root= null;
        try {
            root = FXMLLoader.load(getClass().getResource(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage1.setTitle(tittle);
        stage1.setScene(new Scene(root,1005,550));
        stage1.show();
    }
}
