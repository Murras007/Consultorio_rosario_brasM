package pacient;


import Util.ChangeP;
import Util.HelpFile;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import entity.Pacient;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import restClient.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.PacientService;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class AddPacientController implements Initializable {

    PacientService pacientService;

    Call<Pacient>pacientCall;
    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;

    HamburgerBackArrowBasicTransition basicTransition;


    @FXML
    private JFXTextField txtfName;

    @FXML
    private JFXTextField txtfAge;

    @FXML
    private JFXTextField txtfProssition;

    @FXML
    private DatePicker dpConsrulta;

    @FXML
    private ComboBox<?> cbAid;

    @FXML
    private JFXTextField txtfPhone;

    @FXML
    private JFXTextField txtfAddress;

    @FXML
    private DatePicker cpBirth;

    @FXML

    private JFXTextField txtfBI;

    @FXML
    private Button save;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        VBox box= null;
        try {
            box = FXMLLoader.load(getClass().getResource("/drawer/drawerContent.fxml"));
            drawer.setSidePane(box);
        }catch (Exception e){

        }
        basicTransition= new HamburgerBackArrowBasicTransition(hamburger);
        basicTransition.setRate(-1);

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
   public void save() {

        pacientService= RestClient.getClient().create(PacientService.class);
        DatePicker datePicker=new DatePicker();

       // String dateCon=dpConsrulta.getValue();
        Pacient pacient=new Pacient();
        pacient.setName(txtfName.getText());
        pacient.setAge(txtfAge.getText());
        pacient.setProfission(txtfProssition.getText());
        pacient.setPhone(txtfPhone.getText());
        pacient.setAddress(txtfAddress.getText());
        pacient.setBI(txtfBI.getText());
        pacient.setBookingDate(String.valueOf(dpConsrulta.getValue()));
        pacient.setDateOfBirth(String.valueOf(cpBirth.getValue()));
        Date date=new Date();
        pacient.setCurrentDate(String.valueOf(date.getTime()));
        pacientCall=pacientService.addPacient(HelpFile.COOKIE,HelpFile.USERID,pacient);
        pacientCall.enqueue(new Callback<Pacient>() {
            @Override
            public void onResponse(Call<Pacient> call, Response<Pacient> response) {
                if (response.isSuccessful()){
                    Platform.runLater(
                            () -> {
                                // Update UI here.
                                Stage stage=(Stage) save.getScene().getWindow();
                                stage.close();
                                ChangeP p=new ChangeP();
                                p.ChangePage("/pacient/addPacient.fxml","Add Pacient");

                            });
                }else{
                    System.out.println("didnt hit");
                }
            }

            @Override
            public void onFailure(Call<Pacient> call, Throwable t) {
                System.out.println("bad coding");
            }
        });

    }
}
