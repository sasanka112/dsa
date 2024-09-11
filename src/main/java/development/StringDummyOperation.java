package development;

import org.apache.commons.lang3.StringEscapeUtils;

public class StringDummyOperation {

	public static void main(String[] args) {
		String LOG_API = "https://veritaslogmanagerdev.ausvdc02.pcf.dell.com/api/service/log/add";
		System.out.println("LOG_API :" + LOG_API);
		LOG_API += "loggs";
		System.out.println("LOG_API :" + LOG_API);
		LOG_API = LOG_API.replace("loggs", "");
		System.out.println("LOG_API :" + LOG_API);
		
		String offendingValue = "https://veritaslogmanagerdev.ausvdc02.pcf.dell.com/api/service/log/add";
		System.out.println("offendingValue :" + offendingValue);
		offendingValue = StringEscapeUtils.escapeHtml3(offendingValue);
		System.out.println("offendingValue :" + offendingValue);

		
	}
}
