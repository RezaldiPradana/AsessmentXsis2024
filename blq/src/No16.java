public class No16 {
    public static void main(String[] args) {
        int[][] menu = new int[][]{
                {42000, 1},
                {50000, 0},
                {30000, 0},
                {70000, 0},
                {30000, 0}
        };

        int totalPerson = 4;
        int allergicPerson = 1;

        float[] bill = splitBill(menu, totalPerson, allergicPerson);
        System.out.println("Tagihan biasa: " + bill[1]);
        System.out.println("Tagihan alergi: " + bill[0]);
    }

    private static float[] splitBill(int[][] menu, int totalPerson, int allergicPerson) {
        float totalCost = 0;
        for (int[] item : menu) {
            totalCost += countTaxAndService(item[0]);
        }

        float sharedCost = totalCost / totalPerson;
        float fishCost = 0;
        for (int[] item : menu) {
            if (item[1] == 1) {
                fishCost += countTaxAndService(item[0]);
            }
        }

        float allergicBill = sharedCost;
        float nonAllergicBill = sharedCost + fishCost / (totalPerson - allergicPerson);
        return new float[]{allergicBill, nonAllergicBill};
    }

    private static float countTaxAndService(int price) {
        return price + (price * 15 / 100);
    }
}