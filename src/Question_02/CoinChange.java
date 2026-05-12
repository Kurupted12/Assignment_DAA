package Question_02;

public class CoinChange {


        public static void main(String[] args) {

            int amount = 1988;

            int[] notes = {5000, 1000, 500, 100, 50, 20, 10, 5, 2, 1};

            System.out.println("Currency Distribution for Rs. " + amount + "\n");

            for (int i = 0; i < notes.length; i++) {

                if (amount >= notes[i]) {

                    int count = amount / notes[i];

                    amount = amount % notes[i];

                    System.out.println("Rs. " + notes[i] + " = " + count);
                }
            }
        }

}
