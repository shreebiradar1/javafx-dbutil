package user;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.DatabaseUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SearchScreenController {
	// These are the "Search user" variables
	@FXML
	private TextField searchUser;

	@FXML
	private Label searchLabel;
	
	public void searchEnter() throws SQLException {	
		String query = "Select * from user where username = '" + searchUser.getText() + "' ;";
		
		ResultSet result = DatabaseUtil.resultQuery(query);
		if (result.next()) {
			searchLabel.setText("User Found");
		} else {
			searchLabel.setText("User not Found");
		}

	}
	
	public void back() throws IOException {
		new UserScreen().userManagementShow();
	}
}
