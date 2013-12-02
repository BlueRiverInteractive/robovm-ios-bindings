package com.michingo.robovmbindings.gpgs.libgdx;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.michingo.robovmbindings.gpgs.GPGAchievementMetadata;
import com.michingo.robovmbindings.gpgs.GPGLeaderboardMetadata;
import com.michingo.robovmbindings.gpgs.GPGLeaderboardTimeScope;
import com.michingo.robovmbindings.gpgs.GPGScore;
import com.michingo.robovmbindings.playservices.PlayServicesManager.ScoresLoaded;

public class MyGame implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
	private GPGSInterface gpgs;
	
	public MyGame(GPGSInterface gpgs){
		this.gpgs = gpgs;
	}
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		Gdx.input.setInputProcessor(new InputProcessor(){

			@Override
			public boolean keyDown(int keycode) {
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer,
					int button) {
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer,
					int button) {
				
				//just some screen locations to test. 
				//Press at the left to login.
				//Press at the right to list achievements and scores of a particular leaderboard.
				if (screenX < 160){
					System.out.println("Starting login flow.");
					gpgs.login();
				}else{
					
					System.out.println("Examples of listing data like achievements, leaderboards and scores:");
					
					//example of listing achievements
					System.out.println("Listing achievements:");
					ArrayList<GPGAchievementMetadata> data = gpgs.getAchievements();
					for(int i=0;i<data.size();i++){
						GPGAchievementMetadata meta = data.get(i);
						System.out.println(meta.achievementId()+", "+meta.achievementDescription());
					}
					
					//example of listing leaderboards
					System.out.println("Listing achievements:");
					ArrayList<GPGLeaderboardMetadata> lead = gpgs.getLeaderboards();
					for(int i=0;i<lead.size();i++){
						GPGLeaderboardMetadata meta = lead.get(i);
						System.out.println(meta.leaderboardId()+", "+meta.title());
					}
					
					//example of listing scores
					if (lead.size() > 0){
						String id = lead.get(0).leaderboardId();
						System.out.println("Listing scores of leaderboard: "+id);
						gpgs.getScoresOfLeaderboard(id, false, GPGLeaderboardTimeScope.GPGLeaderboardTimeScopeAllTime, new ScoresLoaded() {
							@Override
							public void invoke(ArrayList<GPGScore> scores) {
								for(int i=0;i<scores.size();i++){
									GPGScore s = scores.get(i);
									System.out.println(s.rank()+"  "+s.displayName()+": "+s.value());
								}
							}
						});
					}
				}
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				return false;
			}
			
		});
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
