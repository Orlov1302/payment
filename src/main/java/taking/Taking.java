package taking;

import payment.PaymentParameters;

public interface Taking {
    public PaymentParameters takePayment();
    public void stopTaking();
}

