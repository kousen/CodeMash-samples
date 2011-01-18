package ast.immutable

import groovy.lang.Immutable;

@Immutable
class ImmutablePoint {
	double x
	double y
    
    String toString() { "($x,$y)" }
}