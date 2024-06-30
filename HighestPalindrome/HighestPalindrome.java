package HighestPalindrome;

public class HighestPalindrome {

    public static void main(String[] args) {
        System.out.println(highestPalindrome("3943", 1));
        System.out.println(highestPalindrome("932239", 2));
        System.out.println(highestPalindrome("12521", 2));
    }

    public static String highestPalindrome(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        boolean[] changed = new boolean[n];

        int changesNeeded = generatePalindrome(arr, 0, n - 1, k, changed);
        if (changesNeeded > k) {
            return "-1";
        }

        generateLargestPalindrome(arr, 0, n - 1, k - changesNeeded, changed);
        return new String(arr);
    }

    private static int generatePalindrome(char[] arr, int left, int right, int k, boolean[] changed) {
        if (left >= right) {
            return 0;
        }

        if (arr[left] == arr[right]) {
            return generatePalindrome(arr, left + 1, right - 1, k, changed);
        } else {
            if (arr[left] > arr[right]) {
                arr[right] = arr[left];
            } else {
                arr[left] = arr[right];
            }
            changed[left] = true;
            changed[right] = true;
            return 1 + generatePalindrome(arr, left + 1, right - 1, k - 1, changed);
        }
    }

    private static void generateLargestPalindrome(char[] arr, int left, int right, int k, boolean[] changed) {
        if (left >= right || k <= 0) {
            return;
        }

        if (arr[left] < '9') {
            if (changed[left] || changed[right]) {
                arr[left] = '9';
                arr[right] = '9';
                k--;
            } else if (k >= 2) {
                arr[left] = '9';
                arr[right] = '9';
                k -= 2;
            }
        }

        generateLargestPalindrome(arr, left + 1, right - 1, k, changed);
    }
}
