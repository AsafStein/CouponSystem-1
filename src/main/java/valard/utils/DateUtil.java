package valard.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public final class DateUtil {
	
	private static final long MILIS_IN_DAY = 1000*60*60*24;
	
	private DateUtil() {}
	
	public static long getNow() {	
		long time = LocalDateTime.now().getLong(ChronoField.EPOCH_DAY)*MILIS_IN_DAY;
		return time;
	}
	
	public static long getNowPlusDays(int days) {
		long time = LocalDateTime.now().plusDays(days).getLong(ChronoField.EPOCH_DAY)*MILIS_IN_DAY;
		return time;
	}
	
	public static long getNowPlusMonths(int months) {
		long time = LocalDateTime.now().plusMonths(months).getLong(ChronoField.EPOCH_DAY)*MILIS_IN_DAY;
		return time;
	}
	
	public static long getNowPlusYears(int years) {
		long time = LocalDateTime.now().plusYears(years).getLong(ChronoField.EPOCH_DAY)*MILIS_IN_DAY;
		return time;
	}
	
}












