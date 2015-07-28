package br.com.androidcore.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class ImageUtil {
	public static byte[] compressImageByte(Bitmap source, Bitmap.CompressFormat format, int quality) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();					
		source.compress(format, quality, os);
		
		byte[] array = os.toByteArray();
		
		return array;
	}
	
	public static Bitmap compressImage(Bitmap source, Bitmap.CompressFormat format, int quality) {
		ByteArrayOutputStream os = new ByteArrayOutputStream();					
		source.compress(format, quality, os);
		
		byte[] array = os.toByteArray();
		
		return BitmapFactory.decodeByteArray(array, 0, array.length);
	}
	
	public static Bitmap resizeBitmap(Bitmap source, int width, int height) {
		return Bitmap.createScaledBitmap(source, width, height, false);
	}
	
	public static byte[] getByteFromImageView(Bitmap bmp) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bmp.compress(Bitmap.CompressFormat.PNG, 50, stream);
		
		return stream.toByteArray();
	}
}
