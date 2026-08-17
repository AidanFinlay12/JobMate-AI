import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

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

        ArrayList<String> skills = new ArrayList<>();

        for (int i = 0; i < candidateSkills.length; i++) {
            candidateSkills[i] = candidateSkills[i].trim();
            skills.add(candidateSkills[i]);
        }

        Candidate candidate = new Candidate(
                name,
                skills,
                education,
                experience
        );

        System.out.println("Enter the job title:");
        String jobTitle = scanner.nextLine();

        System.out.println("Enter the company:");
        String company = scanner.nextLine();

        System.out.println("Enter the required skills separated by commas:");
        String jobInput = scanner.nextLine();
        String[] jobSkills = jobInput.split(",");

        ArrayList<String> requiredSkills = new ArrayList<>();

        for (int i = 0; i < jobSkills.length; i++) {
            jobSkills[i] = jobSkills[i].trim();
            requiredSkills.add(jobSkills[i]);
        }



        System.out.println("Enter the preferred skills separated by commas:");
        String preferredInput = scanner.nextLine();

        String[] preferredSkillArray = preferredInput.split(",");

        ArrayList<String> preferredSkills = new ArrayList<>();

        for (int i = 0; i < preferredSkillArray.length; i++) {
            preferredSkillArray[i] = preferredSkillArray[i].trim();
            preferredSkills.add(preferredSkillArray[i]);
        }

        Job job = new Job(
                jobTitle,
                company,
                requiredSkills,
                preferredSkills
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

        System.out.println("\nOverall Match Percentage: "
                + result.getMatchPercentage()
                + "%");

        scanner.close();
    }
}