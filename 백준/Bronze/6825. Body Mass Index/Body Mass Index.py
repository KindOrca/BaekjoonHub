A = float(input())
B = float(input())
BMI = A / B**2
if BMI > 25: print('Overweight')
elif BMI > 18.5: print('Normal weight')
else: print('Underweight')