/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annotationtest;

/**
 *
 * @author claudio
 */
public class AnnotationTest {

    @Useful
    static class MyClass {
    }

    @Useful(isUseful = "true")
    static class TorvaldsClass {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Object[] list = {
            new MyClass(),
            new TorvaldsClass(),
            new Object()
        };

        for (Object c : list) {
            if (c.getClass().isAnnotationPresent(Useful.class)) {
                Useful ann = c.getClass().getAnnotation(Useful.class);
                if (ann.isUseful().equals("true")) {
                    System.out.println(c.getClass().toString() + " is useful");
                } else {
                    System.out.println(c.getClass().toString() + " is useless");
                }

            } else {
                System.out.println(c.getClass().toString() + "is not annotated");
            }
        }
    }

}
