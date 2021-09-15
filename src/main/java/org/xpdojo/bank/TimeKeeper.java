package org.xpdojo.bank;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeKeeper {
    private LocalDateTime time;


    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
