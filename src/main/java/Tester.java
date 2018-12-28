import Source.Logger;
import Source.LoggerImpl;
import Source.Mode;
import Sync.ConsoleWriter;
import Sync.Writer;

/**
 * Created by pradeep.joshi on 13/10/18.
 */


public class Tester {

    public static void main(String[] args) throws InterruptedException {
        Writer consoleWriter = new ConsoleWriter();
        Logger logger = new LoggerImpl(Mode.DEBUG, consoleWriter) ;

        //all 3 will print...
        System.out.println("set DEBUG MODE.....");
        logger.debug("DEBUG the world!!!");
        logger.info("INFO the world!!!");
        logger.error("ERROR the world!!!");
        Thread.sleep(5000l);
        System.out.println();

        logger = new LoggerImpl(Mode.INFO, consoleWriter) ;

        //INFO & ERROR will print...
        System.out.println("set INFO MODE.....");
        logger.debug("DEBUG the world!!!");
        logger.info("INFO the world!!!");
        logger.error("ERROR the world!!!");
        Thread.sleep(5000l);
        System.out.println();


        logger = new LoggerImpl(Mode.ERROR, consoleWriter) ;

        //ERROR will print...
        System.out.println("set ERROR MODE.....");
        logger.debug("DEBUG the world!!!");
        logger.info("INFO the world!!!");
        logger.error("ERROR the world!!!");

    }
}
