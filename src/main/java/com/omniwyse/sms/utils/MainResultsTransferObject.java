package com.omniwyse.sms.utils;

import java.util.List;

public class MainResultsTransferObject {
	private List<ResultsTransferObject> resulttransfer;
	private List<StudentSubjectMarks> subjects;

	public List<ResultsTransferObject> getResulttransfer() {
		return resulttransfer;
	}

	public void setResulttransfer(List<ResultsTransferObject> resulttransfer) {
		this.resulttransfer = resulttransfer;
	}

	public List<StudentSubjectMarks> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<StudentSubjectMarks> subjects) {
		this.subjects = subjects;
	}

	
}
