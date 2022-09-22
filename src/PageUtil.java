import animatefx.animation.SlideInLeft;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.awt.*;

public class PageUtil {

    private static AnchorPane PANEL=null;
    public static PageUtil PAGEMANAGE =new PageUtil();
    public static void setPANEL(AnchorPane panel){
        PANEL = panel;

    }

    public void showPage(String path){
        Node node= null;
        try{
            node= FXMLLoader.load(getClass().getResource(path));

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        if(node!=null){
            PANEL.getChildren().clear();

            AnchorPane.setLeftAnchor(node,0.0);
            AnchorPane.setRightAnchor(node,0.0);
            AnchorPane.setTopAnchor(node,0.0);
            AnchorPane.setBottomAnchor(node,0.0);


            SlideInLeft slideInLeft = new SlideInLeft(node);

            PANEL.getChildren().add(node);
            slideInLeft.play();
        }
    }
}
