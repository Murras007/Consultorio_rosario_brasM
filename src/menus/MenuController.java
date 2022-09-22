package menus;

import Util.Routes;
import Util.ViewManager;
import com.jfoenix.controls.JFXProgressBar;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private AnchorPane content;

    @FXML
    private BorderPane mainPage;

    private final JFXProgressBar progressBar = new JFXProgressBar();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initComponents();


    }
    void initComponents(){
       ViewManager.setRootPage(content);
       //to(Routes.Page.LandingPage.MAIN);

    }

    @FXML
    void Home(){
//        Platform.runLater(
//                () -> {
//                    try {
//                        ViewManager.Manager.toView(Routes.Page.LandingPage.MAIN);
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//
//                });
        to(Routes.Page.LandingPage.MAIN);
    }
    @FXML
    void Pacient(){
        to(Routes.Page.Pacient.MENUPACIENT);
    }

    void to(String path){
        mainPage.setTop(progressBar);
        Platform.runLater(
                ()->{
                    try {
                        ViewManager.Manager.toPage(path);
                        mainPage.setTop(null);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        );
    }
}
