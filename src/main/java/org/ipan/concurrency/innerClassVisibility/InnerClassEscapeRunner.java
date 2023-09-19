package org.ipan.concurrency.innerClassVisibility;

public class InnerClassEscapeRunner {

    public static void main(String[] args) {
        OuterClass oc1 = new OuterClass();
        OuterClass.InnerClass in = oc1.new InnerClass();
        OuterClass.InnerStaticClass inS = new OuterClass.InnerStaticClass();

        // inner class will have something like this$0 field which is a reference to the outer class
        in.printStates();
        inS.printStates();
    }
}
