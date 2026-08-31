import com.google.gson.Gson;

public class JsonPractise {

    public static void main(String[] args) {

        String json = """
                {
                    "title": "Software Engineer Placement",
                    "company": "Example Ltd",
                    "requiredSkills": ["Java", "SQL"],
                    "preferredSkills": ["AWS"]
                }
                """;

        Gson gson = new Gson();

        Job job = gson.fromJson(json, Job.class);

        System.out.println(job.getTitle());
        System.out.println(job.getCompany());
        System.out.println(job.getRequiredSkills());
        System.out.println(job.getPreferredSkills());
    }
}