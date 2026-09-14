
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {


        String jobDescription = """
        We are looking for a Software Engineer Placement student at Example Ltd.
        Java and SQL are essential.
        Experience with AWS or Azure would be advantageous.
        """;

        Job job = OllamaClient.extractJob(jobDescription);


        System.out.println(job.getTitle());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        System.out.println("Enter your education:");
        String education = scanner.nextLine();

        System.out.println("Enter your experience:");
        String experience = scanner.nextLine();

        System.out.println("Enter your skills separated by commas:");
        String candidateInput = scanner.nextLine();

        String[] candidateSkills = candidateInput.split(",");

        HashSet<String> uniqueSkills = new HashSet<>();

        for (int i = 0; i < candidateSkills.length; i++) {

            String cleanedSkill = candidateSkills[i]
                    .trim()
                    .toLowerCase();

            uniqueSkills.add(cleanedSkill);
        }

        ArrayList<String> skills = new ArrayList<>(uniqueSkills);

        Candidate candidate = new Candidate(
                name,
                skills,
                education,
                experience
        );

        MatchResult result = JobMateMatcher.calculateMatch(candidate, job);
        System.out.println("\n--- Match Results ---");

        System.out.println("\nRequired Skills");
        System.out.println("Matched: " + result.getRequiredMatchedSkills());
        System.out.println("Related: " + result.getRequiredRelatedSkills());
        System.out.println("Missing: " + result.getRequiredMissingSkills());

        System.out.println("\nPreferred Skills");
        System.out.println("Matched: " + result.getPreferredMatchedSkills());
        System.out.println("Related: " + result.getPreferredRelatedSkills());
        System.out.println("Missing: " + result.getPreferredMissingSkills());

        System.out.printf(
                "\nOverall Match Percentage: %.2f%%%n",
                result.getMatchPercentage()
        );

        scanner.close();
    }
}