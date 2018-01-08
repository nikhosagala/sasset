package id.openbox.sasset.filters;

import akka.util.ByteString;
import play.Logger;
import play.libs.streams.Accumulator;
import play.mvc.EssentialAction;
import play.mvc.EssentialFilter;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.concurrent.Executor;

/**
 * Created by nikhosagala on 19/09/2017.
 */
public class Filters extends EssentialFilter {
    private final Executor executor;

    /**
     * @param executor This class is needed to execute code asynchronously.
     */
    @Inject
    public Filters(Executor executor) {
        super();
        this.executor = executor;
    }

    @Override
    public EssentialAction apply(EssentialAction next) {
        return EssentialAction.of(request -> {
            long startTime = System.currentTimeMillis();
            Accumulator<ByteString, Result> accumulator = next.apply(request);
            return accumulator.map(result -> {
                long endTime = System.currentTimeMillis();
                long requestTime = endTime - startTime;

                Logger.info("{} {} took {}ms and returned {}",
                        request.method(), request.uri(), requestTime, result.status());
                return result.withHeaders("Request-Time", requestTime + "ms");
            }, executor);
        });
    }
}
