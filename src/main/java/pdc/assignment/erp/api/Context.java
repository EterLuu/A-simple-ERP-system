package pdc.assignment.erp.api;

public class Context {

    private Context(){
        throw new IllegalStateException("Utility class");
    }

    public static final String TIMEFORMAT = "dd MMM yyyy HH:mm:ss z";
    public static final String CURRENCYSYMBOL = "$";
}
