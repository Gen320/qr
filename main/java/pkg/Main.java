package pkg;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	static String filePath;

	public static void main(String[] args) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timer timer = new Timer(false);
			filePath = CreateQR.createQr("aaa");
			System.out.println(filePath);
			TimerTask task = new TimerTask() {
				@Override
				public void run() {
					timer.cancel();
				}
			};
			timer.schedule(task, sdf.parse("2018-02-26 15:11:11"));  // <-ここにDaoからとてきたstart_timeをString型で入れる
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
//		System.out.println(filePath);
		//ここでqrコードを送るコードを書く、メールは私たちのチームでは扱っていないのでメールのコーディングはお願いします
	}

}
