package edu.hrbeu.SQLiteDemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DBAdapter {

	private static final String DB_NAME = "people.db";
	private static final String DB_TABLE = "peopleinfo";
	private static final int DB_VERSION = 1;
	 
	public static final String KEY_ID = "_id";
	public static final String KEY_NAME = "name";
	public static final String KEY_AGE = "age";
	public static final String KEY_HEIGHT = "height";
	
	private SQLiteDatabase db;
	private final Context context;
	private DBOpenHelper dbOpenHelper;
	
	public DBAdapter(Context _context) {
	    context = _context;
	  }

	  /** Close the database */
	  public void close() {
		  if (db != null){
			  db.close();
			  db = null;
		  }
		}

	  /** Open the database */
	  public void open() throws SQLiteException {  
		  dbOpenHelper = new DBOpenHelper(context, DB_NAME, null, DB_VERSION);
		  try {
			  db = dbOpenHelper.getWritableDatabase();
		  }
		  catch (SQLiteException ex) {
			  db = dbOpenHelper.getReadableDatabase();
		  }	  
		}
	  
	
	  public long insert(People people) {
	    ContentValues newValues = new ContentValues();
	  
	    newValues.put(KEY_NAME, people.Name);
	    newValues.put(KEY_AGE, people.Age);
	    newValues.put(KEY_HEIGHT, people.Height);
	    
	    return db.insert(DB_TABLE, null, newValues);
	  }


	  public People[] queryAllData() {  
		  Cursor results =  db.query(DB_TABLE, new String[] { KEY_ID, KEY_NAME, KEY_AGE, KEY_HEIGHT}, 
				  null, null, null, null, null);
		  return ConvertToPeople(results);   
	  }
	  
	  public People[] queryOneData(long id) {  
		  Cursor results =  db.query(DB_TABLE, new String[] { KEY_ID, KEY_NAME, KEY_AGE, KEY_HEIGHT}, 
				  KEY_ID + "=" + id, null, null, null, null);
		  return ConvertToPeople(results);   
	  }
	  
	  private People[] ConvertToPeople(Cursor cursor){
		  int resultCounts = cursor.getCount();
		  if (resultCounts == 0 || !cursor.moveToFirst()){
			  return null;
		  }
		  People[] peoples = new People[resultCounts];
		  for (int i = 0 ; i<resultCounts; i++){
			  peoples[i] = new People();
			  peoples[i].ID = cursor.getInt(0);
			  peoples[i].Name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
			  peoples[i].Age = cursor.getInt(cursor.getColumnIndex(KEY_AGE));
			  peoples[i].Height = cursor.getFloat(cursor.getColumnIndex(KEY_HEIGHT));
			  
			  cursor.moveToNext();
		  }	  
		  return peoples; 
	  }
	  
	  public long deleteAllData() {
		  return db.delete(DB_TABLE, null, null);
	  }

	  public long deleteOneData(long id) {
		  return db.delete(DB_TABLE,  KEY_ID + "=" + id, null);
	  }

	  public long updateOneData(long id , People people){
		  ContentValues updateValues = new ContentValues();	  
		  updateValues.put(KEY_NAME, people.Name);
		  updateValues.put(KEY_AGE, people.Age);
		  updateValues.put(KEY_HEIGHT, people.Height);
		  
		  return db.update(DB_TABLE, updateValues,  KEY_ID + "=" + id, null);
	  }
	  
		/** 静态Helper类，用于建立、更新和打开数据库*/
	  private static class DBOpenHelper extends SQLiteOpenHelper {

		  public DBOpenHelper(Context context, String name, CursorFactory factory, int version) {
		    super(context, name, factory, version);
		  }

		  private static final String DB_CREATE = "create table " + 
		    DB_TABLE + " (" + KEY_ID + " integer primary key autoincrement, " +
		    KEY_NAME+ " text not null, " + KEY_AGE+ " integer," + KEY_HEIGHT + " float);";

		  @Override
		  public void onCreate(SQLiteDatabase _db) {
		    _db.execSQL(DB_CREATE);
		  }

		  @Override
		  public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) {		    
		    _db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
		    onCreate(_db);
		  }
		}
	}