package com.win.slark.lastshadow.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener implements ApplicationListener<IssueEvent> {



    @Override
    public void onApplicationEvent(IssueEvent issueEvent) {

    }
}
