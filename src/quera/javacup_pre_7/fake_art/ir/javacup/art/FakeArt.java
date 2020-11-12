package quera.javacup_pre_7.fake_art.ir.javacup.art;

import java.lang.reflect.Method;

public class FakeArt {

    public <T> T fake(T original, String... props) throws Exception {
        if (original == null) throw new IllegalArgumentException();
        Class baseClass = original.getClass();
        Object copy = baseClass.newInstance();
        for (String prop : props) {
            Class tClass = baseClass;
            if (!prop.contains(".")) {
                copySingleProp(original, copy, prop, tClass);
            } else {
                String[] parts = prop.split("[.]");
                deepCopy(parts, tClass, original, copy);
            }
        }
        return (T) copy;
    }

    private void copySingleProp(Object original, Object copy, String prop, Class type) throws Exception {
        Method getter = type.getMethod(getMethodName(prop, "get"));
        Object value = getter.invoke(original);
        Method setter = type.getMethod(getMethodName(prop, "set"), getter.getReturnType());
        setter.invoke(copy, value);
    }

    private void deepCopy(String[] parts, Class wClass, Object wObjectO, Object wObjectC) throws Exception {
        for (int i = 0; i < parts.length; i++) {
            boolean lastPart = i == parts.length - 1;
            String part = parts[i];
            Method getter = wClass.getMethod(getMethodName(part, "get"));
            Class type = getter.getReturnType();
            Method setter = wClass.getMethod(getMethodName(part, "set"), type);

            if (lastPart) { // copy all
                setter.invoke(wObjectC, getter.invoke(wObjectO));
            } else { // check for subObject
                wObjectO = getter.invoke(wObjectO);
                if (wObjectO == null) break;
                Object result = getter.invoke(wObjectC);
                if (result == null) { // create subObject if needed
                    Object instance = type.newInstance();
                    setter.invoke(wObjectC, instance);
                    result = instance;
                }
                // go one step deeper
                wObjectC = result;
                wClass = wObjectO.getClass();
            }
        }
    }

    private String getMethodName(String name, String prefix) {
        String n = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        return prefix + n;
    }
}
