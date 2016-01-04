package dateCommonUtils;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by liguodong on 2016/1/4.
 */
public class DateUtils {

    private DateUtils(){}

    /**
     * Ngnix日期格式转换
     * @param inputData
     * @return
     */
    public static String ngnix2CommonFormat(String inputData){

        String outputData=null;

        //正则表达式匹配
        //参考：String reg = "(\\d+)/([a-zA-Z]+)/(\\d+):(\\d+:\\d+:\\d+\\s+[+\\d]+)";

        String regString = "(\\d{2})/([a-zA-Z]{3})/(\\d{4}):(\\d{2}:\\d{2}:\\d{2}\\s+[+]\\d{4})";

        String[] months = { "Jan", "Feb", "Mar",
                "Apr", "May", "Jun",
                "Jul", "Aug", "Sep",
                "Oct", "Nov", "Dec"
        };

        //String d1 = "05/Aug/2015:14:54:37 +0800";


        String m = inputData.replaceAll(regString, "$2");

        //System.out.println("m:"+m);

        //计算月份
        int index = -1;
        for(int i = 0; i < months.length; i++)
        {
            if(m.equals(months[i]))
            {
                index = i + 1;
                break;
            }
        }

        //$1:日
        //$2:月
        //$3:年
        //$4:时分秒
        outputData = inputData.replaceAll(regString, "$3-"+index+"-$1 $4");

        //System.out.println("Method Inner Test:"+outputData);
        return outputData;
    }


    //字符串转日期格式
    public static Date string2Date(String input){
        Date output = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        try {
            output = sdf.parse(input);//转换
            //System.out.println("Method Inner Test:"+sdf.format(output));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return output;
    }


    /**
     * 比较日期的大小
     * @param date1
     * @param date2
     * @return  当date1大于date2，返回1;
     *          当date1小于date2，返回-1;
     *          当date1等于date2，返回0;
     */
    public static int compareDate(Date date1,Date date2){
        int temp = date1.compareTo(date2);
        //System.out.println("Method Inner Test:"+temp);
        return temp;
    }


}
