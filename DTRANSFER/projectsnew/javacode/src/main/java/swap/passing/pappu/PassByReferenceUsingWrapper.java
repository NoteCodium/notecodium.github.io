package projectsnew.javacode.src.main.java.swap.passing.pappu;

import passing.lappu.IntWrapper;

class PassByReferenceUsingWrapper {
    private static void modifyValue(IntWrapper wrapper) {
        wrapper.value = 20;
    }

    public static void main(String[] args) {
        IntWrapper wrapper = new IntWrapper(12);
        System.out.println("Before: " + wrapper.value); // Output: 10
        modifyValue(wrapper);
        System.out.println("After: " + wrapper.value);  // Output: 20
    }
}
  