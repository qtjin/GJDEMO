package com.gj.android.gjdemo.ui.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.gj.android.gjdemo.R;
import com.gj.android.gjdemo.util.MyDBOpenHelper;
import com.gj.android.gjlibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SQLiteActivity extends BaseActivity {

    @BindView(R.id.btn_insert)
    Button btn_insert;

    @BindView(R.id.btn_query)
    Button btn_query;

    @BindView(R.id.btn_update)
    Button btn_update;

    @BindView(R.id.btn_delete)
    Button btn_delete;

    private Context mContext;
    private SQLiteDatabase db;
    private MyDBOpenHelper myDBHelper;
    private StringBuilder sb;
    private int i = 1;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_sqlite;
    }

    @OnClick({ R.id.btn_insert,R.id.btn_query,R.id.btn_update,R.id.btn_delete})
    public void onClick(View v) {
        db = myDBHelper.getWritableDatabase();
        switch (v.getId()) {
            case R.id.btn_insert:
                ContentValues values1 = new ContentValues();
                values1.put("name", "呵呵~" + i);
                i++;

               /* //参数依次是：表名，强行插入null值得数据列的列名，一行记录的数据
                db.insert("person", null, values1);*/

                db.beginTransaction(); //开启事物
                try {
                    //参数依次是：表名，强行插入null值得数据列的列名，一行记录的数据
                    db.insert("person", null, values1);
                    db.setTransactionSuccessful(); //设置事物成功
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    db.endTransaction(); //结束事物
                }

                Toast.makeText(mContext, "插入完毕~", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_query:
                sb = new StringBuilder();
                //参数依次是:表名，列名，where约束条件，where中占位符提供具体的值，指定group by的列，进一步约束
                //指定查询结果的排序方式
                Cursor cursor = db.query("person", null, null, null, null, null, null);
                if (cursor.moveToFirst()) {
                    do {
                        int pid = cursor.getInt(cursor.getColumnIndex("personid"));
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        sb.append("id：" + pid + "：" + name + "\n");
                    } while (cursor.moveToNext());
                }
                cursor.close();
                Toast.makeText(mContext, sb.toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_update:
                ContentValues values2 = new ContentValues();
                values2.put("name", "嘻嘻~");
                //参数依次是表名，修改后的值，where条件，以及约束，如果不指定三四两个参数，会更改所有行
                db.update("person", values2, "name = ?", new String[]{"呵呵~2"});
                break;
            case R.id.btn_delete:
                //参数依次是表名，以及where条件与约束
                db.delete("person", "personid = ?", new String[]{"3"});
                break;
        }
    }

    @Override
    protected void initListener() {
        showTopLeft();
        mContext = SQLiteActivity.this;
        myDBHelper = new MyDBOpenHelper(mContext, "my2017.db", null, 1);
    }

    @Override
    public void pressData(Object obj) {

    }

    @Override
    protected void initData() {
        setTitle("SQLite数据库");
    }
    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    /**
         public void save(Person p)
         {
         SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
         db.execSQL("INSERT INTO person(name,phone) values(?,?)",
         new String[]{p.getName(),p.getPhone()});
         }
         public void delete(Integer id)
         {
         SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
         db.execSQL("DELETE FROM person WHERE personid = ?",
         new String[]{id});
         }
         public void update(Person p)
         {
         SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
         db.execSQL("UPDATE person SET name = ?,phone = ? WHERE personid = ?",
         new String[]{p.getName(),p.getPhone(),p.getId()});
         }
         public Person find(Integer id)
         {
         SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
         Cursor cursor =  db.rawQuery("SELECT * FROM person WHERE personid = ?",
         new String[]{id.toString()});
         //存在数据才返回true
         if(cursor.moveToFirst())
         {
         int personid = cursor.getInt(cursor.getColumnIndex("personid"));
         String name = cursor.getString(cursor.getColumnIndex("name"));
         String phone = cursor.getString(cursor.getColumnIndex("phone"));
         return new Person(personid,name,phone);
         }
         cursor.close();
         return null;
         }
         public List<Person> getScrollData(int offset,int maxResult) //数据分页
         {
         List<Person> person = new ArrayList<Person>();
         SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
         Cursor cursor =  db.rawQuery("SELECT * FROM person ORDER BY personid ASC LIMIT= ?,?",
         new String[]{String.valueOf(offset),String.valueOf(maxResult)});
         while(cursor.moveToNext())
         {
         int personid = cursor.getInt(cursor.getColumnIndex("personid"));
         String name = cursor.getString(cursor.getColumnIndex("name"));
         String phone = cursor.getString(cursor.getColumnIndex("phone"));
         person.add(new Person(personid,name,phone)) ;
         }
         cursor.close();
         return person;
         }
         public long getCount()
         {
         SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
         Cursor cursor =  db.rawQuery("SELECT COUNT (*) FROM person",null);
         cursor.moveToFirst();
         long result = cursor.getLong(0);
         cursor.close();
         return result;
         }


     */
}
