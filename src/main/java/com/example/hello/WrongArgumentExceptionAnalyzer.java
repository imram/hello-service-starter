package com.example.hello;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * Created by Ram Gupta on 5/14/2017.
 */
public class WrongArgumentExceptionAnalyzer extends AbstractFailureAnalyzer<WrongArgumentException> {
    @Override
    protected FailureAnalysis analyze(Throwable throwable, WrongArgumentException e) {
        return new FailureAnalysis(
                "Oops! you have used wrong name as " ,
                "You should change hello input to Ram",
                e);

    }
}
