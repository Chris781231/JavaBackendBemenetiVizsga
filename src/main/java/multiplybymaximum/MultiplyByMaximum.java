package multiplybymaximum;

public class MultiplyByMaximum {

    public int[] multiplyByMaximum(int[] numbers, int n) {
        if (numbers == null) throw new IllegalArgumentException("Array is null");
        if (numbers.length == 0) return new int[0];
        if (n < 1) throw new IllegalArgumentException("number is smaller than 1");

        int maxItem = findMaxItemFromArray(numbers);

        return getResultArray(numbers, n, maxItem);
    }

    private int[] getResultArray(int[] numbers, int n, int maxItem) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if ((i + 1) % n == 0) {
                result[i] = numbers[i] * maxItem;
            } else {
                result[i] = numbers[i];
            }
        }
        return result;
    }

    private int findMaxItemFromArray(int[] numbers) {
        int max = Integer.MIN_VALUE;
        for (int item : numbers) {
            if (item > max) {
                max = item;
            }
        }
        return max;
    }
}
