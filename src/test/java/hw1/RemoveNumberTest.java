package hw1;

import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class RemoveNumberTest {

    private static int[] removeElement(int[] input, int element) {
        int n = input.length;
        int[] result = new int[n];
        int result_length = 0;
        for (int i = 0; i < n; ++i) {
            if (input[i] != element) {
                result[result_length] = input[i];
                result_length++;
            }
        }
        return Arrays.copyOfRange(result, 0, result_length);
    }

    @Test
    public void removeElement() {
        Assertions.assertArrayEquals(new int[]{1}, removeElement(new int[]{1, 2}, 2));
        Assertions.assertArrayEquals(new int[]{}, removeElement(new int[]{1}, 1));
    }

    @Test
    public void removeReturnsNewArray() {
        int[] input = {9, 1, 3, 11, 3, 45, 499};
        int[] copy = Arrays.copyOf(input, input.length);

        int[] removed = removeElement(input, 3);

        Assertions.assertArrayEquals(new int[]{9, 1, 11, 45, 499}, removed);
        Assertions.assertArrayEquals(copy, input);
    }
}
