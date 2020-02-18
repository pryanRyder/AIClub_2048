
import java.util.Arrays;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.*;


public class twentyFurtyeight extends Application 
{
	
	
	Pane graphicsPane = new Pane();
	StackPane stack = new StackPane();
	Button[][] butArr = new Button[4][4];
	Integer[][] intArr = new Integer[4][4];
	Scene scene = new Scene(graphicsPane, 800, 600);
	
	int firstIndex;
	int secondIndex;
	int actualNumber;
	int testNumber;
	
	boolean check;
	
	int k;
	
	Integer[] testValue = new Integer[11];
	
	@SuppressWarnings("unlikely-arg-type")
	public twentyFurtyeight() 
	{	
		Integer z = 1;
		
		for(k = 0; k < 11; k++)
		{
			testValue[k] = (int) Math.pow(2, 1 * z);
			
			z = z + 1;
		}
	
		double setX = 0;
		double setY = 0;
		
		k = 0;
		int i = 0;
		int j = 0;
		
		for(i = 0; i <= 3; i++)
		{
			ObservableList<Node> PaneChildren = graphicsPane.getChildren();
			
			j = 0;
			setX = 0;
		
			for(j = 0; j <= 3; j++)
			{	
				Button but = new Button();
				but.setMinHeight(60);
				but.setMinWidth(55);
				but.setStyle("-fx-border-color: black;" + "-fx-background-color: white;");
				
				butArr[i][j] = but;
				butArr[i][j].setLayoutX(200 + setX);
				butArr[i][j].setLayoutY(200 + setY);
				setX = setX + 55;
				PaneChildren.add(butArr[i][j]);
			}
			
			setY = setY + 60;
		}
		
		
		for(int setup = 0; setup < 2; setup++)
		{
			actualNumber = (int) Math.round(Math.random());
			firstIndex = (int) Math.round(Math.random() * 3);
			secondIndex = (int) Math.round(Math.random() * 3);
			
			if(actualNumber == 0)
			{
				actualNumber = 2;
			} else {
				actualNumber = 4;
			}
			
			
			intArr[(int) firstIndex][(int) secondIndex] = actualNumber;
			
			butArr[firstIndex][secondIndex].setText(Integer.toString(actualNumber));
			
		}
		
		i = 0;
		
		for(i = 0; i <= 3; i++)
		{
			j = 0;
			
			for(j = 0; j <= 3; j++)
			{	
				if(intArr[i][j] != null)
				{
					//Change color based off number. 
					if(intArr[i][j] == 2)
					{
						butArr[i][j].setStyle("-fx-border-color: black;" + "-fx-background-color: LIGHTGREEN;");
					}
					
					if(intArr[i][j] == 4)
					{
						butArr[i][j].setStyle("-fx-border-color: black;" + "-fx-background-color: green;");
					}
					
					
				} else {
					intArr[i][j] = 0;
				}
			}
			
		}
		
		
		/** MOVE LEFT  
		 * @Param Combine Numbers
		 *                          */
		
		Timeline timeline = new Timeline();
		
		timeline.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame keyframe = new KeyFrame(Duration.millis(100), action -> 
		{
			scene.setOnKeyPressed(Action -> {
				switch(Action.getCode()) {
					case UP:
						// Move Numbers Up
						moveUp();
						break;
					
					case DOWN:
						// Move Numbers Down
						moveDown();
						break;
				
					case LEFT:
						// Move Numbers Left
						moveLeft();
						break; 
					
					case RIGHT:
						// Move Numbers Right
						moveRight();
						break;
				}	
			});
		});
		
		timeline.getKeyFrames().add(keyframe);
		timeline.play();
		
		
		//String print = Integer.toString(actualNumber);
		System.out.println(Arrays.deepToString(intArr));
		
	}
	
	private void moveUp() 
	{
			
	}
	
	private void moveDown() 
	{
		for(int i = 0; i <= 3; i++)
		{
			int j = 0;
			
			for(j = 0; j <= 3; j++)
			{	
				
			}
		}		
	}
	
	private void moveLeft() 
	{
		for(int i = 0; i <= 3; i++)
		{
			int j = 0;
			for(j = 0; j <= 3; j++)
			{	
				if(intArr[i][j] != 0) 
				{
					for(k = 0; k < 11; k++)
					{
						if(intArr[i][j] == testValue[k])
						{
							check = true;
						} else {
							check = false;
						}
						
		
					}
				}
			}
		}	
		
	}
	
	private void moveRight() 
	{
		for(int i = 0; i <= 3; i++)
		{
			int j = 0;
			
			for(j = 0; j <= 3; j++)
			{	
				
			}
		}		
	}

	@Override public void start(Stage primaryStage) throws Exception 
	{
		
	//Scene scene = new Scene(graphicsPane, 800, 600);
	primaryStage.setTitle("2048");
	primaryStage.setScene(scene);
	primaryStage.show();
		
	}
	
	public static void main(String[] args) { launch(args); }
	
	
}




