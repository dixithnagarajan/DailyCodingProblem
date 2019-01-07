import collections

def flatten(d, parentKey=''):
	ret = {}
	for k,v in d.items():
		newKey = parentKey+'.'+str(k) if parentKey else k
		if v and isinstance(v, collections.MutableMapping):
			ret.update(flatten(v, newKey).items())
		else:
			ret.update({newKey: v})
	return ret

testDict = {"key":3, "foo":{"a":5, "bar":{"baz":8}}}
flattenedTestDict = flatten(testDict)
print(flattenedTestDict)
