import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateFileName{
	public String generateFileName(){
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String resultFile = dateFormat.format(date);
		return resultFile;
		
	}
}