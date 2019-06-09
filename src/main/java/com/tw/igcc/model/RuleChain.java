package com.tw.igcc.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.tw.igcc.api.Rule;

public class RuleChain implements Iterable<Rule<String>> {
	
	private List<Rule<String>> listOfRule;
	
	public RuleChain(List<Rule<String>> rules) {
		this.listOfRule = new ArrayList<>(rules);
	}
	
	public Iterator<Rule<String>> iterator() {
		return new RuleIterator(listOfRule);
	}

	
	class RuleIterator implements Iterator<Rule<String>>{
		private Iterator<Rule<String>> ruleItertor;
		
		public RuleIterator(List<Rule<String>> listOfRule) {
			this.ruleItertor  = listOfRule.iterator();
		}
		
		public boolean hasNext() {
			return ruleItertor.hasNext();
		}
		
		public Rule<String> next() {
			return ruleItertor.next();
		}
	}

}
