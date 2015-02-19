
package org.robovm.bindings.splunkmint;

import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class TrStart extends SPLTransaction {

    /** Creates a new TrStart instance.
     *
     * @param transactionName The name of the transaction.
     * @param anAppEnvironment A MintAppEnvironment instance.
     * @param aPerformance A MintPerformance instance.
     *
     * @return A reference to the TrStart instance. */
    @Method(selector = "getInstanceWithTransactionName:appEnvironment:andPerformance:")
    public static native TrStart getInstance (String transactionName, MintAppEnvironment anAppEnvironment,
        MintPerformance aPerformance);

    @Method(selector = "isJSONTrStart:")
    public static native boolean isJSONTrStart (String json);

}
