package report;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ReportGenerator {
	void GenerateReport(List<Object> med) throws FileNotFoundException, UnsupportedEncodingException;

}
