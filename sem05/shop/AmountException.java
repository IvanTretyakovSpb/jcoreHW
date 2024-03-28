package homework.sem05.shop;

class AmountException extends Exception {
    private final int currentAmount;

    public AmountException(int currentAmount) {
        super();
        this.currentAmount = currentAmount;
    }

    @Override
    public String getMessage() {
        return String.format("Incorrect amount: %d.", currentAmount);
    }
}
