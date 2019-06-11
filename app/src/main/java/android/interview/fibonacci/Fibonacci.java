package android.interview.fibonacci;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    private int mIndex;

    public Fibonacci(@NonNull int index) {
        mIndex = index;
    }

    public ArrayList<Integer> getResultList() {
        ArrayList<Integer> list = new ArrayList<>();

        calculate_iterative(mIndex, list);

        return list;
    }

    /*
     * Using recursive approach
     *
     * Time Complexity : O(2^n)
     *
     * For upper bound:
     *
     * T(n) = T(n-1) + T(n-2) + c
     *      = 2T(n-1) + c    //from the approximation T(n-1) ~ T(n-2)
     *      = 2*(2T(n-2) + c) + c
     *      = 4T(n-2) + 3c
     *      = 8T(n-3) + 7c
     *      = 2^k * T(n - k) + (2^k - 1)*c
     *
     * **/
    private int calculate_recursive(int n) {
        if (n < 2) {
            return n;
        } else {
            return calculate_recursive(n - 2) + calculate_recursive(n - 1);
        }
    }

    /*
     * Using iterative approach
     *
     * Time Complexity : O(n)
     *
     * **/
    private int calculate_iterative(int n) {

        int value1 = 0;
        int value2 = 1;
        int result = n;

        for (int i = 2; i <= n; i++) {
            result = value1 + value2;
            value1 = value2;
            value2 = result;
        }

        return result;
    }

    private void calculate_iterative(int n, List<Integer> list) {
        list.clear();
        int value1 = 0;
        int value2 = 1;
        int result = n;
        if (n >= 0) list.add(0);
        if (n >= 1) list.add(1);

        for (int i = 2; i <= n; i++) {
            result = value1 + value2;
            list.add(result);
            value1 = value2;
            value2 = result;
        }

    }
}
