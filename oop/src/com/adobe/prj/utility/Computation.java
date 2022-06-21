package com.adobe.prj.utility;

@FunctionalInterface
public interface Computation<T> {
	T compute(T x, T y);
}
