package vertex.ai;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ImageContent;
import dev.langchain4j.data.message.TextContent;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.output.Response;
import dev.langchain4j.model.vertexai.VertexAiGeminiChatModel;

public class GeminiProVisionWithImageInput {

    private static final String PROJECT_ID = "YOUR-PROJECT-ID";
    private static final String LOCATION = "us-central1";
    private static final String MODEL_NAME = "gemini-pro-vision";
    private static final String CAT_IMAGE_URL = "https://upload.wikimedia.org/" +
            "wikipedia/commons/e/e9/" +
            "Felis_silvestris_silvestris_small_gradual_decrease_of_quality.png";

    public static void main(String[] args) {
        ChatLanguageModel visionModel = VertexAiGeminiChatModel.builder()
                .project(PROJECT_ID)
                .location(LOCATION)
                .modelName(MODEL_NAME)
                .build();

        Response<AiMessage> response = visionModel.generate(
                UserMessage.from(
                        ImageContent.from(CAT_IMAGE_URL),
                        TextContent.from("What do you see?")
                )
        );

        System.out.println(response.content().text());
    }
}