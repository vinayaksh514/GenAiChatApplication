package com.epam.training.gen.ai.model;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import reactor.core.publisher.Mono;

/**
 * The Reactive interface provides utility methods for working with reactive
 * programming paradigms. It is designed to facilitate the integration of asynchronous
 * computations often encountered in reactive systems.
 * <p>
 * The default implementation of the interface includes a method to convert a
 * {@link ListenableFuture ListenableFuture}
 * into a {@link Mono Mono}, a reactive type in Project Reactor.
 * This allows seamless integration between Guava's asynchronous utilities
 * and Reactive Streams.
 * <p>
 * The conversion ensures proper propagation of success and failure signals
 * from the ListenableFuture to the Mono sink.
 *
 * @param <T> the type of result produced by the Mono
 */
public interface Reactive {

    /**
     * Converts an instance of {@link ListenableFuture} into a {@link Mono}.
     * This allows bridging between Guava's asynchronous utilities and Project Reactor's
     * reactive programming model.
     *
     * @param <T>    the type of the result contained in the ListenableFuture and the resulting Mono
     * @param future the ListenableFuture to be converted into a Mono; must not be null
     * @return a Mono that emits the value of the future upon completion or propagates
     * an error if the future fails
     */
    default <T> Mono<T> toMono(ListenableFuture<T> future) {
        return Mono.create(sink ->
                Futures.addCallback(future, new FutureCallback<>() {
                    @Override
                    public void onSuccess(T result) {
                        sink.success(result);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        sink.error(t);
                    }
                }, MoreExecutors.directExecutor())
        );
    }
}
