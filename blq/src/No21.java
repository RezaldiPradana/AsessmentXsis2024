public class No21 {

        public static void main(String[] args) {
            String result = solveManholeGame("_ _ _ _ _ O _ _ _ Finish");
            String result1 = solveManholeGame("_ _ _ O _ _ O _ _ Finish");
            System.out.println(result);
            System.out.println(result1);
        }

        public static String solveManholeGame(String track) {
            char[] trackArray = track.replaceAll(" ", "").toCharArray();
            int stamina = 0;
            int distance = 0;
            StringBuilder solution = new StringBuilder();

            for (int i = 1; i < trackArray.length; i++) {
                if (trackArray[0] == 'O') {
                    return "FAILED";
                }
                if (trackArray[i] == '_' && trackArray.length - i == 9 && track.endsWith("_ _ _ Finish") && stamina >= 2) {
                    solution.append("J ");
                    break;
                } else if (trackArray[i] == 'O') {
                    if (stamina >= 2) {
                        stamina -= 2;
                        distance += 3;
                        solution.append("J ");
                    } else {
                        return "FAILED";
                    }
                } else if (trackArray[i] == '_') {
                    stamina += 1;
                    distance += 1;
                    solution.append("W ");
                } else if (trackArray[i] == 'F') {
                    break;
                }
            }

            return solution.toString().trim();
        }


    }
