package edu.io;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import vertex.ai.VertexAI;

public class Controller {

        private VertexAI vertexAI = new VertexAI();

        @FXML
        private Button startButton;

        @FXML
        private Button submitButton;

        @FXML
        private TextArea questionsArea;

        @FXML
        private TextArea answersArea;

        @FXML
        private TextArea feedbackArea;

        @FXML
        private void initialize() {
            startButton.setOnAction(e -> generateQuestions());
            submitButton.setOnAction(e -> checkAnswers());
        }

        private void generateQuestions() {
            String questions = vertexAI.generateQuestions();
            questionsArea.setText(questions);
        }

        private void checkAnswers() {
            String userAnswers = answersArea.getText();
            String questions = questionsArea.getText();
            String correctAnswers = vertexAI.getAnswers(questions);
            String feedback = vertexAI.checkAnswers(userAnswers, correctAnswers);
            feedbackArea.setText(feedback);
        }
    }

