package quera.javacup_practice.online_shopping.ir.javacup.shop;

import java.util.function.Function;

public class OrderFunctionUtilImpl implements OrderFunctionUtil{

    @Override
    public Function<Order, Boolean> isBigOrder() {
        return order -> order.getProducts().stream().map(Product::getPrice).reduce(Long::sum).get() >= 10_000_000;
    }

    @Override
    public Function<Order, Boolean> hasMultipleProducts() {
        return order -> order.getProducts().size() > 1;
    }

    @Override
    public Function<Order, Boolean> hasUnavailableProduct() {
        return order -> order.getProducts().stream().anyMatch(product -> product.getState().equals(ProductState.UNAVAILABLE));
    }

    @Override
    public Function<Order, Boolean> isReadyToDeliver() {
        return order -> !hasUnavailableProduct().apply(order) && order.getState().equals(OrderState.READY_TO_SEND);
    }

    @Override
    public Function<Order, Boolean> hasPerishableProduct() {
        return order -> order.getProducts().stream().anyMatch(product -> product.getType().equals(ProductType.PERISHABLE));
    }

    @Override
    public Function<Order, Boolean> hasExpensiveBreakableProduct() {
        return order -> order.getProducts().stream().anyMatch(product -> product.getType().equals(ProductType.BREAKABLE) && product.getPrice() >= 5_000_000);
    }
}
