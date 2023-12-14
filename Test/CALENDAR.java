import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CALENDAR {
    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());

//获取后一天
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(calendar.getTime()).toString());;


        Timestamp ts = new Timestamp(System.currentTimeMillis());
        //String dte = ts.toString().substring(0, 10);
        String dte = ts.toString().substring(11, 19);

        System.out.println("20:15:00".compareTo(dte));

        //String dte = "2023-03-01";
        Calendar cal = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dte);
        }catch (Exception e){
            System.out.println("转换出错");
            return;
        }
        cal.setTime(date);
        int day = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, day - 1);
        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        System.out.println(dayBefore);
    }
}
