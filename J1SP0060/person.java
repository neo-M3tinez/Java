/*
 * This class represents a person.
 */

package j1.s.p0060;

class Person { // This class represents a user
    private Wallet wallet; // Variable to store the user's wallet

    // Constructor of the Person class, initializes the wallet for the user
    public Person(int walletAmount) {
        this.wallet = new Wallet(walletAmount); // Initialize the user's wallet
    }

    // Method to get the user's wallet
    public Wallet getWallet() {
        return wallet; // Return the user's wallet
    }
}
