package br.com.androidcore.util;

import android.app.AlertDialog;
import android.content.Context;

public class DialogUtil {
	public static void showOKDialog(Context context, int titleRes, int messageRes) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(titleRes);
		builder.setMessage(messageRes);
		builder.setPositiveButton("OK", null);
		
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	public static void showOKDialog(Context context, String title, String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(null);
		builder.setMessage(message);
		builder.setPositiveButton("OK", null);
		
		AlertDialog alert = builder.create();
		alert.show();
	}
}
