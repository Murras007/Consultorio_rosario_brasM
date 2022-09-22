package drawer;


import Util.ChangeP;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DrawerController implements Initializable {

    @FXML
    private JFXButton Inicio;
    @FXML
    private JFXButton Paciente;
    @FXML
    private JFXButton Sair;


    @Override
    public void initialize(URL location, ResourceBundle resources) {



}
    @FXML
    void btnInicio(){
        Platform.runLater(
                () -> {
                    // Update UI here.
                    Stage stage=(Stage) Inicio.getScene().getWindow();
                    stage.close();
                    ChangeP p=new ChangeP();
                    p.ChangePage("/menuPage/landingPage.fxml","Landing Page");

                });
    }
    @FXML
    void btnPaciente() {
        Platform.runLater(
                () -> {
                    // Update UI here.
                    Stage stage=(Stage) Paciente.getScene().getWindow();
                    stage.close();
                    ChangeP p=new ChangeP();
                    p.ChangePage("/pacient/menuPacient.fxml","Pacient Menu");

                });

    }
    @FXML
    void btnSair() {
        Platform.runLater(
                () -> {
                    // Update UI here.
                    Stage stage=(Stage) Sair.getScene().getWindow();
                     stage.close();
                    ChangeP p=new ChangeP();
                    p.ChangePage("/login/login.fxml","Consoltorio Rosario Bras");

                });
    }
}