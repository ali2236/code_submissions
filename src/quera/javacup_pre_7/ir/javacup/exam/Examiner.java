package quera.javacup_pre_7.ir.javacup.exam;

import java.util.List;
import java.util.function.Function;

public class Examiner {
	public int solve(Question test) {
		Medium first = test.getData().source;
		Medium second = test.getData().destination;

		List<Option> options = test.getOptions();
		Option firstOption = options.get(0);
		double ans;
		if(second!=null) ans = first.criticalAngle(second);
		else ans = first.criticalAngle();
		int ansId = firstOption.getId();
		Function<Option, Double> calcDelta = option -> Math.abs(ans - Double.parseDouble(option.getValue()));
		double delta = calcDelta.apply(firstOption);
		for (int i = 1; i < options.size(); i++) {
			Option option = options.get(i);
			Double d = calcDelta.apply(option);
			if (d < delta){
				delta = d;
				ansId = option.getId();
			}
		}
		return ansId;
	}
}
