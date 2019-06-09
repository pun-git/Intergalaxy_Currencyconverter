package com.tw.igcc.api;

public interface Operation<R, I> {
	
	R process(I input);
	
}
