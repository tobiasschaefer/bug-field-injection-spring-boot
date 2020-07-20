package info.novatec;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Init {

    @Autowired
    RuntimeService runtimeService;

    @PostConstruct
    public void init() throws InterruptedException {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runtimeService.startProcessInstanceByKey("Process");
            }
        }.start();

    }
}
