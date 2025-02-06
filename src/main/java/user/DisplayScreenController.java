package user;

import java.io.IOException;

import java.sql.ResultSet;
import java.sql.SQLException;
import common.DatabaseUtil;
import common.StageFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DisplayScreenController {

	@FXML
	private TableColumn<User, String> userName;

	@FXML
	private TableColumn<User, String> userEmail;

	@FXML
	private TableColumn<User, String> userMobile;

	@FXML
	private TableView<User> userTable;

	@FXML
	private void initialize() throws SQLException {
		ObservableList<User> user = FXCollections.observableArrayList();

		String query = "Select * from user";

		ResultSet result = DatabaseUtil.resultQuery(query);

		while (result.next()) {
			user.add(new User(result.getString(1), result.getString(2), result.getString(3)));
		}

		userName.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
		userEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		userMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		userTable.setItems(user);
	}

	public void displayUserShow() throws IOException, SQLException {

		Stage stage = StageFactory.getStage();
		stage.setTitle("UserManagement");

		Parent actor = FXMLLoader.load(getClass().getResource("/user/displayUser.fxml"));
		Scene scene = new Scene(actor);

		stage.setScene(scene);
		stage.show();

//		initialize();
	}

	public void back() throws IOException {
		new UserScreen().userManagementShow();
	}

}