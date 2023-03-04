A = int(input())
B = int(input())
C = B - A
if C <= 0: print('Congratulations, you are within the speed limit!')
elif 1 <= C <= 20: print('You are speeding and your fine is $100.')
elif 21 <= C <= 30: print('You are speeding and your fine is $270.')
else: print('You are speeding and your fine is $500.')