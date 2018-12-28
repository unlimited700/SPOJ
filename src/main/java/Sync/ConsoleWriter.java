package Sync;

/**
 * Created by pradeep.joshi on 13/10/18.
 */
public class ConsoleWriter implements Writer {
    public void write(Object log) {
        System.out.println(log.toString());
    }
}
