package info.novatec;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.impl.el.FixedValue;
import org.springframework.stereotype.Component;

@Component
//@Scope(value = "prototype")
public class MyService {

    private FixedValue x;

    public void hello2(DelegateExecution execution) {
        System.err.println("hello");
        // Nullpointer in the next line because x is not injected when using a Service Task with Implementation "Expression".
        System.err.println(x.getExpressionText());
    }

    public FixedValue getX() {
        return x;
    }

    public void setX(FixedValue x) {
        this.x = x;
    }
}
