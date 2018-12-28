package Source;

import Sync.ConsoleWriter;
import Sync.Writer;

import java.util.concurrent.*;


/**
 * Created by pradeep.joshi on 13/10/18.
 */
public class LoggerImpl implements Logger {

    Mode mode ;
    Writer writer ;
    public static final ExecutorService threadPoolExecutor =
            new ThreadPoolExecutor(
                    PoolConfig.minPool,
                    PoolConfig.maxPool,
                    PoolConfig.keepAliveTime,
                    TimeUnit.MILLISECONDS,
                    new SynchronousQueue<Runnable>(), new DefaultThreadFactory("LOG")
            );



    public LoggerImpl() {
        mode = Mode.INFO;
        writer = new ConsoleWriter();
    }

    public LoggerImpl(Mode mode, Writer writer) {
        this.mode = mode;
        this.writer = writer;
    }

    public void info(Object log) {
        if( mode == Mode.DEBUG || mode == Mode.INFO ){

            threadPoolExecutor.submit(() -> {
                writer.write("info : " +log);
                return;
            });


        }
    }

    public void debug(Object log) {
        if( mode == Mode.DEBUG ){
            threadPoolExecutor.submit(() -> {
                writer.write("debug : " + log);
                return;
            });

        }
    }

    public void error(Object log) {
        threadPoolExecutor.submit(() -> {
            writer.write("error : " +log);
            return;
        });


    }
}
