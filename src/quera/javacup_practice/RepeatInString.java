package quera.javacup_practice;


public class RepeatInString {

	public int StringInString(String one, String two) {
		if(one==null || two==null) return 0;
		int count = 0;
		int start = 0;
		while (start < one.length()){
			int idx = one.indexOf(two,start);
			if(idx==-1) break;
			else {
				count++;
				start = idx + 1;
			}
		}
		return count;
	}
}