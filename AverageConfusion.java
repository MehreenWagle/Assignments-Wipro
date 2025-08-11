public class AverageConfusion {

    public static void main(String[] args) {
        int[] numbers = {3, 12, 8, 20, 5}; 

        //  Replace numbers less than 10 with their double
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 10) {
                numbers[i] = numbers[i] * 2;
            }
        }

        //  Calculate average
        double sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = sum / numbers.length;

        // 
        System.out.println("Modified numbers:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println("\nAverage: " + average);
    }
}

