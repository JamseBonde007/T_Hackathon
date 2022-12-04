package com.thackathon.mim.thk.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

@Service
public class SampleJmsErrorHandler implements ErrorHandler {

    private final Logger log = LoggerFactory.getLogger(SampleJmsErrorHandler.class);

    @Override
    public void handleError(Throwable t) {
        log.warn("In default jms error handler...");
        log.info("Error Message : {}", t.getMessage());
    }

}
