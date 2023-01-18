import java.util.Scanner;
import java.util.regex.Pattern;

/*题目描述
* 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
* 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
* 返回容器可以储存的最大水量。
* 输入：[1,8,6,2,5,4,8,3,7]
* 输出：49
* */

public class L11MaxMultiply {
    public static void main(String[] args) {
        System.out.println("输入水量数组，空格间隔开数字！");
        Scanner input = new Scanner(System.in);
        String strOld = input.nextLine();
        Pattern pattern = Pattern.compile("[0-9|\\s]*");
        if (!pattern.matcher(strOld).matches()){
            System.out.println("请检查输入！");
            return;
        }

        String[] str = strOld.split(" ");
        int[] height = new int[str.length];
        for (int i = 0; i < height.length; i++){
            height[i] = Integer.valueOf(str[i]);
        }
        int maxArea = maxArea(height);
        System.out.println("水量最大为：" + maxArea);
    }
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            int minH = Math.min(height[left], height[right]);
            int area = minH * (right - left);
            maxArea = area > maxArea ? area : maxArea;
            while (height[left] <= minH && left < right){
                left++;
            }
            while (height[right] <= minH && left < right){
                right--;
            }
        }
        return maxArea;
    }
}

