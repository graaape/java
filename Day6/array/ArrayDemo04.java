package array;

public class ArrayDemo04 {
    public static void main(String[] args) {
        int[] arrays={1,2,3,4,5};

        //JDK1.5 没有下标
        for (int array : arrays) {
            System.out.println(array);
        }
        printArray(arrays);
        printArray(reverse(arrays));
    }
    //打印数组元素
    public static void printArray (int[]arrays){
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i]+" ");
        }
        System.out.println();
    }
    //反转数组
    public static int[] reverse(int[]arrays){
        int[]res=new int[arrays.length];

        for (int i = 0,j= res.length-1; i < arrays.length ; i++,j--) {
            res[j]=arrays[i];
        }
        return res;
    }
}
