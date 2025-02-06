package product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.DatabaseUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SearchProductController {
	
	@FXML
	private TextField searchProduct;

	@FXML
	private Label searchLabel;


	public void searchEnter() throws SQLException {
		
		String query = "Select * from product where name = '" + searchProduct.getText() + "';";

		ResultSet result = DatabaseUtil.resultQuery(query);
		if (result.next()) {
			searchLabel.setText("Product Found");
		} else {
			searchLabel.setText("Product not Found");
		}

	}

	public void back() throws IOException {
		new ProductScreen().productManagementShow();
	}
}
