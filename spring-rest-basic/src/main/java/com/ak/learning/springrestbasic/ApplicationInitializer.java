package com.ak.learning.springrestbasic;

import com.ak.learning.springrestbasic.service.IPersonService;
import com.ak.learning.springrestbasic.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializer implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private IPersonService personService;

    @Autowired
    private ITaskService taskService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        personService.initialize();
        taskService.initialize();
    }
}
