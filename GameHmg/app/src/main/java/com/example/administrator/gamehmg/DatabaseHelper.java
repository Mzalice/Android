package com.example.administrator.gamehmg;

/**
 * 数据库帮助类
 * @author MzAlice
 * @Time 2017.1.5
 */


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
	//表people_card
	final String people_card =
			"create table if not exists dict(_id integer primary" +
					" key autoincrement ,number unique,name ,hp ,mp ,atk , " +
					"def ,mat , mdf ,cri ,spd ,luk ,flee)";
	public DatabaseHelper(Context context, String name, int version)
	{
		super(context, name, null, version);
	}
	@Override
	public void onCreate(SQLiteDatabase db)
	{
		// 第一次使用数据库时自动建表
		db.execSQL(people_card);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db
			, int oldVersion, int newVersion)
	{
		System.out.println("--------onUpdate Called--------"
				+ oldVersion + "--->" + newVersion);
	}
}
