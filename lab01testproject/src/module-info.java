module testproject {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
}
