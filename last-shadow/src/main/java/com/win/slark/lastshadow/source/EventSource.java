package com.win.slark.lastshadow.source;

public class EventSource {

    private EventListener eventListener;

    public EventListener getEventListener() {
        return eventListener;
    }

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }


    public void notifyListener(SendMqEvent sendMqEvent) {
        eventListener.handleEvent(sendMqEvent);

    }
}
