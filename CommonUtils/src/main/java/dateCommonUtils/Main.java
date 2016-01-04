package dateCommonUtils;

//import org.joda.time.format.DateTimeFormatter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * Created by liguodong on 2016/1/4.
 */
public class Main {

    public static void main(String[] args) {

        //DateTime dateTime=new DateTime(2012, 12, 13, 18, 23,55);
        //DateTimeFormatter format = DateTimeFormat.forPattern("dd//MM//yyyy:HH:mm:ss");
        //时间解析
        //DateTime dateTime2 = DateTime.parse("29//Dec//2015:23:59:59", format);

       /* String reg = "(\\d+)/([a-zA-Z]+)/(\\d+):(\\d+:\\d+:\\d+\\s+[+\\d]+)";


        String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
        String d1 = "05/Aug/2015:14:54:37 +0800";
        String m = d1.replaceAll(reg, "$2");
        int index = -1;
        for(int i = 0; i < months.length; i++)
        {
            if(m.equals(months[i]))
            {
                index = i + 1;
                break;
            }
        }
        String d2 = d1.replaceAll(reg, "$3-"+index+"-$1 $4");
        System.out.println(d2);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        try {
            System.out.println(sdf.parse(d2));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        /*
        System.out.println(DateUtils.Ngnix2CommonFormat("29/Dec/2015:23:59:59 +0800"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            System.out.println(sdf.parse(DateUtils.Ngnix2CommonFormat("29/Dec/2015:23:59:59 +0800")).toLocaleString());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        String tempString = DateUtils.ngnix2CommonFormat("29/Dec/2015:23:59:59 +0800");
        Date date = DateUtils.string2Date(tempString);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd HH:mm:ss");
        System.out.println(sdf.format(date));

        Date date1 = new Date(System.currentTimeMillis());
        Date date2 = new Date(System.currentTimeMillis()-1000);
        Date date3 = new Date(System.currentTimeMillis()+1000);
        DateUtils.compareDate(date1,date2);
        DateUtils.compareDate(date1,date3);
        DateUtils.compareDate(date1,date1);
    }
}
