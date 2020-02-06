package br.com.arquivei.shared;

import feign.FeignException;

import java.util.Optional;
import java.util.function.Supplier;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public final class FeignUtils {

    private FeignUtils() {
    }

    public static <T> Optional<T> catchFeignException(Supplier<T> supplier) {
        try {
            T response = supplier.get();
            return ofNullable(response);
        } catch (FeignException e) {
            if (NOT_FOUND.value() == e.status() || BAD_REQUEST.value() == e.status()) {
                return empty();
            }

            throw e;
        }
    }

}
