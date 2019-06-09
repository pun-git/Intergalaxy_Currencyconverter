package com.tw.igcc.api;

import java.util.Optional;

public interface Operation<R, I> {
	
	Optional<R> process(I commandArgs);
	
}
