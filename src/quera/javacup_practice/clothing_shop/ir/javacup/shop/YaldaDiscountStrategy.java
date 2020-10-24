package quera.javacup_practice.clothing_shop.ir.javacup.shop;
//package ir.javacup.shop;

public class YaldaDiscountStrategy implements DiscountStrategy{
    @Override
    public long priceByDiscount(Clothing clothing) {
        double off;
        if(clothing instanceof Jacket) off = 0.1;
        else if(clothing instanceof Socks) off = 0.2;
        else off = 0.25;

        return (long) (clothing.getBasePrice() * (1 - off));
    }
}
