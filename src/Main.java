import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Go fuck yourself Amholes!");
        System.out.println("Fight on! Trojan");
        System.out.println("Exam: ");
        String[] problems = pickNRandomCodingProblems(3);
        for (String current : problems) {
            System.out.println(current);
        }
    }

    private static String[] pickNRandomCodingProblems(int n) {
        String[] result = new String[3];
        int weight = 0;
        CodingProblemData codingProblemData = new CodingProblemData();
        Set<CodingProblemData.Problem> myProblems = codingProblemData.getMyProblems();
        for (CodingProblemData.Problem problem : myProblems) {
            weight += problem.weight;
        }

        for (int i = 0; i < n; i++) {
            int randonWeight = (int) (weight * Math.random());
            for (CodingProblemData.Problem problem : myProblems) {
                if (randonWeight <= 0) {
                    result[i] = problem.name;
                    break;
                }
                randonWeight -= problem.weight;
            }
        }
        return result;
    }


}
