package pacient;

import Util.HelpFile;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import restClient.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.PacientService;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HistoryPacientController implements Initializable {

    PacientService pacientService;

    Call<Pacient> listCall;
    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;

    HamburgerBackArrowBasicTransition basicTransition;

    @FXML
    private TableView<Anamnese> anamnese;

    @FXML
    private TableColumn<Anamnese, String> mainComplain;

    @FXML
    private TableColumn<Anamnese, String> background;

    @FXML
    private TableView<ObjectiveExams> tbObjectiveExams;

    @FXML
    private TableColumn<ObjectiveExams, Double> weight;

    @FXML
    private TableColumn<ObjectiveExams, Double> height;

    @FXML
    private TableColumn<ObjectiveExams, Integer> bloodPreasure;

    @FXML
    private TableColumn<ObjectiveExams, Double> temp;

    @FXML
    private TableColumn<ObjectiveExams, String> head;

    @FXML
    private TableColumn<ObjectiveExams, String> neck;

    @FXML
    private TableColumn<ObjectiveExams, String> chest;

    @FXML
    private TableColumn<ObjectiveExams, String> lungsExams;

    @FXML
    private TableColumn<ObjectiveExams, String> ascultacao;

    @FXML
    private TableColumn<ObjectiveExams, String> cardiacExams;

    @FXML
    private TableColumn<ObjectiveExams, String> abdomen;

    @FXML
    private TableColumn<ObjectiveExams, String> growing;

    @FXML
    private TableColumn<ObjectiveExams, String> recto;

    @FXML
    private TableColumn<ObjectiveExams, String> limps;

    @FXML
    private TableView<Diagnostic> tbDiagnostic;

    @FXML
    private TableColumn<Diagnostic, String> diagnostic;

    @FXML
    private TableView<ComplementaryExams> tbComplementaryExams;

    @FXML
    private TableColumn<ComplementaryExams, String> complementsExams;

    @FXML
    private TableView<Pacient> tbTreatments;

    @FXML
    private TableColumn<Pacient, String> treatments;

    ObservableList<ObjectiveExams> list;

    ObservableList<Anamnese>diseaseObservableList;

    ObservableList<Diagnostic>diagnosticObservableList;
    ObservableList<ComplementaryExams>complementaryExamsObservableList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox box= null;
        try {
            box = FXMLLoader.load(getClass().getResource("/drawer/drawerContent.fxml"));
            drawer.setSidePane(box);

            pacientService= RestClient.getClient().create(PacientService.class);
            listCall= pacientService.findById(HelpFile.ID,HelpFile.COOKIE);
            listCall.enqueue(new Callback<Pacient>() {
                @Override
                public void onResponse(Call<Pacient> call, Response<Pacient> response) {
                    if(response.isSuccessful()){
                        List<ObjectiveExams> pacientList= new ArrayList<>();
                        List<Anamnese>anamneseList=new ArrayList<>();
                        List<Diagnostic>diagnosticList=new ArrayList<>();
                        List<ComplementaryExams>complementaryExamsList=new ArrayList<>();
                       // pacient.setObjectiveExams(response.body());

                        Pacient pacient= response.body();
                        for (ObjectiveExams pacient1: pacient.getObjectiveExams()) {
                            weight.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, Double>("weight"));
                            height.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, Double>("height"));
                            bloodPreasure.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, Integer>("bloodPressure"));
                            temp.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, Double>("temperature"));
                            head.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, String>("head"));
                            neck.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, String>("neck"));
                            chest.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, String>("chest"));
                            lungsExams.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, String>("lungExam"));
                            ascultacao.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, String>("Ascultacao"));
                            cardiacExams.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, String>("cardiacExam"));
                            abdomen.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, String>("Abdomen"));
                            growing.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, String>("genitals"));
                            recto.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, String>("Recto"));
                            limps.setCellValueFactory(new PropertyValueFactory<ObjectiveExams, String>("limbs"));
                            pacientList.add(pacient1);

                        list= FXCollections.observableArrayList(pacientList);
                    }
                        for (Anamnese anamnese1: pacient.getAnamneses()){
                            mainComplain.setCellValueFactory(new PropertyValueFactory<Anamnese, String>("queixasPrincipais"));
                            background.setCellValueFactory(new PropertyValueFactory<Anamnese, String>("atencendentes"));
                            anamneseList.add(anamnese1);
                            diseaseObservableList=FXCollections.observableArrayList(anamneseList);
                        }

                        for (Diagnostic diagnostic1: pacient.getDiagnostics()){
                            diagnostic.setCellValueFactory(new PropertyValueFactory<Diagnostic, String>("diagnostic"));
                            diagnosticList.add(diagnostic1);
                            diagnosticObservableList=FXCollections.observableArrayList(diagnosticList);
                        }

                        for (ComplementaryExams complementaryExams: pacient.getComplementaryExams()){
                            complementsExams.setCellValueFactory(new PropertyValueFactory<ComplementaryExams, String>("complementarsExams"));
                            complementaryExamsList.add(complementaryExams);
                            complementaryExamsObservableList=FXCollections.observableArrayList(complementaryExamsList);
                        }
                        tbObjectiveExams.setItems(list);
                        anamnese.setItems(diseaseObservableList);
                        tbDiagnostic.setItems(diagnosticObservableList);
                        tbComplementaryExams.setItems(complementaryExamsObservableList);
                    }else{
                        System.out.println("didnt hit");
                    }
                }

                @Override
                public void onFailure(Call<Pacient> call, Throwable t) {
                    System.out.println("something wrong");
                }
            });
        }catch (Exception e){

        }
        basicTransition= new HamburgerBackArrowBasicTransition(hamburger);
        basicTransition.setRate(-1);
    }
    @FXML
    public void MClicked() {
        drawer.toggle();
        drawer.setOnDrawerOpening((event) -> {
            basicTransition.setRate(basicTransition.getRate() * -1);
            basicTransition.play();

        });
        drawer.setOnDrawerClosed((event) -> {
            basicTransition.setRate(basicTransition.getRate() * -1);
            basicTransition.play();

        });
    }
}
