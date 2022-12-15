package com.example.demoexam;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class startScreenController {

    @FXML
    private Button button;

    @FXML
    private Label label_error;
    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passField;

    // Функция для перехода на новое окно
    //Стих 1
//    public void goToMenu() throws IOException {
//        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menuScreen.fxml")));
//        Stage stage = (Stage) button.getScene().getWindow();
//        stage.setScene(new Scene(parent, 600, 400));
//        stage.setResizable(false);
//        stage.show();
//    }

    public  void goToMenu() throws SQLException, ClassNotFoundException, IOException {
        String loginText = loginField.getText();
        String passText = passField.getText();

        //Стих 3
        if (!loginText.equals("") && !passText.equals("")){
            ConnectDB dbHandler = new ConnectDB();
            ResultSet result = dbHandler.getUser(loginText, passText);
            int count = 0;
            while (true){
                if(!result.next())
                    break;
                count++;
            }

            if( count >= 1){
                Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menuScreen.fxml")));
                Stage stage = (Stage) button.getScene().getWindow();
                stage.setScene(new Scene(parent, 600, 400));
                stage.setResizable(false);
                stage.show();
            }
        }

    }




}