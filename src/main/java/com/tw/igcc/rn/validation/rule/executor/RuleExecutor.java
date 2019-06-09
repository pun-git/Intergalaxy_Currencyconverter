package com.tw.igcc.rn.validation.rule.executor;

import java.util.Iterator;

import com.tw.igcc.api.Rule;
import com.tw.igcc.model.RuleChain;

public class RuleExecutor {
	
	public void execute(RuleChain ruleChain, String romanNumber){
		Iterator<Rule<String>> ruleIterator = ruleChain.iterator();
		while(ruleIterator.hasNext()) {
			ruleIterator.next().execute(romanNumber);
		}
	}

}
