package factory;

import report.ReportCSV;
import report.ReportGenerator;
import report.ReportPDF;

public class FactoryReport {
	String generator = "";
	public String getGenerator() {
		return generator;
	}

	public FactoryReport(String generator) {
		this.generator = generator;
	}
	public ReportGenerator Report() {
		if (generator.equals("PDF")) {
			return new ReportPDF();
		}

		return new ReportCSV();

	}

}
