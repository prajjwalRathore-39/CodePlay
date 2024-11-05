import java.util.*;

class Test {
    public int[] findPair(int input1, int[] input2) {
        int maxProduct = Integer.MIN_VALUE;
        int[] result = new int[2];
        boolean found = false;

        // Iterate through all possible pairs in the array
        for (int i = 0; i < input1; i++) {
            for (int j = i + 1; j < input1; j++) {
                // Check if the sum of the pair is 18
                if (input2[i] + input2[j] == 18) {
                    int first = input2[i];
                    int second = input2[j];

                    // Ensure the first element is greater than the second
                    if (first > second) {
                        int product = first * second;

                        // Update the maximum product pair if found
                        if (product > maxProduct) {
                            maxProduct = product;
                            result[0] = first;
                            result[1] = second;
                            found = true;
                        }
                    }
                }
            }
        }

        // If a pair was found, return it; otherwise, return an empty array
        return found ? result : new int[0];
    }
    public static int[] findPairr(int N, int[] A) {
        int maxProduct = -1;
        int[] bestPair = new int[0];

        // Use a set for efficient lookup of pairs
        Set<Integer> seenElements = new HashSet<>();
        for (int num : A) {
            seenElements.add(num);
        }

       // N ---> input1
        // A --> input2


        // Loop through each element to find pairs
        for (int a : A) {
            int b = 18 - a; // Since a + b must equal 18
            if (seenElements.contains(b) && a > b) {
                int product = a * b;
                if (product > maxProduct) {
                    maxProduct = product;
                    bestPair = new int[]{a, b};
                }
            }
        }

        return bestPair;
    }

    public int dividend(int[] input1, int input2, int input3, int input4, int input5) {
        // Calculate the dividend using the formula Dividend = Divisor * Quotient + Remainder
        int dividend = input2 * input3 + input4;

        // Iterate through the array to find the index of the calculated dividend
        for (int i = 0; i < input5; i++) {
            if (input1[i] == dividend) {
                return i; // Return the index if dividend is found
            }
        }

        // Return -1 if the dividend is not found in the array
        return -1;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size of the Array.");
        int[] arr = new int[sc.nextInt()];
        for (int i = 0;i<arr.length;i++)
            arr[i] = sc.nextInt();


        Test obj = new Test();
       // System.out.println(Arrays.toString(obj.findPair(arr.length,arr)));
        System.out.println(Arrays.toString(obj.findPairr(arr.length,arr)));

//        System.out.println("INPUTS FOR SECOND PROBLEM.");
//        System.out.println("Enter the Size of the Array.");
//        int size = sc.nextInt();
//        int[] arrr = new int[size];
//        for (int i = 0;i<arrr.length;i++){
//            arrr[i] = sc.nextInt();
//        }
//
//        System.out.println("Input 1");
//        int input2 = sc.nextInt();
//        int input3 = sc.nextInt();
//        int input4 = sc.nextInt();
//        int input5 = sc.nextInt();
//        System.out.println("Result for second Questions");
//        System.out.println(obj.dividend(arrr,input2,input3,input4,input5));
    }
}
