package taking;

import payment.PaymentParameters;

import java.util.concurrent.BlockingQueue;

public class QueueTaking implements Taking {
    private BlockingQueue<PaymentParameters> queue;

    public QueueTaking( BlockingQueue<PaymentParameters> queue ){
        this.queue = queue;
    }

    @Override
    public PaymentParameters takePayment(){
        try {
            return queue.take();
        } catch (InterruptedException ex) {
            //System.out.println(ex.getMessage());
            return null;
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            return null;
        }
    }

    @Override
    public void stopTaking(){
        try {
            queue.put(new PaymentParameters());
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

////