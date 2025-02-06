package login;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.DatabaseUtil;
import homeScreen.HomeScreen;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginScreenController {
	
	
	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@FXML
	private Label errorMessage;
	
	public void loginButtonClick() throws SQLException, IOException {
	
	String query = "Select * from login where username = '" + username.getText() + "'and password = '"
			+ password.getText() + "';";
	
	ResultSet result = DatabaseUtil.resultQuery(query);
	
		if(result.next()) {
			//Showing Home Screen
			new HomeScreen().homeshow();
			
		}
		else {
			errorMessage.setTextFill(Color.RED);
			errorMessage.setText("Login Fail");
		}
	}
	
}
