package ps.demo.common;

import com.google.common.base.Preconditions;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;

public class AtTool {

    public static void callUntil(Callable<Boolean> booleanCallable) {
        callUntil(booleanCallable, 300);
    }

    public static void callUntil(Callable<Boolean> booleanCallable, int seconds) {
        Preconditions.checkArgument(seconds > 0, "Timeout setting should > 0");
        Awaitility.await()
                .timeout(seconds, TimeUnit.SECONDS)
                .pollDelay(1, TimeUnit.SECONDS)
                .pollInterval(Duration.ofSeconds(5))
                .until(booleanCallable);
    }
}
