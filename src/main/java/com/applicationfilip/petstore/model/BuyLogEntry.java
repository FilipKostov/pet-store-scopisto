package com.applicationfilip.petstore.model;

import java.time.LocalDateTime;

public class BuyLogEntry {
    private LocalDateTime timestamp;
    private int successfulBuyers;
    private int failedBuyers;

    public BuyLogEntry(LocalDateTime timestamp, int successfulBuyers, int failedBuyers) {
        this.timestamp = timestamp;
        this.successfulBuyers = successfulBuyers;
        this.failedBuyers = failedBuyers;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getSuccessfulBuyers() {
        return successfulBuyers;
    }

    public int getFailedBuyers() {
        return failedBuyers;
    }
}
