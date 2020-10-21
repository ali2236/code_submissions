package quera.javacup_training.clothing_shop.ir.javacup.shop;
//package ir.javacup.shop;

public class SummerDiscountStrategy implements DiscountStrategy{
    @Override
    public long priceByDiscount(Clothing clothing) {
        if(clothing.getSeason().equals(Season.SPRING)) return (long) (clothing.getBasePrice() * 0.6);
        if(clothing.getSeason().equals(Season.SUMMER)) return (long) (clothing.getBasePrice() * 0.5);
        if(clothing.getSeason().equals(Season.WINTER)) return (long) (clothing.getBasePrice() * 0.7);
        return clothing.getBasePrice();
    }
}
