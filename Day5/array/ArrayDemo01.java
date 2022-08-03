package array;

public class ArrayDemo01 {
    public static void main(String[] args) {
        //声明数组
        int[] nums;
        int nums2[];
        //创建数组
        nums=new int[10];
        //给数组元素赋值
        for (int i = 0; i < 10; i++) {
            nums[i]=i+1;
        }
        //计算所有元素的和
        int sum=0;
        for(int x:nums){
            sum+=x;
        }
        System.out.println(sum);
    }
}
