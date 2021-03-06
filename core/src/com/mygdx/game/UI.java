package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class UI {
	private static Skin skin;
	private Stage stage;
	private Table table;
	private Label lblmOrF;
	private Label lblClass;
	private Label lblGame;
	private Label lblName;
	private TextField txtName;
	private TextButton btnFemale;
	private TextButton btnMale;
	private TextButton btnBarbarian;
	private TextButton btnKnight;
	private TextButton btnMonk;
	private TextButton btnWizard;
	private TextButton btnFinished;
	private TextButton gender;
	private TextButton classChoice;
	private ButtonGroup<TextButton> classBtnGroup;
	private ButtonGroup<TextButton> genderBtnGroup;
	private String name = "";
	private int num = -1;
	private boolean finished = false;
	private String empty = "";
	private String message = "What is your name?";
	
	public void create() {
		stage = new Stage();
		setSkin(new Skin());
		Gdx.input.setInputProcessor(stage);

		//Create "white" Texture
		Pixmap pixWhite = new Pixmap(1, 1, Format.RGBA8888);
		pixWhite.setColor(Color.WHITE);
		pixWhite.fill();
		getSkin().add("white", new Texture(pixWhite));
		
		//Create "black" Texture
		Pixmap pixBlack = new Pixmap(1,1, Format.RGBA8888);
		pixBlack.setColor(Color.BLACK);
		pixBlack.fill();
		getSkin().add("black", new Texture(pixBlack));

		// Store the default libgdx font under the name "default".
		getSkin().add("default", new BitmapFont());

		//Configure labelStyle
		LabelStyle lblStyle = new LabelStyle();
		lblStyle.font = getSkin().getFont("default");
		lblStyle.fontColor = Color.WHITE;
		
		LabelStyle lblStyleGame = new LabelStyle(lblStyle);
		
		
		
		//Add Labels
		lblmOrF = new Label("Gender Preference: ", lblStyle);
		lblClass = new Label("Player Class Preference: ", lblStyle);
		lblName = new Label("Name: ", lblStyle);
		lblGame = new Label("DAEMON SOULS", lblStyleGame);
		lblGame.setSize(stage.getWidth(), 100);
		//lblGame.setFontScaleX(stage.getWidth());
		//lblGame.setFontScaleY(100);
		
		//Configure btnStyleMale
		TextButtonStyle btnStyleMale = new TextButtonStyle();
		btnStyleMale.up = getSkin().newDrawable("white", Color.CYAN);
		btnStyleMale.down = getSkin().newDrawable("white");
		btnStyleMale.checked = getSkin().getDrawable("white");
		btnStyleMale.font = getSkin().getFont("default");
		btnStyleMale.downFontColor = Color.BLACK;
		getSkin().add("maleStyle", btnStyleMale);
		
		//Configure btnStyleFemale
		TextButtonStyle btnStyleFemale = new TextButtonStyle(btnStyleMale);
		btnStyleFemale.up = getSkin().newDrawable("white", Color.PINK);
		getSkin().add("femaleStyle", btnStyleFemale);
		
		//Create gender buttons
		btnFemale = new TextButton("Female", getSkin(), "femaleStyle");
		btnMale = new TextButton("Male", getSkin(), "maleStyle");
		
		//Create genderBtnGroup and add gender buttons
		genderBtnGroup = new ButtonGroup<TextButton>(btnMale, btnFemale);
		genderBtnGroup.setMaxCheckCount(1);
		
		//Configure class button styles
		TextButtonStyle btnStyleBarb = new TextButtonStyle(btnStyleFemale);
		btnStyleBarb.up = getSkin().newDrawable("white", Color.ORANGE);
		getSkin().add("barbStyle", btnStyleBarb);
		TextButtonStyle btnStyleKnight = new TextButtonStyle(btnStyleFemale);
		btnStyleKnight.up = getSkin().newDrawable("white", Color.GREEN);
		getSkin().add("knightStyle", btnStyleKnight);
		TextButtonStyle btnStyleMonk = new TextButtonStyle(btnStyleFemale);
		btnStyleMonk.up = getSkin().newDrawable("white", Color.YELLOW);
		getSkin().add("monkStyle", btnStyleMonk);
		TextButtonStyle btnStyleWiz = new TextButtonStyle(btnStyleFemale);
		btnStyleWiz.up = getSkin().newDrawable("white", Color.BLUE);
		getSkin().add("wizStyle", btnStyleWiz);		
		
		//Create class buttons
		btnBarbarian = new TextButton("Barbarian", getSkin(), "barbStyle");
		btnKnight = new TextButton("Knight", getSkin(), "knightStyle");
		btnMonk = new TextButton("Monk", getSkin(), "monkStyle");
		btnWizard = new TextButton("Wizard", getSkin(), "wizStyle");
	
		//Create classBtnGroup and add class buttons.
		classBtnGroup = new ButtonGroup<TextButton>(
				btnBarbarian, btnKnight, btnMonk, btnWizard);
		classBtnGroup.setMaxCheckCount(1);
		
		//Configure btnStyleFin
		TextButtonStyle btnStyleFin = new TextButtonStyle(btnStyleWiz);
		btnStyleFin.up = getSkin().newDrawable("white", Color.GOLD);
		getSkin().add("styleFin", btnStyleFin);
		
		//Create finish button
		btnFinished = new TextButton("I'm done choosing. Let's play!", getSkin(), "styleFin");
		
		//Create textFieldStyle
		TextFieldStyle textStyle = new TextFieldStyle();
		textStyle.font = skin.getFont("default");
		textStyle.fontColor = Color.CHARTREUSE;
		skin.add("textStyle", textStyle);
		
		//Create textField
		txtName = new TextField("", skin, "textStyle");
		txtName.setMessageText(message);
		//txtName.setPosition(stage.getViewport().getScreenX()/3, stage.getViewport().getScreenY()/3);
		txtName.setTextFieldListener(new TextFieldListener() {
			public void keyTyped(TextField txtName, char c) {
				name = name+c;
			}
		});
		
		// Create a table that fills the screen. Everything else will go inside this table.
		table = new Table();
		table.setFillParent(true);
		stage.addActor(table);

		table.add(lblGame);
		table.row();
		table.add(lblName, txtName);
		table.row();
		table.add(lblmOrF, btnMale, btnFemale);
		table.row();
		table.add( lblClass, btnBarbarian, btnKnight, btnMonk, btnWizard);
		table.row();
		table.add(btnFinished);
		
		btnFinished.addListener(new ChangeListener() {
			public void changed (ChangeEvent event, Actor actor) {
				
				gender = genderBtnGroup.getChecked();
				classChoice = classBtnGroup.getChecked();
				
				if (gender != null && classChoice != null && name != message
						&& name != empty){
					if(classChoice == btnBarbarian){
						num = 0;
						if (gender == btnMale){
							Assets.initBarbarianM();
							finished = true;
						} else if (gender == btnFemale){
							Assets.initBarbarianF();
							finished = true;
						} else {
							System.out.println("Error in ui assignment of Barbarian");
						} 
					} else if (classChoice == btnKnight){
						num = 1;
						if (gender == btnMale){
							Assets.initKnightM();
							finished = true;
						} else if (gender == btnFemale){
							Assets.initKnightF();
							finished = true;
						} else {
							System.out.println("Error in ui assignment of Knight");
						}
					} else if (classChoice == btnMonk){
						num = 2;
						if (gender == btnMale){
							Assets.initMonkM();
							finished = true;
						} else if (gender == btnFemale){
							Assets.initMonkF();
							finished = true;
						} else {
							System.out.println("Error in ui assignment of Monk");
						}
					} else if (classChoice == btnWizard){
						num = 3;
						if (gender == btnMale){
							Assets.initWizardM();
							finished = true;
						} else if (gender == btnFemale){
							Assets.initWizardF();
							finished = true;
						} else {
							System.out.println("Error in ui assignment of Wizard");
						}
					} 
					}
				if(finished){
					MyGdxGame.name = name;
					btnFinished.setText("Loading Excitement");
					MyGdxGame.setGameState(MyGdxGame.INIT_PLAYER);
				}
			}
		});
	}

	public int render ()  {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		return num;
	}

	public void resize (int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	public void dispose () {
		stage.dispose();
		getSkin().dispose();
	}

	public static Skin getSkin() {
		return skin;
	}

	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	public int getNum() {
		return num;
	}
}
