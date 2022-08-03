package struct;

public class SwitchDemo02 {
    public static void main(String[] args) {
        String name="小明";
        switch (name){
            case "小明":
                System.out.println("小明");
                break;
            case "小红":
                System.out.println("小红");
                break;
            default:
                System.out.println("不存在");
        }
    }
}
