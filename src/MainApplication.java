import Util.Routes;
import Util.ViewManager;
import animatefx.animation.Bounce;
import com.jfoenix.controls.JFXButton;
import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

//        AnchorPane pane = new AnchorPane();
//        PageUtil.setPANEL(
//                pane
//        );
//        pane.getStylesheets().add("css/style.css");
//        HBox box= new HBox();
//        AnchorPane.setLeftAnchor(box,0.0);
//        AnchorPane.setRightAnchor(box,0.0);
//        AnchorPane.setTopAnchor(box,0.0);
//
//        box.setAlignment(Pos.CENTER);
//        pane.getChildren().add(box);
//
//
//        Dimension resolution=Toolkit.getDefaultToolkit().getScreenSize();
//        double width= resolution.getWidth();
//        double height= resolution.getHeight();
//
//        double w=width/1280;
//        double h=height/720;
//
//        Scale scale=new Scale(w,h,0,0);
//
//        pane.getTransforms().add(scale);
//
//        FXMLLoader fxmlLoader= new FXMLLoader(MainApplication.class.getResource("login/login.fxml"));
//        Scene scene=new Scene(fxmlLoader.load(),805,465);
//        //Scene scene=new Scene(fxmlLoader.load(),w,h);
//        primaryStage.setTitle("Consoltorio Rosario Bras");
//        primaryStage.setScene(scene);
//       // primaryStage.initStyle(StageStyle.UTILITY);
//        primaryStage.show();
//      //  primaryStage.setFullScreen(true);
//
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
        ViewManager.initView(primaryStage);
        ViewManager.Manager.showModal(Routes.Page.InicialPage.LOGIN, Pos.CENTER_LEFT, false);
    }
}
