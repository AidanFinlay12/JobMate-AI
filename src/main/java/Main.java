
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

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

        System.out.println("Enter the job title:");
        String jobTitle = scanner.nextLine();

        System.out.println("Enter the company:");
        String company = scanner.nextLine();

        System.out.println("Enter the required skills separated by commas:");
        String jobInput = scanner.nextLine();
        String[] jobSkills = jobInput.split(",");

        HashSet<String> uniqueRequiredSkills = new HashSet<>();

        for (int i = 0; i < jobSkills.length; i++) {

            String cleanedSkill = jobSkills[i]
                    .trim()
                    .toLowerCase();

            uniqueRequiredSkills.add(cleanedSkill);
        }

        ArrayList<String> requiredSkills =
                new ArrayList<>(uniqueRequiredSkills);



        System.out.println("Enter the preferred skills separated by commas:");
        String preferredInput = scanner.nextLine();

        String[] preferredSkillArray = preferredInput.split(",");

        HashSet<String> uniquePreferredSkills = new HashSet<>();

        for (int i = 0; i < preferredSkillArray.length; i++) {

            String cleanedSkill = preferredSkillArray[i]
                    .trim()
                    .toLowerCase();

            uniquePreferredSkills.add(cleanedSkill);
        }

        ArrayList<String> preferredSkills =
                new ArrayList<>(uniquePreferredSkills);

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

        System.out.println("\nOverall Match Percentage: %.2F%%%n"
                + result.getMatchPercentage());

        scanner.close();
    }
}