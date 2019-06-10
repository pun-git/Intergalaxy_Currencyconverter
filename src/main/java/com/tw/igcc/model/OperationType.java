package com.tw.igcc.model;

public enum OperationType {

		IGCVsRN(".*[VIXLCDM]+.*"),
		IGCWITHMETALVsCREDIT("Credits"),
		QUERY("?");
		
		private String expr; 
		private OperationType(String expr) {
			this.expr = expr;
		}
		
		public String getExpr() {
			return expr;
		}

}
