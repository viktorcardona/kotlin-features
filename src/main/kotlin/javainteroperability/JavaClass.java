package javainteroperability;

public class JavaClass {

    public static void main(String[] args) {
        System.out.println("Calling a kotlin function from Java!");
        System.out.println(KotlinFileKt.function());
        System.out.println(Util.functionV2());
    }

}
