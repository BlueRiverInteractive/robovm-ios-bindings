
package org.robovm.bindings.chartboost;

import org.robovm.rt.bro.Bro;
import org.robovm.rt.bro.LazyGlobalValue;
import org.robovm.rt.bro.annotation.GlobalValue;
import org.robovm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
public class CBLocation {
    static {
        Bro.bind(CBLocation.class);
    }

    public static final CBLocation Startup = new CBLocation("locationStartup");
    public static final CBLocation HomeScreen = new CBLocation("locationHomeScreen");
    public static final CBLocation MainMenu = new CBLocation("locationMainMenu");
    public static final CBLocation GameScreen = new CBLocation("locationGameScreen");
    public static final CBLocation Achievements = new CBLocation("locationAchievements");
    public static final CBLocation Quests = new CBLocation("locationQuests");
    public static final CBLocation Pause = new CBLocation("locationPause");
    public static final CBLocation LevelStart = new CBLocation("locationLevelStart");
    public static final CBLocation LevelComplete = new CBLocation("locationLevelComplete");
    public static final CBLocation TurnComplete = new CBLocation("locationTurnComplete");
    public static final CBLocation IAPStore = new CBLocation("locationIAPStore");
    public static final CBLocation ItemStore = new CBLocation("locationItemStore");
    public static final CBLocation GameOver = new CBLocation("locationGameOver");
    public static final CBLocation LeaderBoard = new CBLocation("locationLeaderBoard");
    public static final CBLocation Settings = new CBLocation("locationSettings");
    public static final CBLocation Quit = new CBLocation("locationQuit");
    public static final CBLocation Default = new CBLocation("locationDefault");

    private static CBLocation[] values = new CBLocation[] {Startup, HomeScreen, MainMenu, GameScreen, Achievements, Quests,
        Pause, LevelStart, LevelComplete, IAPStore, ItemStore, GameOver, LeaderBoard, Settings, Quit, Default};
    private final LazyGlobalValue<String> lazyGlobalValue;

    private CBLocation (String getterName) {
        lazyGlobalValue = new LazyGlobalValue<>(getClass(), getterName);
    }

    public String value () {
        return lazyGlobalValue.value();
    }

    public static CBLocation valueOf (String value) {
        for (CBLocation v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in "
            + /* <name> */CBLocation/* </name> */.class.getName());
    }

    @GlobalValue(symbol = "CBLocationStartup", optional = true)
    private static native String locationStartup ();

    @GlobalValue(symbol = "CBLocationHomeScreen", optional = true)
    private static native String locationHomeScreen ();

    @GlobalValue(symbol = "CBLocationMainMenu", optional = true)
    private static native String locationMainMenu ();

    @GlobalValue(symbol = "CBLocationGameScreen", optional = true)
    private static native String locationGameScreen ();

    @GlobalValue(symbol = "CBLocationAchievements", optional = true)
    private static native String locationAchievements ();

    @GlobalValue(symbol = "CBLocationQuests", optional = true)
    private static native String locationQuests ();

    @GlobalValue(symbol = "CBLocationPause", optional = true)
    private static native String locationPause ();

    @GlobalValue(symbol = "CBLocationLevelStart", optional = true)
    private static native String locationLevelStart ();

    @GlobalValue(symbol = "CBLocationLevelComplete", optional = true)
    private static native String locationLevelComplete ();

    @GlobalValue(symbol = "CBLocationTurnComplete", optional = true)
    private static native String locationTurnComplete ();

    @GlobalValue(symbol = "CBLocationIAPStore", optional = true)
    private static native String locationIAPStore ();

    @GlobalValue(symbol = "CBLocationItemStore", optional = true)
    private static native String locationItemStore ();

    @GlobalValue(symbol = "CBLocationGameOver", optional = true)
    private static native String locationGameOver ();

    @GlobalValue(symbol = "CBLocationLeaderBoard", optional = true)
    private static native String locationLeaderBoard ();

    @GlobalValue(symbol = "CBLocationSettings", optional = true)
    private static native String locationSettings ();

    @GlobalValue(symbol = "CBLocationQuit", optional = true)
    private static native String locationQuit ();

    @GlobalValue(symbol = "CBLocationDefault", optional = true)
    private static native String locationDefault ();
}
