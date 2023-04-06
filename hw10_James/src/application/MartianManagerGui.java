package application;

import application2.*;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MartianManagerGui extends Application {

	// Create Martians
	protected MartianManager mm = new MartianManager();
	ArrayList<Martian> invaders = new ArrayList<>(mm.getSortedMartians());
	protected ToggleGroup tGrpCreateMartian;
	protected TextField txfId, txfVolume, txfTenacity;
	protected Button btnCreateMartian;

	// Display Martians
	protected ToggleGroup tGrpDisplayMartians;
	protected Button btnDisplayMartians, btnTeleport;
	protected TextField txfDestination;

	// ListView events
	protected Button btnDisplaySelected, btnRemoveSelected, btnClosestToSelected;
	protected ListView<String> lvwMartians = new ListView<>();

	// Battle events
	protected Button btnPopulateManager, btnCreateInvaders, btnBattleInvaders, btnReset;
	protected TextField txfNumToCreate;

	// Results
	protected TextArea txaMessage;

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = buildGui();
			Scene scene = new Scene(root,750,590);
			primaryStage.setTitle("Martian Manager");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private Pane buildGui() {
		// Build top row
		GridPane topRow = new GridPane();
		Pane p = this.buildCreateMartian();
		topRow.add(p, 0, 0);
		p = this.buildDisplayMartians();
		topRow.add(p, 1, 0);
		p = buildSelectMartians();
		topRow.add(p, 0, 1);
		p = buildBattleChoices();
		topRow.add(p, 1, 1);

		// Build bottom row
		p = buildResults();

		// Build root container
		VBox root = new VBox();
		root.getStyleClass().add("h_or_v_box");
		root.getStyleClass().add("boxBorder");
		root.getChildren().addAll(topRow, p);

		return root;
	}

	private Pane buildCreateMartian() {
		// Build radio buttons and event button
		btnCreateMartian = new Button("Create");
		btnCreateMartian.setOnAction(new CreateMartianEventHandler());
		RadioButton rbGreen = new RadioButton("Green");
		tGrpCreateMartian = new ToggleGroup();
		rbGreen.setToggleGroup(tGrpCreateMartian);
		RadioButton rbRed = new RadioButton("Red");
		rbRed.setToggleGroup(tGrpCreateMartian);

		HBox hBoxRadios = new HBox();
		hBoxRadios.getStyleClass().add("h_or_v_box");
		hBoxRadios.getChildren().addAll(btnCreateMartian, rbGreen, rbRed);

		// Build text fields
		Label lblId = new Label("Id");
		txfId = new TextField();
		txfId.getStyleClass().add("textFieldCreate");
		Label lblVol = new Label("Volume");
		txfVolume = new TextField();
		txfVolume.getStyleClass().add("textFieldCreate");
		Label lblTen = new Label("Tenacity");
		txfTenacity = new TextField();
		txfTenacity.getStyleClass().add("textFieldCreate");

		HBox hBoxFields = new HBox();
		hBoxFields.getStyleClass().add("h_or_v_box");
		hBoxFields.getChildren().addAll(lblId, txfId, lblVol, txfVolume, lblTen, txfTenacity);

		// Build root container
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		vBox.getStyleClass().add("boxBorder");
		vBox.getChildren().addAll(hBoxRadios, hBoxFields);

		return vBox;
	}

	private Pane buildDisplayMartians() {
		// Build radio buttons and event button
		btnDisplayMartians = new Button("Display");
		btnDisplayMartians.setOnAction(new DisplayMartiansEventHandler());
		RadioButton rbGreen = new RadioButton("Green");
		tGrpDisplayMartians = new ToggleGroup();
		rbGreen.setToggleGroup(tGrpDisplayMartians);
		RadioButton rbRed = new RadioButton("Red");
		rbRed.setToggleGroup(tGrpDisplayMartians);

		RadioButton rbAll = new RadioButton("All");
		rbAll.setToggleGroup(tGrpDisplayMartians);
		RadioButton rbSorted = new RadioButton("Sorted");
		rbSorted.setToggleGroup(tGrpDisplayMartians);

		HBox hBoxRadio1 = new HBox();
		hBoxRadio1.getStyleClass().add("h_or_v_box");
		hBoxRadio1.getChildren().addAll(btnDisplayMartians, rbGreen, rbRed, rbAll, rbSorted);

		// Build teleport
		btnTeleport = new Button("Teleport");
		btnTeleport.setOnAction(new TeleportEventHandler());
		Label lbl = new Label("detination");
		txfDestination = new TextField();

		HBox hBoxTeleport = new HBox();
		hBoxTeleport.getStyleClass().add("h_or_v_box");
		hBoxTeleport.getChildren().addAll(btnTeleport, lbl, txfDestination);

		// Build root pane
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		vBox.getStyleClass().add("boxBorder");
		vBox.getChildren().addAll(hBoxRadio1, hBoxTeleport);

		return vBox;
	}

	private Pane buildSelectMartians() {
		// Build ListView
		lvwMartians.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lvwMartians.setPrefHeight(150);
		lvwMartians.setPrefWidth(120);

		// Build button box.
		Label lbl = new Label("Select 1 or more Martians");
		btnDisplaySelected = new Button("Display");
		btnDisplaySelected.setOnAction(new DisplaySelectedEventHandler());
		btnRemoveSelected = new Button("Remove");
		btnRemoveSelected.setOnAction(new RemoveMartiansEventHandler());
		btnClosestToSelected =new Button("Closest to");
		btnClosestToSelected.setOnAction(new ClosestToEventHandler());
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		vBox.getChildren().addAll(lbl, btnDisplaySelected, btnRemoveSelected, btnClosestToSelected);

		// Build root
		HBox hBox = new HBox();
		hBox.getStyleClass().add("h_or_v_box");
		hBox.getStyleClass().add("boxBorder");
		hBox.getChildren().addAll(lvwMartians, vBox);
		return hBox;
	}

	private Pane buildBattleChoices() {
		// Create buttons
		btnPopulateManager = new Button("Populate Manager");
		btnPopulateManager.setOnAction(new PopulateManagerEventHandler());
		btnCreateInvaders = new Button("Create Invaders");
		btnCreateInvaders.setOnAction(new CreateInvadersEventHandler());
		btnBattleInvaders = new Button("Battle Invaders");
		btnBattleInvaders.setOnAction(new BattleEventHandler());
		btnReset = new Button("Reset All");
		btnReset.setOnAction(new ResetEventHandler());
		// Build num to create.
		HBox hBox = new HBox();
		hBox.getStyleClass().add("h_or_v_box");
		Label lbl = new Label("num");
		txfNumToCreate = new TextField();
		txfNumToCreate.getStyleClass().add("textFieldNum");
		hBox.getChildren().addAll(btnPopulateManager, btnCreateInvaders, lbl, txfNumToCreate);

		String helpMsg = "Use 'Populate...' to create 'num' random Martians\n";
		helpMsg += "Use 'Create...' to create 'num' random invader Martians\n";
		helpMsg += "Create no more than 90 in total.";
		Label lblHelp = new Label(helpMsg);

		HBox hBox2 = new HBox();
		hBox2.getStyleClass().add("h_or_v_box");
		hBox2.getChildren().addAll(btnBattleInvaders, btnReset);

		// Build root
		GridPane root = new GridPane();
		root.getStyleClass().add("grid");
		root.getStyleClass().add("boxBorder");

		root.add(hBox, 0, 0);
		root.add(lblHelp, 0, 1);
		root.add(hBox2, 0, 2);

		return root;
	}

	private Pane buildResults() {
		// Create controls
		Label lbl = new Label("Results");
		txaMessage = new TextArea();

		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		vBox.getChildren().addAll(lbl, txaMessage);

		return vBox;
	}

	/*----------------------------------------------------------------------------
	 * Event handlers
	 ----------------------------------------------------------------------------*/
	/**
	 * Creates a Martian with the values specified and (a) saves in the the martian manager,
	 * (b) add the martian to the list view, (c) and displays the martian in the text area.
	 * Note the format for the items in the list view: firstCharColor-id. For example for a
	 * Green Martian with id=34, the list view would display: G-34.
	 *
	 * Button text: "Create", name: "btnCreateMartians", created: buildCreateMartian()
	 */
	private class CreateMartianEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			RadioButton rb = (RadioButton)tGrpCreateMartian.getSelectedToggle();

			String martian = rb.getText();
			Martian martians = null;
			switch( martian ) {
			case "Green":
				System.out.println("Creating a Green Martian...");
				int id = Integer.parseInt(txfId.getText());
				int volume = Integer.parseInt(txfVolume.getText());
				martians = new GreenMartian(id,volume);
				lvwMartians.getItems().addAll("G-" + id);
				mm.addMartian(martians);
				break;
			case "Red":
				System.out.println("Creating a Red Martian...");
				int id1 = Integer.parseInt(txfId.getText());
				int volume1 = Integer.parseInt(txfVolume.getText());
				int tenacity = Integer.parseInt(txfTenacity.getText());
				martians = new RedMartian(id1,volume1,tenacity);
				lvwMartians.getItems().addAll("R-" + id1);
				mm.addMartian(martians);
				break;
			}
		}
	}

	/**
	 * Displays all the green martians, all the red martians, all martians, or sorted martians,
	 * depending on the radio button that is selected. The results are displayed in the text area.
	 * The "Red" choice will take a little bit of thought. Hint: use MartianManager.getMartianAt(i)
	 * and loop over all and pick out the reds.
	 *
	 * Button text: "Display", name: "btnDisplayMartians", created: buildDisplayMartians()
	 */
	private class DisplayMartiansEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			RadioButton rb = (RadioButton)tGrpDisplayMartians.getSelectedToggle();
			ObservableList<String> m = lvwMartians.getSelectionModel().getSelectedItems();
			String martian = rb.getText();

			switch( martian ) {
			case "Green":
				System.out.println("Displaying Green Martians...");
				String msg = "";
				for(String i : m) {
					if((i).substring(0,1).equals("G")) {
						int id = Integer.parseInt(i.substring(2));
						msg += mm.getMartianWithId(id) + "\n";
					txaMessage.setText(msg);
				}
				}
			break;
			case "Red":
				System.out.println("Displaying Red Martians...");
				String msg1 = "";
				for(String i2 : m) {
					if((i2).substring(0,1).equals("R")) {
						int id1 = Integer.parseInt(i2.substring(2));
						msg1 += mm.getMartianWithId(id1) + "\n";
					}
					txaMessage.setText(msg1);
				}
			break;
			case "All":
				System.out.println("Displaying All Martians...");
				String msg2 = "";
				for(String i1 : m) {
						int id2 = Integer.parseInt(i1.substring(2));
						msg2 += mm.getMartianWithId(id2) + "\n";
				}
				txaMessage.setText(msg2);
			break;
			case "Sorted":
				System.out.println("Displaying Sorted Martians...");
				List<Martian> a = new ArrayList<>(mm.getSortedMartians());
				String c = "";
				for(Martian b : a){
					c += b.toString() + "\n";
				}
				txaMessage.setText(c);
			break;
		}
	}
	}

	/**
	 * Has all the teleporters teleport to the destination that is supplied by the user and the
	 * results are displayed in the text area.
	 *
	 * Button text: "Teleport", name: "btnTeleport", created: buildDisplayMartians()
	 */
	private class TeleportEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			System.out.println("Teleporting...");
			String dest = txfDestination.getText();
			String m = mm.groupTeleport(dest);
			txaMessage.setText(m);
		}
	}

	/**
	 * Displays the selected martians in the text area.
	 *
	 * Button text: "Display", name: "btnDisplaySelected", created: buildSelectMartians()
	 */
	private class DisplaySelectedEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			ObservableList<String> m = lvwMartians.getSelectionModel().getSelectedItems();
			String msg = "";
			for(String ms : m) {
				int id = Integer.parseInt(ms.substring(2));
				Martian mart = mm.getMartianWithId(id);
				msg += "martian: " + mart + "\n";
				txaMessage.setText(msg);
			}
		}
	}

	/**
	 * Removes the selected martians from the martian manager and from the listview, and
	 * displays the removed martians in the text area. Hints:
	 * (1) You obtain a list of string from the list view, each string (e.g. G-34),
	 * corresponds to a Martian. Thus, you can split off the id, and then use it to
	 * remove the martian manager
	 * (2) the manager's remove returns the removed martian, which you can use for the
	 * display in the text area.
	 * (3) The list view can return the selected items as shown in labs and class:
	 *
	 * 		List<String> selMartiansObs = lvwMartians.getSelectionModel().getSelectedItems();
	 *
	 * However, this is an "observable" list which mean that when we use this to loop
	 * over to do the removes from the list view itself, it will change this list which
	 * is problematic. Thus, immediately after the line above, create a new list
	 * which will be "safe" to iterate over.
	 *
	 *      List<String> selMartians = new ArrayList<>(selMartiansObs);
	 *
	 * (4) To remove from list view (for example): lvw.getItems().remove("G-34")
	 *
	 * Button text: "Remove", name: "btnRemoveSelected", created: buildSelectMartians()
	 */
	private class RemoveMartiansEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			List<String> selMartiansObs = lvwMartians.getSelectionModel().getSelectedItems();
			List<String> selMartians = new ArrayList<>(selMartiansObs);
			String msg = "";
			for(String ms : selMartians) {
				int id = Integer.parseInt(ms.substring(2));
				Martian mart = mm.removeMartian(id);
				msg += "martian: " + mart + "\n";
				txaMessage.setText(msg);
				lvwMartians.getItems().remove(ms);
			}
		}
	}

	/**
	 * Finds the martians closest to the selected martians and displays both in the text area.
	 *
	 * Button text: "Closest to", name: "btnClosestToSelected", created: buildSelectMartians()
	 */
	private class ClosestToEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			ObservableList<String> m = lvwMartians.getSelectionModel().getSelectedItems();
			String ms = m.get(0);
			int id = Integer.parseInt(ms.substring(2));
			Martian closest = mm.getMartianClosestTo(id);
			String msg = "original martian: " + m + " martian closest too: " +  closest;
			txaMessage.setText(msg);
		}
	}

	//helper method
	private Martian buildRandomMartian(int num) {
		Martian m = null;
		for(int i=0; i<num; i++) {
		if(Math.random()<0.5) {
			int id = (int)((1+(100-1+1)*Math.random()));
			int vol = (int)((1+(100-1+1)*Math.random()));
			m = new GreenMartian(id,vol);
		}
		else {
			int id = (int)((1+(100-1+1)*Math.random()));
			int vol = (int)((1+(100-1+1)*Math.random()));
			int tenacity = (int)((1+(5-1+1)*Math.random()));
			m = new RedMartian(id,vol,tenacity);
		}
		}
		return m;
	}

	/**
	 * Creates "num" random martians, adds them to the manager, adds them to the list view, and displays
	 * them. A martian is green with probability 0.5. It has an id that is uniformly random between 1 and 100.
	 * It has a volume that is uniformly random between 1 and 100. If it is red, it has a tenacity that
	 * is uniformly random between 1 and 5. Notes on how to create random values is shown on the
	 * problem statement. Suggestion, you should write a helper method: createRandomMartian():Martian.
	 *
	 * Button text: "Populate Manager", name: "btnPopulateManager", created: buildBattleChoices()
	 */
	private class PopulateManagerEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			int num = Integer.parseInt(txfNumToCreate.getText());
			mm.addMartian(buildRandomMartian(num));
			List<Martian> a = new ArrayList<>(mm.getSortedMartians());
			for(Martian m : a) {
				if(m instanceof GreenMartian) {
					lvwMartians.getItems().addAll("G-" + m.getId());
					ObservableList<String> martian = lvwMartians.getSelectionModel().getSelectedItems();
					String msg = "";
					for(String ms : martian) {
						int id = Integer.parseInt(ms.substring(2));
						Martian mart = mm.getMartianWithId(id);
						msg += "martian: " + mart + "\n";
						txaMessage.setText(msg);
					}
				}
				else {
					lvwMartians.getItems().addAll("R-" + m.getId());
					ObservableList<String> martian = lvwMartians.getSelectionModel().getSelectedItems();
					String msg = "";
					for(String ms : martian) {
						int id = Integer.parseInt(ms.substring(2));
						Martian mart = mm.getMartianWithId(id);
						msg += "martian: " + mart + "\n";
						txaMessage.setText(msg);
				}
			}
		}
		}
	}

	/**
	 * Creates "num" random martians that are considered "invaders" and displays them to the text area.
	 * The "invaders" can then be use later when "Battle" is chosen. Hint: you will need a list of
	 * Martians to hold these, so that they can be used later for a battle. Thus, make the list an instance
	 * variable. Hint: use: createRandomMartian() from above. Invaders have the same qualities as above:
	 *
	 * A martian is green with probability 0.5. It has an id that is uniformly random between 1 and 100.
	 * It has a volume that is uniformly random between 1 and 100. If it is red, it has a tenacity that
	 * is uniformly random between 1 and 5. Notes on how to create random values is shown on the
	 * problem statement.
	 *
	 * Button text: "Create Invaders", name: "btnCreateInvaders", created: buildBattleChoices()
	 */
	private class CreateInvadersEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			int num = Integer.parseInt(txfNumToCreate.getText());
			mm.addMartian(buildRandomMartian(num));
			String msg = "";
			for(Martian i : invaders) {
				int id = i.getId();
				Martian mart = mm.getMartianWithId(id);
				msg += "martian: " + mart + "\n";
				txaMessage.setText(msg);
		}
	}
	}

	/**
	 * A "battle" takes place between the martians in the manager and the "invaders" and the killed
	 * martians are displayed in the text area and removed from the list view.
	 *
	 * Button text: "Battle", name: "btnBattleInvaders", created: buildBattleChoices()
	 */
	private class BattleEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			List<Martian> dead = new ArrayList<>(mm.battle(invaders));
			String msg = "";
			for(Martian d : dead) {
				int num = d.getId();
				msg += "martians dead: " + mm.getMartianWithId(num) + "/n";
				txaMessage.setText(msg);
				lvwMartians.getItems().remove(d);
			}
		}
	}

	/**
	 * Removes all the martians from the manager and invader, and removes from list view.
	 * Hints:
	 * (1) the simplest way to remove from manager and invaders is to simply re-instantiate them.
	 * martians are displayed in the text area and removed from the list view.
	 * (2) the simplest way to remove from the list view is: lvw.getItems().clear()
	 *
	 * Button text: "Reset All", name: "btnReset", created: buildBattleChoices()
	 */
	private class ResetEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			txaMessage.clear();
			lvwMartians.getItems().clear();
		}
	}

	public static void main(String[] args) {
		launch(args);

//		MartianManager mm = new MartianManager();
//		GreenMartian gm;
//		mm.addMartian(new GreenMartian(3,4));

	}
}
