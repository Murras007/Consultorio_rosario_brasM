package pacient;

import Util.ChangeP;
import Util.HelpFile;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import entity.Pacient;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import restClient.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.PacientService;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MenuPacientController implements Initializable {

    PacientService pacientService;

    Call <List<Pacient>>listCall;

    Call<Pacient>pacientCall;
    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;

    HamburgerBackArrowBasicTransition basicTransition;
    @FXML
    private TableView<Pacient> tablePacient;

    @FXML
    private TableColumn<Pacient, String> colName;

    @FXML
    private TableColumn<Pacient, String> colAge;

    @FXML
    private TableColumn<Pacient, String> colProfissao;

    @FXML
    private TableColumn<Pacient, String> colDataConsulta;

    @FXML
    private TableColumn<Pacient, String> colDataNascemente;

    @FXML
    private TableColumn<Pacient, String> colSeguro;

    @FXML
    private TableColumn<Pacient, String> colTelefone;

    @FXML
    private TableColumn<Pacient, String> colMorada;

    @FXML
    private TableColumn<Pacient, String> colBI;

    @FXML
    private Label lblName;

    @FXML
    private Label lblAge;

    @FXML
    private Label lblProfisson;

    @FXML
    private Label lblConsultationDate;

    @FXML
    private Label lblMedicalAID;

    @FXML
    private Label lblTelefone;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblBI;

    @FXML
    private Label lblDateOfBirth;

    @FXML
    private Button addPacient;

    @FXML
    private Button editPacient;

    @FXML
    private Button deletePacient;

    @FXML
    private Button addConsultation;

    @FXML
    private JFXTextField pesquisar;

    ObservableList<Pacient>list;
    List<Pacient>pacientList;

    List<Pacient>pacientListBody;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox box= null;
        try {
            box = FXMLLoader.load(getClass().getResource("/drawer/drawerContent.fxml"));
            drawer.setSidePane(box);
            pacientList = new ArrayList<>();
            pacientService= RestClient.getClient().create(PacientService.class);
            listCall= pacientService.findAll(HelpFile.COOKIE);
            listCall.enqueue(new Callback<List<Pacient>>() {
                @Override
                public void onResponse(Call<List<Pacient>> call, Response<List<Pacient>> response) {
                    if(response.isSuccessful()){

                        pacientListBody=response.body();
                        for(Pacient pacient:  pacientListBody){
                            colName.setCellValueFactory(new PropertyValueFactory<Pacient, String>("name"));
                            colAge.setCellValueFactory(new PropertyValueFactory<Pacient, String>("age"));
                            colBI.setCellValueFactory(new PropertyValueFactory<Pacient, String>("BI"));
                            colDataConsulta.setCellValueFactory(new PropertyValueFactory<Pacient, String>("BookingDate"));
                            colMorada.setCellValueFactory(new PropertyValueFactory<Pacient, String>("Address"));
                            colDataNascemente.setCellValueFactory(new PropertyValueFactory<Pacient, String>("DateOfBirth"));
                            colProfissao.setCellValueFactory(new PropertyValueFactory<Pacient, String>("profission"));
                            colTelefone.setCellValueFactory(new PropertyValueFactory<Pacient, String>("phone"));
                           pacientList.add(pacient);
                            list= FXCollections.observableArrayList(pacientList);

                        }
                        //pacientList.add(list)
                        tablePacient.setItems(list);
                    }else{
                        System.out.println("didnt hit");
                    }
                }

                @Override
                public void onFailure(Call<List<Pacient>> call, Throwable t) {
                    System.out.println("something wrong");
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        basicTransition= new HamburgerBackArrowBasicTransition(hamburger);
        basicTransition.setRate(-1);

        pesquisar.textProperty().addListener((obs, oldValue, newValue) -> {
            List<Pacient>pacientList1= new ArrayList<>();
            for(Pacient pacient : pacientListBody){
                if(pacient.getName().contains(newValue)||pacient.getPhone().contains(newValue)||pacient.getBI().contains(newValue)){
                    pacientList1.add(pacient);
                    pacientList = new ArrayList<>();
                    colName.setCellValueFactory(new PropertyValueFactory<Pacient, String>("name"));
                    colAge.setCellValueFactory(new PropertyValueFactory<Pacient, String>("age"));
                    colBI.setCellValueFactory(new PropertyValueFactory<Pacient, String>("BI"));
                    colDataConsulta.setCellValueFactory(new PropertyValueFactory<Pacient, String>("BookingDate"));
                    colMorada.setCellValueFactory(new PropertyValueFactory<Pacient, String>("Address"));
                    colDataNascemente.setCellValueFactory(new PropertyValueFactory<Pacient, String>("DateOfBirth"));
                    colProfissao.setCellValueFactory(new PropertyValueFactory<Pacient, String>("profission"));
                    colTelefone.setCellValueFactory(new PropertyValueFactory<Pacient, String>("phone"));
                    list= FXCollections.observableArrayList(pacientList1);

                }

            }
           // tablePacient =new TableView<>();
            tablePacient.setItems(list);


    //       System.out.println("old"+oldValue);
            System.out.println("new"+newValue);
  //          System.out.println(obs);
        });

    }
    @FXML
    public void MClicked(){
        drawer.toggle();
        drawer.setOnDrawerOpening((event) -> {
            basicTransition.setRate(basicTransition.getRate() *-1);
            basicTransition.play();

        });
        drawer.setOnDrawerClosed((event) -> {
            basicTransition.setRate(basicTransition.getRate()*-1);
            basicTransition.play();

        });

    }
    @FXML
    public void clickedInfo(){
       HelpFile.ID=tablePacient.getSelectionModel().getSelectedItem().getId();
       HelpFile.NAME=tablePacient.getSelectionModel().getSelectedItem().getName();
        //System.out.println(tablePacient.getSelectionModel().getSelectedItem().getName());
        lblName.setText("Nome: "+tablePacient.getSelectionModel().getSelectedItem().getName());
        lblAddress.setText("morada: "+tablePacient.getSelectionModel().getSelectedItem().getAddress());
        lblAge.setText("Idade: "+tablePacient.getSelectionModel().getSelectedItem().getAge());
        lblBI.setText("B.I: "+tablePacient.getSelectionModel().getSelectedItem().getBI());
        lblConsultationDate.setText("Data da Consulta: "+tablePacient.getSelectionModel().getSelectedItem().getBookingDate());
        lblDateOfBirth.setText("Data de Nascimento: "+tablePacient.getSelectionModel().getSelectedItem().getDateOfBirth());
        lblMedicalAID.setText("Seguro: "+tablePacient.getSelectionModel().getSelectedItem().getMedicalAID());
        lblProfisson.setText("Profissao: "+tablePacient.getSelectionModel().getSelectedItem().getProfission());
        lblTelefone.setText("Telefone: "+tablePacient.getSelectionModel().getSelectedItem().getPhone());
    }


    @FXML
    public void AddPacient(){
        Platform.runLater(
                () -> {
                    // Update UI here.
                    Stage stage=(Stage) addPacient.getScene().getWindow();
                   // stage.close();
                    ChangeP p=new ChangeP();
                   // p.ChangePage("/pacient/addPacient.fxml","Add Pacient");
                    p.ChangeAddPage("/pacient/addPacient.fxml","Add Pacient Page");

                });
    }

    @FXML
    public void UpgradePacient(){
        Platform.runLater(
                () -> {
                    // Update UI here.
                    Stage stage=(Stage) editPacient.getScene().getWindow();
                    // stage.close();
                    ChangeP p=new ChangeP();
                    // p.ChangePage("/pacient/addPacient.fxml","Add Pacient");
                    p.ChangeAddPage("/pacient/editPacient.fxml","Edit Pacient Page");

                });
    }

    @FXML
    public void DeletePacient(){
        ButtonType foo = new ButtonType("SIM", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("NAO", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.WARNING,HelpFile.NAME
                ,
                foo,
                bar);

        alert.setTitle("Deseja apagar o Pacient: " );
        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {
            //System.out.println("working");
            pacientService=RestClient.getClient().create(PacientService.class);
            pacientCall=pacientService.deletePacient(HelpFile.COOKIE,HelpFile.ID);
            pacientCall.enqueue(new Callback<Pacient>() {
                @Override
                public void onResponse(Call<Pacient> call, Response<Pacient> response) {
                    if (response.isSuccessful()){
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                // Update UI here.
                                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                                alert.setContentText("Paciente Eleminado");
                                alert.show();
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<Pacient> call, Throwable t) {
                    System.out.println( "didnt delete");

                }
            });

        }
    }

//    @FXML
//    public void ViewHistoryPacient() {
//        Platform.runLater(
//                () -> {
//                    // Update UI here.
//                    Stage stage=(Stage) ViewHistory.getScene().getWindow();
//                    stage.close();
//                    ChangeP p=new ChangeP();
//                    p.ChangePage("/pacient/historyPacient.fxml","Pacient History");
//
//                });
//    }
    @FXML
    public void addConsultation(){
        Platform.runLater(
                () -> {
                    // Update UI here.
                    Stage stage=(Stage) addConsultation.getScene().getWindow();
                    stage.close();
                    ChangeP p=new ChangeP();
                    p.ChangePage("/consultation/menuConsultation.fxml","Menu Consultation");

                });

    }
}



