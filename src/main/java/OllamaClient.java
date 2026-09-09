import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;

public class OllamaClient {

    public static void main(String[] args) throws Exception{

        HttpClient client = HttpClient.newHttpClient();

        String prompt = """
        You are a job-description extraction system.

        Extract these fields:
        - title
        - company
        - requiredSkills
        - preferredSkills

        Rules:
        - Do not invent information.
        - Keep required and preferred skills separate.
        - Only include skills supported by the advert.
        - If title or company is unknown, use an empty string.
        - Return JSON only.

        Job advert:
        We are looking for a Software Engineer Placement student at Example Ltd.
        Java and SQL are essential.
        Experience with AWS or Azure would be advantageous.
        """;

        JsonObject requestJson = new JsonObject();

        requestJson.addProperty("model", "qwen2.5:7b");
        requestJson.addProperty("prompt", prompt);
        requestJson.addProperty("stream", false);
        requestJson.addProperty("format", "json");

        String requestBody = requestJson.toString();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:11434/api/generate"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

        String aiResponse = jsonObject.get("response").getAsString();

        aiResponse = aiResponse
                .replace("```json", "")
                .replace("```", "")
                .trim();

        System.out.println("RAW AI RESPONSE:");
        System.out.println(aiResponse);

        Gson gson = new Gson();
        Job job = gson.fromJson(aiResponse, Job.class);

        System.out.println(job.getTitle());
        System.out.println(job.getCompany());
        System.out.println(job.getRequiredSkills());
        System.out.println(job.getPreferredSkills());
    }
}
