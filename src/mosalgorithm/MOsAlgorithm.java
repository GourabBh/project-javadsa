package mosalgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MOsAlgorithm {
    public static void main(String[] args) {
        List<Query> queries = new ArrayList<Query>();
        queries.add(new Query(0, 4, 1));
        queries.add(new Query(1, 3, 2));
        queries.add(new Query(2, 4, 3));

        int[] a = {1, 1, 2, 1, 3, 4, 5, 2, 8};

        MOsAlgorithmAPI mOsAlgorithmAPI = new MOsAlgorithmImpl();

        List<Answer> answers = mOsAlgorithmAPI.sumOfQueries(a, a.length, queries);
        if (!answers.isEmpty()) {
            answers.sort(new Comparator<Answer>() {
                @Override
                public int compare(Answer o1, Answer o2) {
                    return (o1.getInsertionOrder() < o2.getInsertionOrder() ? -1 : 1);
                }
            });

            for (Answer answer : answers) {
                System.out.println("Sum of " + answer.getInsertionOrder() + " range: " + answer.getSumQuery());
            }
        }

    }
}
