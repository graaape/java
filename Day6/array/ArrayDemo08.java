package array;

public class ArrayDemo08 {
    public static void main(String[] args) {
        //1.创建一个二维数组11*11 0：没有棋子 1：黑棋 2：白棋
        int[][]array1=new int[11][11];
        array1[1][2]=1;
        array1[2][3]=2;
        System.out.println("输出原始的数组");
        for (int[] ints : array1) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        //转换为稀疏数组保存
        //获取有效值的个数
        int sum=0;
        for (int i = 0; i <11 ; i++) {
            for (int j = 0; j <11 ; j++) {
                if(array1[i][j]!=0){
                    sum++;
                }
            }
        }
        int[][]array2=new int[sum+1][3];
        array2[0][0]=11;
        array2[0][1]=11;
        array2[0][2]=sum;
        //遍历二维数组，将非零的值存放在稀疏数组中
        int cnt=0;
        for (int i = 0; i < array1.length ; i++) {
            for (int j = 0; j < array1[i].length ; j++) {
                if(array1[i][j]!=0){
                    cnt++;
                    array2[cnt][0]=i;
                    array2[cnt][1]=j;
                    array2[cnt][2]=cnt;
                }
            }
        }
        //输出稀疏数组
        System.out.println("输出稀疏数组");
        for (int[] ints : array2) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
        System.out.println("=============");
        System.out.println("还原");
        //1.读取稀疏数组
        int[][]array3=new int[array2[0][0]][array2[0][1]];
        //2.还原元素的值
        for (int i = 1; i < array2.length ; i++) {
            array3[array2[i][0]][array2[i][1]]=array2[i][2];
        }
        //3.打印
        for (int[] ints : array3) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}
