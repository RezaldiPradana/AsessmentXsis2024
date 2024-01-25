public class No1 {

    public static void main(String[] args) {
        int N = 1000;
        int[][] items = {
                {500, 600, 700, 800},
                {200, 400, 350},
                {400, 350, 200, 300},
                {100, 50, 150}
        };

        System.out.println("Total item yang didapat dari 1000 rupiah : "+caseMaximumItemPurchasedRecursive(items, N, 0));
    }

    private static int caseMaximumItemPurchasedRecursive(int[][] items, int targetSum, int dimension) {
        if (dimension == items.length) {
            return 0;
        }

        int maxItems = 0;
        for (int i = 0; i < items[dimension].length; i++) {
            int currentElement = items[dimension][i];
            if (currentElement <= targetSum) {
                int remainingItems = caseMaximumItemPurchasedRecursive(items, targetSum - currentElement, dimension + 1);
                maxItems = Math.max(maxItems, 1 + remainingItems);
            }
        }

        return maxItems;
    }
}