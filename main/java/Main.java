import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Timer timer = new Timer(false);
			TimerTask task = new TimerTask() {
	 
				@Override
				public void run() {
					CreateQR.createQr("");
					timer.cancel();
				}
			};
			timer.schedule(task, sdf.parse("2018-02-06 09:11:11"));  // <-ここにDaoからとてきたstart_timeをString型で入れる
		}catch(ParseException e) {
			e.printStackTrace();
		}
		
		File qr = new File("qr_code.png");
		//ここでqrコードを送るコードを書く、メールは私たちのチームでは扱っていないのでメールのコーディングはお願いします
	}

}
