package model;

import java.util.Observable;

import mapComponent.Map;

public class GameModel extends Observable{
	public static Map map;
	public GameModel(Map map){this.map = map;}
	
	public void setchange(){this.setChanged();}
}
