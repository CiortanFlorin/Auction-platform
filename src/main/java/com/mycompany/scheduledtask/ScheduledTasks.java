package com.mycompany.scheduledtask;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.mycompany.auction.AuctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    private AuctionService auctionService;

//    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
//
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        auctionService.checkForEnding();
    }
}
