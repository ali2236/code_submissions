package quera.javacup_final_7.calculator.ir.javacup.calc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CalculatorProxy implements Calculable {

    private final Calculable calculator;

    private final Map<String, BigDecimal> cache = new HashMap<>();

    public CalculatorProxy(Calculable calculator) {
        this.calculator = calculator;
    }

    @Override
    public BigDecimal doOperation(BigDecimal... operands) {

        String key = Arrays.stream(operands)
                .mapToInt(BigDecimal::hashCode)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());

        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            BigDecimal result = calculator.doOperation(operands);
            cache.put(key, result);
            return result;
        }
    }

}
