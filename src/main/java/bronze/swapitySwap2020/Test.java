package bronze.swapitySwap2020;

public class Test {
    public static void main(String[] args) {
        SwapitySwap swapitySwap = new SwapitySwap();
        int[] a1 = {1,2,3};
        int[] a2 = {1,2,3,4};
        swapitySwap.reverse(a1,1,3);
        swapitySwap.reverse(a2,1,4);
        swapitySwap.printArray(a1);
        swapitySwap.printArray(a2);
    }
}
