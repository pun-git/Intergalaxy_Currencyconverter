package com.tw.igcc.rn.validation.rule.builder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.tw.igcc.api.Rule;
import com.tw.igcc.model.RuleChain;
import com.tw.igcc.rn.validation.rule.RSCValidationRule;
import com.tw.igcc.rn.validation.rule.RSDValidationRule;
import com.tw.igcc.rn.validation.rule.RSIValidationRule;
import com.tw.igcc.rn.validation.rule.RSLValidationRule;
import com.tw.igcc.rn.validation.rule.RSMValidationRule;
import com.tw.igcc.rn.validation.rule.RSVValidationRule;
import com.tw.igcc.rn.validation.rule.RSValidationRule;
import com.tw.igcc.rn.validation.rule.RSXValidationRule;

public class ValidationRuleChainBuilder {
	
	public RuleChain build() {
		List<Rule<String>> listOfRules = new ArrayList<>();
		listOfRules.add(new RSValidationRule());
		listOfRules.add(new RSCValidationRule());
		listOfRules.add(new RSDValidationRule());
		listOfRules.add(new RSIValidationRule());
		listOfRules.add(new RSLValidationRule());
		listOfRules.add(new RSMValidationRule());
		listOfRules.add(new RSVValidationRule());
		listOfRules.add(new RSXValidationRule());
		return new RuleChain(listOfRules);
	}
	
	public RuleChain build(File rulesFile) {
		throw new UnsupportedOperationException(); 
	}
	
}
