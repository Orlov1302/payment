package putting;

import payment.PaymentParameters;

import java.util.concurrent.BlockingQueue;

public class QueuePutting implements Putting {
    private BlockingQueue<PaymentParameters> queue;

    public QueuePutting( BlockingQueue<PaymentParameters> queue ){
        this.queue = queue;
    }

    @Override
    public void putPayment(PaymentParameters paymentParameters){
        try {
            queue.put(paymentParameters);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

////
