


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button BOne;
	Button BTwo;
	Button BThree;
	Button BFour;
	Button BFive;
	
	Label LOne;
	TextField TOne;

	//  declare two HBoxes
	
	HBox HOne;
	HBox HTwo;
	
	
	
	//student Task #4:
	//  declare an instance of DataManager
	DataManager data;
	
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		BOne = new Button("Hello");
		BTwo = new Button("Howdy");
		BThree = new Button("Chinese");
		BFour = new Button("Clear");
		BFive = new Button("Exit");
		
		LOne = new Label("Feedback");
		
		TOne = new TextField();
		
		//  instantiate the HBoxes
		HOne = new HBox();
		HTwo = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		data = new DataManager();
		//  set margins and set alignment of the components
		
		BOne.setOnAction(new ButtonHandler());
		BTwo.setOnAction(new ButtonHandler());
		BThree.setOnAction(new ButtonHandler());
		BFour.setOnAction(new ButtonHandler());
		BFive.setOnAction(new ButtonHandler());
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		
		Insets inset = new Insets(25,25,25,25);
		
		
		
		HTwo.getChildren().addAll(LOne,TOne);
		HTwo.setAlignment(Pos.CENTER);
		
		//  add the buttons to the other HBox
		HOne.getChildren().addAll(BOne,BTwo,BThree,BFour,BFive);
		
		HOne.setAlignment(Pos.CENTER);
		
		HBox.setMargin(BOne, inset);
		HBox.setMargin(BTwo, inset);
		HBox.setMargin(BThree, inset);
		HBox.setMargin(BFour, inset);
		HBox.setMargin(BFive, inset);
		
		HBox.setMargin(TOne, inset);
		HBox.setMargin(LOne, inset);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(HOne,HTwo);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			if(event.getTarget().equals(BOne)) {
				TOne.setText(data.getHello());
				
			}
			else if(event.getTarget().equals(BTwo)) {
				TOne.setText(data.getHowdy());
				
			}
			else if(event.getTarget().equals(BThree)) {
				TOne.setText(data.getChinese());
				
			}else if(event.getTarget().equals(BFour)) {
				TOne.setText("");
				
			}else if(event.getTarget().equals(BFive)) {
				Platform.exit();
				System.exit(0);
				
			}
		}
	}
}
	