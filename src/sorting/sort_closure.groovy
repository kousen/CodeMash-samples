package sorting

def strings = ['this','is','a','list','of','strings']

// Closure as Comparator
Collections.sort strings, { s1, s2 -> s1.size() - s2.size() } as Comparator
assert strings == ['a', 'is', 'of', 'this', 'list', 'strings']

// Natural (lexicographical) sort
assert strings.sort() == ['a', 'is', 'list', 'of', 'strings', 'this']

// Closure in sort operation
assert strings.sort { it.size() } == ['a', 'is', 'of', 'list', 'this', 'strings']
