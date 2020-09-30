package putting;

import payment.ParametersPayment;

import java.util.concurrent.BlockingQueue;

public class QueuePutting implements Putting {
    private BlockingQueue<ParametersPayment> queue;

    public QueuePutting( BlockingQueue<ParametersPayment> queue ){
        this.queue = queue;
    }

    @Override
    public void putPayment(ParametersPayment parametersPayment){
        try {
            queue.put(parametersPayment);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

////
