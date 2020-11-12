package quera.javacup_final_7.compress.ir.javacup.cmp;

public class Compression {

	public String compress(String data) {
		String lc = data.toLowerCase();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < data.length(); i++) {
			char c = lc.charAt(i);
			char C = data.charAt(i);
			int Ci = i;
			int count = 1;
			for (int j = i+1; ; j++) {
				if(j >= data.length()){
					i = j-1;
					break;
				}
				if(lc.charAt(j)==c) count++;
				else{
					i = j-1;
					break;
				}
			}
			if(count>2) str.append(count).append(c);
			else if (count==2) str.append(C).append(data.charAt(Ci+1));
			else str.append(C);
		}
		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Compression().compress("abb67775ccc")); //prints: abb63753c
		System.out.println(new Compression().compress("aabddc")); //prints: aabddc
		System.out.println(new Compression().compress("AaaABbbcdefGG")); //prints: 4a3bcdefGG
	}
}
