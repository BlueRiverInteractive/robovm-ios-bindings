com.michingo.robovmbindings
===========================

[Robovm Bindings] Google Play Game Services

Welcome to the bindings for GPGS!
GPGS is a service from google similar to game center. You might think that it is not needed for ios, since there is already game center.
However, gpgs is cross platform, and syncs progress and achievements across devices. This means that you have the same savegame and achievements on
your iphone and android tablet.

Therefore I made bindings for the ENTIRE sdk. This includes:
- sign in
- sign out
- unlock/increment/reveal achievements
- display achievements
- get a list of all achievements
- show a leaderboard
- show a list of leaderboards
- get a list of leaderboards
- get the scores of a leaderboard
- post scores to a leaderboard
- save your game in the cloud
- load your game from the cloud
- get user data (e-mail and name)

Aside the bindings, I make a simple to use PlayServicesManager. This manager contains very simple methods to perform the tasks listed above.


To implement google play game services in your game, follow these steps:
- Create an entry for your game in the Google Play Developer Console.
   It is a good idea to read this: https://developers.google.com/games/services/ios/quickstart
- Copy the libraries in the 'libs' folder to your game and place them in robovm.xml
	
	```
	<lib>libs/ios/GooglePlus.a</lib>
	<lib>libs/ios/GoogleOpenSource.a</lib>
	<lib>libs/ios/PlayGameServices.a</lib>
	```
	
- Place PlayGameServices.bundle in your project and link it in robovm.xml

	```
	<resource>
		<directory>resources</directory>
		<skipPngCrush>true</skipPngCrush>
	</resource>
	```
	
- Add the frameworks of the bindings to your game as well.
- Add this to your info.plist.xml
	
	```
	<key>CFBundleURLTypes</key>
	<array>
		<dict>
			<key>CFBundleURLName</key>
			<string>com.sample.mygame</string>
			<key>CFBundleURLSchemes</key>
			<array>
				<string>com.sample.mygame</string>
			</array>
			<key>CFBundleURLTypes</key>
			<string>Editor</string>
		</dict>
	</array>
	<key>GPGApplicationID</key>
	<string>xxxxxxxxxxxxx</string>
	```
	
- link the bindings to your project. (Eclipse: mygame-ios -> build path -> configure build path... -> projects -> add)
- Preview com.michingo.robovmbindings.playservices.Sample.java to see how to implement the services in your game.
   Note: if you do not implement it in your app delegate, make the class in which you implement the services extend NSObject.

   
Thank you for using my bindings! Enjoy! :)
