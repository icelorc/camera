/**
 * 
 */
package com.example.custom_cameraactivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * @author Peter
 *
 */
public class ImgShowActivity extends Activity {
	private ImageView imageView;
	private DisplayMetrics dm;
	private Bitmap bitmap;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imgshow);
		dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
				
		imageView = (ImageView)findViewById(R.id.image_view);
		//���ointent�̪�bundle
        Bundle bundle = getIntent().getExtras();
		
		Log.i("ImgPath", bundle.getString("ImgPath"));
		bitmap = getBitmapFromSDCard(bundle.getString("ImgPath"));
        
		imageView.setImageBitmap(bitmap);
		new ImageViewHelper(dm,imageView,bitmap);     
	}
	
	 private static Bitmap getBitmapFromSDCard(String file) 
	   {
	      try  
	      {
	         String Env = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
	         Bitmap bitmap = BitmapFactory.decodeFile(Env + "/" + file);
	         Log.i("img1", Env + "/" + file);
	         Log.i("bitmap", bitmap.toString());
	         return bitmap;
	      }  
	      catch (Exception e)  
	      {  
	         e.printStackTrace();  
	         return null;  
	      }  
	   }

}
