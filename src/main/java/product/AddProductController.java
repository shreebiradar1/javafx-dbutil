package product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import common.DatabaseUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddProductController {
	// These are the "Add Product" variables

	@FXML
	private TextField productName;

	@FXML
	private TextField productPrice;

	@FXML
	private TextField productQuantity;

	@FXML
	private Label addLabel;
	
	DatabaseUtil db = new DatabaseUtil();

	public void addEnter() throws SQLException {
		
		String query = "Insert into product (name, price, quantity)" + "Values ('"
				+ productName.getText() + "', " + productPrice.getText() + ", "
				+ productQuantity.getText() + ");";


		DatabaseUtil.executeQuery(query);

		if ((productName.getText() != null)
				&& (productPrice.getText() != null && productQuantity.getText() != null)) {
			addLabel.setText("New Product Added Successfully");
		} else {
			addLabel.setText("Something error occurred");
		}
	}
	public void back() throws IOException {
		new ProductScreen().productManagementShow();
	}
}
