package com.example.test;

public class Vector2 {
	
	private int x;
	private int y;
	
	public Vector2(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getX()
	{
		return this.x;
	}
	public int getY()
	{
		return this.y;
	}
	
	public static Vector2 zero()
	{
		return new Vector2(0,0);
	}
	
	public static Vector2 right()
	{
		return new Vector2(1,0);
	}
	public static Vector2 left()
	{
		return new Vector2(-1,0);
	}
	public static Vector2 up()
	{
		return new Vector2(0,-1);
	}
	public static Vector2 down()
	{
		return new Vector2(0,1);
	}
	public static Vector2 add(Vector2 fst,Vector2 snd)
	{
		return new Vector2(fst.x + snd.x,fst.y + snd.y);
	}
	public static Vector2 scalarMul(int s,Vector2 s1)
	{
		return new Vector2(s1.x * s, s1.y * s);
	}
	public static Vector2 tankRespawnPoint()
	{
		return new Vector2(400,300);
	}

}
