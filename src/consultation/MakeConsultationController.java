package consultation;

import Util.HelpFile;
import com.jfoenix.controls.JFXTextField;
import entity.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import restClient.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.*;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class MakeConsultationController implements Initializable {

    ConsultationService consultationService;
    Call<Consultation>consultationCall;

    AnamneseService anamneseService;
    Call<Anamnese>anamneseCall;

    ComplementaryExamsService complementaryExamsService;
    Call<ComplementaryExams>complementaryExamsCall;

    DiagnosticService diagnosticService;
    Call<Diagnostic>diagnosticCall;

    ObjectiveExamsService objectiveExamsService;
    Call<ObjectiveExams>objectiveExamsCall;

    RecomendationService recomendationService;
    Call<Recomendation>recomendationCall;

    TreatmentService treatmentService;
    Call<Treatment>treatmentCall;

    int ID;
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
    private JFXTextField txtMainComplain;

    @FXML
    private JFXTextField txtBackground;

    @FXML
    private JFXTextField txtDiagnostic;

    @FXML
    private JFXTextField txtComplementariesExams;

    @FXML
    private JFXTextField txtTreatment;

    @FXML
    private JFXTextField txtRecomentation;

    @FXML
    private Button btnSave;

    @Override
    public void initialize(URL location, ResourceBundle resources) {




    }

    public void save(){
        Consultation consultation=new Consultation();
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
//        Timestamp instant= Timestamp.from(Instant.now());
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new java.util.Date());
        consultation.setConsultation(HelpFile.NAME+" "+timeStamp);
        consultation.setCurrentDate(timeStamp);
        consultationService= RestClient.getClient().create(ConsultationService.class);
        consultationCall=consultationService.addConsultation(HelpFile.COOKIE,HelpFile.ID,consultation);
        consultationCall.enqueue(new Callback<Consultation>() {
            @Override
            public void onResponse(Call<Consultation> call, Response<Consultation> response) {
                if(response.isSuccessful()){
                    Consultation consultation1= response.body();
                    ID=consultation1.getId();
                    PostAnamnese(ID);
                    PostComplementaryExams(ID);
                    PostDiagnostic(ID);
                    PostObjectiveExams(ID);
                    PostRecomendation(ID);
                    PostTreatment(ID);
                }else{

                }
            }

            @Override
            public void onFailure(Call<Consultation> call, Throwable t) {

            }
        });

    }

    public void PostAnamnese(int ID){
        Anamnese anamnese= new Anamnese();
       // String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new java.util.Date());
        anamnese.setAtencendentes(txtBackground.getText());
        anamnese.setQueixasPrincipais(txtMainComplain.getText());
        anamneseService= RestClient.getClient().create(AnamneseService.class);
        anamneseCall=anamneseService.add(HelpFile.COOKIE,ID,anamnese);
        anamneseCall.enqueue(new Callback<Anamnese>() {
            @Override
            public void onResponse(Call<Anamnese> call, Response<Anamnese> response) {
                if (response.isSuccessful()){
                    Anamnese anamnese1= response.body();
                }
            }

            @Override
            public void onFailure(Call<Anamnese> call, Throwable t) {

            }
        });
    }
    public void PostComplementaryExams(int ID){
        ComplementaryExams complementaryExams=new ComplementaryExams();
        complementaryExams.setComplementarsExams(txtComplementariesExams.getText());
        complementaryExamsService=RestClient.getClient().create(ComplementaryExamsService.class);
        complementaryExamsCall=complementaryExamsService.addCompExams(HelpFile.COOKIE,ID,complementaryExams);
        complementaryExamsCall.enqueue(new Callback<ComplementaryExams>() {
            @Override
            public void onResponse(Call<ComplementaryExams> call, Response<ComplementaryExams> response) {
                if(response.isSuccessful()){
                    ComplementaryExams complementaryExams1= response.body();

                }else{

                }
            }

            @Override
            public void onFailure(Call<ComplementaryExams> call, Throwable t) {

            }
        });

    }
    public void PostDiagnostic(int ID){
        Diagnostic diagnostic= new Diagnostic();
        diagnostic.setDiagnostic(txtDiagnostic.getText());
        diagnosticService=RestClient.getClient().create(DiagnosticService.class);
        diagnosticCall=diagnosticService.addDiagnostic(HelpFile.COOKIE,ID,diagnostic);
        diagnosticCall.enqueue(new Callback<Diagnostic>() {
            @Override
            public void onResponse(Call<Diagnostic> call, Response<Diagnostic> response) {
                if(response.isSuccessful()){
                    Diagnostic diagnostic1= response.body();
                }
            }

            @Override
            public void onFailure(Call<Diagnostic> call, Throwable t) {

            }
        });

    }
    public void PostObjectiveExams(int ID){
        ObjectiveExams objectiveExams= new ObjectiveExams();
        objectiveExams.setWeight(Double.parseDouble(txtWeight.getText()));
        objectiveExams.setHeight(Double.parseDouble(txtHeight.getText()));
        objectiveExams.setBloodPressure(Integer.parseInt(txtBloodPresure.getText()));
        objectiveExams.setTemperature(Double.parseDouble(txtTempeture.getText()));
        objectiveExams.setHead(txtHead.getText());
        objectiveExams.setChest(txtChest.getText());
        objectiveExams.setNeck(txtNeck.getText());
        objectiveExams.setLungExam(txtLungsExams.getText());
        objectiveExams.setAscultacao(txtAscultacao.getText());
        objectiveExams.setCardiacExam(txtCardiaoExams.getText());
        objectiveExams.setAbdomen(txtAddomen.getText());
        objectiveExams.setGenitals(txtGenitais.getText());
        objectiveExams.setRecto(txtRecto.getText());
        objectiveExams.setLimbs(txtLimps.getText());

        objectiveExamsService=RestClient.getClient().create(ObjectiveExamsService.class);
        objectiveExamsCall=objectiveExamsService.addObjectiveExams(HelpFile.COOKIE,ID,objectiveExams);
        objectiveExamsCall.enqueue(new Callback<ObjectiveExams>() {
            @Override
            public void onResponse(Call<ObjectiveExams> call, Response<ObjectiveExams> response) {
                if(response.isSuccessful()){
                    ObjectiveExams objectiveExams1= response.body();
                }
            }

            @Override
            public void onFailure(Call<ObjectiveExams> call, Throwable t) {

            }
        });

    }
    public void PostRecomendation(int ID){
        Recomendation recomendation= new Recomendation();
        recomendation.setRecomendation(txtRecomentation.getText());

        recomendationService=RestClient.getClient().create(RecomendationService.class);
        recomendationCall=recomendationService.addRecomendation(HelpFile.COOKIE,ID,recomendation);
        recomendationCall.enqueue(new Callback<Recomendation>() {
            @Override
            public void onResponse(Call<Recomendation> call, Response<Recomendation> response) {
                if(response.isSuccessful()){
                    Recomendation recomendation1=response.body();
                }else{

                }
            }

            @Override
            public void onFailure(Call<Recomendation> call, Throwable t) {

            }
        });

    }
    public void PostTreatment(int ID){
        Treatment treatment= new Treatment();
        treatment.setTreatment(txtTreatment.getText());

        treatmentService=RestClient.getClient().create(TreatmentService.class);
        treatmentCall=treatmentService.addTreatment(HelpFile.COOKIE,ID,treatment);
        treatmentCall.enqueue(new Callback<Treatment>() {
            @Override
            public void onResponse(Call<Treatment> call, Response<Treatment> response) {
                if (response.isSuccessful()){
                    Treatment treatment1=response.body();
                }

            }

            @Override
            public void onFailure(Call<Treatment> call, Throwable t) {

            }
        });

    }
}
