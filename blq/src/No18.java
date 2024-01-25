public class No18 {

    public static void main(String[] args) {
        int[] inputHours = new int[]{9, 13, 15, 17};
        int[] inputCalories = new int[]{30, 20, 50, 80};
        int inputTime = 18;

        burningCalories(inputHours, inputCalories, inputTime);
    }

    private static double calculateWaterIntake(int[] inputHours, int[] inputCalories, int inputTime) {
        int totalCaloriesBurned = 0;
        int minutesInAnHour = 60;

        for (int i = 0; i < inputHours.length; i++) {
            if (inputTime > inputHours[i]) {
                int timeDifference = inputTime - inputHours[i];
                totalCaloriesBurned += 0.1 * inputCalories[i] * timeDifference;
            }
        }

        double exerciseDuration = (double) totalCaloriesBurned / minutesInAnHour;
        return (100 * exerciseDuration * 2) + 500;
    }

    public static void burningCalories(int[] inputHours, int[] inputCalories, int inputTime) {
        double waterIntake = calculateWaterIntake(inputHours, inputCalories, inputTime);
        System.out.println("Kebutuhan donna adalah " + (int) waterIntake + "cc air");
    }
}