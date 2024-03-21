package homework.sem04;

class ProductException extends Exception {
    private final Product product;

    public ProductException(Product product) {
        this.product = product;
    }

    @Override
    public String getMessage() {
        return String.format("Unknown product: \n%s", product);
    }
}
