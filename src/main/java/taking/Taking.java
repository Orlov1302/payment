package taking;

import payment.ParametersPayment;

public interface Taking {
    public ParametersPayment takePayment();
    public void stopTaking();
}

////