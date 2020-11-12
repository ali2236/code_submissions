package quera.javacup_final_7.version_controll.ir.javacup.vc;

public class Main {
	
	public static void main(String[] args) {
		Project rms = new Project("Report Management System", 1);
		rms.getSourceCodes().put("A", new StringBuilder("public class A"));
		rms.getSourceCodes().put("B", new StringBuilder("public class B"));
		
		VersionControl git = new VersionControl(rms);
		Project snapshot = git.takeSnapshot();
		
		rms.setName("RMS");
		rms.setVersion(2);
		rms.getSourceCodes().get("A").append(" extends B");
		
		System.out.println("*****snapshot*****");
		System.out.println("name: " + snapshot.getName());
		System.out.println("version: " + snapshot.getVersion());
		System.out.println("file A: " + snapshot.getSourceCodes().get("A"));
		
		System.out.println("*****rms*****");
		System.out.println("name: " + rms.getName());
		System.out.println("version: " + rms.getVersion());
		System.out.println("file A: " + rms.getSourceCodes().get("A"));
		
		git.goBack();
		snapshot.getSourceCodes().get("A").append("implements C");
		
		System.out.println("*****rms after goBack*****");
		System.out.println("name: " + rms.getName());
		System.out.println("version: " + rms.getVersion());
		System.out.println("file A: " + rms.getSourceCodes().get("A"));
	}

}
