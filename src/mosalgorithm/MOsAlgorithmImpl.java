package mosalgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MOsAlgorithmImpl implements MOsAlgorithmAPI {
    /**
     * @param arr
     * @param n
     * @param queries
     * @return
     */
    @Override
    public List<Answer> sumOfQueries(int[] arr, int n, List<Query> queries) {
        int blockSize = 0;
        List<Answer> answers = null;
        if (arr != null && !queries.isEmpty()) {
            blockSize = (int) Math.sqrt(n);
            answers = new ArrayList<>();
            int finalBlockSize = blockSize, i;
            queries.sort(new Comparator<Query>() {
                @Override
                public int compare(Query q1, Query q2) {
                    if (q1.getLeft() / finalBlockSize != q2.getLeft() / finalBlockSize) {
                        return (q1.getLeft() < q2.getLeft() ? -1 : 1);
                    }
                    return q1.getRight() < q2.getRight() ? -1 : 1;
                }
            });
            int currLeft = 0, currRight = -1, currAns = 0, left, right;
            for (i = 0; i < queries.size(); i++) {
                Answer answer = new Answer();
                left = queries.get(i).getLeft();
                right = queries.get(i).getRight();

                while(currLeft > left) {
                    currLeft--;
                    currAns += arr[currLeft];
                }

                while(currRight < right) {
                    currRight++;
                    currAns += arr[currRight];
                }

                while(currLeft < left) {
                    currAns -= arr[currLeft];
                    currLeft++;
                }

                while(currRight > right) {
                    currAns -= arr[currRight];
                    currRight--;
                }
                answer.setSumQuery(currAns);
                answer.setInsertionOrder(queries.get(i).getInsertionOrder());
                answers.add(answer);
            }
        }
        return answers;
    }
}
