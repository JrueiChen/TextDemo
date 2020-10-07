package untitled;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class DateFormatTextDemo {
    public static void main(String[] args) throws ParseException {
        Text_1();
        Text_1();
    }

    public static void Text_1() throws ParseException {
        System.out.println("请输入你的生日：" +
                "格式为：XXXX年XX月XX日");
//        规定一个日期格式
        DateFormat a= DateFormat.getDateInstance(DateFormat.LONG);
//        按照格式输入一个日期
        Scanner sc =new Scanner(System.in);
        String Birthday=sc.nextLine();
//        将字符串日期按规则装换成系统可识别的时间
        Date BirthdayDate = a.parse(Birthday);

//        创建今天的时间并将时间装换为可计算的毫秒
//        Date TodayDate = new Date();
//        long TodayTime = TodayDate.getTime();

//        快捷方法：
        long TodayTime= System.currentTimeMillis();
        long BirthdayTime =BirthdayDate.getTime();


//        辨别是否未出生
        long day = TodayTime-BirthdayTime;
        if(day<0){
            System.out.println("你还没出生！");
        }else{
            System.out.println("你已经活了"+day/1000/60/60/24+"天");
        }

    }
}
