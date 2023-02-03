package ir.mapsa.javacourse.etc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

public class Main {
    @Method(param = {"args", "param"})
    public static void main(String[] args) {
        Arrays.stream(Main.class.getDeclaredMethods())
                .filter(i->i.getName().equals("main"))
                .forEach(i-> {
                    Arrays.stream(i.getAnnotations())
                            .forEach(a-> System.out.println(Arrays.toString(((Method) a).param())));
                });
    }
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Method {
    String name() default "main";

    String[] param();
}
