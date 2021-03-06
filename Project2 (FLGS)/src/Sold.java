public class Sold {
    public void doAction(Games gameSold, String customerName,
                         CashRegister cashRegister) {
        double income = gameSold.getPrice();
        gameSold.inventory -= 1;
        gameSold.sold += 1;
        cashRegister.addCash(income);
        System.out.println(customerName + " bought " + gameSold.getGameName() +
                           " for $"+ String.format("%.2f", income));
    }
}
