package quera.javacup_final_7.version_controll.ir.javacup.vc;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

public class VersionControl {

	private final Project project;

	public VersionControl(Project project) {
		this.project = project;
	}

	final private Deque<Project> snapshots = new LinkedList<>();

	public Project takeSnapshot() {
		Project snapshot = new Project(project.getName(),project.getVersion());
		copyProject(project, snapshot);
		snapshots.push(snapshot);
		return snapshot;
	}

	public void goBack() {
		if(snapshots.size()==0) return;
		Project snapshot = snapshots.pop();
		project.setName(snapshot.getName());
		project.setVersion(snapshot.getVersion());
		copyProject(snapshot, project);
	}

	static void copyProject(Project p1, Project p2){
		Map<String, StringBuilder> otherCodes = p2.getSourceCodes();
		otherCodes.clear();
		p1.getSourceCodes().forEach( (file, source) -> {
			String ss = source.toString();
			StringBuilder str = new StringBuilder(ss.length());
			str.append(ss);
			otherCodes.put(file, str);
		});
	}
}
