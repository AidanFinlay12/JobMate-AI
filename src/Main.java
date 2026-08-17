import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your skills separated by commas:");
        String candidateInput = scanner.nextLine();

        String[] candidateSkills = candidateInput.split(",");

        for (int i = 0; i < candidateSkills.length; i++) {
            candidateSkills[i] = candidateSkills[i].trim();
        }

        System.out.println("Enter the required skills separated by commas:");
        String jobInput = scanner.nextLine();
        String[] jobSkills = jobInput.split(",");

        for (int i = 0; i < jobSkills.length; i++) {
            jobSkills[i] = jobSkills[i].trim();
        }

        MatchResult result =
                JobMateMatcher.calculateMatch(candidateSkills, jobSkills);

        System.out.println("Matched Skills: " + result.getMatchedSkills());
        System.out.println("Related Skills: " + result.getRelatedSkills());
        System.out.println("Missing Skills: " + result.getMissingSkills());
        System.out.println("Match Percentage: " + result.getMatchPercentage() + "%");

        scanner.close();
    }
}