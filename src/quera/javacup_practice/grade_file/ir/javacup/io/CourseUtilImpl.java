package quera.javacup_practice.grade_file.ir.javacup.io;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

public class CourseUtilImpl implements CourseUtil{

    private ByteArrayOutputStream outputStream;
    private List<Grade> grades;

    @Override
    public void setOutputStream(ByteArrayOutputStream out) {
        byte[] bytes = out.toByteArray();
        String source = new String(bytes);
        String[] lines = source.split("\n");
        grades = new ArrayList<>(lines.length);
        for(String line: lines){
            String[] parts = line.split(" ");

            String studentId = parts[0];
            int courseCode = Integer.parseInt(parts[1]);
            double score = Double.parseDouble(parts[2]);

            Grade grade = new Grade();

            grade.setStudentId(studentId);
            grade.setCourseCode(courseCode);
            grade.setScore(score);

            grades.add(grade);
        }
        this.outputStream = out;
    }

    @Override
    public Grade load(int lineNumber) {
        if(lineNumber > count()) return null;
        return grades.get(lineNumber-1);
    }

    @Override
    public void save(Grade score) {
        boolean dup = grades.stream().anyMatch(grade -> grade.equals(score));
        if(dup) return;
        String str = String.format("%s %d %f",score.getStudentId(), score.getCourseCode(), score.getScore());
        try {
            outputStream.write(str.getBytes());
            grades.add(score);
        } catch (Exception ignored){}
    }

    @Override
    public double calcCourseAverage(int courseCode) {
         double[] courseG = grades.stream().filter(grade -> grade.getCourseCode() == courseCode).mapToDouble(Grade::getScore).toArray();
         return DoubleStream.of(courseG).reduce(Double::sum).getAsDouble() / courseG.length;
    }

    @Override
    public double calcStudentAverage(String studentId) {
        double[] courseG = grades.stream().filter(grade -> grade.getStudentId().equals(studentId)).mapToDouble(Grade::getScore).toArray();
        return DoubleStream.of(courseG).reduce(Double::sum).getAsDouble() / courseG.length;
    }

    @Override
    public int count() {
        return grades.size();
    }
}
