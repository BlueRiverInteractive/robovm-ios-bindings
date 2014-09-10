
package org.robovm.bindings.gamecenter;

import java.util.ArrayList;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.foundation.NSError;
import org.robovm.apple.gamekit.GKAchievement;
import org.robovm.apple.gamekit.GKLeaderboard;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UIControl;
import org.robovm.apple.uikit.UIControl.OnTouchUpInsideListener;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UIEvent;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UIView;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.apple.uikit.UIWindow;

/** Sample usage of GameKit framework */
public class Sample extends UIApplicationDelegateAdapter {

    private GameCenterManager gcManager;

    @Override
    public void didFinishLaunching (UIApplication application) {
        UIWindow window = new UIWindow(UIScreen.getMainScreen().getBounds());
        window.makeKeyAndVisible();
        UIViewController viewController = new UIViewController();

        UIButton boton = new UIButton(new CGRect(10, 10, 200, 30));
        boton.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        boton.setTitle("Login", UIControlState.Normal);
        boton.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside (UIControl control, UIEvent event) {
                // If you are using LibGDX, use gcManager.loginGDX(); instead
                gcManager.login();
            }
        });
        UIButton boton2 = new UIButton(new CGRect(10, 60, 200, 30));
        boton2.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        boton2.setTitle("Get Achievement", UIControlState.Normal);
        boton2.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside (UIControl control, UIEvent event) {
                gcManager.reportAchievement("ACHIEVEMENT_ID", 100);
            }
        });
        UIButton boton3 = new UIButton(new CGRect(10, 110, 200, 30));
        boton3.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        boton3.setTitle("Load Achievements", UIControlState.Normal);
        boton3.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside (UIControl control, UIEvent event) {
                gcManager.loadAchievements();
            }
        });
        UIButton boton4 = new UIButton(new CGRect(10, 160, 200, 30));
        boton4.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        boton4.setTitle("Reset Achievements", UIControlState.Normal);
        boton4.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside (UIControl control, UIEvent event) {
                gcManager.resetAchievements();
            }
        });
        UIButton boton5 = new UIButton(new CGRect(220, 10, 200, 30));
        boton5.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        boton5.setTitle("Report Score", UIControlState.Normal);
        boton5.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside (UIControl control, UIEvent event) {
                gcManager.reportScore("LEADERBOARD_ID", 3);
            }
        });
        UIButton boton6 = new UIButton(new CGRect(220, 60, 200, 30));
        boton6.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        boton6.setTitle("Load Leaderboards", UIControlState.Normal);
        boton6.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside (UIControl control, UIEvent event) {
                gcManager.loadLeaderboards();
            }
        });
        UIButton boton7 = new UIButton(new CGRect(220, 110, 200, 30));
        boton7.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        boton7.setTitle("Show Achievements", UIControlState.Normal);
        boton7.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside (UIControl control, UIEvent event) {
                gcManager.showAchievementsView();
            }
        });
        UIButton boton8 = new UIButton(new CGRect(220, 160, 200, 30));
        boton8.setBackgroundColor(new UIColor(1, 0, 0, 0.5f));
        boton8.setTitle("Show Leaderboards", UIControlState.Normal);
        boton8.addOnTouchUpInsideListener(new OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside (UIControl control, UIEvent event) {
                gcManager.showLeaderboardsView();
            }
        });

        UIView view = new UIView(UIScreen.getMainScreen().getBounds());
        view.addSubview(boton);
        view.addSubview(boton2);
        view.addSubview(boton3);
        view.addSubview(boton4);
        view.addSubview(boton5);
        view.addSubview(boton6);
        view.addSubview(boton7);
        view.addSubview(boton8);
        viewController.setView(view);

        window.setRootViewController(viewController);

        gcManager = new GameCenterManager(UIApplication.getSharedApplication().getKeyWindow(), new GameCenterListener() {
            @Override
            public void playerLoginFailed (NSError error) {
                System.out.println("playerLoginFailed. error: " + error);
            }

            @Override
            public void playerLoginCompleted () {
                System.out.println("playerLoginCompleted");
            }

            @Override
            public void achievementReportCompleted () {
                System.out.println("achievementReportCompleted");
            }

            @Override
            public void achievementReportFailed (NSError error) {
                System.out.println("achievementReportFailed. error: " + error);
            }

            @Override
            public void achievementsLoadCompleted (ArrayList<GKAchievement> achievements) {
                System.out.println("achievementsLoadCompleted: " + achievements.size());
            }

            @Override
            public void achievementsLoadFailed (NSError error) {
                System.out.println("achievementsLoadFailed. error: " + error);
            }

            @Override
            public void achievementsResetCompleted () {
                System.out.println("achievementsResetCompleted");
            }

            @Override
            public void achievementsResetFailed (NSError error) {
                System.out.println("achievementsResetFailed. error: " + error);
            }

            @Override
            public void scoreReportCompleted () {
                System.out.println("scoreReportCompleted");
            }

            @Override
            public void scoreReportFailed (NSError error) {
                System.out.println("scoreReportFailed. error: " + error);
            }

            @Override
            public void leaderboardsLoadCompleted (ArrayList<GKLeaderboard> scores) {
                System.out.println("scoresLoadCompleted: " + scores.size());
            }

            @Override
            public void leaderboardsLoadFailed (NSError error) {
                System.out.println("scoresLoadFailed. error: " + error);
            }

            @Override
            public void leaderboardViewDismissed () {
                System.out.println("leaderboardViewDismissed");
            }

            @Override
            public void achievementViewDismissed () {
                System.out.println("achievementViewDismissed");
            }
        });
    }

    public static void main (String[] argv) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(argv, null, Sample.class);
        }
    }
}
