public class No20 {
    public static void main(String[] args) {
        int initialDistance = 2;
        String[] aCombination = {"G", "G", "G"};
        String[] bCombination = {"K", "K", "B"};

        paperRockScissor(initialDistance, aCombination, bCombination);
    }

    private static String[] determineRoundResult(String[] a, String[] b) {
        String[] roundResults = new String[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(b[i])) {
                roundResults[i] = "Draw";
            } else if ((a[i].equals("G") && b[i].equals("K")) ||
                    (a[i].equals("K") && b[i].equals("B")) ||
                    (a[i].equals("B") && b[i].equals("G"))) {
                roundResults[i] = "Win";
            } else {
                roundResults[i] = "Lose";
            }
        }
        return roundResults;
    }

    private static String determineGameWinner(String[] roundResults, int initialDistance) {
        int aRelativePosition = 0;
        int bRelativePosition = initialDistance;
        int lastRound = -1;

        for (int i = 0; i < roundResults.length; i++) {
            if (aRelativePosition == bRelativePosition) {
                lastRound = i - 1;
                break;
            } else if (roundResults[i].equals("Win")) {
                aRelativePosition += 2;
                bRelativePosition += 1;
            } else if (roundResults[i].equals("Lose")) {
                aRelativePosition -= 1;
                bRelativePosition -= 2;
            }
        }

        if (lastRound >= 0 && roundResults[lastRound].equals("Win")) {
            return "A";
        } else if (lastRound >= 0 && roundResults[lastRound].equals("Lose")) {
            return "B";
        }

        return "Draw";
    }

    public static void paperRockScissor(int initialDistance, String[] a, String[] b) {
        String[] roundResults = determineRoundResult(a, b);
        String winner = determineGameWinner(roundResults, initialDistance);
        System.out.println("The winner is: " + winner);
    }
}