
package org.robovm.bindings.splunkmint.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;
import org.robovm.bindings.splunkmint.ExtraData;
import org.robovm.bindings.splunkmint.LoggedRequestEventArgs;
import org.robovm.bindings.splunkmint.Mint;
import org.robovm.bindings.splunkmint.MintLogResult;
import org.robovm.bindings.splunkmint.MintNotificationDelegateAdapter;
import org.robovm.bindings.splunkmint.MintResultState;
import org.robovm.bindings.splunkmint.NetworkDataFixture;
import org.robovm.bindings.splunkmint.TransactionStartResult;
import org.robovm.bindings.splunkmint.TransactionStatus;
import org.robovm.bindings.splunkmint.TransactionStopResult;
import org.robovm.objc.block.VoidBlock1;
import org.robovm.rt.Signals;
import org.robovm.rt.Signals.InstallSignalsCallback;

public class Sample extends UIApplicationDelegateAdapter {
    public static final String MINT_API_KEY = "YOUR_API_KEY";

    @Override
    public boolean didFinishLaunching (UIApplication application, UIApplicationLaunchOptions launchOptions) {
        Signals.installSignals(new InstallSignalsCallback() {
            @Override
            public void install () {
                // If you want to include log messages:
                // Mint.getSharedInstance().enableLogging(true);
                // Mint.getSharedInstance().setLogging(8); // Change this to the number of lines you want to include

                // If you want to log for a specific user:
                // Mint.getSharedInstance().setUserIdentifier("MyUserIdentifier");

                // Init and start the SplunkMINT session.
                Mint.getSharedInstance().initAndStartSession(MINT_API_KEY);
            }
        });

        return true;
    }

    /*
     * The following methods demonstrate several functionalities of the SplunkMINT SDK.
     */

    public void handleTransaction () {
        final String transactionId = "MintTransaction";

        Mint.getSharedInstance().startTransaction(transactionId, new VoidBlock1<TransactionStartResult>() {
            @Override
            public void invoke (TransactionStartResult result) {
                System.out.println(String.format("Transaction with ID:%s %s", transactionId,
                    result.getTransactionStatus() == TransactionStatus.SuccessfullyStarted ? "started successfully"
                        : "failed to start"));
            }
        });

        /*
         * Continue your code...End the transaction so you can track that in your dashboard to resolve an issue or for monitoring.
         */
        Mint.getSharedInstance().stopTransaction(transactionId, new VoidBlock1<TransactionStopResult>() {
            @Override
            public void invoke (TransactionStopResult result) {
                System.out.println(String.format("Transaction with ID:%s %s", transactionId,
                    result.getTransactionStatus() == TransactionStatus.UserSuccessfullyStopped ? "stopped successfully"
                        : "failed to stop"));
            }
        });
    }

    public void logEvent () {
        Mint.getSharedInstance().logEventAsync("Log Custom Event tag", new VoidBlock1<MintLogResult>() {
            @Override
            public void invoke (MintLogResult result) {
                System.out.println(String.format("Log result: %s", result.getResultState() == MintResultState.OK ? "OK" : "Error"));
            }
        });
    }

    public void addCustomDataToCrashReports () {
        Mint.getSharedInstance().addExtraData(new ExtraData("Global Extra Key1", "Global Extra Value1"));
        // or
        Mint.getSharedInstance().getExtraDataList().add("test1", "testValue1");
    }

    public void addBreadcrumbsToCrashReports () {
        Mint.getSharedInstance().leaveBreadcrumb("InTheSettingsController");
    }

    public void removeAllBreadcrumbs () {
        Mint.getSharedInstance().clearBreadcrumbs();
    }

    public void disableLoggingForASpecificURL () {
        Mint.getSharedInstance().addURLToBlackList("www.facebook.com");
    }

    public void listenForInternalSDKActions () {
        Mint.getSharedInstance().setNotificationDelegate(new MintNotificationDelegateAdapter() {
            @Override
            public void loggedRequestHandled (LoggedRequestEventArgs args) {
                System.out.println(String.format("Processed logged client request: %s", args.getResponseResult()
                    .getClientRequest()));
                System.out.println(String.format("Server response: %s", args.getResponseResult().getServerResponse()));
            }

            @Override
            public void networkDataLogged (NetworkDataFixture networkData) {
                System.out.println(String.format("Network Data Logged: %s", networkData.toJSONString()));
            }
        });
    }

    public static void main (String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
}
