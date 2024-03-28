package homework.sem05.shop;

class CustomerException extends Exception {
    private final Customer customer;

    public CustomerException(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String getMessage() {
        return String.format("Unknown customer: \n%s", customer);
    }
}
