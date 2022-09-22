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
import retrofit2.http.Body;
import services.PacientService;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class EditPacient implements Initializable {

    PacientService pacientService;

    Call<Pacient> pacientCall;
//    @FXML
//    private JFXHamburger hamburger;
//
//    @FXML
//    private JFXDrawer drawer;

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
    private Button editPacient;

    @FXML
    private JFXTextField txtfBI;

    Pacient pacient;

//    @FXML
//    void MClicked(MouseEvent event) {
//
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        VBox box= null;
//        try {
//            box = FXMLLoader.load(getClass().getResource("/drawer/drawerContent.fxml"));
//            drawer.setSidePane(box);
//        }catch (Exception e){
//
//        }
//        basicTransition= new HamburgerBackArrowBasicTransition(hamburger);
//        basicTransition.setRate(-1);

        pacientService= RestClient.getClient().create(PacientService.class);
        pacientCall=pacientService.findById(HelpFile.ID,HelpFile.COOKIE);
        pacientCall.enqueue(new Callback<Pacient>() {
            @Override
            public void onResponse(Call<Pacient> call, Response<Pacient> response) {
                if(response.isSuccessful()){
                    pacient= response.body();
                    txtfName.setText(pacient.getName());
                    txtfAge.setText(pacient.getAge());
                    txtfProssition.setText(pacient.getProfission());
                    dpConsrulta.setValue(LocalDate.parse(pacient.getBookingDate()));
                    //cbAid;
                    txtfPhone.setText(pacient.getPhone());
                    txtfAddress.setText(pacient.getAddress());
                    cpBirth.setValue(LocalDate.parse(pacient.getDateOfBirth()));
                    txtfBI.setText(pacient.getBI());

                }
            }

            @Override
            public void onFailure(Call<Pacient> call, Throwable t) {

            }
        });
    }

    @FXML
    public void edit(){
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
        pacient.setEditDate(String.valueOf(date.getTime()));


        pacientService= RestClient.getClient().create(PacientService.class);
        pacientCall=pacientService.editPacient(HelpFile.COOKIE,HelpFile.ID,pacient);
        pacientCall.enqueue(new Callback<Pacient>() {
            @Override
            public void onResponse(Call<Pacient> call, Response<Pacient> response) {
                if(response.isSuccessful()){
                    Platform.runLater(
                            () -> {
                                // Update UI here.
                                Stage stage=(Stage) editPacient.getScene().getWindow();
                                stage.close();
                               // ChangeP p=new ChangeP();
                               // p.ChangePage("/pacient/menuPacient.fxml","Menu Pacient");

                            });
                }else{
                    System.out.println("didnt hit");
                }
            }

            @Override
            public void onFailure(Call<Pacient> call, Throwable t) {

            }
        });

    }
}
