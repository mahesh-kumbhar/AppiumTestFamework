package utilitys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtility
{
    protected static String dateTime ;


    public String getDateTime()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date();
        dateTime= dateFormat.format(date);
        return dateTime;
    }

}
