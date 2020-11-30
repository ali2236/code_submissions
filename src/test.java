public class test {
    public static void main(String[] args) {
        int solution = 1;
        for (int i = 1; i < 256; i++) {
            for (int j = 1; j < 256; j++) {
                for (int k = 1; k < 256; k++) {
                    if(((i*j*k) + (i*j) + i)==2_000_000){
                        System.out.println((solution++)+": i=" +i+" j="+j+" k="+k);
                    }
                }
            }
        }
    }
}
