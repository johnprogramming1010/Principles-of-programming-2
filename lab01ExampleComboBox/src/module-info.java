module ExampleComboBox {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
	opens example_combobox to javafx.graphics, javafx.fxml;
}

