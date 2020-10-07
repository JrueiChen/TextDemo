package untitled;

import java.time.temporal.Temporal;
import java.util.Scanner;

//     用来存放大数的顺序表
class ArrayNumber {
    int[] number;
    int curLen = 0;

    //    初始化顺序表
    ArrayNumber(String number) {
        number2arr(number);
    }

    ArrayNumber() {
    }

/*    //    一开始采用的是long类型数字，发现并不能满足数字无限大的情况
    //    后来采用字符串转字符数组再装数字数组
    ArrayNumber(long number) {
        this.curLen = howManyNumber(number);
        number2arr(number);
    }*/

    //    将数字装换为顺序表（为了方便计算，采用倒序，比如12345在数组里是[5 4 3 2 1]）
    public void number2arr(String num) {
        char[] a = num.toCharArray();
        number = new int[a.length];
        curLen = a.length;
        for (int i = 0; i < a.length; i++) {
            number[i] = a[i] - '0';
        }
        reverseArr();
    }

/*    //    将数字装换为顺序表（为了方便计算，采用倒序，比如12345在数组里是54321）
    public void number2arr(long num) {
        number = new int[(int) (curLen * 1.5)];
        for (int i = 0; i < curLen; i++) {
            number[i] = (int) num % 10;
            num /= 10;
        }
    }

    //    判断数字是几位数构成的
    public int howManyNumber(long number) {
        int i;
        for (i = 0; number > 0; i++) {
            number /= 10;
        }
        return i;
    }*/

    //    扩大顺序表容量
    public void enlargeArr() {
        int[] temp = number;
        number = new int[curLen * 2];
        for (int n = 0; n < curLen; n++) {
            number[n] = temp[n];
        }
    }

    //    缩小顺序表容量
    public void reduceArr() {
        int[] temp = number;
        number = new int[curLen * 2];
        for (int n = 0; n < curLen; n++) {
            number[n] = temp[n];
        }
    }

    //    判断是否需要改变顺序表容量
    public void judgeArr() {
        if (number.length <= curLen + 3) {
            enlargeArr();
        } else if (number.length >= curLen * 3) {
            reduceArr();
        }
    }

    //    重写toString方法
    @Override
    public String toString() {
        if (judge0()) {
            return "0一共有0个有效数字。";
        } else {
            reverseArr();
            StringBuilder stringArr = new StringBuilder();
            for (int i = 0; i < curLen; i++) {
                stringArr.append(number[i]);
            }
            String cur = "\n一共有" + curLen + "个有效数字。";
            return stringArr.toString() + cur;
        }
    }

    //    判断数组是否全为0
    public boolean judge0() {
        return number[curLen - 1] == 0;
    }

    //    翻转数组
    public void reverseArr() {
        int temp;
        for (int i = 0; i < curLen/2; i++) {
            temp = number[i];
            number[i] = number[curLen-1-i];
            number[curLen-1-i] = temp;
        }
    }
}

//顺序表的计算方法
class ComputeMethod {

    //    乘法运算
    public static ArrayNumber multiply(ArrayNumber arr1, ArrayNumber arr2) {
    //    新建一个用来储存结果的数组
        ArrayNumber arr = new ArrayNumber();
        if (arr1.curLen > arr2.curLen) {
            arr.number = new int[arr1.number.length * 2];
        } else {
            arr.number = new int[arr2.number.length * 2];
            }

    //    乘积主要运算算法
        int i, h, k, carry = 0, transNum;
        for (i = 0; i < arr1.curLen; i++) {
            for (h = 0, k = i; h < arr2.curLen; k++, h++) {
                transNum = arr.number[k] + arr2.number[h] * arr1.number[i] + carry;
                arr.number[k] = transNum % 10;
                carry = transNum / 10;
                arr.curLen = k + 1;
            }
            if (carry != 0) {
                arr.number[k] = carry;
                arr.curLen = k + 1;
                carry = 0;
            }
            arr.judgeArr();
        }
        return arr;
    }
}

public class ArrayListCompute {
    public static void main(String[] args) {
        System.out.println("欢迎使用超级大数乘积系统！");
        String s1="1234567",s2="89";

//        System.out.println("请在下方输入你想进行乘积运算的两个超级大数（只能是整数）：");
//        Scanner sc =new Scanner(System.in);
//        s1=sc.nextLine();
//        s2=sc.nextLine();

        ArrayNumber arr = ComputeMethod.multiply(new ArrayNumber(s1), new ArrayNumber(s2));
        System.out.println(s1+"和"+s2+"的乘积为：\n"+arr.toString());
    }
}