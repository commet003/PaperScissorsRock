package com.corie.paperscissorsrock;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private int playerScore = 0;
    private int computerScore = 0;
    private int ties = 0;
    private int rounds = 0;

    private int computerChoice = 0;

    private String[] choices = {"rock", "paper", "scissors"};





    @Override
    public void start(Stage stage) throws IOException {

        // Pane
        GridPane root = new GridPane();
        

        // Labels
        Label playerTitle = new Label("Player");
        Label computerTitle = new Label("Computer");
        Label playerScoreLabel = new Label(Integer.toString(playerScore));
        Label scoreCenter = new Label("-");
        Label computerScoreLabel = new Label(Integer.toString(computerScore));
        Label tiesLabel = new Label("Ties: " + ties);
        Label roundsLabel = new Label("Rounds: " + rounds);
        Label playerChoiceLabel = new Label("Player Choice: ");
        Label computerChoiceLabel = new Label("Computer Choice: ");
        Label winnerLabel = new Label("Winner: ");

        // Buttons
        Button rockButton = new Button("Rock");
        Button paperButton = new Button("Paper");
        Button scissorsButton = new Button("Scissors");
        
        ToggleButton toggleTheme = new ToggleButton("Toggle Theme");
        
        playerTitle.setFont(new Font("Arial", 40));
        computerTitle.setFont(new Font("Arial", 40));
        playerScoreLabel.setFont(new Font("Arial", 40));
        computerScoreLabel.setFont(new Font("Arial", 40));
        tiesLabel.setFont(new Font("Arial", 20));
        roundsLabel.setFont(new Font("Arial", 20));
        playerChoiceLabel.setFont(new Font("Arial", 15));
        computerChoiceLabel.setFont(new Font("Arial", 15));
        winnerLabel.setFont(new Font("Arial", 20));
        scoreCenter.setFont(new Font("Arial", 40));



        // Stage Layout
        HBox horizontalBox = new HBox();
        HBox playerButtons = new HBox();
        HBox playerTitleLayout = new HBox();
        HBox computerTitleLayout = new HBox();
        HBox scoreLayout = new HBox();
        VBox columnOne = new VBox();
        VBox columntwo = new VBox();
        VBox columnThree = new VBox();

        playerButtons.setSpacing(10);
        scoreLayout.setSpacing(10);

        // Add children to layouts
        scoreLayout.getChildren().addAll(playerScoreLabel, scoreCenter, computerScoreLabel);
        playerButtons.getChildren().addAll(rockButton, paperButton, scissorsButton);
        columnOne.getChildren().addAll(playerChoiceLabel, playerButtons);
        columntwo.getChildren().addAll(scoreLayout, winnerLabel, tiesLabel, roundsLabel, toggleTheme);
        columnThree.getChildren().addAll(computerChoiceLabel);
        horizontalBox.getChildren().addAll(columnOne, columntwo, columnThree);

        playerTitleLayout.getChildren().add(playerTitle);
        computerTitleLayout.getChildren().add(computerTitle);

        // Set layout alignment
        scoreLayout.setAlignment(Pos.CENTER);
        playerButtons.setAlignment(Pos.CENTER);
        columnOne.setAlignment(Pos.CENTER);
        columntwo.setAlignment(Pos.CENTER);
        columnThree.setAlignment(Pos.CENTER);

        columnOne.setSpacing(50);
        columntwo.setSpacing(50);

        playerTitleLayout.setPadding(new Insets(20, 0, 0, 0));
        scoreLayout.setPadding(new Insets(20, 0, 0, 0));
        computerTitleLayout.setPadding(new Insets(20, 0, 0, 0));
        columnOne.setPadding(new Insets(50, 10, 10, 10));
        columntwo.setPadding(new Insets(50, 10, 10, 10));
        columnThree.setPadding(new Insets(50, 10, 10, 10));


        playerTitleLayout.setAlignment(Pos.CENTER);
        computerTitleLayout.setAlignment(Pos.CENTER);

        root.add(playerTitleLayout, 0, 0);
        root.add(scoreLayout, 1, 0);
        root.add(computerTitleLayout, 2, 0);
        root.add(columnOne, 0, 1);
        root.add(columntwo, 1, 1);
        root.add(columnThree, 2, 1);


        Scene scene = new Scene(root, 750, 480);
        columnOne.setMinWidth(250);
        columntwo.setMinWidth(250);
        columnThree.setMinWidth(250);

        stage.setResizable(false);
        stage.setTitle("Paper, Scissors, Rock");
        stage.setScene(scene);
        stage.show();


        // Button Actions
        rockButton.setOnAction(e -> {
            playerChoiceLabel.setText("Player Choice: Rock");
            computerChoice = (int) (Math.random() * 3);
            computerChoiceLabel.setText("Computer Choice: " + choices[computerChoice]);
            if (computerChoice == 0) {
                winnerLabel.setText("Winner: Tie");
                ties++;
                tiesLabel.setText("Ties: " + ties);
            } else if (computerChoice == 1) {
                winnerLabel.setText("Winner: Computer");
                computerScore++;
                computerScoreLabel.setText(Integer.toString(computerScore));
            } else {
                winnerLabel.setText("Winner: Player");
                playerScore++;
                playerScoreLabel.setText(Integer.toString(playerScore));
            }
            rounds++;
            roundsLabel.setText("Rounds: " + rounds);
        });

        paperButton.setOnAction(e -> {
            playerChoiceLabel.setText("Player Choice: Paper");
            computerChoice = (int) (Math.random() * 3);
            computerChoiceLabel.setText("Computer Choice: " + choices[computerChoice]);
            if (computerChoice == 0) {
                winnerLabel.setText("Winner: Player");
                playerScore++;
                playerScoreLabel.setText(Integer.toString(playerScore));
            } else if (computerChoice == 1) {
                winnerLabel.setText("Winner: Tie");
                ties++;
                tiesLabel.setText("Ties: " + ties);
            } else {
                winnerLabel.setText("Winner: Computer");
                computerScore++;
                computerScoreLabel.setText(Integer.toString(computerScore));
            }
            rounds++;
            roundsLabel.setText("Rounds: " + rounds);
        });

        scissorsButton.setOnAction(e -> {
            playerChoiceLabel.setText("Player Choice: Scissors");
            computerChoice = (int) (Math.random() * 3);
            computerChoiceLabel.setText("Computer Choice: " + choices[computerChoice]);
            if (computerChoice == 0) {
                winnerLabel.setText("Winner: Computer");
                computerScore++;
                computerScoreLabel.setText(Integer.toString(computerScore));
            } else if (computerChoice == 1) {
                winnerLabel.setText("Winner: Player");
                playerScore++;
                playerScoreLabel.setText(Integer.toString(playerScore));
            } else {
                winnerLabel.setText("Winner: Tie");
                ties++;
                tiesLabel.setText("Ties: " + ties);
            }
            rounds++;
            roundsLabel.setText("Rounds: " + rounds);
        });
        
        toggleTheme.setOnAction(e -> {
        	if(toggleTheme.isSelected()) {
        		root.setStyle("-fx-background-color: black");
        		playerTitle.setStyle("-fx-text-fill: white");
        		computerTitle.setStyle("-fx-text-fill: white");
                playerScoreLabel.setStyle("-fx-text-fill: white");
                computerScoreLabel.setStyle("-fx-text-fill: white");
                tiesLabel.setStyle("-fx-text-fill: white");
                roundsLabel.setStyle("-fx-text-fill: white");
                playerChoiceLabel.setStyle("-fx-text-fill: white");
                computerChoiceLabel.setStyle("-fx-text-fill: white");
                winnerLabel.setStyle("-fx-text-fill: white");
                scoreCenter.setStyle("-fx-text-fill: white");
        	}else {
        		root.setStyle("-fx-background-color: white");
        		playerTitle.setStyle("-fx-text-fill: black");
        		computerTitle.setStyle("-fx-text-fill: black");
                playerScoreLabel.setStyle("-fx-text-fill: black");
                computerScoreLabel.setStyle("-fx-text-fill: black");
                tiesLabel.setStyle("-fx-text-fill: black");
                roundsLabel.setStyle("-fx-text-fill: black");
                playerChoiceLabel.setStyle("-fx-text-fill: black");
                computerChoiceLabel.setStyle("-fx-text-fill: black");
                winnerLabel.setStyle("-fx-text-fill: black");
                scoreCenter.setStyle("-fx-text-fill: black");
        	}
        });
    }

    public static void main(String[] args) {
        launch();
    }
}
