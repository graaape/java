package array;

public class ArrayDemo05 {
    public static void main(String[] args) {
        /*
        1,2
        2,3
        3,4
        4,5
         */
        int[][]array={{1,2},{2,3},{3,4},{4,5}};
//        System.out.println(array.length);
//        System.out.println(array[0].length);
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length ; j++) {
                System.out.println(array[i][j]);
            }
        }
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
