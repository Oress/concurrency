package org.ipan.concurrency.innerClassVisibility;

public class OuterClass {
    private boolean state1 = true;
    private int state2 = 23;


    public class InnerClass {
        private boolean state1 = false;
        private int state2 = 42;

        public void printStates() {
            System.out.println("OuterClass.state1: " + OuterClass.this.state1);
            System.out.println("OuterClass.state2: " + OuterClass.this.state2);
            System.out.println("InnerClass.state1: " + state1);
            System.out.println("InnerClass.state2: " + state2);
        }
    }

    public static class InnerStaticClass {
        private boolean state1 = false;
        private int state2 = 42;

        public void printStates() {
            System.out.println("InnerClass.state1: " + state1);
            System.out.println("InnerClass.state2: " + state2);
        }
    }

}
