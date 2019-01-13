import random

random.seed()

def getRand():
	return random.randint(1, 6)

def test(a, b):
	retVal = 1;
	curr = getRand()
	while True:
		new = getRand()
		retVal+=1
		if(curr == a and new == b):
			return retVal
		curr = new

TRIALS = 100000

sum = 0

for i in range(TRIALS):
	sum+=test(5, 6)

print("5-6 Expectation: "+str(sum/TRIALS))

sum = 0

for i in range(TRIALS):
	sum+=test(5, 5)

print("5-5 Expectation: "+str(sum/TRIALS))

print("So, Alice should choose 5-6 game")
