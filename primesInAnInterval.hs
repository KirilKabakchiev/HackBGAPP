
-- purvi nachin za isPrime
isPrime::Int-> Bool
isPrime n
	| n <= 1 = False
	| otherwise = isPrime' 2 n
		where
			isPrime' current n
				|current == n = True
				|(mod n current) == 0 = False
				|otherwise = isPrime' (current + 1) n
					
 
-- zadachata + vtori nachin za isPrime
primesInAnInterval :: Int -> Int -> [Int]
primesInAnInterval a b 
	| b < a || a < 0 || b < 0 = error "Invalid input for a and b"
	| otherwise = filter isPrime2 [a..b]
		where
			divisors n = [x | x <- [1..n], mod n x == 0]
			sumOfDivisors n = sum $ divisors n
			isPrime2 n = (n+1) == sumOfDivisors n

