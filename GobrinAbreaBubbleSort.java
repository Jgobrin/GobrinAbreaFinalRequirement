import java.util.Scanner;

public class GobrinAbreaBubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter at least 10 dates in the format dd/mm/yyyy, separated by a comma:");

        String input = scanner.nextLine();

        String[] dateArray = processInput(input, scanner);

        System.out.print("Sorted Dates:\n" + String.join(", ", dateArray));

        System.out.println("\nDo you want to run again? (y/n)");
        String runAgain = scanner.nextLine().toLowerCase();

        if (runAgain.equalsIgnoreCase("y")) {
            main(args);
        } else {
            System.out.println("Exiting the program. Goodbye!");
        }
    }

    private static String[] processInput(String input, Scanner scanner) {
        String[] dateArray = input.split(",");
        if (dateArray.length < 10) {
            System.out.println("Invalid input. Please enter at least 10 dates separated by commas.");
            return processInput(scanner.nextLine(), scanner);
        }

        for (int i = 0; i < dateArray.length; i++) {
            if (!containsOnlyNumerical(dateArray[i].trim())) {
                System.out.println("Invalid input. The input contains non-numerical");
                return processInput(scanner.nextLine(), scanner);
            }
            if (!isValidDateFormat(dateArray[i].trim())) {
                System.out.println("Invalid date format. Please enter dates in the format dd/mm/yyyy.");
                return processInput(scanner.nextLine(), scanner);
            }

            dateArray[i] = dateArray[i].trim();
        }

        bubbleSort(dateArray);

        return dateArray;
    }

    private static boolean containsOnlyNumerical(String str) {
        return str.matches("^\\d{2}/\\d{2}/\\d{4}$") || str.matches("^\\d+$");
    }

    private static boolean isValidDateFormat(String date) {
        return date.matches("^\\d{2}/\\d{2}/\\d{4}$");
    }

    private static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}