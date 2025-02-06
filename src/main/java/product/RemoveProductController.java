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

public class RemoveProductController {
	// These are the "Remove product" variables
	@FXML
	private TextField removeProduct;

	@FXML
	private Label removeStatus;

	public void removeEnter() throws SQLException {
		
		String query = "Select * from product where name = '" + removeProduct.getText() + "' ;";
		ResultSet result = DatabaseUtil.resultQuery(query);

		if (result.next()) {
			String remove = "delete from product where name = '" + removeProduct.getText() + "';";

			DatabaseUtil.executeQuery(remove);
			removeStatus.setText("Product Removed");

		} else {
			removeStatus.setText("Product not Found");
		}
	}
	
	public void back() throws IOException {
		new ProductScreen().productManagementShow();
	}
}