package com.win.slark.lastshadow.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Component
public class EventPublish {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void publish(OrderIssueBean message) {
        IssueEvent issueEvent = new IssueEvent(message);
        eventPublisher.publishEvent(issueEvent);
    }
}
