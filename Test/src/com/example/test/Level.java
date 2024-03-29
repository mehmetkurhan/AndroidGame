package com.example.test;

import java.util.ArrayList;
import java.util.List;

import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class Level {

	private int no;
	
	private String tiles[][];
	private String tilesmus[][];
	private ArrayList<Tile> tileList;
	private int mapWidth;
	private int mapHeight;
	private Tile t;
	public Level(int levelNo)
	{
		
		mapWidth = 20;
		mapHeight = 20;
		tilesmus = new String[][]{
				   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
				   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
				   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
				   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
				   {"-","-","-","-","X","X","X","X","X","X","X","-","X","-","X","-","-","X","X","X"},
				   {"-","-","-","-","X","-","-","X","-","-","X","-","X","-","X","-","-","X","-","-"},
				   {"-","-","-","-","X","-","-","X","-","-","X","-","X","-","X","-","-","X","-","-"},
				   {"-","-","-","-","X","-","-","X","-","-","X","-","X","-","X","-","-","X","-","-"},
				   {"-","-","-","-","X","-","-","Y","-","-","X","-","X","-","X","-","-","X","X","X"},
				   {"-","-","-","-","X","-","-","Y","-","-","X","-","X","-","X","-","-","-","-","X"},
				   {"-","-","-","-","X","-","-","Y","-","-","X","-","X","-","X","-","-","-","-","X"},
				   {"-","-","-","-","X","-","-","X","-","-","X","-","X","-","X","-","-","-","-","X"},
				   {"-","-","-","-","X","-","-","X","-","-","X","-","X","X","X","-","-","X","X","X"},
				   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
				   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
				   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
				   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
				   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
				   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
				   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
				   
				
};
		tiles = new String[][]{{"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							   {"-","X","X","X","X","X","-","Y","Y","Y","Y","-","Y","Y","Y","-","X","X","X","X"},
							   {"-","-","-","X","-","-","-","Y","-","-","-","-","Y","-","-","-","-","X","-","-"},
							   {"-","-","-","X","-","-","-","Y","-","-","-","-","Y","-","-","-","-","X","-","-"},
							   {"-","-","-","X","-","-","-","Y","-","-","-","-","Y","-","-","-","-","X","-","-"},
							   {"-","-","-","X","-","-","-","Y","Y","Y","-","-","Y","Y","Y","-","-","X","-","-"},
							   {"-","-","-","X","-","-","-","Y","-","-","-","-","-","-","Y","-","-","X","-","-"},
							   {"-","-","-","X","-","-","-","Y","-","-","-","-","-","-","Y","-","-","X","-","-"},
							   {"-","-","-","X","-","-","-","Y","-","-","-","-","-","-","Y","-","-","X","-","-"},
							   {"-","-","-","X","-","-","-","Y","Y","Y","Y","-","Y","Y","Y","-","-","X","-","-"},
							   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							   {"-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-","-"},
							   
							
	   	};
	
		this.no = levelNo;
		
	}
	public boolean isCompleted()
	{
		return false;
	}
	public int getNumber()
	{
		return no;
	}
	public ArrayList<Tile> tile(VertexBufferObjectManager po)
	{
		tileList = new ArrayList<Tile>();
		for(int i = 0; i < mapWidth; i++)
		{
			for(int j = 0; j < mapHeight; j++)
			{
				if(tiles[i][j] == "X")
				{
				   t = new Wall(j * 32,i * 32,ResourcesManager.getInstance().wall_region,po);
				}
				else if(tiles[i][j] == "Y")
				{
					t = new SteelWall(j * 32,i * 32,ResourcesManager.getInstance().steel_region,po);
				}
				else
				{
					t = null;
				}
				tileList.add(t);
			}
		}
		return tileList;
	}
	
}
