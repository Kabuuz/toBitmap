package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Label label1;
    @FXML
    private TextField textfield1;
    @FXML
    private Button buttonConvert;

    private void setTextField11ToGreen() {
        textfield1.setStyle("-fx-background-color: #00ff00;");
    }
    private void setTextField11ToRed() {
        textfield1.setStyle("-fx-background-color: #ff0000;");
    }

    @FXML
    void clickButtonConvert(ActionEvent event)   {
        Bitmap bitmap=new Bitmap(textfield1.getText());
        bitmap.createTxt();
        if (bitmap.isCorrect()){
            setTextField11ToGreen();
            System.out.println("tak");
        }else{
            setTextField11ToRed();
        }
    }

}

