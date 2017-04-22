package my.pack;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;

public class MyMessageConverter<T> extends AbstractHttpMessageConverter<T> {

    @Override
    protected boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    protected T readInternal(Class<? extends T> aClass, HttpInputMessage httpInputMessage)
            throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(T t, HttpOutputMessage httpOutputMessage)
            throws IOException, HttpMessageNotWritableException {
    }
}
