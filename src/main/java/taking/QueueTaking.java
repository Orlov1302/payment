package taking;

import payment.ParametersPayment;

import java.util.concurrent.BlockingQueue;

public class QueueTaking implements Taking {
    private BlockingQueue<ParametersPayment> queue;

    public QueueTaking( BlockingQueue<ParametersPayment> queue ){
        this.queue = queue;
    }

    @Override
    public ParametersPayment takePayment(){
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
            queue.put(new ParametersPayment());
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

////