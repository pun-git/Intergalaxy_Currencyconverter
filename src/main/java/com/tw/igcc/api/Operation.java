package com.tw.igcc.api;

import java.util.Optional;

import com.tw.igcc.model.Result;

public interface Operation<R, I> {
	
	Optional<Result> process(I commandArgs);
	
}
