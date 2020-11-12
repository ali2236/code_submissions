package quera.javacup_pre_7.exam.ir.javacup.exam;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private QuestionData data;
	private List<Option> options;

	public Question(QuestionData data, List<String> options) {
		this.data = data;
		this.options = new ArrayList<>();
		for (int i = 0; i < options.size(); i++) {
			this.options.add(new Option(i + 1, options.get(i)));
		}
	}

	public QuestionData getData() {
		return data;
	}

	public List<Option> getOptions() {
		return options;
	}
}
