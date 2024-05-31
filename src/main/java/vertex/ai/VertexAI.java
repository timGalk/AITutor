package vertex.ai;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.vertexai.VertexAiGeminiChatModel;

public class GeminiProVisionWithImageInput {

    private static final String PROJECT_ID = "gen-lang-client-0595334583";
    private static final String LOCATION = "us-central1";
    private static final String MODEL_NAME = "gemini-pro";
    private static final String QUESTION = "How many programming do you know?";

    public static void main(String[] args) {
        ChatLanguageModel model = VertexAiGeminiChatModel.builder()
                .project(PROJECT_ID)
                .location(LOCATION)
                .modelName(MODEL_NAME)
                .build();
    String response = model.generate(QUESTION);

        System.out.println(response);
    }
}