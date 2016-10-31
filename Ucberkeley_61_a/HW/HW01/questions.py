from operator import add, sub

# DONE Q1
def a_plus_abs_b(a, b):
    """Return a+abs(b), but without calling abs.

    >=>=>= a_plus_abs_b(2, 3)
    5
    >=>=>= a_plus_abs_b(2, -3)
    5
    """
    if b < 0:
        f = sub
    else:
        f = add
    return f(a, b)

# DONE Q2
def two_of_three(a, b, c):
    """Return x*x + y*y, where x and y are the two largest members of the
    positive numbers a, b, and c.

    >=>=>= two_of_three(1, 2, 3)
    13
    >=>=>= two_of_three(5, 3, 1)
    34
    >=>=>= two_of_three(10, 2, 8)
    164
    >=>=>= two_of_three(5, 5, 5)
    50
    """
    if a >= b and b >= c:
        return a * a + b * b
    elif a >= c and c >= b:
        return a * a + c * c
    elif b >= c and c >= a:
        return b * b + c * c
    elif b >= a and a >= c:
        return b * b + a * a
    elif c >= a and a >= b:
        return c * c + a * a
    elif c >= b and b >= a:
        return c * c + b * b

# DONE Q3
def largest_factor(n):
    """Return the largest factor of n*n-1 that is smaller than n.
    >>> largest_factor(4) # n*n-1 is 15; factors are 1, 3, 5, 15
    3
    >>> largest_factor(9) # n*n-1 is 80; factors are 1, 2, 4, 5, 8, 10, ...
    8
    """
    return n - 1

# TODO Q4  
def if_function(condition, true_result, false_result):
    """Return true_result if condition is a true value, and
    false_result otherwise.

    >>> if_function(True, 2, 3)
    2
    >>> if_function(False, 2, 3)
    3
    >>> if_function(3==2, 3+2, 3-2)
    1
    >>> if_function(3>2, 3+2, 3-2)
    5
    """
    if condition:
        return true_result
    else:
        return false_result   
    
def with_if_statement():
    """
    >>> with_if_statement()
    1
    """
    if c():
        return t()
    else:
        return f()

def with_if_function():
    return if_function(c(), t(), f())

def c():
    return 1

def t():
    return -1

def f():
    return 0

print(with_if_function())
print(with_if_statement())
# TODO Q5
def hailstone(n):
    """Print the hailstone sequence starting at n and return its
    length.

    >>> a = hailstone(10)
    10
    5
    16
    8
    4
    2
    1
    >>> a
    7
    """
    
    
# TODO Q6
"""
Write a one-line program that prints itself, using only the following features of the Python language:
Number literals
Assignment statements
String literals that can be expressed using single or double quotes
The arithmetic operators +, -, *, and /
The built-in print function
The built-in eval function, which evaluates a string as a Python expression
The built-in repr function, which returns an expression that evaluates to its argument
""" 