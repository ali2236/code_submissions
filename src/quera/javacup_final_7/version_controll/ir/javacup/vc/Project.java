package quera.javacup_final_7.version_controll.ir.javacup.vc;

import java.util.HashMap;
import java.util.Map;

final public class Project {
    private String name;
    private int version;
    private Map<String,StringBuilder> sourceCodes;

    public Project(String name, int initVersion) {
        this.name = name;
        this.version = initVersion;
        sourceCodes = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public Map<String, StringBuilder> getSourceCodes() {
        return sourceCodes;
    }

}
