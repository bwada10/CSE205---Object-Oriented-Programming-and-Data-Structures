package application;

/**
 * Assignment #7
 *
 * Name: Takahiro Wada
 * Student ID: 1216601204
 * Lecture: MWF 9:05 - 9:55 AM
 * Description: This program allows user to draw circles on to the pane which they can undo, erase or change colors of the circle.
 *
 */

import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class DisplayCirclePane extends GridPane
{

    // add instance variables
    private ArrayList<Circle> circleList;
    private GridPane ctrlPane;
    private ArrayList<Circle> tempList;
    private CanvasPane canvas; 				// where to draw Circles
    private ComboBox<String> comboBoxColors;
    private Button btnErase, btnUndo;
    private Color newColor;
    private GridPane newGrid;

    //constructor
    public DisplayCirclePane()
    {
        // Initialize data models
        circleList = new ArrayList<>();
        tempList = new ArrayList<>();
        // step 1: initialize instance variables & set up the layout
        btnErase = new Button("Erase");
        btnUndo = new Button("Undo");
        comboBoxColors = new ComboBox<>();
        
        //Adds the colors name into combobox and sets BLACK as default
        comboBoxColors.getItems().addAll("BLACK", "RED", "BLUE", "GREEN", "ORANGE");
        
        //Instantiate and layout GridPane for the buttons and comboBox.
        ctrlPane = new GridPane();
        ctrlPane.add(btnUndo, 0, 0);
        ctrlPane.add(btnErase, 1, 0);
        ctrlPane.add(comboBoxColors, 2, 0);

        
        // Instantiate
        // Create a pane for drawing circles
        canvas = new CanvasPane();
        canvas.setMinWidth(Assignment7.WINSIZE_X);
        canvas.setMinHeight(Assignment7.WINSIZE_Y);
        canvas.setStyle("-fx-background-color: white;");

        //Adding canvas and ctrlPane onto GridPane
        newGrid = new GridPane(); 
        newGrid.add(ctrlPane, 0, 1);
        newGrid.add(canvas,  0,  2);
        this.getChildren().add(newGrid);
        
        //step 3- register your canvas to listen to mouse events
        PointerHandler mouseHandler = new PointerHandler();
        canvas.setOnMousePressed(mouseHandler);
        canvas.setOnMouseDragged(mouseHandler);
        canvas.setOnMouseReleased(mouseHandler);
      
        

        // Optional adjustments to the layout
        // Resize the canvas automatically
        GridPane.setVgrow(canvas, Priority.ALWAYS);
        GridPane.setHgrow(canvas, Priority.ALWAYS);
        // Make the ComboBox of colors to fill the space of the control panel
        comboBoxColors.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(comboBoxColors, Priority.ALWAYS);
        // Set the preferred size of the control buttons (1/3 the size of the
        // initial window)
        double btnPrefWidth = Assignment7.WINSIZE_X / 3;
        
        //step3 : register your buttons and Combobox with its handler objects
        ButtonHandler buttonHandler = new ButtonHandler();
        btnErase.setOnAction(buttonHandler);				
        btnUndo.setOnAction(buttonHandler);
        comboBoxColors.setOnAction(new ColorComboBoxHandler());
        
    }

    /**
     * CanvasPane is the panel where Circles will be drawn on.
     */
    private class CanvasPane extends Pane
    {   //instance variables
        private Circle placeholder;
        private boolean isPlaceholderOn;

        public CanvasPane()
        {
            //implement the constrctor
        	placeholder = new Circle(0,0,0);					
        	isPlaceholderOn = false;
        	
        	
        }

        public void drawPlaceHolder(int x, int y, int radius)
        {
            // Change the position of the placeholder
        	//write your code here
        	placeholder.setCenterX(x);
        	placeholder.setCenterY(y);
        	placeholder.setRadius(radius);
        	placeholder.setStroke(Color.BLACK);
        	placeholder.setFill(Color.WHITE);
        	
            // If this is the first time we draw the placeholder, add it to the canvas
            if (!isPlaceholderOn)
            {
                //write your code here
            	this.getChildren().add(placeholder);			
            	
            	isPlaceholderOn = true;
            }

        }

        public void erasePlaceHolder()
        {
            // Simply remove the placeholder Circle from the canvas
           // write your code here
        	this.getChildren().remove(placeholder);
        	isPlaceholderOn=false;
        }

        /**
         * Erase and redraw all Circles in the Circle list (not including the
         * placeholder)
         */
        public void repaint()			
        {
            // Redraw all circles in the list
            this.getChildren().clear();
            for (Circle c : circleList)
            {
                this.getChildren().add(c);
            }

            // Make the control panel always visible
            ctrlPane.toFront();
        }
    }

    /**
     * Step 2: ButtonListener defines actions to take in case the "Undo" or "Erase"
     * button is clicked
     */
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
    	private int index;
        @Override
        public void handle(ActionEvent e)
        {
            Object source = e.getSource();
            //Check if source refers to the Erase button
            if (source == btnErase)  
            {
                //write your code here
            	tempList.addAll(circleList);
            	circleList.clear(); 
            	canvas.repaint();
            	
            }
            // Check if source refers to the Undo button
            else if (source == btnUndo)
            {
                // Erase the last Circle in the list
                // write your code here
            	if(circleList.isEmpty() == true)
            	{
            		//Restoring previous circles back into circleList
            		tempList.addAll(circleList);
            		circleList.addAll(tempList);
            		//Repaint the Canvas
            		canvas.repaint();
            	}
            	else
            	{
            		//Remove last circle element
                	index = circleList.size() - 1;
                	circleList.remove(index);

                    // Repaint the Canvas
                    canvas.repaint();
            	}	

             }
        }

    }

    /**
     * Step2: A listener class used to set the color chosen by the user via the
     * ComboBox of Colors.
     */
    private class ColorComboBoxHandler implements EventHandler<ActionEvent>
    {
    	
        @Override
        public void handle(ActionEvent e)
        {
            //Sets the color of the Circle based on User's choice
        	if(comboBoxColors.getValue() == "BLACK")
        	{
        		newColor = Color.BLACK;	
        	}
        	
        	if(comboBoxColors.getValue() == "RED")
        	{
        		newColor = Color.RED;
        	}
        	
        	if(comboBoxColors.getValue() == "BLUE")
        	{
        		newColor = Color.BLUE;
        	}
        	
        	if(comboBoxColors.getValue() == "GREEN")
        	{
        		newColor = Color.GREEN;
        	}
        	
        	if(comboBoxColors.getValue() == "ORANGE")
        	{
        		newColor = Color.ORANGE;
        	}
        }

    }

    /**
     * A listener class that handles any mouse events on the Canvas
     */
    private class PointerHandler implements EventHandler<MouseEvent>
    {
    	
        // 1=pressed, 2=dragged, 3=released
        private int x1, y1, x2, y2, x3, y3;
        private Circle newCircle;
    	private int radius;
    	private int newRadius;

        @Override
        public void handle(MouseEvent e)
        {
            //write your code here
        	if(e.getEventType() == MouseEvent.MOUSE_PRESSED)
        	{
        		//Getting the coordinates for x and y
        		x1 = (int) e.getX();
        		y1 = (int) e.getY(); 
        	}
        	else if(e.getEventType() == MouseEvent.MOUSE_DRAGGED)
            	{
        			//Getting the coordinates for x and y
            		x2 = (int) e.getX();
            		y2 = (int) e.getY();
            		radius = (int) getDistance(x1, y1, x2, y2);
            		canvas.drawPlaceHolder(x1, y1, radius);
            		
            	}
            	else if(e.getEventType() == MouseEvent.MOUSE_RELEASED)
                	{
            			//Getting the coordinates for x and y
                		x3 = (int) e.getX();
                		y3 = (int) e.getY();
                		canvas.erasePlaceHolder();
                		
                		//Create a new circle after user releases mouse button and "paint" canvas
                		newCircle = new Circle();
                    	newCircle.setCenterX(x1);
                    	newCircle.setCenterY(y1);
                    	newRadius = (int) getDistance(x1,y1,x2,y2);
                    	newCircle.setRadius(newRadius);
                    	newCircle.setStroke(newColor);
                    	newCircle.setFill(newColor);
                    	circleList.add(newCircle);
                    	canvas.repaint();
                		
                	}
            	
        }	
        	



        

        /**
         * A helper method in case you need it. Get the Euclidean distance between (x1,y1) and (x2,y2)
         */
        private double getDistance(int x1, int y1, int x2, int y2)	//Done Already
        {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }

    }//end of class PointerHandler
}//end of DisplayCirclePane class
