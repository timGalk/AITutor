package vertex.ai;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.vertexai.VertexAiGeminiChatModel;

public class VertexAI {

    private static final String PROJECT_ID = ""; // your project ID here
    private static final String LOCATION = "us-central1";
    private static final String MODEL_NAME = "gemini-1.5-pro-001";


    public String generateQuestions(){
        String question = "Generate 5 multiple-choice questions about OOP (A-E), don't provide correct answers";
        ChatLanguageModel model = VertexAiGeminiChatModel.builder()
                .project(PROJECT_ID)
                .location(LOCATION)
                .modelName(MODEL_NAME)
                .build();
        String response = model.generate(question);
        return response;
    }

    public String getAnswers(String response){

        String getAnswersPrompt = "Provide the correct answers for the following questions in this format: 1.a, 2.b, etc.. NOTHING MORE, WITHOUT EXPLANATION!";
       ChatLanguageModel model = VertexAiGeminiChatModel.builder()
                .project(PROJECT_ID)
                .location(LOCATION)
                .modelName(MODEL_NAME)
                .build();
        String answers = model.generate(response);
        return answers;
    }
    public String checkAnswers(String userAnswers, String rightAnswers){
        String task = "User answers: " + userAnswers + ". Correct answers: " + rightAnswers + ". Count and report how many user answers are correct. " +
                "Give a short feedback and discuss errors.";

        ChatLanguageModel model = VertexAiGeminiChatModel.builder()
                .project(PROJECT_ID)
                .location(LOCATION)
                .modelName(MODEL_NAME)
                .build();
        String result = model.generate(task);
        return result;

    }

}