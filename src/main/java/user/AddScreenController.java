package user;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;

import common.DatabaseUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class AddScreenController {
	// These are the "Add User" variables

	@FXML
	private TextField userName;

	@FXML
	private TextField userEmail;

	@FXML
	private TextField userNumber;

	@FXML
	private Label label;

	public void addEnter() throws SQLException {
		// Just remember to add getText() method.
		String query1 = "Insert into user (username, email, mobile)" + "Values ('" + userName.getText() + "', '"
				+ userEmail.getText() + "', '" + userNumber.getText() + "');";

		// Here we used execute() method inside that we passed our query.

		DatabaseUtil.executeQuery(query1);

		// Here we check the data inside the database where it actually inserted
		// We take that block of data which is inserted recently

		String query2 = "select * from user where username = '" + userName.getText() + "';";

		// And kept inside the result object

		ResultSet result = DatabaseUtil.resultQuery(query2);

		if (result.next()) {
			label.setTextFill(Color.GREEN);
			label.setText("New User Added Successfully");
		} else {
			label.setTextFill(Color.RED);
			label.setText("Something error occurred");
		}
	}

	public void back() throws IOException {
		new UserScreen().userManagementShow();
	}
}
