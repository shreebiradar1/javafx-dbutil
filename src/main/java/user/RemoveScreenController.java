package user;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import common.DatabaseUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RemoveScreenController {

	// These are the "Remove user" variables
	@FXML
	private TextField removeUser;

	@FXML
	private Label removeStatus;

	public void removeEnter() throws SQLException {
		// First checking if the user exist
		// if not it will print else statement
		String query = "Select * from user where username = '" + removeUser.getText() + "' ;";
		ResultSet result = DatabaseUtil.resultQuery(query);		
		
		if (result.next()) {
			String remove = "delete from user where username = '" + removeUser.getText() + "';";

			DatabaseUtil.executeQuery(remove);
			removeStatus.setText("User Removed");

		} else {
			removeStatus.setText("User not Found");
		}
	}
	public void back() throws IOException {
		new UserScreen().userManagementShow();
	}
}
