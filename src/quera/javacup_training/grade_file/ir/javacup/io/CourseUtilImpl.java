package quera.javacup_training.grade_file.ir.javacup.io;

import java.io.ByteArrayOutputStream;

public class CourseUtilImpl implements CourseUtil{

    private ByteArrayOutputStream outputStream;
    private byte[] data;

    @Override
    public void setOutputStream(ByteArrayOutputStream out) {
        this.outputStream = out;
        this.data = outputStream.toByteArray();
    }

    @Override
    public Grade load(int lineNumber) {
        Grade grade = new Grade();
        return grade;
    }

    @Override
    public void save(Grade score) {

    }

    @Override
    public double calcCourseAverage(int courseCode) {
        return 0;
    }

    @Override
    public double calcStudentAverage(String studentId) {
        return 0;
    }

    @Override
    public int count() {
        return (data.length + 1) / 15;
    }
}
