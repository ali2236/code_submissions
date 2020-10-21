package quera.javacup_training.clothing_shop.ir.javacup.shop;
//package ir.javacup.shop;

public class WinterDiscountStrategy implements DiscountStrategy {

    @Override
    public long priceByDiscount(Clothing clothing) {
        long price = clothing.getBasePrice();

        if(clothing.getSeason().equals(Season.FALL)) price *= 0.6;
        else if(clothing.getSeason().equals(Season.WINTER)) price *= 0.5;
        else if(clothing.getSeason().equals(Season.SUMMER)) price *= 0.75;

        if(clothing instanceof Jacket) price *= 0.9;

        return price;
    }
}
