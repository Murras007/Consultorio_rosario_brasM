package consultation;

import Util.ChangeP;
import Util.HelpFile;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import entity.Consultation;
import entity.Pacient;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import restClient.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.ConsultationService;
import services.PacientService;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MenuConsultationController implements Initializable {
    PacientService pacientService;

    Call<Pacient>pacientCall;

    ConsultationService consultationService;

    Call<Consultation>consultationCall;
    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private TableView<Consultation> tableConsalt;

    @FXML
    private TableColumn<Consultation, String> colConsult;

    @FXML
    private TableColumn<Consultation, String> colDataConsult;

    @FXML
    private JFXTextField txtMainComplain;

    @FXML
    private JFXTextField txtBackground;

    @FXML
    private JFXTextField txtWeight;

    @FXML
    private JFXTextField txtHeight;

    @FXML
    private JFXTextField txtBloodPresure;

    @FXML
    private JFXTextField txtTempeture;

    @FXML
    private JFXTextField txtHead;

    @FXML
    private JFXTextField txtNeck;

    @FXML
    private JFXTextField txtChest;

    @FXML
    private JFXTextField txtLungsExams;

    @FXML
    private JFXTextField txtAscultacao;

    @FXML
    private JFXTextField txtCardiaoExams;

    @FXML
    private JFXTextField txtAddomen;

    @FXML
    private JFXTextField txtGenitais;

    @FXML
    private JFXTextField txtRecto;

    @FXML
    private JFXTextField txtLimps;

    @FXML
    private JFXTextField txtDiagnostic;

    @FXML
    private JFXTextField txtComplementariesExams;

    @FXML
    private JFXTextField txtTreatment;

    @FXML
    private JFXTextField txtRecomentation;

    @FXML
    private Label pacientName;



    HamburgerBackArrowBasicTransition basicTransition;
@FXML
    private Button btnCreateConsultation;

    ObservableList<Consultation> list;
    List<Consultation> consultationList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox box= null;

        try {
            box = FXMLLoader.load(getClass().getResource("/drawer/drawerContent.fxml"));
            drawer.setSidePane(box);
            pacientName.setText(HelpFile.NAME);
            consultationList = new ArrayList<>();
            pacientService= RestClient.getClient().create(PacientService.class);
            pacientCall=pacientService.findById(HelpFile.ID,HelpFile.COOKIE);
            pacientCall.enqueue(new Callback<Pacient>() {
                @Override
                public void onResponse(Call<Pacient> call, Response<Pacient> response) {
                    if(response.isSuccessful()){
                        Pacient pacient= response.body();


                        for(Consultation consultation: pacient.getConsultations() ){
                            colConsult.setCellValueFactory(new PropertyValueFactory<Consultation, String>("consultation"));
                            colDataConsult.setCellValueFactory(new PropertyValueFactory<Consultation, String>("currentDate"));

                            consultationList.add(consultation);
                            list= FXCollections.observableArrayList(consultationList);

                        }
                        //pacientList.add(list)
                        tableConsalt.setItems(list);
                    }
                }

                
                @Override
                public void onFailure(Call<Pacient> call, Throwable t) {

                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        basicTransition= new HamburgerBackArrowBasicTransition(hamburger);
        basicTransition.setRate(-1);

    }
    @FXML
    public void clickedInfo(){
        int id=tableConsalt.getSelectionModel().getSelectedItem().getId();
    consultationService=RestClient.getClient().create(ConsultationService.class);
    consultationCall=consultationService.findById(HelpFile.COOKIE,id);
    consultationCall.enqueue(new Callback<Consultation>() {
        @Override
        public void onResponse(Call<Consultation> call, Response<Consultation> response) {
            if(response.isSuccessful()){
                Consultation consultation= response.body();
                txtMainComplain.setText(consultation.getAnamneses().get(0).getQueixasPrincipais());
                txtBackground.setText(consultation.getAnamneses().get(0).getAtencendentes());

                txtWeight.setText(String.valueOf(consultation.getObjectiveExams().get(0).getWeight()));
                txtHeight.setText(String.valueOf(consultation.getObjectiveExams().get(0).getHeight()));
                txtBloodPresure.setText(String.valueOf(consultation.getObjectiveExams().get(0).getBloodPressure()));
                txtTempeture.setText(String.valueOf(consultation.getObjectiveExams().get(0).getBloodPressure()));
                txtHead.setText(consultation.getObjectiveExams().get(0).getHead());
                txtNeck.setText(consultation.getObjectiveExams().get(0).getNeck());
                txtChest.setText(consultation.getObjectiveExams().get(0).getChest());
                txtLungsExams.setText(consultation.getObjectiveExams().get(0).getLungExam());
                txtAscultacao.setText(consultation.getObjectiveExams().get(0).getAscultacao());
                txtCardiaoExams.setText(consultation.getObjectiveExams().get(0).getCardiacExam());
                txtAddomen.setText(consultation.getObjectiveExams().get(0).getAbdomen());
                txtGenitais.setText(consultation.getObjectiveExams().get(0).getGenitals());
                txtRecto.setText(consultation.getObjectiveExams().get(0).getRecto());
                txtLimps.setText(consultation.getObjectiveExams().get(0).getLimbs());

                txtDiagnostic.setText(consultation.getDiagnostics().get(0).getDiagnostic());

                txtComplementariesExams.setText(consultation.getComplementaryExams().get(0).getComplementarsExams());

                txtTreatment.setText(consultation.getTreatments().get(0).getTreatment());

                txtRecomentation.setText(consultation.getRecomendations().get(0).getRecomendation());

            }
        }

        @Override
        public void onFailure(Call<Consultation> call, Throwable t) {

        }
    });
    }
//    @FXML
//    public void TextListener(){
//        // pesquisar.textProperty().addListener((observable, oldValue, newValue) -> );
//        pesquisar.textProperty().addListener((obs, oldValue, newValue) -> {
////                switch (choiceBox.getValue())//Switch on choiceBox value
////                {
////                    case "First Name":
////                        flPerson.setPredicate(p -> p.getFirstName().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by first name
////                        break;
////                    case "Last Name":
////                        flPerson.setPredicate(p -> p.getLastName().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by last name
////                        break;
////                    case "Email":
////                        flPerson.setPredicate(p -> p.getEmail().toLowerCase().contains(newValue.toLowerCase().trim()));//filter table by email
////                        break;
////                }
//
//            System.out.println("it touched me");
//        });
//    }
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
    public void makeConsultation(){
        Platform.runLater(
                () -> {
                    // Update UI here.
                    Stage stage=(Stage) btnCreateConsultation.getScene().getWindow();
                    //stage.close();
                    ChangeP p=new ChangeP();
                   // p.ChangePage("/consultation/makeConsultation.fxml","Make Consultation");
                    p.ChangeAddPage("/consultation/makeConsultation.fxml","Make Consultation");

                });
    }
    }

