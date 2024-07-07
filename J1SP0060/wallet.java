/*
 * This class represents a wallet containing money.
 */

package j1.s.p0060;

class Wallet {
    // Variable to store the amount of money in the wallet
    private int amountInWallet;

    // Constructor of Wallet class, initializes the wallet with the given initial amount
    public Wallet(int amount) {
        this.amountInWallet = amount;
    }

    // Method to calculate the total value of the bills
    public int calcTotal(int[] bills) {
        int total = 0; // Initialize total to zero
        // Iterate through each bill in the bills array
        for (int bill : bills) {
            total += bill; // Add the value of the bill to the total
        }
        return total; // Return the total value of the bills
    }

    // Method to pay money, returns true if enough money is available, false otherwise
    public boolean payMoney(int total) {
        return amountInWallet >= total; // Check if there is enough money
    }
}
