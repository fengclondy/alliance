package com.ai.aso.common.sequence;

import java.util.List;

public interface ISequence {

	public String next();

	public List<String> next(int n);

}
