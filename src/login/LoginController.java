package login;

import Util.*;
import com.jfoenix.controls.JFXButton;
import entity.UserLogin;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import restClient.RestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import services.LoginService;


import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginService loginService;
    Call<UserLogin> loginCall;


    @FXML
    private TextField Username;

    @FXML
    private PasswordField Password;

    @FXML
    private JFXButton login_id;

    @FXML
    private ImageView logo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        SlideInLeft slideInLeft = new SlideInLeft(label);
//        slideInLeft.play();
        Circle clip=new Circle();
        clip.setCenterX(20);
        clip.setCenterY(20);
        //logo.setClip(clip);
    }
    @FXML
    public void btnLogin(){
        String username=Username.getText().toString();
        String password=Password.getText().toString();

        loginService= RestClient.getClient().create(LoginService.class);
        UserLogin login= new UserLogin();
            login.setNameOrEmail(username);
            login.setPassword(password);
        loginCall =loginService.Post_Login( login);
        loginCall.enqueue(new Callback<UserLogin>() {
            @Override
            public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
                if(response.isSuccessful()){
                    UserLogin userLogin= response.body();
                    HelpFile.COOKIE=response.raw().header("set-cookie");
                   // System.out.println(head);
                    HelpFile.USERID=userLogin.getId();
                    HelpFile.DrName=userLogin.getNameOrEmail();

//                    try {
//                        ViewManager.Manager.toView(Routes.Page.Main.MAIN);
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
                                        Platform.runLater(
                            () -> {
                                try {
                                    ViewManager.Manager.toView(Routes.Page.Main.MAIN);
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }

                            });

//                    Platform.runLater(
//                            () -> {
//                                // Update UI here.
//                            Stage stage=(Stage) login_id.getScene().getWindow();
//                               stage.close();
//                                ChangeP p=new ChangeP();
//                                p.ChangePage("/menuPage/landingPage.fxml","Landing Page");
//
//                            });


                }else {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            // Update UI here.
                            Alert alert=new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("nome de usuário ou senha esta Errado");
                            alert.showAndWait();
                        }
                    });
                   // System.err.println(ex.getMessage());
//                    String title="";
//                    String message="";
//                    Util.Alert.Message.show(
//                            UserTranslateException.Auth.translate(ex.getMessage()).title,
//                            UserTranslateException.Auth.translate(ex.getMessage()).message,
//                            Util.Alert.Type.WARNING);

                }
            }

            @Override
            public void onFailure(Call<UserLogin> call, Throwable t) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        // Update UI here.
                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setContentText("Erro com a conneccao ");
                        alert.showAndWait();
                    }
                });

            }
        });

    }

    @FXML
    void close(){
        ViewManager.closeApplication();
    }



}
