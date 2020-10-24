//package quera.javacup_training.copy_with_reflection.ir.javacup.reflection;
package ir.javacup.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Copier {

/*
    public static void main(String[] args) {
        Copier c = new Copier("id");
        PP p1 = new PP();
        p1.setName(54245451);
        p1.setId(455454521);
        PP p2 = new PP();
        p2.setId(2);
        p2.setName(1);
        c.copy(p1, p2);
        System.out.println(p2);
    }
*/

    final private String[] parameters;

    public Copier(String... parms) {
        parameters = parms;
    }

    public void copy(Object o1, Object o2) {
        try {
            List<Method> methods = Stream.of(o1.getClass().getMethods()).filter(method -> method.getName().startsWith("get")).collect(Collectors.toList());
            List<Method> other = Stream.of(o2.getClass().getMethods()).filter(method -> method.getName().startsWith("set")).collect(Collectors.toList());
            if (parameters != null && parameters.length > 0) {
                methods = methods.stream().filter(method -> Arrays.stream(parameters).anyMatch(name -> name.equals(methodNameToName(method.getName())))).collect(Collectors.toList());
            }
            for (Method method : methods) {
                String name = methodNameToName(method.getName());
                String setterName = nameToMethodName("set", name);
                o2.getClass().getMethod(setterName, method.getReturnType()).invoke(o2, method.invoke(o1));
            }
        } catch (Exception ignored) {
        }
    }

    private String methodNameToName(String methodName) {
        String a = methodName.substring(3);
        String b = String.valueOf(a.charAt(0));
        String c = b.toLowerCase();
        String d = a.replaceFirst(b, c);
        return d;
    }

    private String nameToMethodName(String prefix, String name) {
        String s = name.substring(0, 1).toUpperCase() + name.substring(1);
        return prefix + s;
    }
}

/*
class PP {
    private int name, id;

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}*/
