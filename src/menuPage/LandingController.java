package menuPage;

import Util.ChangeP;
import Util.HelpFile;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.awt.event.MouseEvent.*;

public class LandingController  implements Initializable {
    @FXML
    private VBox sideDrawer;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private Label lblDrName;

    @FXML
    private Button criarPaciente;

    @FXML
    private Button verPaciente;

//    @FXML
//    private MouseEvent MClicked;
HamburgerBackArrowBasicTransition basicTransition;

    public static final int MOUSE_PRESSED=501;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            VBox box=FXMLLoader.load(getClass().getResource("/drawer/drawerContent.fxml"));
//            drawer.setSidePane(box);
//
           lblDrName.setText(HelpFile.DrName);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


        basicTransition= new HamburgerBackArrowBasicTransition(hamburger);
        basicTransition.setRate(-1);


    }
    @FXML
    public void MClicked(){
        drawer.toggle();
        drawer.setOnDrawerOpening((event) -> {
            basicTransition.setRate(basicTransition.getRate() *-1);
            basicTransition.play();
           // drawer.setMinWidth(20);
        });
        drawer.setOnDrawerClosed((event) -> {
            basicTransition.setRate(basicTransition.getRate()*-1);
            basicTransition.play();
           // drawer.setMinWidth(0);
        });

    }

    @FXML
    public void CriarPaciente(){
        Platform.runLater(
                () -> {
                    // Update UI here.
                    Stage stage=(Stage) criarPaciente.getScene().getWindow();
                    ChangeP p=new ChangeP();
                   // p.ChangePage("/pacient/addPacient.fxml","Add Pacient Page");
                    p.ChangeAddPage("/pacient/addPacient.fxml","Add Pacient Page");

                });
    }

    @FXML
    public void VerPaciente(){
        Platform.runLater(
                () -> {
                    // Update UI here.
                    Stage stage=(Stage) verPaciente.getScene().getWindow();
                    stage.close();
                    ChangeP p=new ChangeP();
                    p.ChangePage("/pacient/menuPacient.fxml","Menu Pacient Page");

                });

    }
}
