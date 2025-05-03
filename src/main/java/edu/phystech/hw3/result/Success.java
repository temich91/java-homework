package edu.phystech.hw3.result;

import java.util.function.Function;

/**
 * @author kzlv4natoly
 */
public record Success<T>(T value) implements Result<T> {

    @Override
    public boolean isFailure() {
        return false;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public T getOrDefault(T defaultValue) {
        return value;
    }

    @Override
    public Throwable getExceptionOrNull() {
        return null;
    }

    @Override
    public <R> Result<R> map(Function<T, R> transform) {
        return ResultUtil.execute(() -> transform.apply(value));
    }
}
